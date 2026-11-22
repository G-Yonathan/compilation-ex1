package ast;

public class AstExpList extends AstNode
{
	public AstExp exp;
	public AstExpList list;

	/******************/
	/* CONSTRUCTOR(S) */
	/******************/
	public AstExpList(AstExp exp, AstExpList list)
	{
		/******************************/
		/* SET A UNIQUE SERIAL NUMBER */
		/******************************/
		serialNumber = AstNodeSerialNumber.getFresh();

		/***************************************/
		/* PRINT CORRESPONDING DERIVATION RULE */
		/***************************************/
		if (list == null)
			System.out.print("====================== expList -> exp\n");
		else
			System.out.print("====================== expList -> exp COMMA expList\n");

		/*******************************/
		/* COPY INPUT DATA MEMBERS ... */
		/*******************************/
		this.exp = exp;
		this.list = list;
	}

	/*************************************************/
	/* The printing message for an exp list AST node */
	/*************************************************/
	public void printMe()
	{
		/********************************/
		/* AST NODE TYPE = AST EXP LIST */
		/********************************/
		System.out.print("AST NODE EXP LIST\n");

		/************************************/
		/* RECURSIVELY PRINT exp + list ... */
		/************************************/
		if (exp  != null) exp.printMe();
		if (list != null) list.printMe();

		/***************************************/
		/* PRINT Node to AST GRAPHVIZ DOT file */
		/***************************************/
		AstGraphviz.getInstance().logNode(serialNumber, "EXP\nLIST");

		/****************************************/
		/* PRINT Edges to AST GRAPHVIZ DOT file */
		/****************************************/
		if (exp  != null) AstGraphviz.getInstance().logEdge(serialNumber,exp.serialNumber);
		if (list != null) AstGraphviz.getInstance().logEdge(serialNumber,list.serialNumber);
	}
}
