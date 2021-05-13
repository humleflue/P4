// Generated from c:\GitRepos\P4\ANTLR\src\Compiler\Lang.g4 by ANTLR 4.8

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LangParser extends Parser {
    public static final int
            NUMBERTYPE = 1, BOOLTYPE = 2, BOOLLITERAL = 3, NUMLITERAL = 4, ENDF = 5, RETURN = 6,
            IF = 7, PRINTCHAR = 8, LPAREN = 9, RPAREN = 10, LCURLY = 11, RCURLY = 12, LOGOR = 13,
            LOGAND = 14, LOGEQ = 15, LOGNOTEQ = 16, LOGLESS = 17, LOGGREATER = 18, LOGLESSOREQ = 19,
            LOGGREATEROREQ = 20, NEGATE = 21, POW = 22, COMMA = 23, ASSIGN = 24, PLUS = 25, MINUS = 26,
            MULTIPLY = 27, DIVIDE = 28, SEMICOLON = 29, WS = 30, NEWLINE = 31, ID = 32;
    public static final int
            RULE_prog = 0, RULE_code = 1, RULE_funcdef = 2, RULE_returnstmt = 3, RULE_type = 4,
            RULE_funcdefparams = 5, RULE_funcdefparam = 6, RULE_stmts = 7, RULE_stmt = 8,
            RULE_expr = 9, RULE_funccall = 10, RULE_exprparams = 11;
    public static final String[] ruleNames = makeRuleNames();
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\"\u008b\4\2\t\2\4" +
                    "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t" +
                    "\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3%\n\3\3" +
                    "\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7" +
                    "\7\79\n\7\f\7\16\7<\13\7\3\7\5\7?\n\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t" +
                    "\3\t\3\t\3\t\5\tL\n\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3" +
                    "\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13_\n\13\3\13\3\13\3\13\3\13\3\13" +
                    "\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13" +
                    "\3\13\3\13\7\13v\n\13\f\13\16\13y\13\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3" +
                    "\r\7\r\u0083\n\r\f\r\16\r\u0086\13\r\3\r\5\r\u0089\n\r\3\r\2\3\24\16\2" +
                    "\4\6\b\n\f\16\20\22\24\26\30\2\7\3\2\3\4\3\2\35\36\3\2\33\34\3\2\23\26" +
                    "\3\2\21\22\2\u0092\2\32\3\2\2\2\4$\3\2\2\2\6&\3\2\2\2\b\60\3\2\2\2\n\63" +
                    "\3\2\2\2\f>\3\2\2\2\16@\3\2\2\2\20K\3\2\2\2\22M\3\2\2\2\24^\3\2\2\2\26" +
                    "z\3\2\2\2\30\u0088\3\2\2\2\32\33\5\4\3\2\33\34\7\2\2\3\34\3\3\2\2\2\35" +
                    "\36\5\6\4\2\36\37\5\4\3\2\37%\3\2\2\2 !\5\22\n\2!\"\5\4\3\2\"%\3\2\2\2" +
                    "#%\3\2\2\2$\35\3\2\2\2$ \3\2\2\2$#\3\2\2\2%\5\3\2\2\2&\'\5\n\6\2\'(\7" +
                    "\"\2\2()\7\13\2\2)*\5\f\7\2*+\7\f\2\2+,\7\32\2\2,-\5\20\t\2-.\5\b\5\2" +
                    "./\7\7\2\2/\7\3\2\2\2\60\61\7\b\2\2\61\62\5\22\n\2\62\t\3\2\2\2\63\64" +
                    "\t\2\2\2\64\13\3\2\2\2\65:\5\16\b\2\66\67\7\31\2\2\679\5\16\b\28\66\3" +
                    "\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;?\3\2\2\2<:\3\2\2\2=?\3\2\2\2>\65" +
                    "\3\2\2\2>=\3\2\2\2?\r\3\2\2\2@A\5\n\6\2AB\7\"\2\2B\17\3\2\2\2CD\7\t\2" +
                    "\2DE\7\13\2\2EF\5\24\13\2FG\7\f\2\2GH\5\b\5\2HI\5\20\t\2IL\3\2\2\2JL\3" +
                    "\2\2\2KC\3\2\2\2KJ\3\2\2\2L\21\3\2\2\2MN\5\24\13\2NO\7\37\2\2O\23\3\2" +
                    "\2\2PQ\b\13\1\2QR\7\13\2\2RS\5\24\13\2ST\7\f\2\2T_\3\2\2\2U_\5\26\f\2" +
                    "VW\5\26\f\2WX\7\n\2\2X_\3\2\2\2Y_\7\6\2\2Z_\7\5\2\2[_\7\"\2\2\\]\7\27" +
                    "\2\2]_\5\24\13\n^P\3\2\2\2^U\3\2\2\2^V\3\2\2\2^Y\3\2\2\2^Z\3\2\2\2^[\3" +
                    "\2\2\2^\\\3\2\2\2_w\3\2\2\2`a\f\t\2\2ab\7\30\2\2bv\5\24\13\ncd\f\b\2\2" +
                    "de\t\3\2\2ev\5\24\13\tfg\f\7\2\2gh\t\4\2\2hv\5\24\13\bij\f\6\2\2jk\t\5" +
                    "\2\2kv\5\24\13\7lm\f\5\2\2mn\t\6\2\2nv\5\24\13\6op\f\4\2\2pq\7\20\2\2" +
                    "qv\5\24\13\5rs\f\3\2\2st\7\17\2\2tv\5\24\13\4u`\3\2\2\2uc\3\2\2\2uf\3" +
                    "\2\2\2ui\3\2\2\2ul\3\2\2\2uo\3\2\2\2ur\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3" +
                    "\2\2\2x\25\3\2\2\2yw\3\2\2\2z{\7\"\2\2{|\7\13\2\2|}\5\30\r\2}~\7\f\2\2" +
                    "~\27\3\2\2\2\177\u0084\5\24\13\2\u0080\u0081\7\31\2\2\u0081\u0083\5\24" +
                    "\13\2\u0082\u0080\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0084" +
                    "\u0085\3\2\2\2\u0085\u0089\3\2\2\2\u0086\u0084\3\2\2\2\u0087\u0089\3\2" +
                    "\2\2\u0088\177\3\2\2\2\u0088\u0087\3\2\2\2\u0089\31\3\2\2\2\13$:>K^uw" +
                    "\u0084\u0088";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = makeLiteralNames();
    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    static {
        RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION);
    }

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

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }

    public LangParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    private static String[] makeRuleNames() {
        return new String[]{
                "prog", "code", "funcdef", "returnstmt", "type", "funcdefparams", "funcdefparam",
                "stmts", "stmt", "expr", "funccall", "exprparams"
        };
    }

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "'number'", "'bool'", null, null, "'end'", "'return'", "'if'",
                "'?'", "'('", "')'", "'{'", "'}'", "'||'", "'&&'", "'=='", "'!='", "'<'",
                "'>'", "'<='", "'>='", "'!'", "'^'", "','", "'='", "'+'", "'-'", "'*'",
                "'/'", "';'"
        };
    }

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, "NUMBERTYPE", "BOOLTYPE", "BOOLLITERAL", "NUMLITERAL", "ENDF",
                "RETURN", "IF", "PRINTCHAR", "LPAREN", "RPAREN", "LCURLY", "RCURLY",
                "LOGOR", "LOGAND", "LOGEQ", "LOGNOTEQ", "LOGLESS", "LOGGREATER", "LOGLESSOREQ",
                "LOGGREATEROREQ", "NEGATE", "POW", "COMMA", "ASSIGN", "PLUS", "MINUS",
                "MULTIPLY", "DIVIDE", "SEMICOLON", "WS", "NEWLINE", "ID"
        };
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
    public String getGrammarFileName() {
        return "Lang.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
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
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
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
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
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
                returnstmt();
                setState(44);
                match(ENDF);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ReturnstmtContext returnstmt() throws RecognitionException {
        ReturnstmtContext _localctx = new ReturnstmtContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_returnstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(46);
                match(RETURN);
                setState(47);
                stmt();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final TypeContext type() throws RecognitionException {
        TypeContext _localctx = new TypeContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_type);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(49);
                _la = _input.LA(1);
                if (!(_la == NUMBERTYPE || _la == BOOLTYPE)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final FuncdefparamsContext funcdefparams() throws RecognitionException {
        FuncdefparamsContext _localctx = new FuncdefparamsContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_funcdefparams);
        int _la;
        try {
            setState(60);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case NUMBERTYPE:
                case BOOLTYPE:
                    _localctx = new FuncdefparamsNotEmptyContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(51);
                    funcdefparam();
                    setState(56);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == COMMA) {
                        {
                            {
                                setState(52);
                                match(COMMA);
                                setState(53);
                                funcdefparam();
                            }
                        }
                        setState(58);
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
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final FuncdefparamContext funcdefparam() throws RecognitionException {
        FuncdefparamContext _localctx = new FuncdefparamContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_funcdefparam);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(62);
                type();
                setState(63);
                match(ID);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final StmtsContext stmts() throws RecognitionException {
        StmtsContext _localctx = new StmtsContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_stmts);
        try {
            setState(73);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case IF:
                    _localctx = new StmtsNotEmptyContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(65);
                    match(IF);
                    setState(66);
                    match(LPAREN);
                    setState(67);
                    expr(0);
                    setState(68);
                    match(RPAREN);
                    setState(69);
                    returnstmt();
                    setState(70);
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
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final StmtContext stmt() throws RecognitionException {
        StmtContext _localctx = new StmtContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_stmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(75);
                expr(0);
                setState(76);
                match(SEMICOLON);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ExprContext expr() throws RecognitionException {
        return expr(0);
    }

    private ExprContext expr(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        ExprContext _localctx = new ExprContext(_ctx, _parentState);
        ExprContext _prevctx = _localctx;
        int _startState = 18;
        enterRecursionRule(_localctx, 18, RULE_expr, _p);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(92);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 4, _ctx)) {
                    case 1: {
                        _localctx = new ExprParenthesisedContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;

                        setState(79);
                        match(LPAREN);
                        setState(80);
                        expr(0);
                        setState(81);
                        match(RPAREN);
                    }
                    break;
                    case 2: {
                        _localctx = new ExprFunccallContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(83);
                        funccall();
                    }
                    break;
                    case 3: {
                        _localctx = new ExprFunccallPrintContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(84);
                        funccall();
                        setState(85);
                        match(PRINTCHAR);
                    }
                    break;
                    case 4: {
                        _localctx = new ExprNumberContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(87);
                        match(NUMLITERAL);
                    }
                    break;
                    case 5: {
                        _localctx = new ExprBooleanContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(88);
                        match(BOOLLITERAL);
                    }
                    break;
                    case 6: {
                        _localctx = new ExprIdContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(89);
                        match(ID);
                    }
                    break;
                    case 7: {
                        _localctx = new UnaryOpContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(90);
                        ((UnaryOpContext) _localctx).op = match(NEGATE);
                        setState(91);
                        expr(8);
                    }
                    break;
                }
                _ctx.stop = _input.LT(-1);
                setState(117);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 6, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            setState(115);
                            _errHandler.sync(this);
                            switch (getInterpreter().adaptivePredict(_input, 5, _ctx)) {
                                case 1: {
                                    _localctx = new BinaryOpContext(new ExprContext(_parentctx, _parentState));
                                    ((BinaryOpContext) _localctx).left = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(94);
                                    if (!(precpred(_ctx, 7)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 7)");
                                    setState(95);
                                    ((BinaryOpContext) _localctx).op = match(POW);
                                    setState(96);
                                    ((BinaryOpContext) _localctx).right = expr(8);
                                }
                                break;
                                case 2: {
                                    _localctx = new BinaryOpContext(new ExprContext(_parentctx, _parentState));
                                    ((BinaryOpContext) _localctx).left = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(97);
                                    if (!(precpred(_ctx, 6)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 6)");
                                    setState(98);
                                    ((BinaryOpContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!(_la == MULTIPLY || _la == DIVIDE)) {
                                        ((BinaryOpContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(99);
                                    ((BinaryOpContext) _localctx).right = expr(7);
                                }
                                break;
                                case 3: {
                                    _localctx = new BinaryOpContext(new ExprContext(_parentctx, _parentState));
                                    ((BinaryOpContext) _localctx).left = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(100);
                                    if (!(precpred(_ctx, 5)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 5)");
                                    setState(101);
                                    ((BinaryOpContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!(_la == PLUS || _la == MINUS)) {
                                        ((BinaryOpContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(102);
                                    ((BinaryOpContext) _localctx).right = expr(6);
                                }
                                break;
                                case 4: {
                                    _localctx = new BinaryOpContext(new ExprContext(_parentctx, _parentState));
                                    ((BinaryOpContext) _localctx).left = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(103);
                                    if (!(precpred(_ctx, 4)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 4)");
                                    setState(104);
                                    ((BinaryOpContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LOGLESS) | (1L << LOGGREATER) | (1L << LOGLESSOREQ) | (1L << LOGGREATEROREQ))) != 0))) {
                                        ((BinaryOpContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(105);
                                    ((BinaryOpContext) _localctx).right = expr(5);
                                }
                                break;
                                case 5: {
                                    _localctx = new BinaryOpContext(new ExprContext(_parentctx, _parentState));
                                    ((BinaryOpContext) _localctx).left = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(106);
                                    if (!(precpred(_ctx, 3)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 3)");
                                    setState(107);
                                    ((BinaryOpContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!(_la == LOGEQ || _la == LOGNOTEQ)) {
                                        ((BinaryOpContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(108);
                                    ((BinaryOpContext) _localctx).right = expr(4);
                                }
                                break;
                                case 6: {
                                    _localctx = new BinaryOpContext(new ExprContext(_parentctx, _parentState));
                                    ((BinaryOpContext) _localctx).left = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(109);
                                    if (!(precpred(_ctx, 2)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 2)");
                                    setState(110);
                                    ((BinaryOpContext) _localctx).op = match(LOGAND);
                                    setState(111);
                                    ((BinaryOpContext) _localctx).right = expr(3);
                                }
                                break;
                                case 7: {
                                    _localctx = new BinaryOpContext(new ExprContext(_parentctx, _parentState));
                                    ((BinaryOpContext) _localctx).left = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(112);
                                    if (!(precpred(_ctx, 1)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 1)");
                                    setState(113);
                                    ((BinaryOpContext) _localctx).op = match(LOGOR);
                                    setState(114);
                                    ((BinaryOpContext) _localctx).right = expr(2);
                                }
                                break;
                            }
                        }
                    }
                    setState(119);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 6, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public final FunccallContext funccall() throws RecognitionException {
        FunccallContext _localctx = new FunccallContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_funccall);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(120);
                match(ID);
                setState(121);
                match(LPAREN);
                setState(122);
                exprparams();
                setState(123);
                match(RPAREN);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ExprparamsContext exprparams() throws RecognitionException {
        ExprparamsContext _localctx = new ExprparamsContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_exprparams);
        int _la;
        try {
            setState(134);
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
                    setState(125);
                    expr(0);
                    setState(130);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == COMMA) {
                        {
                            {
                                setState(126);
                                match(COMMA);
                                setState(127);
                                expr(0);
                            }
                        }
                        setState(132);
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
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
        switch (ruleIndex) {
            case 9:
                return expr_sempred((ExprContext) _localctx, predIndex);
        }
        return true;
    }

    private boolean expr_sempred(ExprContext _localctx, int predIndex) {
        switch (predIndex) {
            case 0:
                return precpred(_ctx, 7);
            case 1:
                return precpred(_ctx, 6);
            case 2:
                return precpred(_ctx, 5);
            case 3:
                return precpred(_ctx, 4);
            case 4:
                return precpred(_ctx, 3);
            case 5:
                return precpred(_ctx, 2);
            case 6:
                return precpred(_ctx, 1);
        }
        return true;
    }

    public static class ProgContext extends ParserRuleContext {
        public ProgContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public CodeContext code() {
            return getRuleContext(CodeContext.class, 0);
        }

        public TerminalNode EOF() {
            return getToken(LangParser.EOF, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_prog;
        }
    }

    public static class CodeContext extends ParserRuleContext {
        public CodeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public CodeContext() {
        }

        @Override
        public int getRuleIndex() {
            return RULE_code;
        }

        public void copyFrom(CodeContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class CodeEmptyContext extends CodeContext {
        public CodeEmptyContext(CodeContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class CodeStmtContext extends CodeContext {
        public CodeStmtContext(CodeContext ctx) {
            copyFrom(ctx);
        }

        public StmtContext stmt() {
            return getRuleContext(StmtContext.class, 0);
        }

        public CodeContext code() {
            return getRuleContext(CodeContext.class, 0);
        }
    }

    public static class CodeFuncdefContext extends CodeContext {
        public CodeFuncdefContext(CodeContext ctx) {
            copyFrom(ctx);
        }

        public FuncdefContext funcdef() {
            return getRuleContext(FuncdefContext.class, 0);
        }

        public CodeContext code() {
            return getRuleContext(CodeContext.class, 0);
        }
    }

    public static class FuncdefContext extends ParserRuleContext {
        public FuncdefContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public TerminalNode ID() {
            return getToken(LangParser.ID, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(LangParser.LPAREN, 0);
        }

        public FuncdefparamsContext funcdefparams() {
            return getRuleContext(FuncdefparamsContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(LangParser.RPAREN, 0);
        }

        public TerminalNode ASSIGN() {
            return getToken(LangParser.ASSIGN, 0);
        }

        public StmtsContext stmts() {
            return getRuleContext(StmtsContext.class, 0);
        }

        public ReturnstmtContext returnstmt() {
            return getRuleContext(ReturnstmtContext.class, 0);
        }

        public TerminalNode ENDF() {
            return getToken(LangParser.ENDF, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_funcdef;
        }
    }

    public static class ReturnstmtContext extends ParserRuleContext {
        public ReturnstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode RETURN() {
            return getToken(LangParser.RETURN, 0);
        }

        public StmtContext stmt() {
            return getRuleContext(StmtContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_returnstmt;
        }
    }

    public static class TypeContext extends ParserRuleContext {
        public TypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode NUMBERTYPE() {
            return getToken(LangParser.NUMBERTYPE, 0);
        }

        public TerminalNode BOOLTYPE() {
            return getToken(LangParser.BOOLTYPE, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_type;
        }
    }

    public static class FuncdefparamsContext extends ParserRuleContext {
        public FuncdefparamsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public FuncdefparamsContext() {
        }

        @Override
        public int getRuleIndex() {
            return RULE_funcdefparams;
        }

        public void copyFrom(FuncdefparamsContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class FuncdefparamsEmptyContext extends FuncdefparamsContext {
        public FuncdefparamsEmptyContext(FuncdefparamsContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class FuncdefparamsNotEmptyContext extends FuncdefparamsContext {
        public FuncdefparamsNotEmptyContext(FuncdefparamsContext ctx) {
            copyFrom(ctx);
        }

        public List<FuncdefparamContext> funcdefparam() {
            return getRuleContexts(FuncdefparamContext.class);
        }

        public FuncdefparamContext funcdefparam(int i) {
            return getRuleContext(FuncdefparamContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(LangParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(LangParser.COMMA, i);
        }
    }

    public static class FuncdefparamContext extends ParserRuleContext {
        public FuncdefparamContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public TerminalNode ID() {
            return getToken(LangParser.ID, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_funcdefparam;
        }
    }

    public static class StmtsContext extends ParserRuleContext {
        public StmtsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public StmtsContext() {
        }

        @Override
        public int getRuleIndex() {
            return RULE_stmts;
        }

        public void copyFrom(StmtsContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class StmtsNotEmptyContext extends StmtsContext {
        public StmtsNotEmptyContext(StmtsContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode IF() {
            return getToken(LangParser.IF, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(LangParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(LangParser.RPAREN, 0);
        }

        public ReturnstmtContext returnstmt() {
            return getRuleContext(ReturnstmtContext.class, 0);
        }

        public StmtsContext stmts() {
            return getRuleContext(StmtsContext.class, 0);
        }
    }

    public static class StmtsEmptyContext extends StmtsContext {
        public StmtsEmptyContext(StmtsContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class StmtContext extends ParserRuleContext {
        public StmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode SEMICOLON() {
            return getToken(LangParser.SEMICOLON, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_stmt;
        }
    }

    public static class ExprContext extends ParserRuleContext {
        public ExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ExprContext() {
        }

        @Override
        public int getRuleIndex() {
            return RULE_expr;
        }

        public void copyFrom(ExprContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class ExprParenthesisedContext extends ExprContext {
        public ExprParenthesisedContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode LPAREN() {
            return getToken(LangParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(LangParser.RPAREN, 0);
        }
    }

    public static class ExprFunccallContext extends ExprContext {
        public ExprFunccallContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        public FunccallContext funccall() {
            return getRuleContext(FunccallContext.class, 0);
        }
    }

    public static class ExprBooleanContext extends ExprContext {
        public ExprBooleanContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode BOOLLITERAL() {
            return getToken(LangParser.BOOLLITERAL, 0);
        }
    }

    public static class BinaryOpContext extends ExprContext {
        public ExprContext left;
        public Token op;
        public ExprContext right;

        public BinaryOpContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode POW() {
            return getToken(LangParser.POW, 0);
        }

        public TerminalNode DIVIDE() {
            return getToken(LangParser.DIVIDE, 0);
        }

        public TerminalNode MULTIPLY() {
            return getToken(LangParser.MULTIPLY, 0);
        }

        public TerminalNode PLUS() {
            return getToken(LangParser.PLUS, 0);
        }

        public TerminalNode MINUS() {
            return getToken(LangParser.MINUS, 0);
        }

        public TerminalNode LOGLESS() {
            return getToken(LangParser.LOGLESS, 0);
        }

        public TerminalNode LOGGREATER() {
            return getToken(LangParser.LOGGREATER, 0);
        }

        public TerminalNode LOGLESSOREQ() {
            return getToken(LangParser.LOGLESSOREQ, 0);
        }

        public TerminalNode LOGGREATEROREQ() {
            return getToken(LangParser.LOGGREATEROREQ, 0);
        }

        public TerminalNode LOGEQ() {
            return getToken(LangParser.LOGEQ, 0);
        }

        public TerminalNode LOGNOTEQ() {
            return getToken(LangParser.LOGNOTEQ, 0);
        }

        public TerminalNode LOGAND() {
            return getToken(LangParser.LOGAND, 0);
        }

        public TerminalNode LOGOR() {
            return getToken(LangParser.LOGOR, 0);
        }
    }

    public static class ExprIdContext extends ExprContext {
        public ExprIdContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode ID() {
            return getToken(LangParser.ID, 0);
        }
    }

    public static class UnaryOpContext extends ExprContext {
        public Token op;

        public UnaryOpContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode NEGATE() {
            return getToken(LangParser.NEGATE, 0);
        }
    }

    public static class ExprNumberContext extends ExprContext {
        public ExprNumberContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode NUMLITERAL() {
            return getToken(LangParser.NUMLITERAL, 0);
        }
    }

    public static class ExprFunccallPrintContext extends ExprContext {
        public ExprFunccallPrintContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        public FunccallContext funccall() {
            return getRuleContext(FunccallContext.class, 0);
        }

        public TerminalNode PRINTCHAR() {
            return getToken(LangParser.PRINTCHAR, 0);
        }
    }

    public static class FunccallContext extends ParserRuleContext {
        public FunccallContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode ID() {
            return getToken(LangParser.ID, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(LangParser.LPAREN, 0);
        }

        public ExprparamsContext exprparams() {
            return getRuleContext(ExprparamsContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(LangParser.RPAREN, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_funccall;
        }
    }

    public static class ExprparamsContext extends ParserRuleContext {
        public ExprparamsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ExprparamsContext() {
        }

        @Override
        public int getRuleIndex() {
            return RULE_exprparams;
        }

        public void copyFrom(ExprparamsContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class ExprparamsEmptyContext extends ExprparamsContext {
        public ExprparamsEmptyContext(ExprparamsContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class ExprparamsNotEmptyContext extends ExprparamsContext {
        public ExprparamsNotEmptyContext(ExprparamsContext ctx) {
            copyFrom(ctx);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(LangParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(LangParser.COMMA, i);
        }
    }
}