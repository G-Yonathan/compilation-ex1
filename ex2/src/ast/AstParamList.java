package ast;

public class AstParamList extends AstNode
{
	/************************************/
	/*  type ID [ COMMA paramList ]     */
	/************************************/
	public AstType type;
	public String id;
	public AstParamList tail;

	/******************/
	/* CONSTRUCTOR(S) */
	/******************/
	public AstParamList(AstType type, String id, AstParamList tail)
	{
		/******************************/
		/* SET A UNIQUE SERIAL NUMBER */
		/******************************/
		serialNumber = AstNodeSerialNumber.getFresh();

		/***************************************/
		/* PRINT CORRESPONDING DERIVATION RULE */
		/***************************************/
		if (tail == null)
			System.out.format("====================== paramList -> type ID( %s )\n", id);
		else
			System.out.format("====================== paramList -> type ID( %s ) COMMA paramList\n", id);

		/*******************************/
		/* COPY INPUT DATA MEMBERS ... */
		/*******************************/
		this.type = type;
		this.id = id;
		this.tail = tail;
		if (type != null) this.line = type.line;
	}

	/*****************************************************/
	/* The printing message for a param list AST node    */
	/*****************************************************/
	public void printMe()
	{
		/**********************************/
		/* AST NODE TYPE = AST PARAM LIST */
		/**********************************/
		System.out.format("AST NODE PARAM LIST( %s )\n", id);

		/*************************************/
		/* RECURSIVELY PRINT type + tail ... */
		/*************************************/
		if (type != null) type.printMe();
		if (tail != null) tail.printMe();

		/***************************************/
		/* PRINT Node to AST GRAPHVIZ DOT file */
		/***************************************/
		AstGraphviz.getInstance().logNode(serialNumber, String.format("PARAM\n%s", id));

		/****************************************/
		/* PRINT Edges to AST GRAPHVIZ DOT file */
		/****************************************/
		if (type != null) AstGraphviz.getInstance().logEdge(serialNumber,type.serialNumber);
		if (tail != null) AstGraphviz.getInstance().logEdge(serialNumber,tail.serialNumber);
	}
}
