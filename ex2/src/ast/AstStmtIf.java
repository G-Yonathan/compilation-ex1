package ast;

public class AstStmtIf extends AstStmt
{
	/*******************************************/
	/*  if (cond) { body } [else { elseBody }] */
	/*******************************************/
	public AstExp cond;
	public AstStmtList body;
	public AstStmtList elseBody;

	/*******************/
	/*  CONSTRUCTOR(S) */
	/*******************/
	public AstStmtIf(AstExp cond, AstStmtList body, AstStmtList elseBody)
	{
		/******************************/
		/* SET A UNIQUE SERIAL NUMBER */
		/******************************/
		serialNumber = AstNodeSerialNumber.getFresh();

		/***************************************/
		/* PRINT CORRESPONDING DERIVATION RULE */
		/***************************************/
		if (elseBody == null)
			System.out.print("====================== stmt -> IF LPAREN exp RPAREN LBRACE stmtList RBRACE\n");
		else
			System.out.print("====================== stmt -> IF LPAREN exp RPAREN LBRACE stmtList RBRACE ELSE LBRACE stmtList RBRACE\n");

		/*******************************/
		/* COPY INPUT DATA MEMBERS ... */
		/*******************************/
		this.cond = cond;
		this.body = body;
		this.elseBody = elseBody;
	}

	/*****************************************************/
	/* The printing message for an if statement AST node */
	/*****************************************************/
	public void printMe()
	{
		/************************************/
		/* AST NODE TYPE = AST IF STATEMENT */
		/************************************/
		System.out.print("AST NODE IF STMT\n");

		/************************************************/
		/* RECURSIVELY PRINT cond + body + elseBody ... */
		/************************************************/
		if (cond     != null) cond.printMe();
		if (body     != null) body.printMe();
		if (elseBody != null) elseBody.printMe();

		/***************************************/
		/* PRINT Node to AST GRAPHVIZ DOT file */
		/***************************************/
		String label;
		if (elseBody == null) label = "IF\n(cond) {body}";
		else                  label = "IF\n(cond) {body}\nelse {elseBody}";
		AstGraphviz.getInstance().logNode(serialNumber, label);

		/****************************************/
		/* PRINT Edges to AST GRAPHVIZ DOT file */
		/****************************************/
		if (cond     != null) AstGraphviz.getInstance().logEdge(serialNumber,cond.serialNumber);
		if (body     != null) AstGraphviz.getInstance().logEdge(serialNumber,body.serialNumber);
		if (elseBody != null) AstGraphviz.getInstance().logEdge(serialNumber,elseBody.serialNumber);
	}
}
