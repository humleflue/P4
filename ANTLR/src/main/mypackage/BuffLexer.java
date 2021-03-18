// Generated from Buff.g4 by ANTLR 4.9.2
package mypackage;
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
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NUMBERDCL=1, TEXTDCL=2, ID=3, TEXTVAL=4, NUMBERVAL=5, LPAREN=6, RPAREN=7, 
		ASSIGN=8, COMMA=9, PLUS=10, MINUS=11, SEMICOLON=12, WS=13, NEWLINE=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"NUMBERDCL", "TEXTDCL", "ID", "TEXTVAL", "NUMBERVAL", "LPAREN", "RPAREN", 
			"ASSIGN", "COMMA", "PLUS", "MINUS", "SEMICOLON", "WS", "NEWLINE"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\20a\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\7\5\60\n\5\f\5\16\5\63\13\5\3\6\6\6"+
		"\66\n\6\r\6\16\6\67\3\6\6\6;\n\6\r\6\16\6<\3\6\3\6\6\6A\n\6\r\6\16\6B"+
		"\5\6E\n\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3"+
		"\16\3\16\6\16W\n\16\r\16\16\16X\3\16\3\16\3\17\3\17\3\17\5\17`\n\17\2"+
		"\2\20\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\3\2\6\5\2))C\\c|\7\2))\62;C\\aac|\4\2\13\13\"\"\4\2\f\f\17\17\2h\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\3\37\3\2\2\2\5&\3\2\2\2\7+\3\2\2"+
		"\2\t-\3\2\2\2\13D\3\2\2\2\rF\3\2\2\2\17H\3\2\2\2\21J\3\2\2\2\23L\3\2\2"+
		"\2\25N\3\2\2\2\27P\3\2\2\2\31R\3\2\2\2\33V\3\2\2\2\35_\3\2\2\2\37 \7p"+
		"\2\2 !\7w\2\2!\"\7o\2\2\"#\7d\2\2#$\7g\2\2$%\7t\2\2%\4\3\2\2\2&\'\7v\2"+
		"\2\'(\7g\2\2()\7z\2\2)*\7v\2\2*\6\3\2\2\2+,\5\t\5\2,\b\3\2\2\2-\61\t\2"+
		"\2\2.\60\t\3\2\2/.\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62"+
		"\n\3\2\2\2\63\61\3\2\2\2\64\66\4\62;\2\65\64\3\2\2\2\66\67\3\2\2\2\67"+
		"\65\3\2\2\2\678\3\2\2\28E\3\2\2\29;\4\62;\2:9\3\2\2\2;<\3\2\2\2<:\3\2"+
		"\2\2<=\3\2\2\2=>\3\2\2\2>@\7\60\2\2?A\4\62;\2@?\3\2\2\2AB\3\2\2\2B@\3"+
		"\2\2\2BC\3\2\2\2CE\3\2\2\2D\65\3\2\2\2D:\3\2\2\2E\f\3\2\2\2FG\7*\2\2G"+
		"\16\3\2\2\2HI\7+\2\2I\20\3\2\2\2JK\7?\2\2K\22\3\2\2\2LM\7.\2\2M\24\3\2"+
		"\2\2NO\7-\2\2O\26\3\2\2\2PQ\7/\2\2Q\30\3\2\2\2RS\7=\2\2S\32\3\2\2\2TW"+
		"\t\4\2\2UW\5\35\17\2VT\3\2\2\2VU\3\2\2\2WX\3\2\2\2XV\3\2\2\2XY\3\2\2\2"+
		"YZ\3\2\2\2Z[\b\16\2\2[\34\3\2\2\2\\]\7\17\2\2]`\7\f\2\2^`\t\5\2\2_\\\3"+
		"\2\2\2_^\3\2\2\2`\36\3\2\2\2\13\2\61\67<BDVX_\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}