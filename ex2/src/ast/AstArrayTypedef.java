package ast;

public class AstArrayTypedef extends AstDec
{
	/*****************************************/
	/*  ARRAY ID = type [ ] ;                */
	/*****************************************/
	public String id;
	public AstType elementType;

	/******************/
	/* CONSTRUCTOR(S) */
	/******************/
	public AstArrayTypedef(String id, AstType elementType)
	{
		/******************************/
		/* SET A UNIQUE SERIAL NUMBER */
		/******************************/
		serialNumber = AstNodeSerialNumber.getFresh();

		/***************************************/
		/* PRINT CORRESPONDING DERIVATION RULE */
		/***************************************/
		System.out.format("====================== arrayTypedef -> ARRAY ID( %s ) EQ type LBRACK RBRACK SEMICOLON\n", id);

		/*******************************/
		/* COPY INPUT DATA MEMBERS ... */
		/*******************************/
		this.id = id;
		this.elementType = elementType;
		if (elementType != null) this.line = elementType.line;
	}

	/*****************************************************/
	/* The printing message for an array typedef node    */
	/*****************************************************/
	public void printMe()
	{
		/*************************************/
		/* AST NODE TYPE = AST ARRAY TYPEDEF */
		/*************************************/
		System.out.format("AST NODE ARRAY TYPEDEF( %s )\n", id);

		/*************************************/
		/* RECURSIVELY PRINT elementType ... */
		/*************************************/
		if (elementType != null) elementType.printMe();

		/***************************************/
		/* PRINT Node to AST GRAPHVIZ DOT file */
		/***************************************/
		AstGraphviz.getInstance().logNode(serialNumber, String.format("ARRAY TYPEDEF\n%s = type[]", id));

		/****************************************/
		/* PRINT Edges to AST GRAPHVIZ DOT file */
		/****************************************/
		if (elementType != null) AstGraphviz.getInstance().logEdge(serialNumber,elementType.serialNumber);
	}
}
