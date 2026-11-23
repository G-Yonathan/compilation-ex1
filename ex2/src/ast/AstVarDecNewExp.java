package ast;

public class AstVarDecNewExp extends AstVarDec
{
	/********************************/
	/*  type ID ASSIGN newExp ;     */
	/********************************/
	public AstNewExp newExp;

	/******************/
	/* CONSTRUCTOR(S) */
	/******************/
	public AstVarDecNewExp(AstType type, String id, AstNewExp newExp)
	{
		/******************************/
		/* SET A UNIQUE SERIAL NUMBER */
		/******************************/
		serialNumber = AstNodeSerialNumber.getFresh();

		/***************************************/
		/* PRINT CORRESPONDING DERIVATION RULE */
		/***************************************/
		System.out.format("====================== varDec -> type ID( %s ) ASSIGN newExp SEMICOLON\n", id);

		/*******************************/
		/* COPY INPUT DATA MEMBERS ... */
		/*******************************/
		this.type = type;
		this.id = id;
		this.newExp = newExp;
		if (type != null) this.line = type.line;
	}

	/***********************************************************/
	/* The printing message for a var dec := new AST node      */
	/***********************************************************/
	public void printMe()
	{
		/***************************************/
		/* AST NODE TYPE = AST VAR DEC NEW EXP */
		/***************************************/
		System.out.format("AST NODE VAR DEC NEW( %s )\n", id);

		/***************************************/
		/* RECURSIVELY PRINT type + newExp ... */
		/***************************************/
		if (type   != null) type.printMe();
		if (newExp != null) newExp.printMe();

		/***************************************/
		/* PRINT Node to AST GRAPHVIZ DOT file */
		/***************************************/
		AstGraphviz.getInstance().logNode(serialNumber, String.format("VAR DEC\n%s := new", id));

		/****************************************/
		/* PRINT Edges to AST GRAPHVIZ DOT file */
		/****************************************/
		if (type   != null) AstGraphviz.getInstance().logEdge(serialNumber,type.serialNumber);
		if (newExp != null) AstGraphviz.getInstance().logEdge(serialNumber,newExp.serialNumber);
	}
}
