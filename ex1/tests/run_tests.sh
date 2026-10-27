#!/bin/bash
# Runs LEXER on every tests/input/NAME.txt (and the course tests in input/)
# and compares the result with expected_output/NAME_Expected_Output.txt.
# Usage (from the project root, after running make):  bash tests/run_tests.sh

cd "$(dirname "$0")/.." || exit 1
OUT_DIR=$(mktemp -d)
pass=0
fail=0

run_suite() { # input dir, expected output dir
	for input in "$1"/*.txt; do
		name=$(basename "$input" .txt)
		expected="$2/${name}_Expected_Output.txt"
		[ -f "$expected" ] || continue
		output="$OUT_DIR/$name.txt"
		java -jar LEXER "$input" "$output" > /dev/null 2>&1
		if [ -f "$output" ] && diff -q <(tr -d '\r' < "$output") <(tr -d '\r' < "$expected") > /dev/null; then
			pass=$((pass + 1))
		else
			fail=$((fail + 1))
			echo "FAIL $name"
			echo "  expected: $(tr '\n' ' ' < "$expected")"
			echo "  got:      $( [ -f "$output" ] && tr '\n' ' ' < "$output" || echo '<no output file>')"
		fi
	done
}

run_suite tests/input tests/expected_output
run_suite input expected_output

rm -rf "$OUT_DIR"
echo "Passed: $pass, Failed: $fail"
[ "$fail" -eq 0 ]
