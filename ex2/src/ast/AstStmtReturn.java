package ast;

public class AstStmtReturn extends AstStmt
{
	/*****************/
	/*  return [exp] */
	/*****************/
	public AstExp exp;

	/*******************/
	/*  CONSTRUCTOR(S) */
	/*******************/
	public AstStmtReturn(AstExp exp)
	{
		/******************************/
		/* SET A UNIQUE SERIAL NUMBER */
		/******************************/
		serialNumber = AstNodeSerialNumber.getFresh();

		/***************************************/
		/* PRINT CORRESPONDING DERIVATION RULE */
		/***************************************/
		if (exp == null) System.out.print("====================== stmt -> RETURN SEMICOLON\n");
		else             System.out.print("====================== stmt -> RETURN exp SEMICOLON\n");

		/*******************************/
		/* COPY INPUT DATA MEMBERS ... */
		/*******************************/
		this.exp = exp;
	}

	/********************************************************/
	/* The printing message for a return statement AST node */
	/********************************************************/
	public void printMe()
	{
		/****************************************/
		/* AST NODE TYPE = AST RETURN STATEMENT */
		/****************************************/
		System.out.print("AST NODE RETURN STMT\n");

		/*****************************/
		/* RECURSIVELY PRINT exp ... */
		/*****************************/
		if (exp != null) exp.printMe();

		/***************************************/
		/* PRINT Node to AST GRAPHVIZ DOT file */
		/***************************************/
		AstGraphviz.getInstance().logNode(serialNumber, "RETURN");

		/****************************************/
		/* PRINT Edges to AST GRAPHVIZ DOT file */
		/****************************************/
		if (exp != null) AstGraphviz.getInstance().logEdge(serialNumber,exp.serialNumber);
	}
}
