// Generated from C:/Users/chris/4-semester/Projekt/P4/ANTLR/src/main\Buff.g4 by ANTLR 4.9.1
package main;
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
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NEWLINE=1, NUMBER=2, WHITESPACE=3, LPAREN=4, RPAREN=5, ASSIGN=6, COMMA=7, 
		PLUS=8, MINUS=9, TEXTVAL=10, SEMI=11, NUMBERDCL=12, TEXTDCL=13, ID=14, 
		NUMBERDCl=15;
	public static final int
		RULE_prog = 0, RULE_dcls = 1, RULE_dcl = 2, RULE_type = 3, RULE_dclParams = 4, 
		RULE_dclMoreParams = 5, RULE_dclParam = 6, RULE_stmts = 7, RULE_stmt = 8, 
		RULE_math = 9, RULE_followTerm = 10, RULE_term = 11, RULE_simpleOps = 12, 
		RULE_val = 13, RULE_funcCall = 14, RULE_stmtParams = 15, RULE_stmtMoreParams = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "dcls", "dcl", "type", "dclParams", "dclMoreParams", "dclParam", 
			"stmts", "stmt", "math", "followTerm", "term", "simpleOps", "val", "funcCall", 
			"stmtParams", "stmtMoreParams"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'('", "')'", "'='", "','", "'+'", "'-'", null, 
			"';'", "'number'", "'text'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NEWLINE", "NUMBER", "WHITESPACE", "LPAREN", "RPAREN", "ASSIGN", 
			"COMMA", "PLUS", "MINUS", "TEXTVAL", "SEMI", "NUMBERDCL", "TEXTDCL", 
			"ID", "NUMBERDCl"
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
			setState(34);
			dcls();
			setState(35);
			stmts();
			setState(36);
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
		public TerminalNode SEMI() { return getToken(BuffParser.SEMI, 0); }
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
			setState(43);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEXTDCL:
			case NUMBERDCl:
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				dcl();
				setState(39);
				match(SEMI);
				setState(40);
				dcls();
				}
				break;
			case EOF:
			case NUMBER:
			case LPAREN:
			case TEXTVAL:
			case ID:
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
		public DclParamsContext dclParams() {
			return getRuleContext(DclParamsContext.class,0);
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
			setState(45);
			type();
			setState(46);
			match(ID);
			setState(47);
			match(LPAREN);
			setState(48);
			dclParams();
			setState(49);
			match(RPAREN);
			setState(50);
			match(ASSIGN);
			setState(51);
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
		public TerminalNode NUMBERDCl() { return getToken(BuffParser.NUMBERDCl, 0); }
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
			setState(53);
			_la = _input.LA(1);
			if ( !(_la==TEXTDCL || _la==NUMBERDCl) ) {
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
			if ( listener instanceof BuffListener ) ((BuffListener)listener).enterDclParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).exitDclParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuffVisitor ) return ((BuffVisitor<? extends T>)visitor).visitDclParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DclParamsContext dclParams() throws RecognitionException {
		DclParamsContext _localctx = new DclParamsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_dclParams);
		try {
			setState(59);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEXTDCL:
			case NUMBERDCl:
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				dclParam();
				setState(56);
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
		public TerminalNode COMMA() { return getToken(BuffParser.COMMA, 0); }
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
			if ( listener instanceof BuffListener ) ((BuffListener)listener).enterDclMoreParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).exitDclMoreParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuffVisitor ) return ((BuffVisitor<? extends T>)visitor).visitDclMoreParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DclMoreParamsContext dclMoreParams() throws RecognitionException {
		DclMoreParamsContext _localctx = new DclMoreParamsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_dclMoreParams);
		try {
			setState(66);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMA:
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				match(COMMA);
				setState(62);
				dclParam();
				setState(63);
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
		public TerminalNode ID() { return getToken(BuffParser.ID, 0); }
		public DclParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dclParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).enterDclParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).exitDclParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuffVisitor ) return ((BuffVisitor<? extends T>)visitor).visitDclParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DclParamContext dclParam() throws RecognitionException {
		DclParamContext _localctx = new DclParamContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_dclParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			type();
			setState(69);
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
		public TerminalNode SEMI() { return getToken(BuffParser.SEMI, 0); }
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
			setState(76);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
			case LPAREN:
			case TEXTVAL:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				stmt();
				setState(72);
				match(SEMI);
				setState(73);
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
			setState(80);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
			case LPAREN:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				math();
				}
				break;
			case TEXTVAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
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
		public FollowTermContext followTerm() {
			return getRuleContext(FollowTermContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(BuffParser.NUMBER, 0); }
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
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				term();
				setState(83);
				followTerm();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				match(NUMBER);
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

	public static class FollowTermContext extends ParserRuleContext {
		public SimpleOpsContext simpleOps() {
			return getRuleContext(SimpleOpsContext.class,0);
		}
		public MathContext math() {
			return getRuleContext(MathContext.class,0);
		}
		public FollowTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_followTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).enterFollowTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).exitFollowTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuffVisitor ) return ((BuffVisitor<? extends T>)visitor).visitFollowTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FollowTermContext followTerm() throws RecognitionException {
		FollowTermContext _localctx = new FollowTermContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_followTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			simpleOps();
			setState(89);
			math();
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
		public FuncCallContext funcCall() {
			return getRuleContext(FuncCallContext.class,0);
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
			setState(93);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				funcCall();
				}
				break;
			case NUMBER:
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
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

	public static class SimpleOpsContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(BuffParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(BuffParser.MINUS, 0); }
		public SimpleOpsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleOps; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).enterSimpleOps(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).exitSimpleOps(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuffVisitor ) return ((BuffVisitor<? extends T>)visitor).visitSimpleOps(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleOpsContext simpleOps() throws RecognitionException {
		SimpleOpsContext _localctx = new SimpleOpsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_simpleOps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
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
		public TerminalNode LPAREN() { return getToken(BuffParser.LPAREN, 0); }
		public MathContext math() {
			return getRuleContext(MathContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BuffParser.RPAREN, 0); }
		public TerminalNode NUMBER() { return getToken(BuffParser.NUMBER, 0); }
		public ValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_val; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).enterVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).exitVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuffVisitor ) return ((BuffVisitor<? extends T>)visitor).visitVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValContext val() throws RecognitionException {
		ValContext _localctx = new ValContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_val);
		try {
			setState(102);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				match(LPAREN);
				setState(98);
				math();
				setState(99);
				match(RPAREN);
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				match(NUMBER);
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

	public static class FuncCallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(BuffParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(BuffParser.LPAREN, 0); }
		public StmtParamsContext stmtParams() {
			return getRuleContext(StmtParamsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BuffParser.RPAREN, 0); }
		public FuncCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).enterFuncCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).exitFuncCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuffVisitor ) return ((BuffVisitor<? extends T>)visitor).visitFuncCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncCallContext funcCall() throws RecognitionException {
		FuncCallContext _localctx = new FuncCallContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_funcCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(ID);
			setState(105);
			match(LPAREN);
			setState(106);
			stmtParams();
			setState(107);
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
			if ( listener instanceof BuffListener ) ((BuffListener)listener).enterStmtParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).exitStmtParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuffVisitor ) return ((BuffVisitor<? extends T>)visitor).visitStmtParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtParamsContext stmtParams() throws RecognitionException {
		StmtParamsContext _localctx = new StmtParamsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_stmtParams);
		try {
			setState(113);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
			case LPAREN:
			case TEXTVAL:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				stmt();
				setState(110);
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
		public TerminalNode COMMA() { return getToken(BuffParser.COMMA, 0); }
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
			if ( listener instanceof BuffListener ) ((BuffListener)listener).enterStmtMoreParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuffListener ) ((BuffListener)listener).exitStmtMoreParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuffVisitor ) return ((BuffVisitor<? extends T>)visitor).visitStmtMoreParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtMoreParamsContext stmtMoreParams() throws RecognitionException {
		StmtMoreParamsContext _localctx = new StmtMoreParamsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_stmtMoreParams);
		try {
			setState(120);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMA:
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				match(COMMA);
				setState(116);
				stmt();
				setState(117);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\21}\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22\3\2\3"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3.\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\5\3\5\3\6\3\6\3\6\3\6\5\6>\n\6\3\7\3\7\3\7\3\7\3\7\5\7E\n\7\3\b\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\3\t\5\tO\n\t\3\n\3\n\5\nS\n\n\3\13\3\13\3\13\3"+
		"\13\5\13Y\n\13\3\f\3\f\3\f\3\r\3\r\5\r`\n\r\3\16\3\16\3\17\3\17\3\17\3"+
		"\17\3\17\5\17i\n\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\5\21"+
		"t\n\21\3\22\3\22\3\22\3\22\3\22\5\22{\n\22\3\22\2\2\23\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"\2\4\4\2\17\17\21\21\3\2\n\13\2u\2$\3\2\2\2"+
		"\4-\3\2\2\2\6/\3\2\2\2\b\67\3\2\2\2\n=\3\2\2\2\fD\3\2\2\2\16F\3\2\2\2"+
		"\20N\3\2\2\2\22R\3\2\2\2\24X\3\2\2\2\26Z\3\2\2\2\30_\3\2\2\2\32a\3\2\2"+
		"\2\34h\3\2\2\2\36j\3\2\2\2 s\3\2\2\2\"z\3\2\2\2$%\5\4\3\2%&\5\20\t\2&"+
		"\'\7\2\2\3\'\3\3\2\2\2()\5\6\4\2)*\7\r\2\2*+\5\4\3\2+.\3\2\2\2,.\3\2\2"+
		"\2-(\3\2\2\2-,\3\2\2\2.\5\3\2\2\2/\60\5\b\5\2\60\61\7\20\2\2\61\62\7\6"+
		"\2\2\62\63\5\n\6\2\63\64\7\7\2\2\64\65\7\b\2\2\65\66\5\22\n\2\66\7\3\2"+
		"\2\2\678\t\2\2\28\t\3\2\2\29:\5\16\b\2:;\5\f\7\2;>\3\2\2\2<>\3\2\2\2="+
		"9\3\2\2\2=<\3\2\2\2>\13\3\2\2\2?@\7\t\2\2@A\5\16\b\2AB\5\f\7\2BE\3\2\2"+
		"\2CE\3\2\2\2D?\3\2\2\2DC\3\2\2\2E\r\3\2\2\2FG\5\b\5\2GH\7\20\2\2H\17\3"+
		"\2\2\2IJ\5\22\n\2JK\7\r\2\2KL\5\20\t\2LO\3\2\2\2MO\3\2\2\2NI\3\2\2\2N"+
		"M\3\2\2\2O\21\3\2\2\2PS\5\24\13\2QS\7\f\2\2RP\3\2\2\2RQ\3\2\2\2S\23\3"+
		"\2\2\2TU\5\30\r\2UV\5\26\f\2VY\3\2\2\2WY\7\4\2\2XT\3\2\2\2XW\3\2\2\2Y"+
		"\25\3\2\2\2Z[\5\32\16\2[\\\5\24\13\2\\\27\3\2\2\2]`\5\36\20\2^`\5\34\17"+
		"\2_]\3\2\2\2_^\3\2\2\2`\31\3\2\2\2ab\t\3\2\2b\33\3\2\2\2cd\7\6\2\2de\5"+
		"\24\13\2ef\7\7\2\2fi\3\2\2\2gi\7\4\2\2hc\3\2\2\2hg\3\2\2\2i\35\3\2\2\2"+
		"jk\7\20\2\2kl\7\6\2\2lm\5 \21\2mn\7\7\2\2n\37\3\2\2\2op\5\22\n\2pq\5\""+
		"\22\2qt\3\2\2\2rt\3\2\2\2so\3\2\2\2sr\3\2\2\2t!\3\2\2\2uv\7\t\2\2vw\5"+
		"\22\n\2wx\5\"\22\2x{\3\2\2\2y{\3\2\2\2zu\3\2\2\2zy\3\2\2\2{#\3\2\2\2\f"+
		"-=DNRX_hsz";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}