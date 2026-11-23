package ast;

public class AstDecArrayTypedef extends AstDec
{
	/****************/
	/* DATA MEMBERS */
	/****************/
	public AstArrayTypedef arrayTypedef;

	/******************/
	/* CONSTRUCTOR(S) */
	/******************/
	public AstDecArrayTypedef(AstArrayTypedef arrayTypedef, int line)
	{
		/******************************/
		/* SET A UNIQUE SERIAL NUMBER */
		/******************************/
		serialNumber = AstNodeSerialNumber.getFresh();

		/***************************************/
		/* PRINT CORRESPONDING DERIVATION RULE */
		/***************************************/
		System.out.print("====================== dec -> arrayTypedef\n");

		/*******************************/
		/* COPY INPUT DATA MEMBERS ... */
		/*******************************/
		this.arrayTypedef = arrayTypedef;
		this.line = line;
	}

	/*****************************************************/
	/* The printing message for a declaration AST node  */
	/*****************************************************/
	public void printMe()
	{
		/***********************************/
		/* AST NODE TYPE = AST DECLARATION */
		/***********************************/
		System.out.print("AST NODE DEC ARRAY TYPEDEF\n");

		/******************************/
		/* RECURSIVELY PRINT CHILD ... */
		/******************************/
		if (arrayTypedef != null) arrayTypedef.printMe();

		/**********************************/
		/* PRINT to AST GRAPHVIZ DOT file */
		/**********************************/
		AstGraphviz.getInstance().logNode(serialNumber, "DEC\nARRAY TYPEDEF");

		/****************************************/
		/* PRINT Edges to AST GRAPHVIZ DOT file */
		/****************************************/
		if (arrayTypedef != null) AstGraphviz.getInstance().logEdge(serialNumber,arrayTypedef.serialNumber);
	}
}
