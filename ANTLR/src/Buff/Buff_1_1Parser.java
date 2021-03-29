// Generated from Buff_1_1.g4 by ANTLR 4.7.2
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
public class Buff_1_1Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NUMBERDCL=1, TEXTDCL=2, BOOLEAN=3, ENDF=4, PRINTDEBUG=5, ID=6, TEXTVAL=7, 
		NUMBERVAL=8, BOOLVAL=9, LPAREN=10, RPAREN=11, LCURLY=12, RCURLY=13, RETURN=14, 
		LOGAND=15, LOGOR=16, IF=17, LOGEQUALS=18, LOGNEQUALS=19, LOGLESS=20, LOGGREATER=21, 
		LOGLESSOREQUAL=22, LOGGREATEROREQUAL=23, NEGATE=24, POWER=25, COMMA=26, 
		ASSIGN=27, PLUS=28, MINUS=29, MULTIPLY=30, DIVIDE=31, SEMICOLON=32, WS=33, 
		NEWLINE=34;
	public static final int
		RULE_start = 0, RULE_prog = 1, RULE_dcl = 2, RULE_type = 3, RULE_dclParams = 4, 
		RULE_dclMoreParams = 5, RULE_dclParam = 6, RULE_stmts = 7, RULE_stmt = 8, 
		RULE_expr = 9, RULE_lgclExpr = 10, RULE_lgclExpr2 = 11, RULE_lgclExpr3 = 12, 
		RULE_mathExpr = 13, RULE_mathExpr2 = 14, RULE_mathExpr3 = 15, RULE_lgclExpr4 = 16, 
		RULE_val = 17, RULE_termVal = 18, RULE_funcCall = 19, RULE_stmtParams = 20, 
		RULE_exprMoreParams = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "prog", "dcl", "type", "dclParams", "dclMoreParams", "dclParam", 
			"stmts", "stmt", "expr", "lgclExpr", "lgclExpr2", "lgclExpr3", "mathExpr", 
			"mathExpr2", "mathExpr3", "lgclExpr4", "val", "termVal", "funcCall", 
			"stmtParams", "exprMoreParams"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'number'", "'text'", "'bool'", "'endf'", "'?'", null, null, null, 
			null, "'('", "')'", "'{'", "'}'", "'return'", "'&&'", "'||'", "'if'", 
			"'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'!'", "'^'", "','", "'='", 
			"'+'", "'-'", "'*'", "'/'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NUMBERDCL", "TEXTDCL", "BOOLEAN", "ENDF", "PRINTDEBUG", "ID", 
			"TEXTVAL", "NUMBERVAL", "BOOLVAL", "LPAREN", "RPAREN", "LCURLY", "RCURLY", 
			"RETURN", "LOGAND", "LOGOR", "IF", "LOGEQUALS", "LOGNEQUALS", "LOGLESS", 
			"LOGGREATER", "LOGLESSOREQUAL", "LOGGREATEROREQUAL", "NEGATE", "POWER", 
			"COMMA", "ASSIGN", "PLUS", "MINUS", "MULTIPLY", "DIVIDE", "SEMICOLON", 
			"WS", "NEWLINE"
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
	public String getGrammarFileName() { return "Buff_1_1.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Buff_1_1Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public ProgContext prog() {
			return getRuleContext(ProgContext.class,0);
		}
		public TerminalNode EOF() { return getToken(Buff_1_1Parser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			prog();
			setState(45);
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

	public static class ProgContext extends ParserRuleContext {
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	 
		public ProgContext() { }
		public void copyFrom(ProgContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StmtProgContext extends ProgContext {
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public ProgContext prog() {
			return getRuleContext(ProgContext.class,0);
		}
		public StmtProgContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterStmtProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitStmtProg(this);
		}
	}
	public static class DclProgContext extends ProgContext {
		public DclContext dcl() {
			return getRuleContext(DclContext.class,0);
		}
		public ProgContext prog() {
			return getRuleContext(ProgContext.class,0);
		}
		public DclProgContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterDclProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitDclProg(this);
		}
	}
	public static class ProgEmptyContext extends ProgContext {
		public ProgEmptyContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterProgEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitProgEmpty(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_prog);
		try {
			setState(54);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBERDCL:
			case BOOLEAN:
				_localctx = new DclProgContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				dcl();
				setState(48);
				prog();
				}
				break;
			case ID:
			case NUMBERVAL:
			case BOOLVAL:
			case LPAREN:
			case NEGATE:
				_localctx = new StmtProgContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				stmt();
				setState(51);
				prog();
				}
				break;
			case EOF:
				_localctx = new ProgEmptyContext(_localctx);
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

	public static class DclContext extends ParserRuleContext {
		public DclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dcl; }
	 
		public DclContext() { }
		public void copyFrom(DclContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MultiLineStmtContext extends DclContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(Buff_1_1Parser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(Buff_1_1Parser.LPAREN, 0); }
		public DclParamsContext dclParams() {
			return getRuleContext(DclParamsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Buff_1_1Parser.RPAREN, 0); }
		public TerminalNode ASSIGN() { return getToken(Buff_1_1Parser.ASSIGN, 0); }
		public TerminalNode LCURLY() { return getToken(Buff_1_1Parser.LCURLY, 0); }
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(Buff_1_1Parser.RETURN, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public TerminalNode RCURLY() { return getToken(Buff_1_1Parser.RCURLY, 0); }
		public TerminalNode ENDF() { return getToken(Buff_1_1Parser.ENDF, 0); }
		public MultiLineStmtContext(DclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterMultiLineStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitMultiLineStmt(this);
		}
	}
	public static class OneLineStmtContext extends DclContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(Buff_1_1Parser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(Buff_1_1Parser.LPAREN, 0); }
		public DclParamsContext dclParams() {
			return getRuleContext(DclParamsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Buff_1_1Parser.RPAREN, 0); }
		public TerminalNode ASSIGN() { return getToken(Buff_1_1Parser.ASSIGN, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public OneLineStmtContext(DclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterOneLineStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitOneLineStmt(this);
		}
	}

	public final DclContext dcl() throws RecognitionException {
		DclContext _localctx = new DclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_dcl);
		try {
			setState(77);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new OneLineStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				type();
				setState(57);
				match(ID);
				setState(58);
				match(LPAREN);
				setState(59);
				dclParams();
				setState(60);
				match(RPAREN);
				setState(61);
				match(ASSIGN);
				setState(62);
				stmt();
				}
				break;
			case 2:
				_localctx = new MultiLineStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				type();
				setState(65);
				match(ID);
				setState(66);
				match(LPAREN);
				setState(67);
				dclParams();
				setState(68);
				match(RPAREN);
				setState(69);
				match(ASSIGN);
				setState(70);
				match(LCURLY);
				setState(71);
				stmts();
				setState(72);
				match(RETURN);
				setState(73);
				stmt();
				setState(74);
				match(RCURLY);
				setState(75);
				match(ENDF);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode NUMBERDCL() { return getToken(Buff_1_1Parser.NUMBERDCL, 0); }
		public TerminalNode BOOLEAN() { return getToken(Buff_1_1Parser.BOOLEAN, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			_la = _input.LA(1);
			if ( !(_la==NUMBERDCL || _la==BOOLEAN) ) {
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

	public static class DclParamsContext extends ParserRuleContext {
		public DclParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dclParams; }
	 
		public DclParamsContext() { }
		public void copyFrom(DclParamsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DclParamsEmptyContext extends DclParamsContext {
		public DclParamsEmptyContext(DclParamsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterDclParamsEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitDclParamsEmpty(this);
		}
	}
	public static class DclParamscontainedContext extends DclParamsContext {
		public DclParamContext dclParam() {
			return getRuleContext(DclParamContext.class,0);
		}
		public DclMoreParamsContext dclMoreParams() {
			return getRuleContext(DclMoreParamsContext.class,0);
		}
		public DclParamscontainedContext(DclParamsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterDclParamscontained(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitDclParamscontained(this);
		}
	}

	public final DclParamsContext dclParams() throws RecognitionException {
		DclParamsContext _localctx = new DclParamsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_dclParams);
		try {
			setState(85);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBERDCL:
			case BOOLEAN:
				_localctx = new DclParamscontainedContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				dclParam();
				setState(82);
				dclMoreParams();
				}
				break;
			case RPAREN:
				_localctx = new DclParamsEmptyContext(_localctx);
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

	public static class DclMoreParamsContext extends ParserRuleContext {
		public DclMoreParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dclMoreParams; }
	 
		public DclMoreParamsContext() { }
		public void copyFrom(DclMoreParamsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DclMoreParamscontainedContext extends DclMoreParamsContext {
		public TerminalNode COMMA() { return getToken(Buff_1_1Parser.COMMA, 0); }
		public DclParamContext dclParam() {
			return getRuleContext(DclParamContext.class,0);
		}
		public DclMoreParamsContext dclMoreParams() {
			return getRuleContext(DclMoreParamsContext.class,0);
		}
		public DclMoreParamscontainedContext(DclMoreParamsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterDclMoreParamscontained(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitDclMoreParamscontained(this);
		}
	}
	public static class DclMoreParamsEmptyContext extends DclMoreParamsContext {
		public DclMoreParamsEmptyContext(DclMoreParamsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterDclMoreParamsEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitDclMoreParamsEmpty(this);
		}
	}

	public final DclMoreParamsContext dclMoreParams() throws RecognitionException {
		DclMoreParamsContext _localctx = new DclMoreParamsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_dclMoreParams);
		try {
			setState(92);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMA:
				_localctx = new DclMoreParamscontainedContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				match(COMMA);
				setState(88);
				dclParam();
				setState(89);
				dclMoreParams();
				}
				break;
			case RPAREN:
				_localctx = new DclMoreParamsEmptyContext(_localctx);
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

	public static class DclParamContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(Buff_1_1Parser.ID, 0); }
		public DclParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dclParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterDclParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitDclParam(this);
		}
	}

	public final DclParamContext dclParam() throws RecognitionException {
		DclParamContext _localctx = new DclParamContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_dclParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			type();
			setState(95);
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
	public static class StmtsEmptyContext extends StmtsContext {
		public StmtsEmptyContext(StmtsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterStmtsEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitStmtsEmpty(this);
		}
	}
	public static class StmtsContainedContext extends StmtsContext {
		public TerminalNode IF() { return getToken(Buff_1_1Parser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(Buff_1_1Parser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Buff_1_1Parser.RPAREN, 0); }
		public TerminalNode RETURN() { return getToken(Buff_1_1Parser.RETURN, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public StmtsContainedContext(StmtsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterStmtsContained(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitStmtsContained(this);
		}
	}

	public final StmtsContext stmts() throws RecognitionException {
		StmtsContext _localctx = new StmtsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_stmts);
		try {
			setState(106);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				_localctx = new StmtsContainedContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				match(IF);
				setState(98);
				match(LPAREN);
				setState(99);
				expr();
				setState(100);
				match(RPAREN);
				setState(101);
				match(RETURN);
				setState(102);
				stmt();
				setState(103);
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
		public TerminalNode SEMICOLON() { return getToken(Buff_1_1Parser.SEMICOLON, 0); }
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitStmt(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			expr();
			setState(109);
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
		public LgclExprContext left;
		public Token op;
		public ExprContext right;
		public LgclExprContext lgclExpr() {
			return getRuleContext(LgclExprContext.class,0);
		}
		public TerminalNode LOGOR() { return getToken(Buff_1_1Parser.LOGOR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LogOrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterLogOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitLogOr(this);
		}
	}
	public static class LogExpContext extends ExprContext {
		public LgclExprContext lgclExpr() {
			return getRuleContext(LgclExprContext.class,0);
		}
		public LogExpContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterLogExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitLogExp(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expr);
		try {
			setState(116);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new LogOrContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				((LogOrContext)_localctx).left = lgclExpr();
				setState(112);
				((LogOrContext)_localctx).op = match(LOGOR);
				setState(113);
				((LogOrContext)_localctx).right = expr();
				}
				break;
			case 2:
				_localctx = new LogExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(115);
				lgclExpr();
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

	public static class LgclExprContext extends ParserRuleContext {
		public LgclExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lgclExpr; }
	 
		public LgclExprContext() { }
		public void copyFrom(LgclExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LogAndContext extends LgclExprContext {
		public LgclExpr2Context left;
		public Token op;
		public LgclExprContext right;
		public LgclExpr2Context lgclExpr2() {
			return getRuleContext(LgclExpr2Context.class,0);
		}
		public TerminalNode LOGAND() { return getToken(Buff_1_1Parser.LOGAND, 0); }
		public LgclExprContext lgclExpr() {
			return getRuleContext(LgclExprContext.class,0);
		}
		public LogAndContext(LgclExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterLogAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitLogAnd(this);
		}
	}
	public static class Log2Context extends LgclExprContext {
		public LgclExpr2Context lgclExpr2() {
			return getRuleContext(LgclExpr2Context.class,0);
		}
		public Log2Context(LgclExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterLog2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitLog2(this);
		}
	}

	public final LgclExprContext lgclExpr() throws RecognitionException {
		LgclExprContext _localctx = new LgclExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_lgclExpr);
		try {
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new LogAndContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				((LogAndContext)_localctx).left = lgclExpr2();
				setState(119);
				((LogAndContext)_localctx).op = match(LOGAND);
				setState(120);
				((LogAndContext)_localctx).right = lgclExpr();
				}
				break;
			case 2:
				_localctx = new Log2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				lgclExpr2();
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

	public static class LgclExpr2Context extends ParserRuleContext {
		public LgclExpr2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lgclExpr2; }
	 
		public LgclExpr2Context() { }
		public void copyFrom(LgclExpr2Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LogEqualsOpContext extends LgclExpr2Context {
		public LgclExpr3Context left;
		public Token op;
		public LgclExpr2Context right;
		public LgclExpr3Context lgclExpr3() {
			return getRuleContext(LgclExpr3Context.class,0);
		}
		public TerminalNode LOGEQUALS() { return getToken(Buff_1_1Parser.LOGEQUALS, 0); }
		public LgclExpr2Context lgclExpr2() {
			return getRuleContext(LgclExpr2Context.class,0);
		}
		public TerminalNode LOGNEQUALS() { return getToken(Buff_1_1Parser.LOGNEQUALS, 0); }
		public LogEqualsOpContext(LgclExpr2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterLogEqualsOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitLogEqualsOp(this);
		}
	}
	public static class MathLogContext extends LgclExpr2Context {
		public LgclExpr3Context lgclExpr3() {
			return getRuleContext(LgclExpr3Context.class,0);
		}
		public MathLogContext(LgclExpr2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterMathLog(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitMathLog(this);
		}
	}

	public final LgclExpr2Context lgclExpr2() throws RecognitionException {
		LgclExpr2Context _localctx = new LgclExpr2Context(_ctx, getState());
		enterRule(_localctx, 22, RULE_lgclExpr2);
		try {
			setState(134);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new LogEqualsOpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				((LogEqualsOpContext)_localctx).left = lgclExpr3();
				setState(126);
				((LogEqualsOpContext)_localctx).op = match(LOGEQUALS);
				setState(127);
				((LogEqualsOpContext)_localctx).right = lgclExpr2();
				}
				break;
			case 2:
				_localctx = new LogEqualsOpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				((LogEqualsOpContext)_localctx).left = lgclExpr3();
				setState(130);
				((LogEqualsOpContext)_localctx).op = match(LOGNEQUALS);
				setState(131);
				((LogEqualsOpContext)_localctx).right = lgclExpr2();
				}
				break;
			case 3:
				_localctx = new MathLogContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(133);
				lgclExpr3();
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

	public static class LgclExpr3Context extends ParserRuleContext {
		public LgclExpr3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lgclExpr3; }
	 
		public LgclExpr3Context() { }
		public void copyFrom(LgclExpr3Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LogicalOpContext extends LgclExpr3Context {
		public MathExprContext left;
		public Token op;
		public LgclExpr3Context right;
		public MathExprContext mathExpr() {
			return getRuleContext(MathExprContext.class,0);
		}
		public TerminalNode LOGLESS() { return getToken(Buff_1_1Parser.LOGLESS, 0); }
		public LgclExpr3Context lgclExpr3() {
			return getRuleContext(LgclExpr3Context.class,0);
		}
		public TerminalNode LOGGREATER() { return getToken(Buff_1_1Parser.LOGGREATER, 0); }
		public TerminalNode LOGLESSOREQUAL() { return getToken(Buff_1_1Parser.LOGLESSOREQUAL, 0); }
		public TerminalNode LOGGREATEROREQUAL() { return getToken(Buff_1_1Parser.LOGGREATEROREQUAL, 0); }
		public LogicalOpContext(LgclExpr3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterLogicalOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitLogicalOp(this);
		}
	}
	public static class MathContext extends LgclExpr3Context {
		public MathExprContext mathExpr() {
			return getRuleContext(MathExprContext.class,0);
		}
		public MathContext(LgclExpr3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterMath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitMath(this);
		}
	}

	public final LgclExpr3Context lgclExpr3() throws RecognitionException {
		LgclExpr3Context _localctx = new LgclExpr3Context(_ctx, getState());
		enterRule(_localctx, 24, RULE_lgclExpr3);
		try {
			setState(153);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new LogicalOpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				((LogicalOpContext)_localctx).left = mathExpr();
				setState(137);
				((LogicalOpContext)_localctx).op = match(LOGLESS);
				setState(138);
				((LogicalOpContext)_localctx).right = lgclExpr3();
				}
				break;
			case 2:
				_localctx = new LogicalOpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(140);
				((LogicalOpContext)_localctx).left = mathExpr();
				setState(141);
				((LogicalOpContext)_localctx).op = match(LOGGREATER);
				setState(142);
				((LogicalOpContext)_localctx).right = lgclExpr3();
				}
				break;
			case 3:
				_localctx = new LogicalOpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(144);
				((LogicalOpContext)_localctx).left = mathExpr();
				setState(145);
				((LogicalOpContext)_localctx).op = match(LOGLESSOREQUAL);
				setState(146);
				((LogicalOpContext)_localctx).right = lgclExpr3();
				}
				break;
			case 4:
				_localctx = new LogicalOpContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(148);
				((LogicalOpContext)_localctx).left = mathExpr();
				setState(149);
				((LogicalOpContext)_localctx).op = match(LOGGREATEROREQUAL);
				setState(150);
				((LogicalOpContext)_localctx).right = lgclExpr3();
				}
				break;
			case 5:
				_localctx = new MathContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(152);
				mathExpr();
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

	public static class MathExprContext extends ParserRuleContext {
		public MathExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mathExpr; }
	 
		public MathExprContext() { }
		public void copyFrom(MathExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MathDivMulContext extends MathExprContext {
		public MathExpr2Context mathExpr2() {
			return getRuleContext(MathExpr2Context.class,0);
		}
		public MathDivMulContext(MathExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterMathDivMul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitMathDivMul(this);
		}
	}
	public static class BinaryOpPlusMinusContext extends MathExprContext {
		public MathExpr2Context left;
		public Token op;
		public MathExprContext right;
		public MathExpr2Context mathExpr2() {
			return getRuleContext(MathExpr2Context.class,0);
		}
		public TerminalNode PLUS() { return getToken(Buff_1_1Parser.PLUS, 0); }
		public MathExprContext mathExpr() {
			return getRuleContext(MathExprContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(Buff_1_1Parser.MINUS, 0); }
		public BinaryOpPlusMinusContext(MathExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterBinaryOpPlusMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitBinaryOpPlusMinus(this);
		}
	}

	public final MathExprContext mathExpr() throws RecognitionException {
		MathExprContext _localctx = new MathExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_mathExpr);
		try {
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new BinaryOpPlusMinusContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				((BinaryOpPlusMinusContext)_localctx).left = mathExpr2();
				setState(156);
				((BinaryOpPlusMinusContext)_localctx).op = match(PLUS);
				setState(157);
				((BinaryOpPlusMinusContext)_localctx).right = mathExpr();
				}
				break;
			case 2:
				_localctx = new BinaryOpPlusMinusContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				((BinaryOpPlusMinusContext)_localctx).left = mathExpr2();
				setState(160);
				((BinaryOpPlusMinusContext)_localctx).op = match(MINUS);
				setState(161);
				((BinaryOpPlusMinusContext)_localctx).right = mathExpr();
				}
				break;
			case 3:
				_localctx = new MathDivMulContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(163);
				mathExpr2();
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

	public static class MathExpr2Context extends ParserRuleContext {
		public MathExpr2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mathExpr2; }
	 
		public MathExpr2Context() { }
		public void copyFrom(MathExpr2Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MathPowContext extends MathExpr2Context {
		public MathExpr3Context mathExpr3() {
			return getRuleContext(MathExpr3Context.class,0);
		}
		public MathPowContext(MathExpr2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterMathPow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitMathPow(this);
		}
	}
	public static class BinaryOpDivMulContext extends MathExpr2Context {
		public MathExpr3Context left;
		public Token op;
		public MathExpr2Context right;
		public MathExpr3Context mathExpr3() {
			return getRuleContext(MathExpr3Context.class,0);
		}
		public TerminalNode MULTIPLY() { return getToken(Buff_1_1Parser.MULTIPLY, 0); }
		public MathExpr2Context mathExpr2() {
			return getRuleContext(MathExpr2Context.class,0);
		}
		public TerminalNode DIVIDE() { return getToken(Buff_1_1Parser.DIVIDE, 0); }
		public BinaryOpDivMulContext(MathExpr2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterBinaryOpDivMul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitBinaryOpDivMul(this);
		}
	}

	public final MathExpr2Context mathExpr2() throws RecognitionException {
		MathExpr2Context _localctx = new MathExpr2Context(_ctx, getState());
		enterRule(_localctx, 28, RULE_mathExpr2);
		try {
			setState(175);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new BinaryOpDivMulContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				((BinaryOpDivMulContext)_localctx).left = mathExpr3();
				setState(167);
				((BinaryOpDivMulContext)_localctx).op = match(MULTIPLY);
				setState(168);
				((BinaryOpDivMulContext)_localctx).right = mathExpr2();
				}
				break;
			case 2:
				_localctx = new BinaryOpDivMulContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(170);
				((BinaryOpDivMulContext)_localctx).left = mathExpr3();
				setState(171);
				((BinaryOpDivMulContext)_localctx).op = match(DIVIDE);
				setState(172);
				((BinaryOpDivMulContext)_localctx).right = mathExpr2();
				}
				break;
			case 3:
				_localctx = new MathPowContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(174);
				mathExpr3();
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

	public static class MathExpr3Context extends ParserRuleContext {
		public MathExpr3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mathExpr3; }
	 
		public MathExpr3Context() { }
		public void copyFrom(MathExpr3Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BinaryOpPowContext extends MathExpr3Context {
		public LgclExpr4Context left;
		public Token op;
		public MathExpr3Context right;
		public LgclExpr4Context lgclExpr4() {
			return getRuleContext(LgclExpr4Context.class,0);
		}
		public TerminalNode POWER() { return getToken(Buff_1_1Parser.POWER, 0); }
		public MathExpr3Context mathExpr3() {
			return getRuleContext(MathExpr3Context.class,0);
		}
		public BinaryOpPowContext(MathExpr3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterBinaryOpPow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitBinaryOpPow(this);
		}
	}
	public static class LogUnaryContext extends MathExpr3Context {
		public LgclExpr4Context lgclExpr4() {
			return getRuleContext(LgclExpr4Context.class,0);
		}
		public LogUnaryContext(MathExpr3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterLogUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitLogUnary(this);
		}
	}

	public final MathExpr3Context mathExpr3() throws RecognitionException {
		MathExpr3Context _localctx = new MathExpr3Context(_ctx, getState());
		enterRule(_localctx, 30, RULE_mathExpr3);
		try {
			setState(182);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new BinaryOpPowContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(177);
				((BinaryOpPowContext)_localctx).left = lgclExpr4();
				setState(178);
				((BinaryOpPowContext)_localctx).op = match(POWER);
				setState(179);
				((BinaryOpPowContext)_localctx).right = mathExpr3();
				}
				break;
			case 2:
				_localctx = new LogUnaryContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(181);
				lgclExpr4();
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

	public static class LgclExpr4Context extends ParserRuleContext {
		public LgclExpr4Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lgclExpr4; }
	 
		public LgclExpr4Context() { }
		public void copyFrom(LgclExpr4Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NegateContext extends LgclExpr4Context {
		public Token op;
		public ValContext val() {
			return getRuleContext(ValContext.class,0);
		}
		public TerminalNode NEGATE() { return getToken(Buff_1_1Parser.NEGATE, 0); }
		public NegateContext(LgclExpr4Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterNegate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitNegate(this);
		}
	}
	public static class ValueContext extends LgclExpr4Context {
		public ValContext val() {
			return getRuleContext(ValContext.class,0);
		}
		public ValueContext(LgclExpr4Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitValue(this);
		}
	}

	public final LgclExpr4Context lgclExpr4() throws RecognitionException {
		LgclExpr4Context _localctx = new LgclExpr4Context(_ctx, getState());
		enterRule(_localctx, 32, RULE_lgclExpr4);
		try {
			setState(187);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEGATE:
				_localctx = new NegateContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(184);
				((NegateContext)_localctx).op = match(NEGATE);
				setState(185);
				val();
				}
				break;
			case ID:
			case NUMBERVAL:
			case BOOLVAL:
			case LPAREN:
				_localctx = new ValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(186);
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
	public static class ParensExpContext extends ValContext {
		public TerminalNode LPAREN() { return getToken(Buff_1_1Parser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Buff_1_1Parser.RPAREN, 0); }
		public ParensExpContext(ValContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterParensExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitParensExp(this);
		}
	}
	public static class ValTerminalContext extends ValContext {
		public TermValContext termVal() {
			return getRuleContext(TermValContext.class,0);
		}
		public ValTerminalContext(ValContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterValTerminal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitValTerminal(this);
		}
	}
	public static class ValFuncCallContext extends ValContext {
		public FuncCallContext funcCall() {
			return getRuleContext(FuncCallContext.class,0);
		}
		public ValFuncCallContext(ValContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterValFuncCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitValFuncCall(this);
		}
	}
	public static class ValFuncCallDebugContext extends ValContext {
		public FuncCallContext funcCall() {
			return getRuleContext(FuncCallContext.class,0);
		}
		public TerminalNode PRINTDEBUG() { return getToken(Buff_1_1Parser.PRINTDEBUG, 0); }
		public ValFuncCallDebugContext(ValContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterValFuncCallDebug(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitValFuncCallDebug(this);
		}
	}

	public final ValContext val() throws RecognitionException {
		ValContext _localctx = new ValContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_val);
		try {
			setState(198);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new ParensExpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(189);
				match(LPAREN);
				setState(190);
				expr();
				setState(191);
				match(RPAREN);
				}
				break;
			case 2:
				_localctx = new ValFuncCallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(193);
				funcCall();
				}
				break;
			case 3:
				_localctx = new ValFuncCallDebugContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(194);
				funcCall();
				setState(195);
				match(PRINTDEBUG);
				}
				break;
			case 4:
				_localctx = new ValTerminalContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(197);
				termVal();
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

	public static class TermValContext extends ParserRuleContext {
		public TerminalNode NUMBERVAL() { return getToken(Buff_1_1Parser.NUMBERVAL, 0); }
		public TerminalNode BOOLVAL() { return getToken(Buff_1_1Parser.BOOLVAL, 0); }
		public TerminalNode ID() { return getToken(Buff_1_1Parser.ID, 0); }
		public TermValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termVal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterTermVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitTermVal(this);
		}
	}

	public final TermValContext termVal() throws RecognitionException {
		TermValContext _localctx = new TermValContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_termVal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << NUMBERVAL) | (1L << BOOLVAL))) != 0)) ) {
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

	public static class FuncCallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(Buff_1_1Parser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(Buff_1_1Parser.LPAREN, 0); }
		public StmtParamsContext stmtParams() {
			return getRuleContext(StmtParamsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Buff_1_1Parser.RPAREN, 0); }
		public FuncCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterFuncCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitFuncCall(this);
		}
	}

	public final FuncCallContext funcCall() throws RecognitionException {
		FuncCallContext _localctx = new FuncCallContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_funcCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			match(ID);
			setState(203);
			match(LPAREN);
			setState(204);
			stmtParams();
			setState(205);
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

	public static class StmtParamsContext extends ParserRuleContext {
		public StmtParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtParams; }
	 
		public StmtParamsContext() { }
		public void copyFrom(StmtParamsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StmtParamscontainedContext extends StmtParamsContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprMoreParamsContext exprMoreParams() {
			return getRuleContext(ExprMoreParamsContext.class,0);
		}
		public StmtParamscontainedContext(StmtParamsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterStmtParamscontained(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitStmtParamscontained(this);
		}
	}
	public static class StmtParamsEmptyContext extends StmtParamsContext {
		public StmtParamsEmptyContext(StmtParamsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterStmtParamsEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitStmtParamsEmpty(this);
		}
	}

	public final StmtParamsContext stmtParams() throws RecognitionException {
		StmtParamsContext _localctx = new StmtParamsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_stmtParams);
		try {
			setState(211);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
			case NUMBERVAL:
			case BOOLVAL:
			case LPAREN:
			case NEGATE:
				_localctx = new StmtParamscontainedContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(207);
				expr();
				setState(208);
				exprMoreParams();
				}
				break;
			case RPAREN:
				_localctx = new StmtParamsEmptyContext(_localctx);
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

	public static class ExprMoreParamsContext extends ParserRuleContext {
		public ExprMoreParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprMoreParams; }
	 
		public ExprMoreParamsContext() { }
		public void copyFrom(ExprMoreParamsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprMoreParamsContainedContext extends ExprMoreParamsContext {
		public TerminalNode COMMA() { return getToken(Buff_1_1Parser.COMMA, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public ExprMoreParamsContext exprMoreParams() {
			return getRuleContext(ExprMoreParamsContext.class,0);
		}
		public ExprMoreParamsContainedContext(ExprMoreParamsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterExprMoreParamsContained(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitExprMoreParamsContained(this);
		}
	}
	public static class ExprMoreParamsEmptyContext extends ExprMoreParamsContext {
		public ExprMoreParamsEmptyContext(ExprMoreParamsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterExprMoreParamsEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitExprMoreParamsEmpty(this);
		}
	}

	public final ExprMoreParamsContext exprMoreParams() throws RecognitionException {
		ExprMoreParamsContext _localctx = new ExprMoreParamsContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_exprMoreParams);
		try {
			setState(218);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMA:
				_localctx = new ExprMoreParamsContainedContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(213);
				match(COMMA);
				setState(214);
				stmt();
				setState(215);
				exprMoreParams();
				}
				break;
			case RPAREN:
				_localctx = new ExprMoreParamsEmptyContext(_localctx);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3$\u00df\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\5\39\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4P\n\4\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\5\6X\n\6\3\7\3\7\3\7\3\7\3\7\5\7_\n\7\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\5\tm\n\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\5\13w\n\13\3\f\3\f\3\f\3\f\3\f\5\f~\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\5\r\u0089\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u009c\n\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\5\17\u00a7\n\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\5\20\u00b2\n\20\3\21\3\21\3\21\3\21\3\21\5\21\u00b9\n"+
		"\21\3\22\3\22\3\22\5\22\u00be\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\5\23\u00c9\n\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26"+
		"\3\26\3\26\5\26\u00d6\n\26\3\27\3\27\3\27\3\27\3\27\5\27\u00dd\n\27\3"+
		"\27\2\2\30\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,\2\4\4\2\3\3"+
		"\5\5\4\2\b\b\n\13\2\u00e1\2.\3\2\2\2\48\3\2\2\2\6O\3\2\2\2\bQ\3\2\2\2"+
		"\nW\3\2\2\2\f^\3\2\2\2\16`\3\2\2\2\20l\3\2\2\2\22n\3\2\2\2\24v\3\2\2\2"+
		"\26}\3\2\2\2\30\u0088\3\2\2\2\32\u009b\3\2\2\2\34\u00a6\3\2\2\2\36\u00b1"+
		"\3\2\2\2 \u00b8\3\2\2\2\"\u00bd\3\2\2\2$\u00c8\3\2\2\2&\u00ca\3\2\2\2"+
		"(\u00cc\3\2\2\2*\u00d5\3\2\2\2,\u00dc\3\2\2\2./\5\4\3\2/\60\7\2\2\3\60"+
		"\3\3\2\2\2\61\62\5\6\4\2\62\63\5\4\3\2\639\3\2\2\2\64\65\5\22\n\2\65\66"+
		"\5\4\3\2\669\3\2\2\2\679\3\2\2\28\61\3\2\2\28\64\3\2\2\28\67\3\2\2\29"+
		"\5\3\2\2\2:;\5\b\5\2;<\7\b\2\2<=\7\f\2\2=>\5\n\6\2>?\7\r\2\2?@\7\35\2"+
		"\2@A\5\22\n\2AP\3\2\2\2BC\5\b\5\2CD\7\b\2\2DE\7\f\2\2EF\5\n\6\2FG\7\r"+
		"\2\2GH\7\35\2\2HI\7\16\2\2IJ\5\20\t\2JK\7\20\2\2KL\5\22\n\2LM\7\17\2\2"+
		"MN\7\6\2\2NP\3\2\2\2O:\3\2\2\2OB\3\2\2\2P\7\3\2\2\2QR\t\2\2\2R\t\3\2\2"+
		"\2ST\5\16\b\2TU\5\f\7\2UX\3\2\2\2VX\3\2\2\2WS\3\2\2\2WV\3\2\2\2X\13\3"+
		"\2\2\2YZ\7\34\2\2Z[\5\16\b\2[\\\5\f\7\2\\_\3\2\2\2]_\3\2\2\2^Y\3\2\2\2"+
		"^]\3\2\2\2_\r\3\2\2\2`a\5\b\5\2ab\7\b\2\2b\17\3\2\2\2cd\7\23\2\2de\7\f"+
		"\2\2ef\5\24\13\2fg\7\r\2\2gh\7\20\2\2hi\5\22\n\2ij\5\20\t\2jm\3\2\2\2"+
		"km\3\2\2\2lc\3\2\2\2lk\3\2\2\2m\21\3\2\2\2no\5\24\13\2op\7\"\2\2p\23\3"+
		"\2\2\2qr\5\26\f\2rs\7\22\2\2st\5\24\13\2tw\3\2\2\2uw\5\26\f\2vq\3\2\2"+
		"\2vu\3\2\2\2w\25\3\2\2\2xy\5\30\r\2yz\7\21\2\2z{\5\26\f\2{~\3\2\2\2|~"+
		"\5\30\r\2}x\3\2\2\2}|\3\2\2\2~\27\3\2\2\2\177\u0080\5\32\16\2\u0080\u0081"+
		"\7\24\2\2\u0081\u0082\5\30\r\2\u0082\u0089\3\2\2\2\u0083\u0084\5\32\16"+
		"\2\u0084\u0085\7\25\2\2\u0085\u0086\5\30\r\2\u0086\u0089\3\2\2\2\u0087"+
		"\u0089\5\32\16\2\u0088\177\3\2\2\2\u0088\u0083\3\2\2\2\u0088\u0087\3\2"+
		"\2\2\u0089\31\3\2\2\2\u008a\u008b\5\34\17\2\u008b\u008c\7\26\2\2\u008c"+
		"\u008d\5\32\16\2\u008d\u009c\3\2\2\2\u008e\u008f\5\34\17\2\u008f\u0090"+
		"\7\27\2\2\u0090\u0091\5\32\16\2\u0091\u009c\3\2\2\2\u0092\u0093\5\34\17"+
		"\2\u0093\u0094\7\30\2\2\u0094\u0095\5\32\16\2\u0095\u009c\3\2\2\2\u0096"+
		"\u0097\5\34\17\2\u0097\u0098\7\31\2\2\u0098\u0099\5\32\16\2\u0099\u009c"+
		"\3\2\2\2\u009a\u009c\5\34\17\2\u009b\u008a\3\2\2\2\u009b\u008e\3\2\2\2"+
		"\u009b\u0092\3\2\2\2\u009b\u0096\3\2\2\2\u009b\u009a\3\2\2\2\u009c\33"+
		"\3\2\2\2\u009d\u009e\5\36\20\2\u009e\u009f\7\36\2\2\u009f\u00a0\5\34\17"+
		"\2\u00a0\u00a7\3\2\2\2\u00a1\u00a2\5\36\20\2\u00a2\u00a3\7\37\2\2\u00a3"+
		"\u00a4\5\34\17\2\u00a4\u00a7\3\2\2\2\u00a5\u00a7\5\36\20\2\u00a6\u009d"+
		"\3\2\2\2\u00a6\u00a1\3\2\2\2\u00a6\u00a5\3\2\2\2\u00a7\35\3\2\2\2\u00a8"+
		"\u00a9\5 \21\2\u00a9\u00aa\7 \2\2\u00aa\u00ab\5\36\20\2\u00ab\u00b2\3"+
		"\2\2\2\u00ac\u00ad\5 \21\2\u00ad\u00ae\7!\2\2\u00ae\u00af\5\36\20\2\u00af"+
		"\u00b2\3\2\2\2\u00b0\u00b2\5 \21\2\u00b1\u00a8\3\2\2\2\u00b1\u00ac\3\2"+
		"\2\2\u00b1\u00b0\3\2\2\2\u00b2\37\3\2\2\2\u00b3\u00b4\5\"\22\2\u00b4\u00b5"+
		"\7\33\2\2\u00b5\u00b6\5 \21\2\u00b6\u00b9\3\2\2\2\u00b7\u00b9\5\"\22\2"+
		"\u00b8\u00b3\3\2\2\2\u00b8\u00b7\3\2\2\2\u00b9!\3\2\2\2\u00ba\u00bb\7"+
		"\32\2\2\u00bb\u00be\5$\23\2\u00bc\u00be\5$\23\2\u00bd\u00ba\3\2\2\2\u00bd"+
		"\u00bc\3\2\2\2\u00be#\3\2\2\2\u00bf\u00c0\7\f\2\2\u00c0\u00c1\5\24\13"+
		"\2\u00c1\u00c2\7\r\2\2\u00c2\u00c9\3\2\2\2\u00c3\u00c9\5(\25\2\u00c4\u00c5"+
		"\5(\25\2\u00c5\u00c6\7\7\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c9\5&\24\2\u00c8"+
		"\u00bf\3\2\2\2\u00c8\u00c3\3\2\2\2\u00c8\u00c4\3\2\2\2\u00c8\u00c7\3\2"+
		"\2\2\u00c9%\3\2\2\2\u00ca\u00cb\t\3\2\2\u00cb\'\3\2\2\2\u00cc\u00cd\7"+
		"\b\2\2\u00cd\u00ce\7\f\2\2\u00ce\u00cf\5*\26\2\u00cf\u00d0\7\r\2\2\u00d0"+
		")\3\2\2\2\u00d1\u00d2\5\24\13\2\u00d2\u00d3\5,\27\2\u00d3\u00d6\3\2\2"+
		"\2\u00d4\u00d6\3\2\2\2\u00d5\u00d1\3\2\2\2\u00d5\u00d4\3\2\2\2\u00d6+"+
		"\3\2\2\2\u00d7\u00d8\7\34\2\2\u00d8\u00d9\5\22\n\2\u00d9\u00da\5,\27\2"+
		"\u00da\u00dd\3\2\2\2\u00db\u00dd\3\2\2\2\u00dc\u00d7\3\2\2\2\u00dc\u00db"+
		"\3\2\2\2\u00dd-\3\2\2\2\228OW^lv}\u0088\u009b\u00a6\u00b1\u00b8\u00bd"+
		"\u00c8\u00d5\u00dc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}