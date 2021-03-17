// Generated from C:/Users/chris/4-semester/Projekt/P4/ANTLR/src/main\Buff.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BuffLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NUMBERDCL=1, TEXTDCL=2, ID=3, TEXTVAL=4, NUMBERVAL=5, LPAREN=6, RPAREN=7, 
		ASSIGN=8, COMMA=9, PLUS=10, MINUS=11, SEMICOLON=12, NEWLINE=13, WS=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"NUMBERDCL", "TEXTDCL", "ID", "TEXTVAL", "NUMBERVAL", "LPAREN", "RPAREN", 
			"ASSIGN", "COMMA", "PLUS", "MINUS", "SEMICOLON", "NEWLINE", "WS"
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
			"RPAREN", "ASSIGN", "COMMA", "PLUS", "MINUS", "SEMICOLON", "NEWLINE", 
			"WS"
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


	public BuffLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Buff.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\20b\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\4\6\4-\n\4\r\4\16\4.\3\5\6\5\62\n\5\r\5\16\5\63\3"+
		"\6\6\6\67\n\6\r\6\16\68\3\6\6\6<\n\6\r\6\16\6=\3\6\3\6\6\6B\n\6\r\6\16"+
		"\6C\5\6F\n\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r"+
		"\3\16\3\16\3\16\5\16Y\n\16\3\17\3\17\6\17]\n\17\r\17\16\17^\3\17\3\17"+
		"\2\2\20\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\3\2\5\4\2C\\c|\4\2\f\f\17\17\4\2\13\13\"\"\2j\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\3\37\3\2\2\2\5&\3\2\2\2\7,\3\2\2\2\t\61\3\2\2\2\13"+
		"E\3\2\2\2\rG\3\2\2\2\17I\3\2\2\2\21K\3\2\2\2\23M\3\2\2\2\25O\3\2\2\2\27"+
		"Q\3\2\2\2\31S\3\2\2\2\33X\3\2\2\2\35\\\3\2\2\2\37 \7p\2\2 !\7w\2\2!\""+
		"\7o\2\2\"#\7d\2\2#$\7g\2\2$%\7t\2\2%\4\3\2\2\2&\'\7v\2\2\'(\7g\2\2()\7"+
		"z\2\2)*\7v\2\2*\6\3\2\2\2+-\4c|\2,+\3\2\2\2-.\3\2\2\2.,\3\2\2\2./\3\2"+
		"\2\2/\b\3\2\2\2\60\62\t\2\2\2\61\60\3\2\2\2\62\63\3\2\2\2\63\61\3\2\2"+
		"\2\63\64\3\2\2\2\64\n\3\2\2\2\65\67\4\62;\2\66\65\3\2\2\2\678\3\2\2\2"+
		"8\66\3\2\2\289\3\2\2\29F\3\2\2\2:<\4\62;\2;:\3\2\2\2<=\3\2\2\2=;\3\2\2"+
		"\2=>\3\2\2\2>?\3\2\2\2?A\7\60\2\2@B\4\62;\2A@\3\2\2\2BC\3\2\2\2CA\3\2"+
		"\2\2CD\3\2\2\2DF\3\2\2\2E\66\3\2\2\2E;\3\2\2\2F\f\3\2\2\2GH\7*\2\2H\16"+
		"\3\2\2\2IJ\7+\2\2J\20\3\2\2\2KL\7?\2\2L\22\3\2\2\2MN\7.\2\2N\24\3\2\2"+
		"\2OP\7-\2\2P\26\3\2\2\2QR\7/\2\2R\30\3\2\2\2ST\7=\2\2T\32\3\2\2\2UV\7"+
		"\17\2\2VY\7\f\2\2WY\t\3\2\2XU\3\2\2\2XW\3\2\2\2Y\34\3\2\2\2Z]\t\4\2\2"+
		"[]\5\33\16\2\\Z\3\2\2\2\\[\3\2\2\2]^\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_`\3"+
		"\2\2\2`a\b\17\2\2a\36\3\2\2\2\f\2.\638=CEX\\^\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}