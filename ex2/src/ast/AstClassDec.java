package ast;

public class AstClassDec extends AstDec
{
	/*******************************************************/
	/*  CLASS ID [ EXTENDS ID ] { cFieldList }             */
	/*******************************************************/
	public String id;
	public String parentId;
	public AstCFieldList fields;

	/******************/
	/* CONSTRUCTOR(S) */
	/******************/
	public AstClassDec(String id, String parentId, AstCFieldList fields)
	{
		/******************************/
		/* SET A UNIQUE SERIAL NUMBER */
		/******************************/
		serialNumber = AstNodeSerialNumber.getFresh();

		/***************************************/
		/* PRINT CORRESPONDING DERIVATION RULE */
		/***************************************/
		if (parentId == null)
			System.out.format("====================== classDec -> CLASS ID( %s ) LBRACE cFieldList RBRACE\n", id);
		else
			System.out.format("====================== classDec -> CLASS ID( %s ) EXTENDS ID( %s ) LBRACE cFieldList RBRACE\n", id, parentId);

		/*******************************/
		/* COPY INPUT DATA MEMBERS ... */
		/*******************************/
		this.id = id;
		this.parentId = parentId;
		this.fields = fields;
	}

	/*********************************************************/
	/* The printing message for a class declaration AST node */
	/*********************************************************/
	public void printMe()
	{
		/*********************************/
		/* AST NODE TYPE = AST CLASS DEC */
		/*********************************/
		if (parentId == null) System.out.format("AST NODE CLASS DEC( %s )\n", id);
		else                  System.out.format("AST NODE CLASS DEC( %s EXTENDS %s )\n", id, parentId);

		/*******************************/
		/* RECURSIVELY PRINT fields ... */
		/*******************************/
		if (fields != null) fields.printMe();

		/***************************************/
		/* PRINT Node to AST GRAPHVIZ DOT file */
		/***************************************/
		String label;
		if (parentId == null) label = String.format("CLASS\n%s", id);
		else                  label = String.format("CLASS\n%s\nextends %s", id, parentId);
		AstGraphviz.getInstance().logNode(serialNumber, label);

		/****************************************/
		/* PRINT Edges to AST GRAPHVIZ DOT file */
		/****************************************/
		if (fields != null) AstGraphviz.getInstance().logEdge(serialNumber,fields.serialNumber);
	}
}
