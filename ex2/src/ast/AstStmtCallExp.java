package ast;

public class AstStmtCallExp extends AstStmt
{
	/*************/
	/*  callExp; */
	/*************/
	public AstCallExp callExp;

	/*******************/
	/*  CONSTRUCTOR(S) */
	/*******************/
	public AstStmtCallExp(AstCallExp callExp)
	{
		/******************************/
		/* SET A UNIQUE SERIAL NUMBER */
		/******************************/
		serialNumber = AstNodeSerialNumber.getFresh();

		/***************************************/
		/* PRINT CORRESPONDING DERIVATION RULE */
		/***************************************/
		System.out.print("====================== stmt -> callExp SEMICOLON\n");

		/*******************************/
		/* COPY INPUT DATA MEMBERS ... */
		/*******************************/
		this.callExp = callExp;
	}

	/******************************************************/
	/* The printing message for a call statement AST node */
	/******************************************************/
	public void printMe()
	{
		/**************************************/
		/* AST NODE TYPE = AST CALL STATEMENT */
		/**************************************/
		System.out.print("AST NODE CALL STMT\n");

		/*********************************/
		/* RECURSIVELY PRINT callExp ... */
		/*********************************/
		if (callExp != null) callExp.printMe();

		/***************************************/
		/* PRINT Node to AST GRAPHVIZ DOT file */
		/***************************************/
		AstGraphviz.getInstance().logNode(serialNumber, "STMT\nCALL");

		/****************************************/
		/* PRINT Edges to AST GRAPHVIZ DOT file */
		/****************************************/
		if (callExp != null) AstGraphviz.getInstance().logEdge(serialNumber,callExp.serialNumber);
	}
}
