package ast;

public class AstStmtNewExp extends AstStmt
{
	/******************/
	/*  var := newExp */
	/******************/
	public AstVar var;
	public AstNewExp newExp;

	/*******************/
	/*  CONSTRUCTOR(S) */
	/*******************/
	public AstStmtNewExp(AstVar var, AstNewExp newExp)
	{
		/******************************/
		/* SET A UNIQUE SERIAL NUMBER */
		/******************************/
		serialNumber = AstNodeSerialNumber.getFresh();

		/***************************************/
		/* PRINT CORRESPONDING DERIVATION RULE */
		/***************************************/
		System.out.print("====================== stmt -> var ASSIGN newExp SEMICOLON\n");

		/*******************************/
		/* COPY INPUT DATA MEMBERS ... */
		/*******************************/
		this.var = var;
		this.newExp = newExp;
	}

	/*************************************************************/
	/* The printing message for an assign new statement AST node */
	/*************************************************************/
	public void printMe()
	{
		/************************************************/
		/* AST NODE TYPE = AST ASSIGN NEW EXP STATEMENT */
		/************************************************/
		System.out.print("AST NODE ASSIGN NEW STMT\n");

		/**************************************/
		/* RECURSIVELY PRINT var + newExp ... */
		/**************************************/
		if (var    != null) var.printMe();
		if (newExp != null) newExp.printMe();

		/***************************************/
		/* PRINT Node to AST GRAPHVIZ DOT file */
		/***************************************/
		AstGraphviz.getInstance().logNode(serialNumber, "ASSIGN\nleft := new");

		/****************************************/
		/* PRINT Edges to AST GRAPHVIZ DOT file */
		/****************************************/
		if (var    != null) AstGraphviz.getInstance().logEdge(serialNumber,var.serialNumber);
		if (newExp != null) AstGraphviz.getInstance().logEdge(serialNumber,newExp.serialNumber);
	}
}
