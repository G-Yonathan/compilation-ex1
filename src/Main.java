import java.io.*;

import java_cup.runtime.Symbol;

public class Main {
	static public void main(String argv[]) {
		Lexer l;
		Symbol s;
		FileReader fileReader;
		PrintWriter fileWriter;
		String inputFileName = argv[0];
		String outputFileName = argv[1];
		StringBuilder out = new StringBuilder();

		try {
			/********************************/
			/* [1] Initialize a file reader */
			/********************************/
			fileReader = new FileReader(inputFileName);

			/******************************/
			/* [3] Initialize a new lexer */
			/******************************/
			l = new Lexer(fileReader);

			/***********************/
			/* [4] Read next token */
			/***********************/
			s = l.next_token();
			boolean first = true;

			/********************************/
			/* [5] Main reading tokens loop */
			/********************************/
			while (s.sym != TokenNames.EOF) {
				/************************/
				/* [6] Print to console */
				/************************/
				System.out.print("[");
				System.out.print(l.getLine());
				System.out.print(",");
				System.out.print(l.getTokenStartPosition());
				System.out.print("]:");
				System.out.print(s.value);
				System.out.print("\n");

				/*********************/
				/* [7] Print to file */
				/*********************/
				if (!first) {
					out.append("\n");
				}
				out.append(TokenNames.nameOf(s.sym));
				if (s.value != null) {
					out.append("(" + s.value + ")");
				}
				out.append("[" + l.getLine() + "," + l.getTokenStartPosition() + "]");
				first = false;

				/***********************/
				/* [8] Read next token */
				/***********************/
				s = l.next_token();
			}

			/******************************/
			/* [9] Close lexer input file */
			/******************************/
			l.yyclose();
		}

		catch (Throwable e) {
			out = new StringBuilder("ERROR");
		}

		/*********************/
		/* Write output file */
		/*********************/
		try {
			fileWriter = new PrintWriter(outputFileName);
			fileWriter.print(out);
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
