package ast;

public class AstTypeId extends AstType
{
	/***************************************/
	/* name of a class or array type, e.g. */
	/* Person or IntArray                  */
	/***************************************/
	public String name;

	/******************/
	/* CONSTRUCTOR(S) */
	/******************/
	public AstTypeId(String name, int line)
	{
		/******************************/
		/* SET A UNIQUE SERIAL NUMBER */
		/******************************/
		serialNumber = AstNodeSerialNumber.getFresh();

		/***************************************/
		/* PRINT CORRESPONDING DERIVATION RULE */
		/***************************************/
		System.out.print("====================== type -> ID\n");

		/*******************************/
		/* COPY INPUT DATA MEMBERS ... */
		/*******************************/
		this.name = name;
		this.line = line;
	}

	/*****************************************************/
	/* The printing message for a named type AST node    */
	/*****************************************************/
	public void printMe()
	{
		/**********************************/
		/* AST NODE TYPE = AST NAMED TYPE */
		/**********************************/
		System.out.print(String.format("AST NODE TYPE ID(%s)\n", name));

		/**********************************/
		/* Print to AST GRAPHVIZ DOT file */
		/**********************************/
		AstGraphviz.getInstance().logNode(serialNumber, String.format("TYPE\n%s", name));
	}
}
