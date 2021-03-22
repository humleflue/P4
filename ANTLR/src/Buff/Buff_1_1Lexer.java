// Generated from Buff_1_1.g4 by ANTLR 4.9
package Buff;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Buff_1_1Lexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"NUMBERDCL", "TEXTDCL", "BOOLEAN", "ID", "TEXTVAL", "NUMBERVAL", "BOOLVAL", 
			"LPAREN", "RPAREN", "LCURLY", "RCURLY", "RETURN", "LOGAND", "LOGOR", 
			"IF", "LOGEQUALS", "LOGNEQUALS", "LOGLESS", "LOGGREATER", "LOGLESSOREQUAL", 
			"LOGGREATEROREQUAL", "NEGATE", "POWER", "COMMA", "ASSIGN", "PLUS", "MINUS", 
			"MULTIPLY", "DIVIDE", "SEMICOLON", "WS", "NEWLINE"
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


	public Buff_1_1Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Buff_1_1.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\"\u00c1\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\5\3\5\3\6\3\6\7\6Y\n\6\f\6\16\6\\\13\6\3\7\6\7_\n\7\r\7\16\7`\3\7"+
		"\6\7d\n\7\r\7\16\7e\3\7\3\7\6\7j\n\7\r\7\16\7k\5\7n\n\7\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\5\by\n\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\26"+
		"\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34"+
		"\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \6 \u00b7\n \r \16 \u00b8\3 \3 \3"+
		"!\3!\3!\5!\u00c0\n!\2\2\"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\63\33\65\34\67\359\36;\37= ?!A\"\3\2\6\5\2))C\\c|\7\2))\62;C\\aac|\4"+
		"\2\13\13\"\"\4\2\f\f\17\17\2\u00c9\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2"+
		"\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2"+
		"\2\3C\3\2\2\2\5J\3\2\2\2\7O\3\2\2\2\tT\3\2\2\2\13V\3\2\2\2\rm\3\2\2\2"+
		"\17x\3\2\2\2\21z\3\2\2\2\23|\3\2\2\2\25~\3\2\2\2\27\u0080\3\2\2\2\31\u0082"+
		"\3\2\2\2\33\u0089\3\2\2\2\35\u008c\3\2\2\2\37\u008f\3\2\2\2!\u0092\3\2"+
		"\2\2#\u0095\3\2\2\2%\u0098\3\2\2\2\'\u009a\3\2\2\2)\u009c\3\2\2\2+\u009f"+
		"\3\2\2\2-\u00a2\3\2\2\2/\u00a4\3\2\2\2\61\u00a6\3\2\2\2\63\u00a8\3\2\2"+
		"\2\65\u00aa\3\2\2\2\67\u00ac\3\2\2\29\u00ae\3\2\2\2;\u00b0\3\2\2\2=\u00b2"+
		"\3\2\2\2?\u00b6\3\2\2\2A\u00bf\3\2\2\2CD\7p\2\2DE\7w\2\2EF\7o\2\2FG\7"+
		"d\2\2GH\7g\2\2HI\7t\2\2I\4\3\2\2\2JK\7v\2\2KL\7g\2\2LM\7z\2\2MN\7v\2\2"+
		"N\6\3\2\2\2OP\7d\2\2PQ\7q\2\2QR\7q\2\2RS\7n\2\2S\b\3\2\2\2TU\5\13\6\2"+
		"U\n\3\2\2\2VZ\t\2\2\2WY\t\3\2\2XW\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2"+
		"\2[\f\3\2\2\2\\Z\3\2\2\2]_\4\62;\2^]\3\2\2\2_`\3\2\2\2`^\3\2\2\2`a\3\2"+
		"\2\2an\3\2\2\2bd\4\62;\2cb\3\2\2\2de\3\2\2\2ec\3\2\2\2ef\3\2\2\2fg\3\2"+
		"\2\2gi\7\60\2\2hj\4\62;\2ih\3\2\2\2jk\3\2\2\2ki\3\2\2\2kl\3\2\2\2ln\3"+
		"\2\2\2m^\3\2\2\2mc\3\2\2\2n\16\3\2\2\2op\7v\2\2pq\7t\2\2qr\7w\2\2ry\7"+
		"g\2\2st\7h\2\2tu\7c\2\2uv\7n\2\2vw\7u\2\2wy\7g\2\2xo\3\2\2\2xs\3\2\2\2"+
		"y\20\3\2\2\2z{\7*\2\2{\22\3\2\2\2|}\7+\2\2}\24\3\2\2\2~\177\7}\2\2\177"+
		"\26\3\2\2\2\u0080\u0081\7\177\2\2\u0081\30\3\2\2\2\u0082\u0083\7t\2\2"+
		"\u0083\u0084\7g\2\2\u0084\u0085\7v\2\2\u0085\u0086\7w\2\2\u0086\u0087"+
		"\7t\2\2\u0087\u0088\7p\2\2\u0088\32\3\2\2\2\u0089\u008a\7(\2\2\u008a\u008b"+
		"\7(\2\2\u008b\34\3\2\2\2\u008c\u008d\7~\2\2\u008d\u008e\7~\2\2\u008e\36"+
		"\3\2\2\2\u008f\u0090\7k\2\2\u0090\u0091\7h\2\2\u0091 \3\2\2\2\u0092\u0093"+
		"\7?\2\2\u0093\u0094\7?\2\2\u0094\"\3\2\2\2\u0095\u0096\7#\2\2\u0096\u0097"+
		"\7?\2\2\u0097$\3\2\2\2\u0098\u0099\7>\2\2\u0099&\3\2\2\2\u009a\u009b\7"+
		"@\2\2\u009b(\3\2\2\2\u009c\u009d\7>\2\2\u009d\u009e\7?\2\2\u009e*\3\2"+
		"\2\2\u009f\u00a0\7@\2\2\u00a0\u00a1\7?\2\2\u00a1,\3\2\2\2\u00a2\u00a3"+
		"\7#\2\2\u00a3.\3\2\2\2\u00a4\u00a5\7`\2\2\u00a5\60\3\2\2\2\u00a6\u00a7"+
		"\7.\2\2\u00a7\62\3\2\2\2\u00a8\u00a9\7?\2\2\u00a9\64\3\2\2\2\u00aa\u00ab"+
		"\7-\2\2\u00ab\66\3\2\2\2\u00ac\u00ad\7/\2\2\u00ad8\3\2\2\2\u00ae\u00af"+
		"\7,\2\2\u00af:\3\2\2\2\u00b0\u00b1\7\61\2\2\u00b1<\3\2\2\2\u00b2\u00b3"+
		"\7=\2\2\u00b3>\3\2\2\2\u00b4\u00b7\t\4\2\2\u00b5\u00b7\5A!\2\u00b6\u00b4"+
		"\3\2\2\2\u00b6\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8"+
		"\u00b9\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\b \2\2\u00bb@\3\2\2\2\u00bc"+
		"\u00bd\7\17\2\2\u00bd\u00c0\7\f\2\2\u00be\u00c0\t\5\2\2\u00bf\u00bc\3"+
		"\2\2\2\u00bf\u00be\3\2\2\2\u00c0B\3\2\2\2\f\2Z`ekmx\u00b6\u00b8\u00bf"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}