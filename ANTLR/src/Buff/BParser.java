// Generated from B.g4 by ANTLR 4.9
package Buff;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BParser extends Parser {
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
		RULE_funcdefmoreparams = 5, RULE_funcdefparam = 6, RULE_stmts = 7, RULE_stmt = 8, 
		RULE_expr = 9, RULE_logexpr = 10, RULE_logexpr2 = 11, RULE_logexpr3 = 12, 
		RULE_mathexpr = 13, RULE_mathexpr2 = 14, RULE_mathexpr3 = 15, RULE_logexpr4 = 16, 
		RULE_val = 17, RULE_funccall = 18, RULE_exprparams = 19, RULE_exprmoreparams = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "code", "funcdef", "type", "funcdefparams", "funcdefmoreparams", 
			"funcdefparam", "stmts", "stmt", "expr", "logexpr", "logexpr2", "logexpr3", 
			"mathexpr", "mathexpr2", "mathexpr3", "logexpr4", "val", "funccall", 
			"exprparams", "exprmoreparams"
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
	public String getGrammarFileName() { return "B.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public TerminalNode EOF() { return getToken(BParser.EOF, 0); }
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			code();
			setState(43);
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
			if ( listener instanceof BListener ) ((BListener)listener).enterCodeEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitCodeEmpty(this);
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
			if ( listener instanceof BListener ) ((BListener)listener).enterCodeStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitCodeStmt(this);
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
			if ( listener instanceof BListener ) ((BListener)listener).enterCodeFuncdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitCodeFuncdef(this);
		}
	}

	public final CodeContext code() throws RecognitionException {
		CodeContext _localctx = new CodeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_code);
		try {
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBERTYPE:
			case BOOLTYPE:
				_localctx = new CodeFuncdefContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				funcdef();
				setState(46);
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
				setState(48);
				stmt();
				setState(49);
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
		public TerminalNode ID() { return getToken(BParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(BParser.LPAREN, 0); }
		public FuncdefparamsContext funcdefparams() {
			return getRuleContext(FuncdefparamsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BParser.RPAREN, 0); }
		public TerminalNode ASSIGN() { return getToken(BParser.ASSIGN, 0); }
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(BParser.RETURN, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public TerminalNode ENDF() { return getToken(BParser.ENDF, 0); }
		public FuncdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcdef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).enterFuncdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitFuncdef(this);
		}
	}

	public final FuncdefContext funcdef() throws RecognitionException {
		FuncdefContext _localctx = new FuncdefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_funcdef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			type();
			setState(55);
			match(ID);
			setState(56);
			match(LPAREN);
			setState(57);
			funcdefparams();
			setState(58);
			match(RPAREN);
			setState(59);
			match(ASSIGN);
			setState(60);
			stmts();
			setState(61);
			match(RETURN);
			setState(62);
			stmt();
			setState(63);
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
		public TerminalNode NUMBERTYPE() { return getToken(BParser.NUMBERTYPE, 0); }
		public TerminalNode BOOLTYPE() { return getToken(BParser.BOOLTYPE, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
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
			if ( listener instanceof BListener ) ((BListener)listener).enterFuncdefparamsEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitFuncdefparamsEmpty(this);
		}
	}
	public static class FuncdefparamsNotEmptyContext extends FuncdefparamsContext {
		public FuncdefparamContext funcdefparam() {
			return getRuleContext(FuncdefparamContext.class,0);
		}
		public FuncdefmoreparamsContext funcdefmoreparams() {
			return getRuleContext(FuncdefmoreparamsContext.class,0);
		}
		public FuncdefparamsNotEmptyContext(FuncdefparamsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).enterFuncdefparamsNotEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitFuncdefparamsNotEmpty(this);
		}
	}

	public final FuncdefparamsContext funcdefparams() throws RecognitionException {
		FuncdefparamsContext _localctx = new FuncdefparamsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_funcdefparams);
		try {
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBERTYPE:
			case BOOLTYPE:
				_localctx = new FuncdefparamsNotEmptyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				funcdefparam();
				setState(68);
				funcdefmoreparams();
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

	public static class FuncdefmoreparamsContext extends ParserRuleContext {
		public FuncdefmoreparamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcdefmoreparams; }
	 
		public FuncdefmoreparamsContext() { }
		public void copyFrom(FuncdefmoreparamsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FuncdefmoreparamsNotEmptyContext extends FuncdefmoreparamsContext {
		public TerminalNode COMMA() { return getToken(BParser.COMMA, 0); }
		public FuncdefparamContext funcdefparam() {
			return getRuleContext(FuncdefparamContext.class,0);
		}
		public FuncdefmoreparamsContext funcdefmoreparams() {
			return getRuleContext(FuncdefmoreparamsContext.class,0);
		}
		public FuncdefmoreparamsNotEmptyContext(FuncdefmoreparamsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).enterFuncdefmoreparamsNotEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitFuncdefmoreparamsNotEmpty(this);
		}
	}
	public static class FuncdefmoreparamsEmptyContext extends FuncdefmoreparamsContext {
		public FuncdefmoreparamsEmptyContext(FuncdefmoreparamsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).enterFuncdefmoreparamsEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitFuncdefmoreparamsEmpty(this);
		}
	}

	public final FuncdefmoreparamsContext funcdefmoreparams() throws RecognitionException {
		FuncdefmoreparamsContext _localctx = new FuncdefmoreparamsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_funcdefmoreparams);
		try {
			setState(78);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMA:
				_localctx = new FuncdefmoreparamsNotEmptyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				match(COMMA);
				setState(74);
				funcdefparam();
				setState(75);
				funcdefmoreparams();
				}
				break;
			case RPAREN:
				_localctx = new FuncdefmoreparamsEmptyContext(_localctx);
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
		public TerminalNode ID() { return getToken(BParser.ID, 0); }
		public FuncdefparamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcdefparam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).enterFuncdefparam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitFuncdefparam(this);
		}
	}

	public final FuncdefparamContext funcdefparam() throws RecognitionException {
		FuncdefparamContext _localctx = new FuncdefparamContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_funcdefparam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			type();
			setState(81);
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
		public TerminalNode IF() { return getToken(BParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(BParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BParser.RPAREN, 0); }
		public TerminalNode RETURN() { return getToken(BParser.RETURN, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public StmtsNotEmptyContext(StmtsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).enterStmtsNotEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitStmtsNotEmpty(this);
		}
	}
	public static class StmtsEmptyContext extends StmtsContext {
		public StmtsEmptyContext(StmtsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).enterStmtsEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitStmtsEmpty(this);
		}
	}

	public final StmtsContext stmts() throws RecognitionException {
		StmtsContext _localctx = new StmtsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_stmts);
		try {
			setState(92);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				_localctx = new StmtsNotEmptyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(83);
				match(IF);
				setState(84);
				match(LPAREN);
				setState(85);
				expr();
				setState(86);
				match(RPAREN);
				setState(87);
				match(RETURN);
				setState(88);
				stmt();
				setState(89);
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
		public TerminalNode SEMICOLON() { return getToken(BParser.SEMICOLON, 0); }
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitStmt(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			expr();
			setState(95);
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
	public static class LogOrContext extends ExprContext {
		public LogexprContext left;
		public Token op;
		public ExprContext right;
		public LogexprContext logexpr() {
			return getRuleContext(LogexprContext.class,0);
		}
		public TerminalNode LOGOR() { return getToken(BParser.LOGOR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LogOrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).enterLogOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitLogOr(this);
		}
	}
	public static class LogContext extends ExprContext {
		public LogexprContext logexpr() {
			return getRuleContext(LogexprContext.class,0);
		}
		public LogContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).enterLog(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitLog(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expr);
		try {
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new LogOrContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				((LogOrContext)_localctx).left = logexpr();
				setState(98);
				((LogOrContext)_localctx).op = match(LOGOR);
				setState(99);
				((LogOrContext)_localctx).right = expr();
				}
				break;
			case 2:
				_localctx = new LogContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				logexpr();
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

	public static class LogexprContext extends ParserRuleContext {
		public LogexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logexpr; }
	 
		public LogexprContext() { }
		public void copyFrom(LogexprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LogAndContext extends LogexprContext {
		public Logexpr2Context left;
		public Token op;
		public LogexprContext right;
		public Logexpr2Context logexpr2() {
			return getRuleContext(Logexpr2Context.class,0);
		}
		public TerminalNode LOGAND() { return getToken(BParser.LOGAND, 0); }
		public LogexprContext logexpr() {
			return getRuleContext(LogexprContext.class,0);
		}
		public LogAndContext(LogexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).enterLogAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitLogAnd(this);
		}
	}
	public static class Log2Context extends LogexprContext {
		public Logexpr2Context logexpr2() {
			return getRuleContext(Logexpr2Context.class,0);
		}
		public Log2Context(LogexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).enterLog2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitLog2(this);
		}
	}

	public final LogexprContext logexpr() throws RecognitionException {
		LogexprContext _localctx = new LogexprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_logexpr);
		try {
			setState(109);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new LogAndContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				((LogAndContext)_localctx).left = logexpr2();
				setState(105);
				((LogAndContext)_localctx).op = match(LOGAND);
				setState(106);
				((LogAndContext)_localctx).right = logexpr();
				}
				break;
			case 2:
				_localctx = new Log2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
				logexpr2();
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

	public static class Logexpr2Context extends ParserRuleContext {
		public Logexpr2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logexpr2; }
	 
		public Logexpr2Context() { }
		public void copyFrom(Logexpr2Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LogEqualsOpContext extends Logexpr2Context {
		public Logexpr3Context left;
		public Token op;
		public Logexpr2Context right;
		public Logexpr3Context logexpr3() {
			return getRuleContext(Logexpr3Context.class,0);
		}
		public TerminalNode LOGEQ() { return getToken(BParser.LOGEQ, 0); }
		public Logexpr2Context logexpr2() {
			return getRuleContext(Logexpr2Context.class,0);
		}
		public TerminalNode LOGNOTEQ() { return getToken(BParser.LOGNOTEQ, 0); }
		public LogEqualsOpContext(Logexpr2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).enterLogEqualsOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitLogEqualsOp(this);
		}
	}
	public static class Log3Context extends Logexpr2Context {
		public Logexpr3Context logexpr3() {
			return getRuleContext(Logexpr3Context.class,0);
		}
		public Log3Context(Logexpr2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).enterLog3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitLog3(this);
		}
	}

	public final Logexpr2Context logexpr2() throws RecognitionException {
		Logexpr2Context _localctx = new Logexpr2Context(_ctx, getState());
		enterRule(_localctx, 22, RULE_logexpr2);
		try {
			setState(120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new LogEqualsOpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				((LogEqualsOpContext)_localctx).left = logexpr3();
				setState(112);
				((LogEqualsOpContext)_localctx).op = match(LOGEQ);
				setState(113);
				((LogEqualsOpContext)_localctx).right = logexpr2();
				}
				break;
			case 2:
				_localctx = new LogEqualsOpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(115);
				((LogEqualsOpContext)_localctx).left = logexpr3();
				setState(116);
				((LogEqualsOpContext)_localctx).op = match(LOGNOTEQ);
				setState(117);
				((LogEqualsOpContext)_localctx).right = logexpr2();
				}
				break;
			case 3:
				_localctx = new Log3Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(119);
				logexpr3();
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

	public static class Logexpr3Context extends ParserRuleContext {
		public Logexpr3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logexpr3; }
	 
		public Logexpr3Context() { }
		public void copyFrom(Logexpr3Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LogOpContext extends Logexpr3Context {
		public MathexprContext left;
		public Token op;
		public Logexpr3Context right;
		public MathexprContext mathexpr() {
			return getRuleContext(MathexprContext.class,0);
		}
		public TerminalNode LOGLESS() { return getToken(BParser.LOGLESS, 0); }
		public Logexpr3Context logexpr3() {
			return getRuleContext(Logexpr3Context.class,0);
		}
		public TerminalNode LOGGREATER() { return getToken(BParser.LOGGREATER, 0); }
		public TerminalNode LOGLESSOREQ() { return getToken(BParser.LOGLESSOREQ, 0); }
		public TerminalNode LOGGREATEROREQ() { return getToken(BParser.LOGGREATEROREQ, 0); }
		public LogOpContext(Logexpr3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).enterLogOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitLogOp(this);
		}
	}
	public static class MathContext extends Logexpr3Context {
		public MathexprContext mathexpr() {
			return getRuleContext(MathexprContext.class,0);
		}
		public MathContext(Logexpr3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).enterMath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitMath(this);
		}
	}

	public final Logexpr3Context logexpr3() throws RecognitionException {
		Logexpr3Context _localctx = new Logexpr3Context(_ctx, getState());
		enterRule(_localctx, 24, RULE_logexpr3);
		try {
			setState(139);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new LogOpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				((LogOpContext)_localctx).left = mathexpr();
				setState(123);
				((LogOpContext)_localctx).op = match(LOGLESS);
				setState(124);
				((LogOpContext)_localctx).right = logexpr3();
				}
				break;
			case 2:
				_localctx = new LogOpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				((LogOpContext)_localctx).left = mathexpr();
				setState(127);
				((LogOpContext)_localctx).op = match(LOGGREATER);
				setState(128);
				((LogOpContext)_localctx).right = logexpr3();
				}
				break;
			case 3:
				_localctx = new LogOpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(130);
				((LogOpContext)_localctx).left = mathexpr();
				setState(131);
				((LogOpContext)_localctx).op = match(LOGLESSOREQ);
				setState(132);
				((LogOpContext)_localctx).right = logexpr3();
				}
				break;
			case 4:
				_localctx = new LogOpContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(134);
				((LogOpContext)_localctx).left = mathexpr();
				setState(135);
				((LogOpContext)_localctx).op = match(LOGGREATEROREQ);
				setState(136);
				((LogOpContext)_localctx).right = logexpr3();
				}
				break;
			case 5:
				_localctx = new MathContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(138);
				mathexpr();
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

	public static class MathexprContext extends ParserRuleContext {
		public MathexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mathexpr; }
	 
		public MathexprContext() { }
		public void copyFrom(MathexprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PlusMinusContext extends MathexprContext {
		public Mathexpr2Context left;
		public Token op;
		public MathexprContext right;
		public Mathexpr2Context mathexpr2() {
			return getRuleContext(Mathexpr2Context.class,0);
		}
		public TerminalNode PLUS() { return getToken(BParser.PLUS, 0); }
		public MathexprContext mathexpr() {
			return getRuleContext(MathexprContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(BParser.MINUS, 0); }
		public PlusMinusContext(MathexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).enterPlusMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitPlusMinus(this);
		}
	}
	public static class Math2Context extends MathexprContext {
		public Mathexpr2Context mathexpr2() {
			return getRuleContext(Mathexpr2Context.class,0);
		}
		public Math2Context(MathexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).enterMath2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitMath2(this);
		}
	}

	public final MathexprContext mathexpr() throws RecognitionException {
		MathexprContext _localctx = new MathexprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_mathexpr);
		try {
			setState(150);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new PlusMinusContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(141);
				((PlusMinusContext)_localctx).left = mathexpr2();
				setState(142);
				((PlusMinusContext)_localctx).op = match(PLUS);
				setState(143);
				((PlusMinusContext)_localctx).right = mathexpr();
				}
				break;
			case 2:
				_localctx = new PlusMinusContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
				((PlusMinusContext)_localctx).left = mathexpr2();
				setState(146);
				((PlusMinusContext)_localctx).op = match(MINUS);
				setState(147);
				((PlusMinusContext)_localctx).right = mathexpr();
				}
				break;
			case 3:
				_localctx = new Math2Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(149);
				mathexpr2();
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

	public static class Mathexpr2Context extends ParserRuleContext {
		public Mathexpr2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mathexpr2; }
	 
		public Mathexpr2Context() { }
		public void copyFrom(Mathexpr2Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MultDivContext extends Mathexpr2Context {
		public Mathexpr3Context left;
		public Token op;
		public Mathexpr2Context right;
		public Mathexpr3Context mathexpr3() {
			return getRuleContext(Mathexpr3Context.class,0);
		}
		public TerminalNode MULTIPLY() { return getToken(BParser.MULTIPLY, 0); }
		public Mathexpr2Context mathexpr2() {
			return getRuleContext(Mathexpr2Context.class,0);
		}
		public TerminalNode DIVIDE() { return getToken(BParser.DIVIDE, 0); }
		public MultDivContext(Mathexpr2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).enterMultDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitMultDiv(this);
		}
	}
	public static class Math3Context extends Mathexpr2Context {
		public Mathexpr3Context mathexpr3() {
			return getRuleContext(Mathexpr3Context.class,0);
		}
		public Math3Context(Mathexpr2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).enterMath3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitMath3(this);
		}
	}

	public final Mathexpr2Context mathexpr2() throws RecognitionException {
		Mathexpr2Context _localctx = new Mathexpr2Context(_ctx, getState());
		enterRule(_localctx, 28, RULE_mathexpr2);
		try {
			setState(161);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new MultDivContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				((MultDivContext)_localctx).left = mathexpr3();
				setState(153);
				((MultDivContext)_localctx).op = match(MULTIPLY);
				setState(154);
				((MultDivContext)_localctx).right = mathexpr2();
				}
				break;
			case 2:
				_localctx = new MultDivContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(156);
				((MultDivContext)_localctx).left = mathexpr3();
				setState(157);
				((MultDivContext)_localctx).op = match(DIVIDE);
				setState(158);
				((MultDivContext)_localctx).right = mathexpr2();
				}
				break;
			case 3:
				_localctx = new Math3Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(160);
				mathexpr3();
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

	public static class Mathexpr3Context extends ParserRuleContext {
		public Mathexpr3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mathexpr3; }
	 
		public Mathexpr3Context() { }
		public void copyFrom(Mathexpr3Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Log4Context extends Mathexpr3Context {
		public Logexpr4Context logexpr4() {
			return getRuleContext(Logexpr4Context.class,0);
		}
		public Log4Context(Mathexpr3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).enterLog4(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitLog4(this);
		}
	}
	public static class PowContext extends Mathexpr3Context {
		public Logexpr4Context left;
		public Token op;
		public Mathexpr3Context right;
		public Logexpr4Context logexpr4() {
			return getRuleContext(Logexpr4Context.class,0);
		}
		public TerminalNode POW() { return getToken(BParser.POW, 0); }
		public Mathexpr3Context mathexpr3() {
			return getRuleContext(Mathexpr3Context.class,0);
		}
		public PowContext(Mathexpr3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).enterPow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitPow(this);
		}
	}

	public final Mathexpr3Context mathexpr3() throws RecognitionException {
		Mathexpr3Context _localctx = new Mathexpr3Context(_ctx, getState());
		enterRule(_localctx, 30, RULE_mathexpr3);
		try {
			setState(168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new PowContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(163);
				((PowContext)_localctx).left = logexpr4();
				setState(164);
				((PowContext)_localctx).op = match(POW);
				setState(165);
				((PowContext)_localctx).right = mathexpr3();
				}
				break;
			case 2:
				_localctx = new Log4Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
				logexpr4();
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

	public static class Logexpr4Context extends ParserRuleContext {
		public Logexpr4Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logexpr4; }
	 
		public Logexpr4Context() { }
		public void copyFrom(Logexpr4Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NegateContext extends Logexpr4Context {
		public Token op;
		public ValContext val() {
			return getRuleContext(ValContext.class,0);
		}
		public TerminalNode NEGATE() { return getToken(BParser.NEGATE, 0); }
		public NegateContext(Logexpr4Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).enterNegate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitNegate(this);
		}
	}
	public static class ValueContext extends Logexpr4Context {
		public ValContext val() {
			return getRuleContext(ValContext.class,0);
		}
		public ValueContext(Logexpr4Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitValue(this);
		}
	}

	public final Logexpr4Context logexpr4() throws RecognitionException {
		Logexpr4Context _localctx = new Logexpr4Context(_ctx, getState());
		enterRule(_localctx, 32, RULE_logexpr4);
		try {
			setState(173);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEGATE:
				_localctx = new NegateContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				((NegateContext)_localctx).op = match(NEGATE);
				setState(171);
				val();
				}
				break;
			case BOOLLITERAL:
			case NUMLITERAL:
			case LPAREN:
			case ID:
				_localctx = new ValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				val();
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
		public TerminalNode ID() { return getToken(BParser.ID, 0); }
		public ValIdContext(ValContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).enterValId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitValId(this);
		}
	}
	public static class ValNumberContext extends ValContext {
		public TerminalNode NUMLITERAL() { return getToken(BParser.NUMLITERAL, 0); }
		public ValNumberContext(ValContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).enterValNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitValNumber(this);
		}
	}
	public static class ValFunccallPrintContext extends ValContext {
		public FunccallContext funccall() {
			return getRuleContext(FunccallContext.class,0);
		}
		public TerminalNode PRINTCHAR() { return getToken(BParser.PRINTCHAR, 0); }
		public ValFunccallPrintContext(ValContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).enterValFunccallPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitValFunccallPrint(this);
		}
	}
	public static class ValParenthesisedExprContext extends ValContext {
		public TerminalNode LPAREN() { return getToken(BParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BParser.RPAREN, 0); }
		public ValParenthesisedExprContext(ValContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).enterValParenthesisedExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitValParenthesisedExpr(this);
		}
	}
	public static class ValFunccallContext extends ValContext {
		public FunccallContext funccall() {
			return getRuleContext(FunccallContext.class,0);
		}
		public ValFunccallContext(ValContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).enterValFunccall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitValFunccall(this);
		}
	}
	public static class ValBooleanContext extends ValContext {
		public TerminalNode BOOLLITERAL() { return getToken(BParser.BOOLLITERAL, 0); }
		public ValBooleanContext(ValContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).enterValBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitValBoolean(this);
		}
	}

	public final ValContext val() throws RecognitionException {
		ValContext _localctx = new ValContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_val);
		try {
			setState(186);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new ValParenthesisedExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(175);
				match(LPAREN);
				setState(176);
				expr();
				setState(177);
				match(RPAREN);
				}
				break;
			case 2:
				_localctx = new ValFunccallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				funccall();
				}
				break;
			case 3:
				_localctx = new ValFunccallPrintContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(180);
				funccall();
				setState(181);
				match(PRINTCHAR);
				}
				break;
			case 4:
				_localctx = new ValNumberContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(183);
				match(NUMLITERAL);
				}
				break;
			case 5:
				_localctx = new ValBooleanContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(184);
				match(BOOLLITERAL);
				}
				break;
			case 6:
				_localctx = new ValIdContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(185);
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
		public TerminalNode ID() { return getToken(BParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(BParser.LPAREN, 0); }
		public ExprparamsContext exprparams() {
			return getRuleContext(ExprparamsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BParser.RPAREN, 0); }
		public FunccallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funccall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).enterFunccall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitFunccall(this);
		}
	}

	public final FunccallContext funccall() throws RecognitionException {
		FunccallContext _localctx = new FunccallContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_funccall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(ID);
			setState(189);
			match(LPAREN);
			setState(190);
			exprparams();
			setState(191);
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
			if ( listener instanceof BListener ) ((BListener)listener).enterExprparamsEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitExprparamsEmpty(this);
		}
	}
	public static class ExprparamsNotEmptyContext extends ExprparamsContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprmoreparamsContext exprmoreparams() {
			return getRuleContext(ExprmoreparamsContext.class,0);
		}
		public ExprparamsNotEmptyContext(ExprparamsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).enterExprparamsNotEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitExprparamsNotEmpty(this);
		}
	}

	public final ExprparamsContext exprparams() throws RecognitionException {
		ExprparamsContext _localctx = new ExprparamsContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_exprparams);
		try {
			setState(197);
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
				setState(193);
				expr();
				setState(194);
				exprmoreparams();
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

	public static class ExprmoreparamsContext extends ParserRuleContext {
		public ExprmoreparamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprmoreparams; }
	 
		public ExprmoreparamsContext() { }
		public void copyFrom(ExprmoreparamsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprmoreparamsNotEmptyContext extends ExprmoreparamsContext {
		public TerminalNode COMMA() { return getToken(BParser.COMMA, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprmoreparamsContext exprmoreparams() {
			return getRuleContext(ExprmoreparamsContext.class,0);
		}
		public ExprmoreparamsNotEmptyContext(ExprmoreparamsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).enterExprmoreparamsNotEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitExprmoreparamsNotEmpty(this);
		}
	}
	public static class ExprmoreparamsEmptyContext extends ExprmoreparamsContext {
		public ExprmoreparamsEmptyContext(ExprmoreparamsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).enterExprmoreparamsEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BListener ) ((BListener)listener).exitExprmoreparamsEmpty(this);
		}
	}

	public final ExprmoreparamsContext exprmoreparams() throws RecognitionException {
		ExprmoreparamsContext _localctx = new ExprmoreparamsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_exprmoreparams);
		try {
			setState(204);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMA:
				_localctx = new ExprmoreparamsNotEmptyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(199);
				match(COMMA);
				setState(200);
				expr();
				setState(201);
				exprmoreparams();
				}
				break;
			case RPAREN:
				_localctx = new ExprmoreparamsEmptyContext(_localctx);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\"\u00d1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\5\3\67\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5"+
		"\3\5\3\6\3\6\3\6\3\6\5\6J\n\6\3\7\3\7\3\7\3\7\3\7\5\7Q\n\7\3\b\3\b\3\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t_\n\t\3\n\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\13\5\13i\n\13\3\f\3\f\3\f\3\f\3\f\5\fp\n\f\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\5\r{\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u008e\n\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0099\n\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\5\20\u00a4\n\20\3\21\3\21\3\21\3\21\3\21\5\21"+
		"\u00ab\n\21\3\22\3\22\3\22\5\22\u00b0\n\22\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\5\23\u00bd\n\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\3\25\5\25\u00c8\n\25\3\26\3\26\3\26\3\26\3\26\5\26\u00cf"+
		"\n\26\3\26\2\2\27\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*\2\3\3"+
		"\2\3\4\2\u00d5\2,\3\2\2\2\4\66\3\2\2\2\68\3\2\2\2\bC\3\2\2\2\nI\3\2\2"+
		"\2\fP\3\2\2\2\16R\3\2\2\2\20^\3\2\2\2\22`\3\2\2\2\24h\3\2\2\2\26o\3\2"+
		"\2\2\30z\3\2\2\2\32\u008d\3\2\2\2\34\u0098\3\2\2\2\36\u00a3\3\2\2\2 \u00aa"+
		"\3\2\2\2\"\u00af\3\2\2\2$\u00bc\3\2\2\2&\u00be\3\2\2\2(\u00c7\3\2\2\2"+
		"*\u00ce\3\2\2\2,-\5\4\3\2-.\7\2\2\3.\3\3\2\2\2/\60\5\6\4\2\60\61\5\4\3"+
		"\2\61\67\3\2\2\2\62\63\5\22\n\2\63\64\5\4\3\2\64\67\3\2\2\2\65\67\3\2"+
		"\2\2\66/\3\2\2\2\66\62\3\2\2\2\66\65\3\2\2\2\67\5\3\2\2\289\5\b\5\29:"+
		"\7\"\2\2:;\7\13\2\2;<\5\n\6\2<=\7\f\2\2=>\7\32\2\2>?\5\20\t\2?@\7\b\2"+
		"\2@A\5\22\n\2AB\7\7\2\2B\7\3\2\2\2CD\t\2\2\2D\t\3\2\2\2EF\5\16\b\2FG\5"+
		"\f\7\2GJ\3\2\2\2HJ\3\2\2\2IE\3\2\2\2IH\3\2\2\2J\13\3\2\2\2KL\7\31\2\2"+
		"LM\5\16\b\2MN\5\f\7\2NQ\3\2\2\2OQ\3\2\2\2PK\3\2\2\2PO\3\2\2\2Q\r\3\2\2"+
		"\2RS\5\b\5\2ST\7\"\2\2T\17\3\2\2\2UV\7\t\2\2VW\7\13\2\2WX\5\24\13\2XY"+
		"\7\f\2\2YZ\7\b\2\2Z[\5\22\n\2[\\\5\20\t\2\\_\3\2\2\2]_\3\2\2\2^U\3\2\2"+
		"\2^]\3\2\2\2_\21\3\2\2\2`a\5\24\13\2ab\7\37\2\2b\23\3\2\2\2cd\5\26\f\2"+
		"de\7\17\2\2ef\5\24\13\2fi\3\2\2\2gi\5\26\f\2hc\3\2\2\2hg\3\2\2\2i\25\3"+
		"\2\2\2jk\5\30\r\2kl\7\20\2\2lm\5\26\f\2mp\3\2\2\2np\5\30\r\2oj\3\2\2\2"+
		"on\3\2\2\2p\27\3\2\2\2qr\5\32\16\2rs\7\21\2\2st\5\30\r\2t{\3\2\2\2uv\5"+
		"\32\16\2vw\7\22\2\2wx\5\30\r\2x{\3\2\2\2y{\5\32\16\2zq\3\2\2\2zu\3\2\2"+
		"\2zy\3\2\2\2{\31\3\2\2\2|}\5\34\17\2}~\7\23\2\2~\177\5\32\16\2\177\u008e"+
		"\3\2\2\2\u0080\u0081\5\34\17\2\u0081\u0082\7\24\2\2\u0082\u0083\5\32\16"+
		"\2\u0083\u008e\3\2\2\2\u0084\u0085\5\34\17\2\u0085\u0086\7\25\2\2\u0086"+
		"\u0087\5\32\16\2\u0087\u008e\3\2\2\2\u0088\u0089\5\34\17\2\u0089\u008a"+
		"\7\26\2\2\u008a\u008b\5\32\16\2\u008b\u008e\3\2\2\2\u008c\u008e\5\34\17"+
		"\2\u008d|\3\2\2\2\u008d\u0080\3\2\2\2\u008d\u0084\3\2\2\2\u008d\u0088"+
		"\3\2\2\2\u008d\u008c\3\2\2\2\u008e\33\3\2\2\2\u008f\u0090\5\36\20\2\u0090"+
		"\u0091\7\33\2\2\u0091\u0092\5\34\17\2\u0092\u0099\3\2\2\2\u0093\u0094"+
		"\5\36\20\2\u0094\u0095\7\34\2\2\u0095\u0096\5\34\17\2\u0096\u0099\3\2"+
		"\2\2\u0097\u0099\5\36\20\2\u0098\u008f\3\2\2\2\u0098\u0093\3\2\2\2\u0098"+
		"\u0097\3\2\2\2\u0099\35\3\2\2\2\u009a\u009b\5 \21\2\u009b\u009c\7\35\2"+
		"\2\u009c\u009d\5\36\20\2\u009d\u00a4\3\2\2\2\u009e\u009f\5 \21\2\u009f"+
		"\u00a0\7\36\2\2\u00a0\u00a1\5\36\20\2\u00a1\u00a4\3\2\2\2\u00a2\u00a4"+
		"\5 \21\2\u00a3\u009a\3\2\2\2\u00a3\u009e\3\2\2\2\u00a3\u00a2\3\2\2\2\u00a4"+
		"\37\3\2\2\2\u00a5\u00a6\5\"\22\2\u00a6\u00a7\7\30\2\2\u00a7\u00a8\5 \21"+
		"\2\u00a8\u00ab\3\2\2\2\u00a9\u00ab\5\"\22\2\u00aa\u00a5\3\2\2\2\u00aa"+
		"\u00a9\3\2\2\2\u00ab!\3\2\2\2\u00ac\u00ad\7\27\2\2\u00ad\u00b0\5$\23\2"+
		"\u00ae\u00b0\5$\23\2\u00af\u00ac\3\2\2\2\u00af\u00ae\3\2\2\2\u00b0#\3"+
		"\2\2\2\u00b1\u00b2\7\13\2\2\u00b2\u00b3\5\24\13\2\u00b3\u00b4\7\f\2\2"+
		"\u00b4\u00bd\3\2\2\2\u00b5\u00bd\5&\24\2\u00b6\u00b7\5&\24\2\u00b7\u00b8"+
		"\7\n\2\2\u00b8\u00bd\3\2\2\2\u00b9\u00bd\7\6\2\2\u00ba\u00bd\7\5\2\2\u00bb"+
		"\u00bd\7\"\2\2\u00bc\u00b1\3\2\2\2\u00bc\u00b5\3\2\2\2\u00bc\u00b6\3\2"+
		"\2\2\u00bc\u00b9\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bb\3\2\2\2\u00bd"+
		"%\3\2\2\2\u00be\u00bf\7\"\2\2\u00bf\u00c0\7\13\2\2\u00c0\u00c1\5(\25\2"+
		"\u00c1\u00c2\7\f\2\2\u00c2\'\3\2\2\2\u00c3\u00c4\5\24\13\2\u00c4\u00c5"+
		"\5*\26\2\u00c5\u00c8\3\2\2\2\u00c6\u00c8\3\2\2\2\u00c7\u00c3\3\2\2\2\u00c7"+
		"\u00c6\3\2\2\2\u00c8)\3\2\2\2\u00c9\u00ca\7\31\2\2\u00ca\u00cb\5\24\13"+
		"\2\u00cb\u00cc\5*\26\2\u00cc\u00cf\3\2\2\2\u00cd\u00cf\3\2\2\2\u00ce\u00c9"+
		"\3\2\2\2\u00ce\u00cd\3\2\2\2\u00cf+\3\2\2\2\21\66IP^hoz\u008d\u0098\u00a3"+
		"\u00aa\u00af\u00bc\u00c7\u00ce";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}