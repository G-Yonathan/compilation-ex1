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
			/* [2] Initialize a new lexer */
			/******************************/
			l = new Lexer(fileReader);

			/***********************/
			/* [3] Read next token */
			/***********************/
			s = l.next_token();
			boolean first = true;

			/********************************/
			/* [4] Main reading tokens loop */
			/********************************/
			while (s.sym != TokenNames.EOF) {
				/**************************************/
				/* [5] Append token to string builder */
				/**************************************/
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
				/* [6] Read next token */
				/***********************/
				s = l.next_token();
			}

			/******************************/
			/* [7] Close lexer input file */
			/******************************/
			l.yyclose();
		}

		catch (Throwable e) {
			out = new StringBuilder("ERROR");
		}

		/*************************/
		/* [8] Write output file */
		/*************************/
		try {
			fileWriter = new PrintWriter(outputFileName);
			fileWriter.print(out);
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
