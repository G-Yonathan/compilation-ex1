package ast;

public abstract class AstVarDec extends AstDec
{
	/******************************************/
	/* type ID [ := exp | := newExp ] ;       */
	/* common to both variable declarations   */
	/******************************************/
	public AstType type;
	public String id;
}
