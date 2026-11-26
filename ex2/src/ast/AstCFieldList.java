package ast;

public class AstCFieldList extends AstNode
{
	/****************/
	/* DATA MEMBERS */
	/****************/
	public AstCField head;
	public AstCFieldList tail;

	/******************/
	/* CONSTRUCTOR(S) */
	/******************/
	public AstCFieldList(AstCField head, AstCFieldList tail)
	{
		/******************************/
		/* SET A UNIQUE SERIAL NUMBER */
		/******************************/
		serialNumber = AstNodeSerialNumber.getFresh();

		/***************************************/
		/* PRINT CORRESPONDING DERIVATION RULE */
		/***************************************/
		if (tail != null) System.out.print("====================== cFieldList -> cField cFieldList\n");
		if (tail == null) System.out.print("====================== cFieldList -> cField\n");

		/*******************************/
		/* COPY INPUT DATA MEMBERS ... */
		/*******************************/
		this.head = head;
		this.tail = tail;
	}

	/***************************************************/
	/* The printing message for a field list AST node  */
	/***************************************************/
	public void printMe()
	{
		/************************************/
		/* AST NODE TYPE = AST C FIELD LIST */
		/************************************/
		System.out.print("AST NODE CFIELD LIST\n");

		/*************************************/
		/* RECURSIVELY PRINT HEAD + TAIL ... */
		/*************************************/
		if (head != null) head.printMe();
		if (tail != null) tail.printMe();

		/**********************************/
		/* PRINT to AST GRAPHVIZ DOT file */
		/**********************************/
		AstGraphviz.getInstance().logNode(serialNumber, "CFIELD\nLIST");

		/****************************************/
		/* PRINT Edges to AST GRAPHVIZ DOT file */
		/****************************************/
		if (head != null) AstGraphviz.getInstance().logEdge(serialNumber,head.serialNumber);
		if (tail != null) AstGraphviz.getInstance().logEdge(serialNumber,tail.serialNumber);
	}
}
