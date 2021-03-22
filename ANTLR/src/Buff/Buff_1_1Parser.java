// Generated from Buff_1_1.g4 by ANTLR 4.9
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
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NUMBERDCL=1, TEXTDCL=2, BOOLEAN=3, ID=4, TEXTVAL=5, NUMBERVAL=6, BOOLVAL=7, 
		LPAREN=8, RPAREN=9, LCURLY=10, RCURLY=11, RETURN=12, LOGAND=13, LOGOR=14, 
		IF=15, LOGEQUALS=16, LOGNEQUALS=17, LOGLESS=18, LOGGREATER=19, LOGLESSOREQUAL=20, 
		LOGGREATEROREQUAL=21, NEGATE=22, POWER=23, COMMA=24, ASSIGN=25, PLUS=26, 
		MINUS=27, MULTIPLY=28, DIVIDE=29, SEMICOLON=30, WS=31, NEWLINE=32;
	public static final int
		RULE_start = 0, RULE_prog = 1, RULE_dcl = 2, RULE_type = 3, RULE_dclParams = 4, 
		RULE_dclMoreParams = 5, RULE_dclParam = 6, RULE_stmts = 7, RULE_stmt = 8, 
		RULE_expr = 9, RULE_lgclExpr = 10, RULE_lgclExpr2 = 11, RULE_lgclExpr3 = 12, 
		RULE_mathExpr = 13, RULE_mathExpr2 = 14, RULE_mathExpr3 = 15, RULE_lgclExpr4 = 16, 
		RULE_val = 17, RULE_termVal = 18, RULE_funcCall = 19, RULE_stmtParams = 20, 
		RULE_stmtMoreParams = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "prog", "dcl", "type", "dclParams", "dclMoreParams", "dclParam", 
			"stmts", "stmt", "expr", "lgclExpr", "lgclExpr2", "lgclExpr3", "mathExpr", 
			"mathExpr2", "mathExpr3", "lgclExpr4", "val", "termVal", "funcCall", 
			"stmtParams", "stmtMoreParams"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'number'", "'text'", "'bool'", null, null, null, null, "'('", 
			"')'", "'{'", "'}'", "'return'", "'&&'", "'||'", "'if'", "'=='", "'!='", 
			"'<'", "'>'", "'<='", "'>='", "'!'", "'^'", "','", "'='", "'+'", "'-'", 
			"'*'", "'/'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NUMBERDCL", "TEXTDCL", "BOOLEAN", "ID", "TEXTVAL", "NUMBERVAL", 
			"BOOLVAL", "LPAREN", "RPAREN", "LCURLY", "RCURLY", "RETURN", "LOGAND", 
			"LOGOR", "IF", "LOGEQUALS", "LOGNEQUALS", "LOGLESS", "LOGGREATER", "LOGLESSOREQUAL", 
			"LOGGREATEROREQUAL", "NEGATE", "POWER", "COMMA", "ASSIGN", "PLUS", "MINUS", 
			"MULTIPLY", "DIVIDE", "SEMICOLON", "WS", "NEWLINE"
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Buff_1_1Visitor ) return ((Buff_1_1Visitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Buff_1_1Visitor ) return ((Buff_1_1Visitor<? extends T>)visitor).visitStmtProg(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Buff_1_1Visitor ) return ((Buff_1_1Visitor<? extends T>)visitor).visitDclProg(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Buff_1_1Visitor ) return ((Buff_1_1Visitor<? extends T>)visitor).visitProgEmpty(this);
			else return visitor.visitChildren(this);
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
			case TEXTDCL:
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
			case TEXTVAL:
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
		public MultiLineStmtContext(DclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterMultiLineStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitMultiLineStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Buff_1_1Visitor ) return ((Buff_1_1Visitor<? extends T>)visitor).visitMultiLineStmt(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Buff_1_1Visitor ) return ((Buff_1_1Visitor<? extends T>)visitor).visitOneLineStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DclContext dcl() throws RecognitionException {
		DclContext _localctx = new DclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_dcl);
		try {
			setState(76);
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
		public TerminalNode TEXTDCL() { return getToken(Buff_1_1Parser.TEXTDCL, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Buff_1_1Visitor ) return ((Buff_1_1Visitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMBERDCL) | (1L << TEXTDCL) | (1L << BOOLEAN))) != 0)) ) {
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
		public DclParamContext dclParam() {
			return getRuleContext(DclParamContext.class,0);
		}
		public DclMoreParamsContext dclMoreParams() {
			return getRuleContext(DclMoreParamsContext.class,0);
		}
		public DclParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dclParams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterDclParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitDclParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Buff_1_1Visitor ) return ((Buff_1_1Visitor<? extends T>)visitor).visitDclParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DclParamsContext dclParams() throws RecognitionException {
		DclParamsContext _localctx = new DclParamsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_dclParams);
		try {
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBERDCL:
			case TEXTDCL:
			case BOOLEAN:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				dclParam();
				setState(81);
				dclMoreParams();
				}
				break;
			case RPAREN:
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
		public TerminalNode COMMA() { return getToken(Buff_1_1Parser.COMMA, 0); }
		public DclParamContext dclParam() {
			return getRuleContext(DclParamContext.class,0);
		}
		public DclMoreParamsContext dclMoreParams() {
			return getRuleContext(DclMoreParamsContext.class,0);
		}
		public DclMoreParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dclMoreParams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterDclMoreParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitDclMoreParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Buff_1_1Visitor ) return ((Buff_1_1Visitor<? extends T>)visitor).visitDclMoreParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DclMoreParamsContext dclMoreParams() throws RecognitionException {
		DclMoreParamsContext _localctx = new DclMoreParamsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_dclMoreParams);
		try {
			setState(91);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMA:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				match(COMMA);
				setState(87);
				dclParam();
				setState(88);
				dclMoreParams();
				}
				break;
			case RPAREN:
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Buff_1_1Visitor ) return ((Buff_1_1Visitor<? extends T>)visitor).visitDclParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DclParamContext dclParam() throws RecognitionException {
		DclParamContext _localctx = new DclParamContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_dclParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			type();
			setState(94);
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
		public StmtsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmts; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterStmts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitStmts(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Buff_1_1Visitor ) return ((Buff_1_1Visitor<? extends T>)visitor).visitStmts(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtsContext stmts() throws RecognitionException {
		StmtsContext _localctx = new StmtsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_stmts);
		try {
			setState(105);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				match(IF);
				setState(97);
				match(LPAREN);
				setState(98);
				expr();
				setState(99);
				match(RPAREN);
				setState(100);
				match(RETURN);
				setState(101);
				stmt();
				setState(102);
				stmts();
				}
				break;
			case RETURN:
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Buff_1_1Visitor ) return ((Buff_1_1Visitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			expr();
			setState(108);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Buff_1_1Visitor ) return ((Buff_1_1Visitor<? extends T>)visitor).visitLogOr(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Buff_1_1Visitor ) return ((Buff_1_1Visitor<? extends T>)visitor).visitLogExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expr);
		try {
			setState(115);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new LogOrContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				((LogOrContext)_localctx).left = lgclExpr();
				setState(111);
				((LogOrContext)_localctx).op = match(LOGOR);
				setState(112);
				((LogOrContext)_localctx).right = expr();
				}
				break;
			case 2:
				_localctx = new LogExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Buff_1_1Visitor ) return ((Buff_1_1Visitor<? extends T>)visitor).visitLogAnd(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Buff_1_1Visitor ) return ((Buff_1_1Visitor<? extends T>)visitor).visitLog2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LgclExprContext lgclExpr() throws RecognitionException {
		LgclExprContext _localctx = new LgclExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_lgclExpr);
		try {
			setState(122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new LogAndContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				((LogAndContext)_localctx).left = lgclExpr2();
				setState(118);
				((LogAndContext)_localctx).op = match(LOGAND);
				setState(119);
				((LogAndContext)_localctx).right = lgclExpr();
				}
				break;
			case 2:
				_localctx = new Log2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Buff_1_1Visitor ) return ((Buff_1_1Visitor<? extends T>)visitor).visitLogEqualsOp(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Buff_1_1Visitor ) return ((Buff_1_1Visitor<? extends T>)visitor).visitMathLog(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LgclExpr2Context lgclExpr2() throws RecognitionException {
		LgclExpr2Context _localctx = new LgclExpr2Context(_ctx, getState());
		enterRule(_localctx, 22, RULE_lgclExpr2);
		try {
			setState(133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new LogEqualsOpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				((LogEqualsOpContext)_localctx).left = lgclExpr3();
				setState(125);
				((LogEqualsOpContext)_localctx).op = match(LOGEQUALS);
				setState(126);
				((LogEqualsOpContext)_localctx).right = lgclExpr2();
				}
				break;
			case 2:
				_localctx = new LogEqualsOpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				((LogEqualsOpContext)_localctx).left = lgclExpr3();
				setState(129);
				((LogEqualsOpContext)_localctx).op = match(LOGNEQUALS);
				setState(130);
				((LogEqualsOpContext)_localctx).right = lgclExpr2();
				}
				break;
			case 3:
				_localctx = new MathLogContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(132);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Buff_1_1Visitor ) return ((Buff_1_1Visitor<? extends T>)visitor).visitLogicalOp(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Buff_1_1Visitor ) return ((Buff_1_1Visitor<? extends T>)visitor).visitMath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LgclExpr3Context lgclExpr3() throws RecognitionException {
		LgclExpr3Context _localctx = new LgclExpr3Context(_ctx, getState());
		enterRule(_localctx, 24, RULE_lgclExpr3);
		try {
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new LogicalOpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				((LogicalOpContext)_localctx).left = mathExpr();
				setState(136);
				((LogicalOpContext)_localctx).op = match(LOGLESS);
				setState(137);
				((LogicalOpContext)_localctx).right = lgclExpr3();
				}
				break;
			case 2:
				_localctx = new LogicalOpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				((LogicalOpContext)_localctx).left = mathExpr();
				setState(140);
				((LogicalOpContext)_localctx).op = match(LOGGREATER);
				setState(141);
				((LogicalOpContext)_localctx).right = lgclExpr3();
				}
				break;
			case 3:
				_localctx = new LogicalOpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(143);
				((LogicalOpContext)_localctx).left = mathExpr();
				setState(144);
				((LogicalOpContext)_localctx).op = match(LOGLESSOREQUAL);
				setState(145);
				((LogicalOpContext)_localctx).right = lgclExpr3();
				}
				break;
			case 4:
				_localctx = new LogicalOpContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(147);
				((LogicalOpContext)_localctx).left = mathExpr();
				setState(148);
				((LogicalOpContext)_localctx).op = match(LOGGREATEROREQUAL);
				setState(149);
				((LogicalOpContext)_localctx).right = lgclExpr3();
				}
				break;
			case 5:
				_localctx = new MathContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(151);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Buff_1_1Visitor ) return ((Buff_1_1Visitor<? extends T>)visitor).visitMathDivMul(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Buff_1_1Visitor ) return ((Buff_1_1Visitor<? extends T>)visitor).visitBinaryOpPlusMinus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MathExprContext mathExpr() throws RecognitionException {
		MathExprContext _localctx = new MathExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_mathExpr);
		try {
			setState(163);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new BinaryOpPlusMinusContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				((BinaryOpPlusMinusContext)_localctx).left = mathExpr2();
				setState(155);
				((BinaryOpPlusMinusContext)_localctx).op = match(PLUS);
				setState(156);
				((BinaryOpPlusMinusContext)_localctx).right = mathExpr();
				}
				break;
			case 2:
				_localctx = new BinaryOpPlusMinusContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				((BinaryOpPlusMinusContext)_localctx).left = mathExpr2();
				setState(159);
				((BinaryOpPlusMinusContext)_localctx).op = match(MINUS);
				setState(160);
				((BinaryOpPlusMinusContext)_localctx).right = mathExpr();
				}
				break;
			case 3:
				_localctx = new MathDivMulContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(162);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Buff_1_1Visitor ) return ((Buff_1_1Visitor<? extends T>)visitor).visitMathPow(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Buff_1_1Visitor ) return ((Buff_1_1Visitor<? extends T>)visitor).visitBinaryOpDivMul(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MathExpr2Context mathExpr2() throws RecognitionException {
		MathExpr2Context _localctx = new MathExpr2Context(_ctx, getState());
		enterRule(_localctx, 28, RULE_mathExpr2);
		try {
			setState(174);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new BinaryOpDivMulContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				((BinaryOpDivMulContext)_localctx).left = mathExpr3();
				setState(166);
				((BinaryOpDivMulContext)_localctx).op = match(MULTIPLY);
				setState(167);
				((BinaryOpDivMulContext)_localctx).right = mathExpr2();
				}
				break;
			case 2:
				_localctx = new BinaryOpDivMulContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				((BinaryOpDivMulContext)_localctx).left = mathExpr3();
				setState(170);
				((BinaryOpDivMulContext)_localctx).op = match(DIVIDE);
				setState(171);
				((BinaryOpDivMulContext)_localctx).right = mathExpr2();
				}
				break;
			case 3:
				_localctx = new MathPowContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(173);
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
	public static class BinaryOpPoeContext extends MathExpr3Context {
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
		public BinaryOpPoeContext(MathExpr3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterBinaryOpPoe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitBinaryOpPoe(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Buff_1_1Visitor ) return ((Buff_1_1Visitor<? extends T>)visitor).visitBinaryOpPoe(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Buff_1_1Visitor ) return ((Buff_1_1Visitor<? extends T>)visitor).visitLogUnary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MathExpr3Context mathExpr3() throws RecognitionException {
		MathExpr3Context _localctx = new MathExpr3Context(_ctx, getState());
		enterRule(_localctx, 30, RULE_mathExpr3);
		try {
			setState(181);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new BinaryOpPoeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				((BinaryOpPoeContext)_localctx).left = lgclExpr4();
				setState(177);
				((BinaryOpPoeContext)_localctx).op = match(POWER);
				setState(178);
				((BinaryOpPoeContext)_localctx).right = mathExpr3();
				}
				break;
			case 2:
				_localctx = new LogUnaryContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(180);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Buff_1_1Visitor ) return ((Buff_1_1Visitor<? extends T>)visitor).visitNegate(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Buff_1_1Visitor ) return ((Buff_1_1Visitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LgclExpr4Context lgclExpr4() throws RecognitionException {
		LgclExpr4Context _localctx = new LgclExpr4Context(_ctx, getState());
		enterRule(_localctx, 32, RULE_lgclExpr4);
		try {
			setState(186);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEGATE:
				_localctx = new NegateContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(183);
				((NegateContext)_localctx).op = match(NEGATE);
				setState(184);
				val();
				}
				break;
			case ID:
			case TEXTVAL:
			case NUMBERVAL:
			case BOOLVAL:
			case LPAREN:
				_localctx = new ValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(185);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Buff_1_1Visitor ) return ((Buff_1_1Visitor<? extends T>)visitor).visitParensExp(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Buff_1_1Visitor ) return ((Buff_1_1Visitor<? extends T>)visitor).visitValTerminal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValFuncCalContext extends ValContext {
		public FuncCallContext funcCall() {
			return getRuleContext(FuncCallContext.class,0);
		}
		public ValFuncCalContext(ValContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterValFuncCal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitValFuncCal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Buff_1_1Visitor ) return ((Buff_1_1Visitor<? extends T>)visitor).visitValFuncCal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValContext val() throws RecognitionException {
		ValContext _localctx = new ValContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_val);
		try {
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new ParensExpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(188);
				match(LPAREN);
				setState(189);
				expr();
				setState(190);
				match(RPAREN);
				}
				break;
			case 2:
				_localctx = new ValFuncCalContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(192);
				funcCall();
				}
				break;
			case 3:
				_localctx = new ValTerminalContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(193);
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
		public TerminalNode TEXTVAL() { return getToken(Buff_1_1Parser.TEXTVAL, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Buff_1_1Visitor ) return ((Buff_1_1Visitor<? extends T>)visitor).visitTermVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermValContext termVal() throws RecognitionException {
		TermValContext _localctx = new TermValContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_termVal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << TEXTVAL) | (1L << NUMBERVAL) | (1L << BOOLVAL))) != 0)) ) {
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Buff_1_1Visitor ) return ((Buff_1_1Visitor<? extends T>)visitor).visitFuncCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncCallContext funcCall() throws RecognitionException {
		FuncCallContext _localctx = new FuncCallContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_funcCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(ID);
			setState(199);
			match(LPAREN);
			setState(200);
			stmtParams();
			setState(201);
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
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public StmtMoreParamsContext stmtMoreParams() {
			return getRuleContext(StmtMoreParamsContext.class,0);
		}
		public StmtParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtParams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterStmtParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitStmtParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Buff_1_1Visitor ) return ((Buff_1_1Visitor<? extends T>)visitor).visitStmtParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtParamsContext stmtParams() throws RecognitionException {
		StmtParamsContext _localctx = new StmtParamsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_stmtParams);
		try {
			setState(207);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
			case TEXTVAL:
			case NUMBERVAL:
			case BOOLVAL:
			case LPAREN:
			case NEGATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(203);
				stmt();
				setState(204);
				stmtMoreParams();
				}
				break;
			case RPAREN:
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

	public static class StmtMoreParamsContext extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(Buff_1_1Parser.COMMA, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public StmtMoreParamsContext stmtMoreParams() {
			return getRuleContext(StmtMoreParamsContext.class,0);
		}
		public StmtMoreParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtMoreParams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).enterStmtMoreParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Buff_1_1Listener ) ((Buff_1_1Listener)listener).exitStmtMoreParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Buff_1_1Visitor ) return ((Buff_1_1Visitor<? extends T>)visitor).visitStmtMoreParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtMoreParamsContext stmtMoreParams() throws RecognitionException {
		StmtMoreParamsContext _localctx = new StmtMoreParamsContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_stmtMoreParams);
		try {
			setState(214);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMA:
				enterOuterAlt(_localctx, 1);
				{
				setState(209);
				match(COMMA);
				setState(210);
				stmt();
				setState(211);
				stmtMoreParams();
				}
				break;
			case RPAREN:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\"\u00db\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\5\39\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4O\n\4\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\5\6W\n\6\3\7\3\7\3\7\3\7\3\7\5\7^\n\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\5\tl\n\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\5\13"+
		"v\n\13\3\f\3\f\3\f\3\f\3\f\5\f}\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\5\r\u0088\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u009b\n\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\5\17\u00a6\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\5\20\u00b1\n\20\3\21\3\21\3\21\3\21\3\21\5\21\u00b8\n\21\3"+
		"\22\3\22\3\22\5\22\u00bd\n\22\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00c5"+
		"\n\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\5\26\u00d2"+
		"\n\26\3\27\3\27\3\27\3\27\3\27\5\27\u00d9\n\27\3\27\2\2\30\2\4\6\b\n\f"+
		"\16\20\22\24\26\30\32\34\36 \"$&(*,\2\4\3\2\3\5\3\2\6\t\2\u00dc\2.\3\2"+
		"\2\2\48\3\2\2\2\6N\3\2\2\2\bP\3\2\2\2\nV\3\2\2\2\f]\3\2\2\2\16_\3\2\2"+
		"\2\20k\3\2\2\2\22m\3\2\2\2\24u\3\2\2\2\26|\3\2\2\2\30\u0087\3\2\2\2\32"+
		"\u009a\3\2\2\2\34\u00a5\3\2\2\2\36\u00b0\3\2\2\2 \u00b7\3\2\2\2\"\u00bc"+
		"\3\2\2\2$\u00c4\3\2\2\2&\u00c6\3\2\2\2(\u00c8\3\2\2\2*\u00d1\3\2\2\2,"+
		"\u00d8\3\2\2\2./\5\4\3\2/\60\7\2\2\3\60\3\3\2\2\2\61\62\5\6\4\2\62\63"+
		"\5\4\3\2\639\3\2\2\2\64\65\5\22\n\2\65\66\5\4\3\2\669\3\2\2\2\679\3\2"+
		"\2\28\61\3\2\2\28\64\3\2\2\28\67\3\2\2\29\5\3\2\2\2:;\5\b\5\2;<\7\6\2"+
		"\2<=\7\n\2\2=>\5\n\6\2>?\7\13\2\2?@\7\33\2\2@A\5\22\n\2AO\3\2\2\2BC\5"+
		"\b\5\2CD\7\6\2\2DE\7\n\2\2EF\5\n\6\2FG\7\13\2\2GH\7\33\2\2HI\7\f\2\2I"+
		"J\5\20\t\2JK\7\16\2\2KL\5\22\n\2LM\7\r\2\2MO\3\2\2\2N:\3\2\2\2NB\3\2\2"+
		"\2O\7\3\2\2\2PQ\t\2\2\2Q\t\3\2\2\2RS\5\16\b\2ST\5\f\7\2TW\3\2\2\2UW\3"+
		"\2\2\2VR\3\2\2\2VU\3\2\2\2W\13\3\2\2\2XY\7\32\2\2YZ\5\16\b\2Z[\5\f\7\2"+
		"[^\3\2\2\2\\^\3\2\2\2]X\3\2\2\2]\\\3\2\2\2^\r\3\2\2\2_`\5\b\5\2`a\7\6"+
		"\2\2a\17\3\2\2\2bc\7\21\2\2cd\7\n\2\2de\5\24\13\2ef\7\13\2\2fg\7\16\2"+
		"\2gh\5\22\n\2hi\5\20\t\2il\3\2\2\2jl\3\2\2\2kb\3\2\2\2kj\3\2\2\2l\21\3"+
		"\2\2\2mn\5\24\13\2no\7 \2\2o\23\3\2\2\2pq\5\26\f\2qr\7\20\2\2rs\5\24\13"+
		"\2sv\3\2\2\2tv\5\26\f\2up\3\2\2\2ut\3\2\2\2v\25\3\2\2\2wx\5\30\r\2xy\7"+
		"\17\2\2yz\5\26\f\2z}\3\2\2\2{}\5\30\r\2|w\3\2\2\2|{\3\2\2\2}\27\3\2\2"+
		"\2~\177\5\32\16\2\177\u0080\7\22\2\2\u0080\u0081\5\30\r\2\u0081\u0088"+
		"\3\2\2\2\u0082\u0083\5\32\16\2\u0083\u0084\7\23\2\2\u0084\u0085\5\30\r"+
		"\2\u0085\u0088\3\2\2\2\u0086\u0088\5\32\16\2\u0087~\3\2\2\2\u0087\u0082"+
		"\3\2\2\2\u0087\u0086\3\2\2\2\u0088\31\3\2\2\2\u0089\u008a\5\34\17\2\u008a"+
		"\u008b\7\24\2\2\u008b\u008c\5\32\16\2\u008c\u009b\3\2\2\2\u008d\u008e"+
		"\5\34\17\2\u008e\u008f\7\25\2\2\u008f\u0090\5\32\16\2\u0090\u009b\3\2"+
		"\2\2\u0091\u0092\5\34\17\2\u0092\u0093\7\26\2\2\u0093\u0094\5\32\16\2"+
		"\u0094\u009b\3\2\2\2\u0095\u0096\5\34\17\2\u0096\u0097\7\27\2\2\u0097"+
		"\u0098\5\32\16\2\u0098\u009b\3\2\2\2\u0099\u009b\5\34\17\2\u009a\u0089"+
		"\3\2\2\2\u009a\u008d\3\2\2\2\u009a\u0091\3\2\2\2\u009a\u0095\3\2\2\2\u009a"+
		"\u0099\3\2\2\2\u009b\33\3\2\2\2\u009c\u009d\5\36\20\2\u009d\u009e\7\34"+
		"\2\2\u009e\u009f\5\34\17\2\u009f\u00a6\3\2\2\2\u00a0\u00a1\5\36\20\2\u00a1"+
		"\u00a2\7\35\2\2\u00a2\u00a3\5\34\17\2\u00a3\u00a6\3\2\2\2\u00a4\u00a6"+
		"\5\36\20\2\u00a5\u009c\3\2\2\2\u00a5\u00a0\3\2\2\2\u00a5\u00a4\3\2\2\2"+
		"\u00a6\35\3\2\2\2\u00a7\u00a8\5 \21\2\u00a8\u00a9\7\36\2\2\u00a9\u00aa"+
		"\5\36\20\2\u00aa\u00b1\3\2\2\2\u00ab\u00ac\5 \21\2\u00ac\u00ad\7\37\2"+
		"\2\u00ad\u00ae\5\36\20\2\u00ae\u00b1\3\2\2\2\u00af\u00b1\5 \21\2\u00b0"+
		"\u00a7\3\2\2\2\u00b0\u00ab\3\2\2\2\u00b0\u00af\3\2\2\2\u00b1\37\3\2\2"+
		"\2\u00b2\u00b3\5\"\22\2\u00b3\u00b4\7\31\2\2\u00b4\u00b5\5 \21\2\u00b5"+
		"\u00b8\3\2\2\2\u00b6\u00b8\5\"\22\2\u00b7\u00b2\3\2\2\2\u00b7\u00b6\3"+
		"\2\2\2\u00b8!\3\2\2\2\u00b9\u00ba\7\30\2\2\u00ba\u00bd\5$\23\2\u00bb\u00bd"+
		"\5$\23\2\u00bc\u00b9\3\2\2\2\u00bc\u00bb\3\2\2\2\u00bd#\3\2\2\2\u00be"+
		"\u00bf\7\n\2\2\u00bf\u00c0\5\24\13\2\u00c0\u00c1\7\13\2\2\u00c1\u00c5"+
		"\3\2\2\2\u00c2\u00c5\5(\25\2\u00c3\u00c5\5&\24\2\u00c4\u00be\3\2\2\2\u00c4"+
		"\u00c2\3\2\2\2\u00c4\u00c3\3\2\2\2\u00c5%\3\2\2\2\u00c6\u00c7\t\3\2\2"+
		"\u00c7\'\3\2\2\2\u00c8\u00c9\7\6\2\2\u00c9\u00ca\7\n\2\2\u00ca\u00cb\5"+
		"*\26\2\u00cb\u00cc\7\13\2\2\u00cc)\3\2\2\2\u00cd\u00ce\5\22\n\2\u00ce"+
		"\u00cf\5,\27\2\u00cf\u00d2\3\2\2\2\u00d0\u00d2\3\2\2\2\u00d1\u00cd\3\2"+
		"\2\2\u00d1\u00d0\3\2\2\2\u00d2+\3\2\2\2\u00d3\u00d4\7\32\2\2\u00d4\u00d5"+
		"\5\22\n\2\u00d5\u00d6\5,\27\2\u00d6\u00d9\3\2\2\2\u00d7\u00d9\3\2\2\2"+
		"\u00d8\u00d3\3\2\2\2\u00d8\u00d7\3\2\2\2\u00d9-\3\2\2\2\228NV]ku|\u0087"+
		"\u009a\u00a5\u00b0\u00b7\u00bc\u00c4\u00d1\u00d8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}