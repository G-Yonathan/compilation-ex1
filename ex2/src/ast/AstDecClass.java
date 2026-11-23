package ast;

public class AstDecClass extends AstDec
{
	/****************/
	/* DATA MEMBERS */
	/****************/
	public AstClassDec classDec;

	/******************/
	/* CONSTRUCTOR(S) */
	/******************/
	public AstDecClass(AstClassDec classDec, int line)
	{
		/******************************/
		/* SET A UNIQUE SERIAL NUMBER */
		/******************************/
		serialNumber = AstNodeSerialNumber.getFresh();

		/***************************************/
		/* PRINT CORRESPONDING DERIVATION RULE */
		/***************************************/
		System.out.print("====================== dec -> classDec\n");

		/*******************************/
		/* COPY INPUT DATA MEMBERS ... */
		/*******************************/
		this.classDec = classDec;
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
		System.out.print("AST NODE DEC CLASS\n");

		/******************************/
		/* RECURSIVELY PRINT CHILD ... */
		/******************************/
		if (classDec != null) classDec.printMe();

		/**********************************/
		/* PRINT to AST GRAPHVIZ DOT file */
		/**********************************/
		AstGraphviz.getInstance().logNode(serialNumber, "DEC\nCLASS");

		/****************************************/
		/* PRINT Edges to AST GRAPHVIZ DOT file */
		/****************************************/
		if (classDec != null) AstGraphviz.getInstance().logEdge(serialNumber,classDec.serialNumber);
	}
}
