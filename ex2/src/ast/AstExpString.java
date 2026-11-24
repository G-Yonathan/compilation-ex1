package ast;

public class AstExpString extends AstExp
{
	public String value;

	/******************/
	/* CONSTRUCTOR(S) */
	/******************/
	public AstExpString(String value)
	{
		/******************************/
		/* SET A UNIQUE SERIAL NUMBER */
		/******************************/
		serialNumber = AstNodeSerialNumber.getFresh();

		/***************************************/
		/* PRINT CORRESPONDING DERIVATION RULE */
		/***************************************/
		System.out.format("====================== exp -> STRING( %s )\n", value);

		/*******************************/
		/* COPY INPUT DATA MEMBERS ... */
		/*******************************/
		this.value = value;
	}

	/***************************************************/
	/* The printing message for a string exp AST node */
	/***************************************************/
	public void printMe()
	{
		/**********************************/
		/* AST NODE TYPE = AST STRING EXP */
		/**********************************/
		System.out.format("AST NODE STRING( %s )\n",value);

		/*****************************************************/
		/* Print to AST GRAPHVIZ DOT file (the value keeps   */
		/* its quotes, so escape them inside the dot label)  */
		/*****************************************************/
		AstGraphviz.getInstance().logNode(
				serialNumber,
			String.format("STRING(%s)",value.replace("\"","\\\"")));
	}
}
