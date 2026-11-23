package ast;

public class AstTypeInt extends AstType
{
	/******************/
	/* CONSTRUCTOR(S) */
	/******************/
	public AstTypeInt(int line)
	{
		/******************************/
		/* SET A UNIQUE SERIAL NUMBER */
		/******************************/
		serialNumber = AstNodeSerialNumber.getFresh();

		/***************************************/
		/* PRINT CORRESPONDING DERIVATION RULE */
		/***************************************/
		System.out.print("====================== type -> TYPE_INT\n");

		/*******************************/
		/* COPY INPUT DATA MEMBERS ... */
		/*******************************/
		this.line = line;
	}

	/*************************************************/
	/* The printing message for an int type AST node */
	/*************************************************/
	public void printMe()
	{
		/********************************/
		/* AST NODE TYPE = AST INT TYPE */
		/********************************/
		System.out.print("AST NODE TYPE INT\n");

		/**********************************/
		/* Print to AST GRAPHVIZ DOT file */
		/**********************************/
		AstGraphviz.getInstance().logNode(serialNumber, "TYPE\nint");
	}
}
