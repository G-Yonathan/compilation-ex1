package ast;

public class AstDecVar extends AstDec
{
	/****************/
	/* DATA MEMBERS */
	/****************/
	public AstVarDec varDec;

	/******************/
	/* CONSTRUCTOR(S) */
	/******************/
	public AstDecVar(AstVarDec varDec, int line)
	{
		/******************************/
		/* SET A UNIQUE SERIAL NUMBER */
		/******************************/
		serialNumber = AstNodeSerialNumber.getFresh();

		/***************************************/
		/* PRINT CORRESPONDING DERIVATION RULE */
		/***************************************/
		System.out.print("====================== dec -> varDec\n");

		/*******************************/
		/* COPY INPUT DATA MEMBERS ... */
		/*******************************/
		this.varDec = varDec;
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
		System.out.print("AST NODE DEC VAR\n");

		/******************************/
		/* RECURSIVELY PRINT CHILD ... */
		/******************************/
		if (varDec != null) varDec.printMe();

		/**********************************/
		/* PRINT to AST GRAPHVIZ DOT file */
		/**********************************/
		AstGraphviz.getInstance().logNode(serialNumber, "DEC\nVAR");

		/****************************************/
		/* PRINT Edges to AST GRAPHVIZ DOT file */
		/****************************************/
		if (varDec != null) AstGraphviz.getInstance().logEdge(serialNumber,varDec.serialNumber);
	}
}
