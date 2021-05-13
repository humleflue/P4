// Generated from c:\GitRepos\P4\ANTLR\src\Compiler\Lang.g4 by ANTLR 4.8

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LangLexer extends Lexer {
    public static final int
            NUMBERTYPE = 1, BOOLTYPE = 2, BOOLLITERAL = 3, NUMLITERAL = 4, ENDF = 5, RETURN = 6,
            IF = 7, PRINTCHAR = 8, LPAREN = 9, RPAREN = 10, LCURLY = 11, RCURLY = 12, LOGOR = 13,
            LOGAND = 14, LOGEQ = 15, LOGNOTEQ = 16, LOGLESS = 17, LOGGREATER = 18, LOGLESSOREQ = 19,
            LOGGREATEROREQ = 20, NEGATE = 21, POW = 22, COMMA = 23, ASSIGN = 24, PLUS = 25, MINUS = 26,
            MULTIPLY = 27, DIVIDE = 28, SEMICOLON = 29, WS = 30, NEWLINE = 31, ID = 32;
    public static final String[] ruleNames = makeRuleNames();
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\"\u00c6\b\1\4\2\t" +
                    "\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13" +
                    "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" +
                    "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31" +
                    "\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!" +
                    "\t!\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3" +
                    "\4\3\4\3\4\3\4\3\4\5\4Y\n\4\3\5\5\5\\\n\5\3\5\6\5_\n\5\r\5\16\5`\3\5\5" +
                    "\5d\n\5\3\5\6\5g\n\5\r\5\16\5h\3\5\3\5\6\5m\n\5\r\5\16\5n\5\5q\n\5\3\6" +
                    "\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3" +
                    "\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20" +
                    "\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26" +
                    "\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35" +
                    "\3\35\3\36\3\36\3\37\3\37\6\37\u00b5\n\37\r\37\16\37\u00b6\3\37\3\37\3" +
                    " \3 \3 \5 \u00be\n \3!\3!\7!\u00c2\n!\f!\16!\u00c5\13!\2\2\"\3\3\5\4\7" +
                    "\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22" +
                    "#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"\3" +
                    "\2\6\4\2\13\13\"\"\4\2\f\f\17\17\5\2))C\\c|\7\2))\62;C\\aac|\2\u00d0\2" +
                    "\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2" +
                    "\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2" +
                    "\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2" +
                    "\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2" +
                    "\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2" +
                    "\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\3C\3\2\2\2\5J\3\2\2\2\7X\3\2\2\2" +
                    "\tp\3\2\2\2\13r\3\2\2\2\rv\3\2\2\2\17}\3\2\2\2\21\u0080\3\2\2\2\23\u0082" +
                    "\3\2\2\2\25\u0084\3\2\2\2\27\u0086\3\2\2\2\31\u0088\3\2\2\2\33\u008a\3" +
                    "\2\2\2\35\u008d\3\2\2\2\37\u0090\3\2\2\2!\u0093\3\2\2\2#\u0096\3\2\2\2" +
                    "%\u0098\3\2\2\2\'\u009a\3\2\2\2)\u009d\3\2\2\2+\u00a0\3\2\2\2-\u00a2\3" +
                    "\2\2\2/\u00a4\3\2\2\2\61\u00a6\3\2\2\2\63\u00a8\3\2\2\2\65\u00aa\3\2\2" +
                    "\2\67\u00ac\3\2\2\29\u00ae\3\2\2\2;\u00b0\3\2\2\2=\u00b4\3\2\2\2?\u00bd" +
                    "\3\2\2\2A\u00bf\3\2\2\2CD\7p\2\2DE\7w\2\2EF\7o\2\2FG\7d\2\2GH\7g\2\2H" +
                    "I\7t\2\2I\4\3\2\2\2JK\7d\2\2KL\7q\2\2LM\7q\2\2MN\7n\2\2N\6\3\2\2\2OP\7" +
                    "v\2\2PQ\7t\2\2QR\7w\2\2RY\7g\2\2ST\7h\2\2TU\7c\2\2UV\7n\2\2VW\7u\2\2W" +
                    "Y\7g\2\2XO\3\2\2\2XS\3\2\2\2Y\b\3\2\2\2Z\\\7/\2\2[Z\3\2\2\2[\\\3\2\2\2" +
                    "\\^\3\2\2\2]_\4\62;\2^]\3\2\2\2_`\3\2\2\2`^\3\2\2\2`a\3\2\2\2aq\3\2\2" +
                    "\2bd\7/\2\2cb\3\2\2\2cd\3\2\2\2df\3\2\2\2eg\4\62;\2fe\3\2\2\2gh\3\2\2" +
                    "\2hf\3\2\2\2hi\3\2\2\2ij\3\2\2\2jl\7\60\2\2km\4\62;\2lk\3\2\2\2mn\3\2" +
                    "\2\2nl\3\2\2\2no\3\2\2\2oq\3\2\2\2p[\3\2\2\2pc\3\2\2\2q\n\3\2\2\2rs\7" +
                    "g\2\2st\7p\2\2tu\7f\2\2u\f\3\2\2\2vw\7t\2\2wx\7g\2\2xy\7v\2\2yz\7w\2\2" +
                    "z{\7t\2\2{|\7p\2\2|\16\3\2\2\2}~\7k\2\2~\177\7h\2\2\177\20\3\2\2\2\u0080" +
                    "\u0081\7A\2\2\u0081\22\3\2\2\2\u0082\u0083\7*\2\2\u0083\24\3\2\2\2\u0084" +
                    "\u0085\7+\2\2\u0085\26\3\2\2\2\u0086\u0087\7}\2\2\u0087\30\3\2\2\2\u0088" +
                    "\u0089\7\177\2\2\u0089\32\3\2\2\2\u008a\u008b\7~\2\2\u008b\u008c\7~\2" +
                    "\2\u008c\34\3\2\2\2\u008d\u008e\7(\2\2\u008e\u008f\7(\2\2\u008f\36\3\2" +
                    "\2\2\u0090\u0091\7?\2\2\u0091\u0092\7?\2\2\u0092 \3\2\2\2\u0093\u0094" +
                    "\7#\2\2\u0094\u0095\7?\2\2\u0095\"\3\2\2\2\u0096\u0097\7>\2\2\u0097$\3" +
                    "\2\2\2\u0098\u0099\7@\2\2\u0099&\3\2\2\2\u009a\u009b\7>\2\2\u009b\u009c" +
                    "\7?\2\2\u009c(\3\2\2\2\u009d\u009e\7@\2\2\u009e\u009f\7?\2\2\u009f*\3" +
                    "\2\2\2\u00a0\u00a1\7#\2\2\u00a1,\3\2\2\2\u00a2\u00a3\7`\2\2\u00a3.\3\2" +
                    "\2\2\u00a4\u00a5\7.\2\2\u00a5\60\3\2\2\2\u00a6\u00a7\7?\2\2\u00a7\62\3" +
                    "\2\2\2\u00a8\u00a9\7-\2\2\u00a9\64\3\2\2\2\u00aa\u00ab\7/\2\2\u00ab\66" +
                    "\3\2\2\2\u00ac\u00ad\7,\2\2\u00ad8\3\2\2\2\u00ae\u00af\7\61\2\2\u00af" +
                    ":\3\2\2\2\u00b0\u00b1\7=\2\2\u00b1<\3\2\2\2\u00b2\u00b5\t\2\2\2\u00b3" +
                    "\u00b5\5? \2\u00b4\u00b2\3\2\2\2\u00b4\u00b3\3\2\2\2\u00b5\u00b6\3\2\2" +
                    "\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9" +
                    "\b\37\2\2\u00b9>\3\2\2\2\u00ba\u00bb\7\17\2\2\u00bb\u00be\7\f\2\2\u00bc" +
                    "\u00be\t\3\2\2\u00bd\u00ba\3\2\2\2\u00bd\u00bc\3\2\2\2\u00be@\3\2\2\2" +
                    "\u00bf\u00c3\t\4\2\2\u00c0\u00c2\t\5\2\2\u00c1\u00c0\3\2\2\2\u00c2\u00c5" +
                    "\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4B\3\2\2\2\u00c5" +
                    "\u00c3\3\2\2\2\16\2X[`chnp\u00b4\u00b6\u00bd\u00c3\3\b\2\2";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = makeLiteralNames();
    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);
    public static String[] channelNames = {
            "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
    };
    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

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

    public LangLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    private static String[] makeRuleNames() {
        return new String[]{
                "NUMBERTYPE", "BOOLTYPE", "BOOLLITERAL", "NUMLITERAL", "ENDF", "RETURN",
                "IF", "PRINTCHAR", "LPAREN", "RPAREN", "LCURLY", "RCURLY", "LOGOR", "LOGAND",
                "LOGEQ", "LOGNOTEQ", "LOGLESS", "LOGGREATER", "LOGLESSOREQ", "LOGGREATEROREQ",
                "NEGATE", "POW", "COMMA", "ASSIGN", "PLUS", "MINUS", "MULTIPLY", "DIVIDE",
                "SEMICOLON", "WS", "NEWLINE", "ID"
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
    public String[] getChannelNames() {
        return channelNames;
    }

    @Override
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }
}