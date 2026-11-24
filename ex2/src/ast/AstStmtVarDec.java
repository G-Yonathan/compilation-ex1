package ast;

public class AstStmtVarDec extends AstStmt
{
	/**********/
	/* varDec */
	/**********/
	public AstVarDec varDec;

	/*******************/
	/*  CONSTRUCTOR(S) */
	/*******************/
	public AstStmtVarDec(AstVarDec varDec)
	{
		/******************************/
		/* SET A UNIQUE SERIAL NUMBER */
		/******************************/
		serialNumber = AstNodeSerialNumber.getFresh();

		/***************************************/
		/* PRINT CORRESPONDING DERIVATION RULE */
		/***************************************/
		System.out.print("====================== stmt -> varDec\n");

		/*******************************/
		/* COPY INPUT DATA MEMBERS ... */
		/*******************************/
		this.varDec = varDec;
	}

	/*********************************************************/
	/* The printing message for a var dec statement AST node */
	/*********************************************************/
	public void printMe()
	{
		/*****************************************/
		/* AST NODE TYPE = AST VAR DEC STATEMENT */
		/*****************************************/
		System.out.print("AST NODE VAR DEC STMT\n");

		/********************************/
		/* RECURSIVELY PRINT varDec ... */
		/********************************/
		if (varDec != null) varDec.printMe();

		/***************************************/
		/* PRINT Node to AST GRAPHVIZ DOT file */
		/***************************************/
		AstGraphviz.getInstance().logNode(serialNumber, "STMT\nVAR DEC");

		/****************************************/
		/* PRINT Edges to AST GRAPHVIZ DOT file */
		/****************************************/
		if (varDec != null) AstGraphviz.getInstance().logEdge(serialNumber,varDec.serialNumber);
	}
}
