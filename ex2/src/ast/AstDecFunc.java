package ast;

public class AstDecFunc extends AstDec
{
	/****************/
	/* DATA MEMBERS */
	/****************/
	public AstFuncDec funcDec;

	/******************/
	/* CONSTRUCTOR(S) */
	/******************/
	public AstDecFunc(AstFuncDec funcDec, int line)
	{
		/******************************/
		/* SET A UNIQUE SERIAL NUMBER */
		/******************************/
		serialNumber = AstNodeSerialNumber.getFresh();

		/***************************************/
		/* PRINT CORRESPONDING DERIVATION RULE */
		/***************************************/
		System.out.print("====================== dec -> funcDec\n");

		/*******************************/
		/* COPY INPUT DATA MEMBERS ... */
		/*******************************/
		this.funcDec = funcDec;
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
		System.out.print("AST NODE DEC FUNC\n");

		/******************************/
		/* RECURSIVELY PRINT CHILD ... */
		/******************************/
		if (funcDec != null) funcDec.printMe();

		/**********************************/
		/* PRINT to AST GRAPHVIZ DOT file */
		/**********************************/
		AstGraphviz.getInstance().logNode(serialNumber, "DEC\nFUNC");

		/****************************************/
		/* PRINT Edges to AST GRAPHVIZ DOT file */
		/****************************************/
		if (funcDec != null) AstGraphviz.getInstance().logEdge(serialNumber,funcDec.serialNumber);
	}
}
