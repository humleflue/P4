// Generated from Lang.g4 by ANTLR 4.9
package Compiler.Lang;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NUMBERTYPE=1, BOOLTYPE=2, BOOLLITERAL=3, NUMLITERAL=4, ENDF=5, RETURN=6, 
		IF=7, PRINTCHAR=8, LPAREN=9, RPAREN=10, LCURLY=11, RCURLY=12, LOGOR=13, 
		LOGAND=14, LOGEQ=15, LOGNOTEQ=16, LOGLESS=17, LOGGREATER=18, LOGLESSOREQ=19, 
		LOGGREATEROREQ=20, NEGATE=21, POW=22, COMMA=23, ASSIGN=24, PLUS=25, MINUS=26, 
		MULTIPLY=27, DIVIDE=28, SEMICOLON=29, WS=30, NEWLINE=31, ID=32;
	public static final int
		RULE_prog = 0, RULE_code = 1, RULE_funcdef = 2, RULE_type = 3, RULE_funcdefparams = 4, 
		RULE_funcdefparam = 5, RULE_stmts = 6, RULE_stmt = 7, RULE_expr = 8, RULE_val = 9, 
		RULE_funccall = 10, RULE_exprparams = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "code", "funcdef", "type", "funcdefparams", "funcdefparam", "stmts", 
			"stmt", "expr", "val", "funccall", "exprparams"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'number'", "'bool'", null, null, "'endf'", "'return'", "'if'", 
			"'?'", "'('", "')'", "'{'", "'}'", "'||'", "'&&'", "'=='", "'!='", "'<'", 
			"'>'", "'<='", "'>='", "'!'", "'^'", "','", "'='", "'+'", "'-'", "'*'", 
			"'/'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NUMBERTYPE", "BOOLTYPE", "BOOLLITERAL", "NUMLITERAL", "ENDF", 
			"RETURN", "IF", "PRINTCHAR", "LPAREN", "RPAREN", "LCURLY", "RCURLY", 
			"LOGOR", "LOGAND", "LOGEQ", "LOGNOTEQ", "LOGLESS", "LOGGREATER", "LOGLESSOREQ", 
			"LOGGREATEROREQ", "NEGATE", "POW", "COMMA", "ASSIGN", "PLUS", "MINUS", 
			"MULTIPLY", "DIVIDE", "SEMICOLON", "WS", "NEWLINE", "ID"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Lang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public TerminalNode EOF() { return getToken(LangParser.EOF, 0); }
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			code();
			setState(25);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CodeContext extends ParserRuleContext {
		public CodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code; }
	 
		public CodeContext() { }
		public void copyFrom(CodeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CodeEmptyContext extends CodeContext {
		public CodeEmptyContext(CodeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterCodeEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitCodeEmpty(this);
		}
	}
	public static class CodeStmtContext extends CodeContext {
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public CodeStmtContext(CodeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterCodeStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitCodeStmt(this);
		}
	}
	public static class CodeFuncdefContext extends CodeContext {
		public FuncdefContext funcdef() {
			return getRuleContext(FuncdefContext.class,0);
		}
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public CodeFuncdefContext(CodeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterCodeFuncdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitCodeFuncdef(this);
		}
	}

	public final CodeContext code() throws RecognitionException {
		CodeContext _localctx = new CodeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_code);
		try {
			setState(34);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBERTYPE:
			case BOOLTYPE:
				_localctx = new CodeFuncdefContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(27);
				funcdef();
				setState(28);
				code();
				}
				break;
			case BOOLLITERAL:
			case NUMLITERAL:
			case LPAREN:
			case NEGATE:
			case ID:
				_localctx = new CodeStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(30);
				stmt();
				setState(31);
				code();
				}
				break;
			case EOF:
				_localctx = new CodeEmptyContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncdefContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(LangParser.LPAREN, 0); }
		public FuncdefparamsContext funcdefparams() {
			return getRuleContext(FuncdefparamsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LangParser.RPAREN, 0); }
		public TerminalNode ASSIGN() { return getToken(LangParser.ASSIGN, 0); }
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(LangParser.RETURN, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public TerminalNode ENDF() { return getToken(LangParser.ENDF, 0); }
		public FuncdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcdef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterFuncdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitFuncdef(this);
		}
	}

	public final FuncdefContext funcdef() throws RecognitionException {
		FuncdefContext _localctx = new FuncdefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_funcdef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			type();
			setState(37);
			match(ID);
			setState(38);
			match(LPAREN);
			setState(39);
			funcdefparams();
			setState(40);
			match(RPAREN);
			setState(41);
			match(ASSIGN);
			setState(42);
			stmts();
			setState(43);
			match(RETURN);
			setState(44);
			stmt();
			setState(45);
			match(ENDF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode NUMBERTYPE() { return getToken(LangParser.NUMBERTYPE, 0); }
		public TerminalNode BOOLTYPE() { return getToken(LangParser.BOOLTYPE, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_la = _input.LA(1);
			if ( !(_la==NUMBERTYPE || _la==BOOLTYPE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncdefparamsContext extends ParserRuleContext {
		public FuncdefparamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcdefparams; }
	 
		public FuncdefparamsContext() { }
		public void copyFrom(FuncdefparamsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FuncdefparamsEmptyContext extends FuncdefparamsContext {
		public FuncdefparamsEmptyContext(FuncdefparamsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterFuncdefparamsEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitFuncdefparamsEmpty(this);
		}
	}
	public static class FuncdefparamsNotEmptyContext extends FuncdefparamsContext {
		public List<FuncdefparamContext> funcdefparam() {
			return getRuleContexts(FuncdefparamContext.class);
		}
		public FuncdefparamContext funcdefparam(int i) {
			return getRuleContext(FuncdefparamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LangParser.COMMA, i);
		}
		public FuncdefparamsNotEmptyContext(FuncdefparamsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterFuncdefparamsNotEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitFuncdefparamsNotEmpty(this);
		}
	}

	public final FuncdefparamsContext funcdefparams() throws RecognitionException {
		FuncdefparamsContext _localctx = new FuncdefparamsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_funcdefparams);
		int _la;
		try {
			setState(58);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBERTYPE:
			case BOOLTYPE:
				_localctx = new FuncdefparamsNotEmptyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				funcdefparam();
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(50);
					match(COMMA);
					setState(51);
					funcdefparam();
					}
					}
					setState(56);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case RPAREN:
				_localctx = new FuncdefparamsEmptyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncdefparamContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public FuncdefparamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcdefparam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterFuncdefparam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitFuncdefparam(this);
		}
	}

	public final FuncdefparamContext funcdefparam() throws RecognitionException {
		FuncdefparamContext _localctx = new FuncdefparamContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_funcdefparam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			type();
			setState(61);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtsContext extends ParserRuleContext {
		public StmtsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmts; }
	 
		public StmtsContext() { }
		public void copyFrom(StmtsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StmtsNotEmptyContext extends StmtsContext {
		public TerminalNode IF() { return getToken(LangParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(LangParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LangParser.RPAREN, 0); }
		public TerminalNode RETURN() { return getToken(LangParser.RETURN, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public StmtsNotEmptyContext(StmtsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterStmtsNotEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitStmtsNotEmpty(this);
		}
	}
	public static class StmtsEmptyContext extends StmtsContext {
		public StmtsEmptyContext(StmtsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterStmtsEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitStmtsEmpty(this);
		}
	}

	public final StmtsContext stmts() throws RecognitionException {
		StmtsContext _localctx = new StmtsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_stmts);
		try {
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				_localctx = new StmtsNotEmptyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				match(IF);
				setState(64);
				match(LPAREN);
				setState(65);
				expr(0);
				setState(66);
				match(RPAREN);
				setState(67);
				match(RETURN);
				setState(68);
				stmt();
				setState(69);
				stmts();
				}
				break;
			case RETURN:
				_localctx = new StmtsEmptyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(LangParser.SEMICOLON, 0); }
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitStmt(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			expr(0);
			setState(75);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BinaryOpContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode POW() { return getToken(LangParser.POW, 0); }
		public TerminalNode DIVIDE() { return getToken(LangParser.DIVIDE, 0); }
		public TerminalNode MULTIPLY() { return getToken(LangParser.MULTIPLY, 0); }
		public TerminalNode PLUS() { return getToken(LangParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(LangParser.MINUS, 0); }
		public TerminalNode LOGEQ() { return getToken(LangParser.LOGEQ, 0); }
		public TerminalNode LOGNOTEQ() { return getToken(LangParser.LOGNOTEQ, 0); }
		public TerminalNode LOGLESS() { return getToken(LangParser.LOGLESS, 0); }
		public TerminalNode LOGGREATER() { return getToken(LangParser.LOGGREATER, 0); }
		public TerminalNode LOGLESSOREQ() { return getToken(LangParser.LOGLESSOREQ, 0); }
		public TerminalNode LOGGREATEROREQ() { return getToken(LangParser.LOGGREATEROREQ, 0); }
		public TerminalNode LOGAND() { return getToken(LangParser.LOGAND, 0); }
		public TerminalNode LOGOR() { return getToken(LangParser.LOGOR, 0); }
		public BinaryOpContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterBinaryOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitBinaryOp(this);
		}
	}
	public static class UneryOpContext extends ExprContext {
		public Token op;
		public ValContext val() {
			return getRuleContext(ValContext.class,0);
		}
		public TerminalNode NEGATE() { return getToken(LangParser.NEGATE, 0); }
		public UneryOpContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterUneryOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitUneryOp(this);
		}
	}
	public static class ValueContext extends ExprContext {
		public ValContext val() {
			return getRuleContext(ValContext.class,0);
		}
		public ValueContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitValue(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLLITERAL:
			case NUMLITERAL:
			case LPAREN:
			case ID:
				{
				_localctx = new ValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(78);
				val();
				}
				break;
			case NEGATE:
				{
				_localctx = new UneryOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(79);
				((UneryOpContext)_localctx).op = match(NEGATE);
				setState(80);
				val();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(124);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(122);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryOpContext(new ExprContext(_parentctx, _parentState));
						((BinaryOpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(83);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(84);
						((BinaryOpContext)_localctx).op = match(POW);
						setState(85);
						((BinaryOpContext)_localctx).right = expr(14);
						}
						break;
					case 2:
						{
						_localctx = new BinaryOpContext(new ExprContext(_parentctx, _parentState));
						((BinaryOpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(86);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(87);
						((BinaryOpContext)_localctx).op = match(DIVIDE);
						setState(88);
						((BinaryOpContext)_localctx).right = expr(13);
						}
						break;
					case 3:
						{
						_localctx = new BinaryOpContext(new ExprContext(_parentctx, _parentState));
						((BinaryOpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(89);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(90);
						((BinaryOpContext)_localctx).op = match(MULTIPLY);
						setState(91);
						((BinaryOpContext)_localctx).right = expr(12);
						}
						break;
					case 4:
						{
						_localctx = new BinaryOpContext(new ExprContext(_parentctx, _parentState));
						((BinaryOpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(92);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(93);
						((BinaryOpContext)_localctx).op = match(PLUS);
						setState(94);
						((BinaryOpContext)_localctx).right = expr(11);
						}
						break;
					case 5:
						{
						_localctx = new BinaryOpContext(new ExprContext(_parentctx, _parentState));
						((BinaryOpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(95);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(96);
						((BinaryOpContext)_localctx).op = match(MINUS);
						setState(97);
						((BinaryOpContext)_localctx).right = expr(10);
						}
						break;
					case 6:
						{
						_localctx = new BinaryOpContext(new ExprContext(_parentctx, _parentState));
						((BinaryOpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(98);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(99);
						((BinaryOpContext)_localctx).op = match(LOGEQ);
						setState(100);
						((BinaryOpContext)_localctx).right = expr(9);
						}
						break;
					case 7:
						{
						_localctx = new BinaryOpContext(new ExprContext(_parentctx, _parentState));
						((BinaryOpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(101);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(102);
						((BinaryOpContext)_localctx).op = match(LOGNOTEQ);
						setState(103);
						((BinaryOpContext)_localctx).right = expr(8);
						}
						break;
					case 8:
						{
						_localctx = new BinaryOpContext(new ExprContext(_parentctx, _parentState));
						((BinaryOpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(104);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(105);
						((BinaryOpContext)_localctx).op = match(LOGLESS);
						setState(106);
						((BinaryOpContext)_localctx).right = expr(7);
						}
						break;
					case 9:
						{
						_localctx = new BinaryOpContext(new ExprContext(_parentctx, _parentState));
						((BinaryOpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(107);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(108);
						((BinaryOpContext)_localctx).op = match(LOGGREATER);
						setState(109);
						((BinaryOpContext)_localctx).right = expr(6);
						}
						break;
					case 10:
						{
						_localctx = new BinaryOpContext(new ExprContext(_parentctx, _parentState));
						((BinaryOpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(110);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(111);
						((BinaryOpContext)_localctx).op = match(LOGLESSOREQ);
						setState(112);
						((BinaryOpContext)_localctx).right = expr(5);
						}
						break;
					case 11:
						{
						_localctx = new BinaryOpContext(new ExprContext(_parentctx, _parentState));
						((BinaryOpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(113);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(114);
						((BinaryOpContext)_localctx).op = match(LOGGREATEROREQ);
						setState(115);
						((BinaryOpContext)_localctx).right = expr(4);
						}
						break;
					case 12:
						{
						_localctx = new BinaryOpContext(new ExprContext(_parentctx, _parentState));
						((BinaryOpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(116);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(117);
						((BinaryOpContext)_localctx).op = match(LOGAND);
						setState(118);
						((BinaryOpContext)_localctx).right = expr(3);
						}
						break;
					case 13:
						{
						_localctx = new BinaryOpContext(new ExprContext(_parentctx, _parentState));
						((BinaryOpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(119);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(120);
						((BinaryOpContext)_localctx).op = match(LOGOR);
						setState(121);
						((BinaryOpContext)_localctx).right = expr(2);
						}
						break;
					}
					} 
				}
				setState(126);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ValContext extends ParserRuleContext {
		public ValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_val; }
	 
		public ValContext() { }
		public void copyFrom(ValContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ValIdContext extends ValContext {
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public ValIdContext(ValContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterValId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitValId(this);
		}
	}
	public static class ValNumberContext extends ValContext {
		public TerminalNode NUMLITERAL() { return getToken(LangParser.NUMLITERAL, 0); }
		public ValNumberContext(ValContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterValNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitValNumber(this);
		}
	}
	public static class ValFunccallPrintContext extends ValContext {
		public FunccallContext funccall() {
			return getRuleContext(FunccallContext.class,0);
		}
		public TerminalNode PRINTCHAR() { return getToken(LangParser.PRINTCHAR, 0); }
		public ValFunccallPrintContext(ValContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterValFunccallPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitValFunccallPrint(this);
		}
	}
	public static class ValParenthesisedExprContext extends ValContext {
		public TerminalNode LPAREN() { return getToken(LangParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LangParser.RPAREN, 0); }
		public ValParenthesisedExprContext(ValContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterValParenthesisedExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitValParenthesisedExpr(this);
		}
	}
	public static class ValFunccallContext extends ValContext {
		public FunccallContext funccall() {
			return getRuleContext(FunccallContext.class,0);
		}
		public ValFunccallContext(ValContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterValFunccall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitValFunccall(this);
		}
	}
	public static class ValBooleanContext extends ValContext {
		public TerminalNode BOOLLITERAL() { return getToken(LangParser.BOOLLITERAL, 0); }
		public ValBooleanContext(ValContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterValBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitValBoolean(this);
		}
	}

	public final ValContext val() throws RecognitionException {
		ValContext _localctx = new ValContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_val);
		try {
			setState(138);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new ValParenthesisedExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				match(LPAREN);
				setState(128);
				expr(0);
				setState(129);
				match(RPAREN);
				}
				break;
			case 2:
				_localctx = new ValFunccallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				funccall();
				}
				break;
			case 3:
				_localctx = new ValFunccallPrintContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(132);
				funccall();
				setState(133);
				match(PRINTCHAR);
				}
				break;
			case 4:
				_localctx = new ValNumberContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(135);
				match(NUMLITERAL);
				}
				break;
			case 5:
				_localctx = new ValBooleanContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(136);
				match(BOOLLITERAL);
				}
				break;
			case 6:
				_localctx = new ValIdContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(137);
				match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunccallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(LangParser.LPAREN, 0); }
		public ExprparamsContext exprparams() {
			return getRuleContext(ExprparamsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LangParser.RPAREN, 0); }
		public FunccallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funccall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterFunccall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitFunccall(this);
		}
	}

	public final FunccallContext funccall() throws RecognitionException {
		FunccallContext _localctx = new FunccallContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_funccall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(ID);
			setState(141);
			match(LPAREN);
			setState(142);
			exprparams();
			setState(143);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprparamsContext extends ParserRuleContext {
		public ExprparamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprparams; }
	 
		public ExprparamsContext() { }
		public void copyFrom(ExprparamsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprparamsEmptyContext extends ExprparamsContext {
		public ExprparamsEmptyContext(ExprparamsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterExprparamsEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitExprparamsEmpty(this);
		}
	}
	public static class ExprparamsNotEmptyContext extends ExprparamsContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LangParser.COMMA, i);
		}
		public ExprparamsNotEmptyContext(ExprparamsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterExprparamsNotEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitExprparamsNotEmpty(this);
		}
	}

	public final ExprparamsContext exprparams() throws RecognitionException {
		ExprparamsContext _localctx = new ExprparamsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_exprparams);
		int _la;
		try {
			setState(154);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLLITERAL:
			case NUMLITERAL:
			case LPAREN:
			case NEGATE:
			case ID:
				_localctx = new ExprparamsNotEmptyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				expr(0);
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(146);
					match(COMMA);
					setState(147);
					expr(0);
					}
					}
					setState(152);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case RPAREN:
				_localctx = new ExprparamsEmptyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		case 6:
			return precpred(_ctx, 7);
		case 7:
			return precpred(_ctx, 6);
		case 8:
			return precpred(_ctx, 5);
		case 9:
			return precpred(_ctx, 4);
		case 10:
			return precpred(_ctx, 3);
		case 11:
			return precpred(_ctx, 2);
		case 12:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\"\u009f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3%\n\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\7\6\67"+
		"\n\6\f\6\16\6:\13\6\3\6\5\6=\n\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\5\bK\n\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\5\nT\n\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\7\n}\n\n\f\n\16\n\u0080\13\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13\u008d\n\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\7\r\u0097"+
		"\n\r\f\r\16\r\u009a\13\r\3\r\5\r\u009d\n\r\3\r\2\3\22\16\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\2\3\3\2\3\4\2\u00ac\2\32\3\2\2\2\4$\3\2\2\2\6&\3\2\2\2"+
		"\b\61\3\2\2\2\n<\3\2\2\2\f>\3\2\2\2\16J\3\2\2\2\20L\3\2\2\2\22S\3\2\2"+
		"\2\24\u008c\3\2\2\2\26\u008e\3\2\2\2\30\u009c\3\2\2\2\32\33\5\4\3\2\33"+
		"\34\7\2\2\3\34\3\3\2\2\2\35\36\5\6\4\2\36\37\5\4\3\2\37%\3\2\2\2 !\5\20"+
		"\t\2!\"\5\4\3\2\"%\3\2\2\2#%\3\2\2\2$\35\3\2\2\2$ \3\2\2\2$#\3\2\2\2%"+
		"\5\3\2\2\2&\'\5\b\5\2\'(\7\"\2\2()\7\13\2\2)*\5\n\6\2*+\7\f\2\2+,\7\32"+
		"\2\2,-\5\16\b\2-.\7\b\2\2./\5\20\t\2/\60\7\7\2\2\60\7\3\2\2\2\61\62\t"+
		"\2\2\2\62\t\3\2\2\2\638\5\f\7\2\64\65\7\31\2\2\65\67\5\f\7\2\66\64\3\2"+
		"\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29=\3\2\2\2:8\3\2\2\2;=\3\2\2\2<"+
		"\63\3\2\2\2<;\3\2\2\2=\13\3\2\2\2>?\5\b\5\2?@\7\"\2\2@\r\3\2\2\2AB\7\t"+
		"\2\2BC\7\13\2\2CD\5\22\n\2DE\7\f\2\2EF\7\b\2\2FG\5\20\t\2GH\5\16\b\2H"+
		"K\3\2\2\2IK\3\2\2\2JA\3\2\2\2JI\3\2\2\2K\17\3\2\2\2LM\5\22\n\2MN\7\37"+
		"\2\2N\21\3\2\2\2OP\b\n\1\2PT\5\24\13\2QR\7\27\2\2RT\5\24\13\2SO\3\2\2"+
		"\2SQ\3\2\2\2T~\3\2\2\2UV\f\17\2\2VW\7\30\2\2W}\5\22\n\20XY\f\16\2\2YZ"+
		"\7\36\2\2Z}\5\22\n\17[\\\f\r\2\2\\]\7\35\2\2]}\5\22\n\16^_\f\f\2\2_`\7"+
		"\33\2\2`}\5\22\n\rab\f\13\2\2bc\7\34\2\2c}\5\22\n\fde\f\n\2\2ef\7\21\2"+
		"\2f}\5\22\n\13gh\f\t\2\2hi\7\22\2\2i}\5\22\n\njk\f\b\2\2kl\7\23\2\2l}"+
		"\5\22\n\tmn\f\7\2\2no\7\24\2\2o}\5\22\n\bpq\f\6\2\2qr\7\25\2\2r}\5\22"+
		"\n\7st\f\5\2\2tu\7\26\2\2u}\5\22\n\6vw\f\4\2\2wx\7\20\2\2x}\5\22\n\5y"+
		"z\f\3\2\2z{\7\17\2\2{}\5\22\n\4|U\3\2\2\2|X\3\2\2\2|[\3\2\2\2|^\3\2\2"+
		"\2|a\3\2\2\2|d\3\2\2\2|g\3\2\2\2|j\3\2\2\2|m\3\2\2\2|p\3\2\2\2|s\3\2\2"+
		"\2|v\3\2\2\2|y\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\23\3"+
		"\2\2\2\u0080~\3\2\2\2\u0081\u0082\7\13\2\2\u0082\u0083\5\22\n\2\u0083"+
		"\u0084\7\f\2\2\u0084\u008d\3\2\2\2\u0085\u008d\5\26\f\2\u0086\u0087\5"+
		"\26\f\2\u0087\u0088\7\n\2\2\u0088\u008d\3\2\2\2\u0089\u008d\7\6\2\2\u008a"+
		"\u008d\7\5\2\2\u008b\u008d\7\"\2\2\u008c\u0081\3\2\2\2\u008c\u0085\3\2"+
		"\2\2\u008c\u0086\3\2\2\2\u008c\u0089\3\2\2\2\u008c\u008a\3\2\2\2\u008c"+
		"\u008b\3\2\2\2\u008d\25\3\2\2\2\u008e\u008f\7\"\2\2\u008f\u0090\7\13\2"+
		"\2\u0090\u0091\5\30\r\2\u0091\u0092\7\f\2\2\u0092\27\3\2\2\2\u0093\u0098"+
		"\5\22\n\2\u0094\u0095\7\31\2\2\u0095\u0097\5\22\n\2\u0096\u0094\3\2\2"+
		"\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009d"+
		"\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u009d\3\2\2\2\u009c\u0093\3\2\2\2\u009c"+
		"\u009b\3\2\2\2\u009d\31\3\2\2\2\f$8<JS|~\u008c\u0098\u009c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}