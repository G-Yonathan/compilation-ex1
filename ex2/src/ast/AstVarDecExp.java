package ast;

public class AstVarDecExp extends AstVarDec
{
	/*****************************/
	/*  type ID [ ASSIGN exp ] ; */
	/*****************************/
	public AstExp exp;

	/******************/
	/* CONSTRUCTOR(S) */
	/******************/
	public AstVarDecExp(AstType type, String id, AstExp exp)
	{
		/******************************/
		/* SET A UNIQUE SERIAL NUMBER */
		/******************************/
		serialNumber = AstNodeSerialNumber.getFresh();

		/***************************************/
		/* PRINT CORRESPONDING DERIVATION RULE */
		/***************************************/
		if (exp == null)
			System.out.format("====================== varDec -> type ID( %s ) SEMICOLON\n", id);
		else
			System.out.format("====================== varDec -> type ID( %s ) ASSIGN exp SEMICOLON\n", id);

		/*******************************/
		/* COPY INPUT DATA MEMBERS ... */
		/*******************************/
		this.type = type;
		this.id = id;
		this.exp = exp;
		if (type != null) this.line = type.line;
	}

	/*******************************************************/
	/* The printing message for a var declaration AST node */
	/*******************************************************/
	public void printMe()
	{
		/*******************************/
		/* AST NODE TYPE = AST VAR DEC */
		/*******************************/
		System.out.format("AST NODE VAR DEC( %s )\n", id);

		/************************************/
		/* RECURSIVELY PRINT type + exp ... */
		/************************************/
		if (type != null) type.printMe();
		if (exp  != null) exp.printMe();

		/***************************************/
		/* PRINT Node to AST GRAPHVIZ DOT file */
		/***************************************/
		String label;
		if (exp == null) label = String.format("VAR DEC\n%s", id);
		else             label = String.format("VAR DEC\n%s := exp", id);
		AstGraphviz.getInstance().logNode(serialNumber, label);

		/****************************************/
		/* PRINT Edges to AST GRAPHVIZ DOT file */
		/****************************************/
		if (type != null) AstGraphviz.getInstance().logEdge(serialNumber,type.serialNumber);
		if (exp  != null) AstGraphviz.getInstance().logEdge(serialNumber,exp.serialNumber);
	}
}
