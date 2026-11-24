package ast;

public class AstExpCallExp extends AstExp
{
	public AstCallExp callExp;

	/******************/
	/* CONSTRUCTOR(S) */
	/******************/
	public AstExpCallExp(AstCallExp callExp)
	{
		/******************************/
		/* SET A UNIQUE SERIAL NUMBER */
		/******************************/
		serialNumber = AstNodeSerialNumber.getFresh();

		/***************************************/
		/* PRINT CORRESPONDING DERIVATION RULE */
		/***************************************/
		System.out.print("====================== exp -> callExp\n");

		/*******************************/
		/* COPY INPUT DATA MEMBERS ... */
		/*******************************/
		this.callExp = callExp;
	}

	/*************************************************/
	/* The printing message for an exp call exp AST node */
	/*************************************************/
	public void printMe()
	{
		/********************************/
		/* AST NODE TYPE = AST EXP CALL EXP */
		/********************************/
		System.out.print("AST NODE EXP CALL EXP\n");

		/************************************/
		/* RECURSIVELY PRINT callExp ... */
		/************************************/
		if (callExp != null) callExp.printMe();

		/***************************************/
		/* PRINT Node to AST GRAPHVIZ DOT file */
		/***************************************/
		AstGraphviz.getInstance().logNode(serialNumber, "EXP\nCALL");

		/****************************************/
		/* PRINT Edges to AST GRAPHVIZ DOT file */
		/****************************************/
		if (callExp != null) AstGraphviz.getInstance().logEdge(serialNumber,callExp.serialNumber);
	}
}
