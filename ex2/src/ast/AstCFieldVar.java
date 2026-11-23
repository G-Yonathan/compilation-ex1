package ast;

public class AstCFieldVar extends AstCField
{
	/****************/
	/* DATA MEMBERS */
	/****************/
	public AstVarDec varDec;

	/******************/
	/* CONSTRUCTOR(S) */
	/******************/
	public AstCFieldVar(AstVarDec varDec)
	{
		/******************************/
		/* SET A UNIQUE SERIAL NUMBER */
		/******************************/
		serialNumber = AstNodeSerialNumber.getFresh();

		/***************************************/
		/* PRINT CORRESPONDING DERIVATION RULE */
		/***************************************/
		System.out.print("====================== cField -> varDec\n");

		/*******************************/
		/* COPY INPUT DATA MEMBERS ... */
		/*******************************/
		this.varDec = varDec;
		if (varDec != null) this.line = varDec.line;
	}

	/*******************************************************/
	/* The printing message for a class var field AST node */
	/*******************************************************/
	public void printMe()
	{
		/***********************************/
		/* AST NODE TYPE = AST CFIELD VAR  */
		/***********************************/
		System.out.print("AST NODE CFIELD VAR\n");

		/********************************/
		/* RECURSIVELY PRINT varDec ... */
		/********************************/
		if (varDec != null) varDec.printMe();

		/***************************************/
		/* PRINT Node to AST GRAPHVIZ DOT file */
		/***************************************/
		AstGraphviz.getInstance().logNode(serialNumber, "CFIELD\nVAR");

		/****************************************/
		/* PRINT Edges to AST GRAPHVIZ DOT file */
		/****************************************/
		if (varDec != null) AstGraphviz.getInstance().logEdge(serialNumber,varDec.serialNumber);
	}
}
