package ast;

public class AstCallExp extends AstNode
{
	public AstVar var;
	public String id;
    public AstExpList list;

	/******************/
	/* CONSTRUCTOR(S) */
	/******************/
	public AstCallExp(AstVar var, String id, AstExpList list)
	{
		/******************************/
		/* SET A UNIQUE SERIAL NUMBER */
		/******************************/
		serialNumber = AstNodeSerialNumber.getFresh();

		/***************************************/
		/* PRINT CORRESPONDING DERIVATION RULE */
		/***************************************/
		if (var == null && list == null)
			System.out.print("====================== callExp -> ID LPAREN RPAREN\n");
		else if (var == null)
			System.out.print("====================== callExp -> ID LPAREN expList RPAREN\n");
		else if (list == null)
			System.out.print("====================== callExp -> var DOT ID LPAREN RPAREN\n");
		else
			System.out.print("====================== callExp -> var DOT ID LPAREN expList RPAREN\n");

		/*******************************/
		/* COPY INPUT DATA MEMBERS ... */
		/*******************************/
		this.var = var;
		this.id = id;
		this.list = list;
	}

	/************************************************/
	/* The printing message for a call exp AST node */
	/************************************************/
	public void printMe()
	{
		/*********************************/
		/* AST NODE TYPE = AST CALL EXP  */
		/*********************************/
		System.out.print("AST NODE CALL EXP\n");

		/************************************/
		/* RECURSIVELY PRINT var + list ... */
		/************************************/
		if (var  != null) var.printMe();
		if (list != null) list.printMe();

		/***************************************/
		/* PRINT Node to AST GRAPHVIZ DOT file */
		/***************************************/
		String label;
		if (var == null) label = String.format("CALL\n%s(...)",id);
		else             label = String.format("CALL\n...%s(...)",id);
		AstGraphviz.getInstance().logNode(serialNumber, label);

		/****************************************/
		/* PRINT Edges to AST GRAPHVIZ DOT file */
		/****************************************/
		if (var != null) AstGraphviz.getInstance().logEdge(serialNumber,var.serialNumber);
		if (list  != null) AstGraphviz.getInstance().logEdge(serialNumber,list.serialNumber);
	}
}
