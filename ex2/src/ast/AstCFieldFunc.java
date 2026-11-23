package ast;

public class AstCFieldFunc extends AstCField
{
	/****************/
	/* DATA MEMBERS */
	/****************/
	public AstFuncDec funcDec;

	/******************/
	/* CONSTRUCTOR(S) */
	/******************/
	public AstCFieldFunc(AstFuncDec funcDec)
	{
		/******************************/
		/* SET A UNIQUE SERIAL NUMBER */
		/******************************/
		serialNumber = AstNodeSerialNumber.getFresh();

		/***************************************/
		/* PRINT CORRESPONDING DERIVATION RULE */
		/***************************************/
		System.out.print("====================== cField -> funcDec\n");

		/*******************************/
		/* COPY INPUT DATA MEMBERS ... */
		/*******************************/
		this.funcDec = funcDec;
		if (funcDec != null) this.line = funcDec.line;
	}

	/**********************************************************/
	/* The printing message for a class method field AST node */
	/**********************************************************/
	public void printMe()
	{
		/************************************/
		/* AST NODE TYPE = AST CFIELD FUNC  */
		/************************************/
		System.out.print("AST NODE CFIELD FUNC\n");

		/*********************************/
		/* RECURSIVELY PRINT funcDec ... */
		/*********************************/
		if (funcDec != null) funcDec.printMe();

		/***************************************/
		/* PRINT Node to AST GRAPHVIZ DOT file */
		/***************************************/
		AstGraphviz.getInstance().logNode(serialNumber, "CFIELD\nFUNC");

		/****************************************/
		/* PRINT Edges to AST GRAPHVIZ DOT file */
		/****************************************/
		if (funcDec != null) AstGraphviz.getInstance().logEdge(serialNumber,funcDec.serialNumber);
	}
}
