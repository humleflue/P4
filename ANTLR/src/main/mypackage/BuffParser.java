// Generated from Buff.g4 by ANTLR 4.9.2
package mypackage;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BuffParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NUMBERDCL=1, TEXTDCL=2, ID=3, TEXTVAL=4, NUMBERVAL=5, LPAREN=6, RPAREN=7, 
		ASSIGN=8, COMMA=9, PLUS=10, MINUS=11, SEMICOLON=12, WS=13, NEWLINE=14;
	public static final int
		RULE_prog = 0, RULE_dcls = 1, RULE_dcl = 2, RULE_type = 3, RULE_dclparams = 4, 
		RULE_dclmoreparams = 5, RULE_dclparam = 6, RULE_stmts = 7, RULE_stmt = 8, 
		RULE_math = 9, RULE_followterm = 10, RULE_term = 11, RULE_simpleops = 12, 
		RULE_val = 13, RULE_valTerminal = 14, RULE_funccall = 15, RULE_stmtparams = 16, 
		RULE_stmtmoreparams = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "dcls", "dcl", "type", "dclparams", "dclmoreparams", "dclparam", 
			"stmts", "stmt", "math", "followterm", "term", "simpleops", "val", "valTerminal", 
			"funccall", "stmtparams", "stmtmoreparams"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'number'", "'text'", null, null, null, "'('", "')'", "'='", "','", 
			"'+'", "'-'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NUMBERDCL", "TEXTDCL", "ID", "TEXTVAL", "NUMBERVAL", "LPAREN", 
			"RPAREN", "ASSIGN", "COMMA", "PLUS", "MINUS", "SEMICOLON", "WS", "NEWLINE"
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
	public String getGrammarFileName() { return "Buff.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BuffParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public DclsContext dcls() {
			return getRuleContext(DclsContext.class,0);
		}
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(BuffParser.EOF, 0); }
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuffVisitor ) return ((BuffVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			dcls();
			setState(37);
			stmts();
			setState(38);
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

	public static class DclsContext extends ParserRuleContext {
		public DclContext dcl() {
			return getRuleContext(DclContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(BuffParser.SEMICOLON, 0); }
		public DclsContext dcls() {
			return getRuleContext(DclsContext.class,0);
		}
		public DclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dcls; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).enterDcls(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).exitDcls(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuffVisitor ) return ((BuffVisitor<? extends T>)visitor).visitDcls(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DclsContext dcls() throws RecognitionException {
		DclsContext _localctx = new DclsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_dcls);
		try {
			setState(45);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBERDCL:
			case TEXTDCL:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				dcl();
				setState(41);
				match(SEMICOLON);
				setState(42);
				dcls();
				}
				break;
			case EOF:
			case ID:
			case TEXTVAL:
			case NUMBERVAL:
			case LPAREN:
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

	public static class DclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(BuffParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(BuffParser.LPAREN, 0); }
		public DclparamsContext dclparams() {
			return getRuleContext(DclparamsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BuffParser.RPAREN, 0); }
		public TerminalNode ASSIGN() { return getToken(BuffParser.ASSIGN, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public DclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).enterDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).exitDcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuffVisitor ) return ((BuffVisitor<? extends T>)visitor).visitDcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DclContext dcl() throws RecognitionException {
		DclContext _localctx = new DclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_dcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			type();
			setState(48);
			match(ID);
			setState(49);
			match(LPAREN);
			setState(50);
			dclparams();
			setState(51);
			match(RPAREN);
			setState(52);
			match(ASSIGN);
			setState(53);
			stmt();
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
		public TerminalNode NUMBERDCL() { return getToken(BuffParser.NUMBERDCL, 0); }
		public TerminalNode TEXTDCL() { return getToken(BuffParser.TEXTDCL, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuffVisitor ) return ((BuffVisitor<? extends T>)visitor).visitType(this);
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
			setState(55);
			_la = _input.LA(1);
			if ( !(_la==NUMBERDCL || _la==TEXTDCL) ) {
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

	public static class DclparamsContext extends ParserRuleContext {
		public DclparamContext dclparam() {
			return getRuleContext(DclparamContext.class,0);
		}
		public DclmoreparamsContext dclmoreparams() {
			return getRuleContext(DclmoreparamsContext.class,0);
		}
		public DclparamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dclparams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).enterDclparams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).exitDclparams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuffVisitor ) return ((BuffVisitor<? extends T>)visitor).visitDclparams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DclparamsContext dclparams() throws RecognitionException {
		DclparamsContext _localctx = new DclparamsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_dclparams);
		try {
			setState(61);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBERDCL:
			case TEXTDCL:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				dclparam();
				setState(58);
				dclmoreparams();
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

	public static class DclmoreparamsContext extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(BuffParser.COMMA, 0); }
		public DclparamContext dclparam() {
			return getRuleContext(DclparamContext.class,0);
		}
		public DclmoreparamsContext dclmoreparams() {
			return getRuleContext(DclmoreparamsContext.class,0);
		}
		public DclmoreparamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dclmoreparams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).enterDclmoreparams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).exitDclmoreparams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuffVisitor ) return ((BuffVisitor<? extends T>)visitor).visitDclmoreparams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DclmoreparamsContext dclmoreparams() throws RecognitionException {
		DclmoreparamsContext _localctx = new DclmoreparamsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_dclmoreparams);
		try {
			setState(68);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMA:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				match(COMMA);
				setState(64);
				dclparam();
				setState(65);
				dclmoreparams();
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

	public static class DclparamContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(BuffParser.ID, 0); }
		public DclparamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dclparam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).enterDclparam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).exitDclparam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuffVisitor ) return ((BuffVisitor<? extends T>)visitor).visitDclparam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DclparamContext dclparam() throws RecognitionException {
		DclparamContext _localctx = new DclparamContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_dclparam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			type();
			setState(71);
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
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(BuffParser.SEMICOLON, 0); }
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public StmtsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmts; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).enterStmts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).exitStmts(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuffVisitor ) return ((BuffVisitor<? extends T>)visitor).visitStmts(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtsContext stmts() throws RecognitionException {
		StmtsContext _localctx = new StmtsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_stmts);
		try {
			setState(78);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
			case TEXTVAL:
			case NUMBERVAL:
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				stmt();
				setState(74);
				match(SEMICOLON);
				setState(75);
				stmts();
				}
				break;
			case EOF:
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
		public MathContext math() {
			return getRuleContext(MathContext.class,0);
		}
		public TerminalNode TEXTVAL() { return getToken(BuffParser.TEXTVAL, 0); }
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuffVisitor ) return ((BuffVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_stmt);
		try {
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
			case NUMBERVAL:
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				math();
				}
				break;
			case TEXTVAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				match(TEXTVAL);
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

	public static class MathContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public FollowtermContext followterm() {
			return getRuleContext(FollowtermContext.class,0);
		}
		public MathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_math; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).enterMath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).exitMath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuffVisitor ) return ((BuffVisitor<? extends T>)visitor).visitMath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MathContext math() throws RecognitionException {
		MathContext _localctx = new MathContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_math);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			term();
			setState(85);
			followterm();
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

	public static class FollowtermContext extends ParserRuleContext {
		public SimpleopsContext simpleops() {
			return getRuleContext(SimpleopsContext.class,0);
		}
		public MathContext math() {
			return getRuleContext(MathContext.class,0);
		}
		public FollowtermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_followterm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).enterFollowterm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).exitFollowterm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuffVisitor ) return ((BuffVisitor<? extends T>)visitor).visitFollowterm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FollowtermContext followterm() throws RecognitionException {
		FollowtermContext _localctx = new FollowtermContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_followterm);
		try {
			setState(91);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				simpleops();
				setState(88);
				math();
				}
				break;
			case RPAREN:
			case COMMA:
			case SEMICOLON:
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

	public static class TermContext extends ParserRuleContext {
		public FunccallContext funccall() {
			return getRuleContext(FunccallContext.class,0);
		}
		public ValContext val() {
			return getRuleContext(ValContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuffVisitor ) return ((BuffVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_term);
		try {
			setState(95);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				funccall();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				val();
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

	public static class SimpleopsContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(BuffParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(BuffParser.MINUS, 0); }
		public SimpleopsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleops; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).enterSimpleops(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).exitSimpleops(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuffVisitor ) return ((BuffVisitor<? extends T>)visitor).visitSimpleops(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleopsContext simpleops() throws RecognitionException {
		SimpleopsContext _localctx = new SimpleopsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_simpleops);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
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
	public static class PresedenceMathContext extends ValContext {
		public TerminalNode LPAREN() { return getToken(BuffParser.LPAREN, 0); }
		public MathContext math() {
			return getRuleContext(MathContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BuffParser.RPAREN, 0); }
		public PresedenceMathContext(ValContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).enterPresedenceMath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).exitPresedenceMath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuffVisitor ) return ((BuffVisitor<? extends T>)visitor).visitPresedenceMath(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TermTerminalContext extends ValContext {
		public ValTerminalContext valTerminal() {
			return getRuleContext(ValTerminalContext.class,0);
		}
		public TermTerminalContext(ValContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).enterTermTerminal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).exitTermTerminal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuffVisitor ) return ((BuffVisitor<? extends T>)visitor).visitTermTerminal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValContext val() throws RecognitionException {
		ValContext _localctx = new ValContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_val);
		try {
			setState(104);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				_localctx = new PresedenceMathContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				match(LPAREN);
				setState(100);
				math();
				setState(101);
				match(RPAREN);
				}
				break;
			case ID:
			case NUMBERVAL:
				_localctx = new TermTerminalContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				valTerminal();
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

	public static class ValTerminalContext extends ParserRuleContext {
		public TerminalNode NUMBERVAL() { return getToken(BuffParser.NUMBERVAL, 0); }
		public TerminalNode ID() { return getToken(BuffParser.ID, 0); }
		public ValTerminalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valTerminal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).enterValTerminal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).exitValTerminal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuffVisitor ) return ((BuffVisitor<? extends T>)visitor).visitValTerminal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValTerminalContext valTerminal() throws RecognitionException {
		ValTerminalContext _localctx = new ValTerminalContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_valTerminal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUMBERVAL) ) {
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

	public static class FunccallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(BuffParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(BuffParser.LPAREN, 0); }
		public StmtparamsContext stmtparams() {
			return getRuleContext(StmtparamsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BuffParser.RPAREN, 0); }
		public FunccallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funccall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).enterFunccall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).exitFunccall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuffVisitor ) return ((BuffVisitor<? extends T>)visitor).visitFunccall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunccallContext funccall() throws RecognitionException {
		FunccallContext _localctx = new FunccallContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_funccall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(ID);
			setState(109);
			match(LPAREN);
			setState(110);
			stmtparams();
			setState(111);
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

	public static class StmtparamsContext extends ParserRuleContext {
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public StmtmoreparamsContext stmtmoreparams() {
			return getRuleContext(StmtmoreparamsContext.class,0);
		}
		public StmtparamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtparams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).enterStmtparams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).exitStmtparams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuffVisitor ) return ((BuffVisitor<? extends T>)visitor).visitStmtparams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtparamsContext stmtparams() throws RecognitionException {
		StmtparamsContext _localctx = new StmtparamsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_stmtparams);
		try {
			setState(117);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
			case TEXTVAL:
			case NUMBERVAL:
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				stmt();
				setState(114);
				stmtmoreparams();
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

	public static class StmtmoreparamsContext extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(BuffParser.COMMA, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public StmtmoreparamsContext stmtmoreparams() {
			return getRuleContext(StmtmoreparamsContext.class,0);
		}
		public StmtmoreparamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtmoreparams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).enterStmtmoreparams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).exitStmtmoreparams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuffVisitor ) return ((BuffVisitor<? extends T>)visitor).visitStmtmoreparams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtmoreparamsContext stmtmoreparams() throws RecognitionException {
		StmtmoreparamsContext _localctx = new StmtmoreparamsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_stmtmoreparams);
		try {
			setState(124);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMA:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				match(COMMA);
				setState(120);
				stmt();
				setState(121);
				stmtmoreparams();
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\20\u0081\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3\60\n\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\5\6@\n\6\3\7\3\7\3\7\3\7"+
		"\3\7\5\7G\n\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\5\tQ\n\t\3\n\3\n\5\nU\n"+
		"\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\5\f^\n\f\3\r\3\r\5\rb\n\r\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\5\17k\n\17\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\5\22x\n\22\3\23\3\23\3\23\3\23\3\23\5\23\177\n\23"+
		"\3\23\2\2\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\5\3\2\3\4\3"+
		"\2\f\r\4\2\5\5\7\7\2x\2&\3\2\2\2\4/\3\2\2\2\6\61\3\2\2\2\b9\3\2\2\2\n"+
		"?\3\2\2\2\fF\3\2\2\2\16H\3\2\2\2\20P\3\2\2\2\22T\3\2\2\2\24V\3\2\2\2\26"+
		"]\3\2\2\2\30a\3\2\2\2\32c\3\2\2\2\34j\3\2\2\2\36l\3\2\2\2 n\3\2\2\2\""+
		"w\3\2\2\2$~\3\2\2\2&\'\5\4\3\2\'(\5\20\t\2()\7\2\2\3)\3\3\2\2\2*+\5\6"+
		"\4\2+,\7\16\2\2,-\5\4\3\2-\60\3\2\2\2.\60\3\2\2\2/*\3\2\2\2/.\3\2\2\2"+
		"\60\5\3\2\2\2\61\62\5\b\5\2\62\63\7\5\2\2\63\64\7\b\2\2\64\65\5\n\6\2"+
		"\65\66\7\t\2\2\66\67\7\n\2\2\678\5\22\n\28\7\3\2\2\29:\t\2\2\2:\t\3\2"+
		"\2\2;<\5\16\b\2<=\5\f\7\2=@\3\2\2\2>@\3\2\2\2?;\3\2\2\2?>\3\2\2\2@\13"+
		"\3\2\2\2AB\7\13\2\2BC\5\16\b\2CD\5\f\7\2DG\3\2\2\2EG\3\2\2\2FA\3\2\2\2"+
		"FE\3\2\2\2G\r\3\2\2\2HI\5\b\5\2IJ\7\5\2\2J\17\3\2\2\2KL\5\22\n\2LM\7\16"+
		"\2\2MN\5\20\t\2NQ\3\2\2\2OQ\3\2\2\2PK\3\2\2\2PO\3\2\2\2Q\21\3\2\2\2RU"+
		"\5\24\13\2SU\7\6\2\2TR\3\2\2\2TS\3\2\2\2U\23\3\2\2\2VW\5\30\r\2WX\5\26"+
		"\f\2X\25\3\2\2\2YZ\5\32\16\2Z[\5\24\13\2[^\3\2\2\2\\^\3\2\2\2]Y\3\2\2"+
		"\2]\\\3\2\2\2^\27\3\2\2\2_b\5 \21\2`b\5\34\17\2a_\3\2\2\2a`\3\2\2\2b\31"+
		"\3\2\2\2cd\t\3\2\2d\33\3\2\2\2ef\7\b\2\2fg\5\24\13\2gh\7\t\2\2hk\3\2\2"+
		"\2ik\5\36\20\2je\3\2\2\2ji\3\2\2\2k\35\3\2\2\2lm\t\4\2\2m\37\3\2\2\2n"+
		"o\7\5\2\2op\7\b\2\2pq\5\"\22\2qr\7\t\2\2r!\3\2\2\2st\5\22\n\2tu\5$\23"+
		"\2ux\3\2\2\2vx\3\2\2\2ws\3\2\2\2wv\3\2\2\2x#\3\2\2\2yz\7\13\2\2z{\5\22"+
		"\n\2{|\5$\23\2|\177\3\2\2\2}\177\3\2\2\2~y\3\2\2\2~}\3\2\2\2\177%\3\2"+
		"\2\2\f/?FPT]ajw~";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}