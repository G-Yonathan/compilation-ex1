public interface TokenNames {
  /* terminals */
  public static final int EOF = 0;
  public static final int PLUS = 1;
  public static final int MINUS = 2;
  public static final int TIMES = 3;
  public static final int DIVIDE = 4;
  public static final int LPAREN = 5;
  public static final int RPAREN = 6;
  public static final int INT = 7;
  public static final int ID = 8;
  public static final int EQ = 9;
  public static final int LT = 10;
  public static final int GT = 11;
  public static final int AND = 12;
  public static final int OR = 13;
  public static final int LBRACK = 14;
  public static final int RBRACK = 15;
  public static final int LBRACE = 16;
  public static final int RBRACE = 17;
  public static final int COMMA = 18;
  public static final int DOT = 19;
  public static final int SEMICOLON = 20;
  public static final int ASSIGN = 21;
  public static final int ARRAY = 22;
  public static final int CLASS = 23;
  public static final int EXTENDS = 24;
  public static final int NEW = 25;
  public static final int NIL = 26;
  public static final int IF = 27;
  public static final int ELSE = 28;
  public static final int WHILE = 29;
  public static final int RETURN = 30;
  public static final int TYPE_INT = 31;
  public static final int TYPE_STRING = 32;
  public static final int TYPE_VOID = 33;
  public static final int STRING = 34;

  public static String nameOf(int token) {
    switch (token) {
      case EOF: return "EOF";
      case PLUS: return "PLUS";
      case MINUS: return "MINUS";
      case TIMES: return "TIMES";
      case DIVIDE: return "DIVIDE";
      case LPAREN: return "LPAREN";
      case RPAREN: return "RPAREN";
      case INT: return "INT";
      case ID: return "ID";
      case EQ: return "EQ";
      case LT: return "LT";
      case GT: return "GT";
      case AND: return "AND";
      case OR: return "OR";
      case LBRACK: return "LBRACK";
      case RBRACK: return "RBRACK";
      case LBRACE: return "LBRACE";
      case RBRACE: return "RBRACE";
      case COMMA: return "COMMA";
      case DOT: return "DOT";
      case SEMICOLON: return "SEMICOLON";
      case ASSIGN: return "ASSIGN";
      case ARRAY: return "ARRAY";
      case CLASS: return "CLASS";
      case EXTENDS: return "EXTENDS";
      case NEW: return "NEW";
      case NIL: return "NIL";
      case IF: return "IF";
      case ELSE: return "ELSE";
      case WHILE: return "WHILE";
      case RETURN: return "RETURN";
      case TYPE_INT: return "TYPE_INT";
      case TYPE_STRING: return "TYPE_STRING";
      case TYPE_VOID: return "TYPE_VOID";
      case STRING: return "STRING";
      default: return "UNKNOWN";
    }
  }
}
