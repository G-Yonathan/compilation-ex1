package ast;

public class AstTypeVoid extends AstType
{
	/******************/
	/* CONSTRUCTOR(S) */
	/******************/
	public AstTypeVoid(int line)
	{
		/******************************/
		/* SET A UNIQUE SERIAL NUMBER */
		/******************************/
		serialNumber = AstNodeSerialNumber.getFresh();

		/***************************************/
		/* PRINT CORRESPONDING DERIVATION RULE */
		/***************************************/
		System.out.print("====================== type -> TYPE_VOID\n");

		/*******************************/
		/* COPY INPUT DATA MEMBERS ... */
		/*******************************/
		this.line = line;
	}

	/*************************************************/
	/* The printing message for a void type AST node */
	/*************************************************/
	public void printMe()
	{
		/*********************************/
		/* AST NODE TYPE = AST VOID TYPE */
		/*********************************/
		System.out.print("AST NODE TYPE VOID\n");

		/**********************************/
		/* Print to AST GRAPHVIZ DOT file */
		/**********************************/
		AstGraphviz.getInstance().logNode(serialNumber, "TYPE\nvoid");
	}
}
