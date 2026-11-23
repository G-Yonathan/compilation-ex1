package ast;

public class AstTypeString extends AstType
{
	/******************/
	/* CONSTRUCTOR(S) */
	/******************/
	public AstTypeString(int line)
	{
		/******************************/
		/* SET A UNIQUE SERIAL NUMBER */
		/******************************/
		serialNumber = AstNodeSerialNumber.getFresh();

		/***************************************/
		/* PRINT CORRESPONDING DERIVATION RULE */
		/***************************************/
		System.out.print("====================== type -> TYPE_STRING\n");

		/*******************************/
		/* COPY INPUT DATA MEMBERS ... */
		/*******************************/
		this.line = line;
	}

	/***************************************************/
	/* The printing message for a string type AST node */
	/***************************************************/
	public void printMe()
	{
		/***********************************/
		/* AST NODE TYPE = AST STRING TYPE */
		/***********************************/
		System.out.print("AST NODE TYPE STRING\n");

		/**********************************/
		/* Print to AST GRAPHVIZ DOT file */
		/**********************************/
		AstGraphviz.getInstance().logNode(serialNumber, "TYPE\nstring");
	}
}
