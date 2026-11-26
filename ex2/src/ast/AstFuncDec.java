package ast;

public class AstFuncDec extends AstDec
{
	/*****************************************************/
	/*  returnType ID ( [paramList] ) { stmtList }       */
	/*****************************************************/
	public AstType returnType;
	public String id;
	public AstParamList params;
	public AstStmtList body;

	/******************/
	/* CONSTRUCTOR(S) */
	/******************/
	public AstFuncDec(AstType returnType, String id, AstParamList params, AstStmtList body)
	{
		/******************************/
		/* SET A UNIQUE SERIAL NUMBER */
		/******************************/
		serialNumber = AstNodeSerialNumber.getFresh();

		/***************************************/
		/* PRINT CORRESPONDING DERIVATION RULE */
		/***************************************/
		if (params == null)
			System.out.format("====================== funcDec -> type ID( %s ) LPAREN RPAREN LBRACE stmtList RBRACE\n", id);
		else
			System.out.format("====================== funcDec -> type ID( %s ) LPAREN paramList RPAREN LBRACE stmtList RBRACE\n", id);

		/*******************************/
		/* COPY INPUT DATA MEMBERS ... */
		/*******************************/
		this.returnType = returnType;
		this.id = id;
		this.params = params;
		this.body = body;
		if (returnType != null) this.line = returnType.line;
	}

	/************************************************************/
	/* The printing message for a function declaration AST node */
	/************************************************************/
	public void printMe()
	{
		/********************************/
		/* AST NODE TYPE = AST FUNC DEC */
		/********************************/
		System.out.format("AST NODE FUNC DEC( %s )\n", id);

		/**************************************************/
		/* RECURSIVELY PRINT returnType + params + body   */
		/**************************************************/
		if (returnType != null) returnType.printMe();
		if (params     != null) params.printMe();
		if (body       != null) body.printMe();

		/***************************************/
		/* PRINT Node to AST GRAPHVIZ DOT file */
		/***************************************/
		AstGraphviz.getInstance().logNode(serialNumber, String.format("FUNC DEC\n%s(...)", id));

		/****************************************/
		/* PRINT Edges to AST GRAPHVIZ DOT file */
		/****************************************/
		if (returnType != null) AstGraphviz.getInstance().logEdge(serialNumber,returnType.serialNumber);
		if (params     != null) AstGraphviz.getInstance().logEdge(serialNumber,params.serialNumber);
		if (body       != null) AstGraphviz.getInstance().logEdge(serialNumber,body.serialNumber);
	}
}
