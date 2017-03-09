// Generated from Reika.g4 by ANTLR 4.6
package io.xephon.proxy.ql.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ReikaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, INT=11, DOUBLE=12, BOOL=13, STRING=14, ID=15, ADD=16, MINUS=17, 
		MULT=18, DIV=19, AND=20, OR=21, WS=22, COMMENT=23, SL_COMMENT=24;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "INT", "DOUBLE", "BOOL", "STRING", "ESC", "ID", "LETTER", "ADD", 
		"MINUS", "MULT", "DIV", "AND", "OR", "WS", "COMMENT", "SL_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'int'", "'double'", "'bool'", "'string'", "'date'", "'='", "';'", 
		"'('", "')'", "','", null, null, null, null, null, "'+'", "'-'", "'*'", 
		"'/'", "'&&'", "'||'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "INT", 
		"DOUBLE", "BOOL", "STRING", "ID", "ADD", "MINUS", "MULT", "DIV", "AND", 
		"OR", "WS", "COMMENT", "SL_COMMENT"
	};
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


	public ReikaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Reika.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\32\u00c2\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\6\f_\n\f\r\f\16\f`\3\r\6"+
		"\rd\n\r\r\r\16\re\3\r\3\r\6\rj\n\r\r\r\16\rk\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\5\16w\n\16\3\17\3\17\3\17\7\17|\n\17\f\17\16\17\177"+
		"\13\17\3\17\3\17\3\20\3\20\3\20\3\20\5\20\u0087\n\20\3\21\3\21\3\21\7"+
		"\21\u008c\n\21\f\21\16\21\u008f\13\21\3\22\3\22\3\23\3\23\3\24\3\24\3"+
		"\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\6\31\u00a2\n\31"+
		"\r\31\16\31\u00a3\3\31\3\31\3\32\3\32\3\32\3\32\7\32\u00ac\n\32\f\32\16"+
		"\32\u00af\13\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\7\33\u00ba"+
		"\n\33\f\33\16\33\u00bd\13\33\3\33\3\33\3\33\3\33\5}\u00ad\u00bb\2\34\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\2!\21#\2%\22\'\23)\24+\25-\26/\27\61\30\63\31\65\32\3\2\5\3\2\62;\4\2"+
		"C\\c|\5\2\13\f\17\17\"\"\u00cb\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"!\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3"+
		"\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\3\67\3\2\2\2\5;\3\2\2\2"+
		"\7B\3\2\2\2\tG\3\2\2\2\13N\3\2\2\2\rS\3\2\2\2\17U\3\2\2\2\21W\3\2\2\2"+
		"\23Y\3\2\2\2\25[\3\2\2\2\27^\3\2\2\2\31c\3\2\2\2\33v\3\2\2\2\35x\3\2\2"+
		"\2\37\u0086\3\2\2\2!\u0088\3\2\2\2#\u0090\3\2\2\2%\u0092\3\2\2\2\'\u0094"+
		"\3\2\2\2)\u0096\3\2\2\2+\u0098\3\2\2\2-\u009a\3\2\2\2/\u009d\3\2\2\2\61"+
		"\u00a1\3\2\2\2\63\u00a7\3\2\2\2\65\u00b5\3\2\2\2\678\7k\2\289\7p\2\29"+
		":\7v\2\2:\4\3\2\2\2;<\7f\2\2<=\7q\2\2=>\7w\2\2>?\7d\2\2?@\7n\2\2@A\7g"+
		"\2\2A\6\3\2\2\2BC\7d\2\2CD\7q\2\2DE\7q\2\2EF\7n\2\2F\b\3\2\2\2GH\7u\2"+
		"\2HI\7v\2\2IJ\7t\2\2JK\7k\2\2KL\7p\2\2LM\7i\2\2M\n\3\2\2\2NO\7f\2\2OP"+
		"\7c\2\2PQ\7v\2\2QR\7g\2\2R\f\3\2\2\2ST\7?\2\2T\16\3\2\2\2UV\7=\2\2V\20"+
		"\3\2\2\2WX\7*\2\2X\22\3\2\2\2YZ\7+\2\2Z\24\3\2\2\2[\\\7.\2\2\\\26\3\2"+
		"\2\2]_\t\2\2\2^]\3\2\2\2_`\3\2\2\2`^\3\2\2\2`a\3\2\2\2a\30\3\2\2\2bd\t"+
		"\2\2\2cb\3\2\2\2de\3\2\2\2ec\3\2\2\2ef\3\2\2\2fg\3\2\2\2gi\7\60\2\2hj"+
		"\t\2\2\2ih\3\2\2\2jk\3\2\2\2ki\3\2\2\2kl\3\2\2\2l\32\3\2\2\2mn\7v\2\2"+
		"no\7t\2\2op\7w\2\2pw\7g\2\2qr\7h\2\2rs\7c\2\2st\7n\2\2tu\7u\2\2uw\7g\2"+
		"\2vm\3\2\2\2vq\3\2\2\2w\34\3\2\2\2x}\7$\2\2y|\5\37\20\2z|\13\2\2\2{y\3"+
		"\2\2\2{z\3\2\2\2|\177\3\2\2\2}~\3\2\2\2}{\3\2\2\2~\u0080\3\2\2\2\177}"+
		"\3\2\2\2\u0080\u0081\7$\2\2\u0081\36\3\2\2\2\u0082\u0083\7^\2\2\u0083"+
		"\u0087\7$\2\2\u0084\u0085\7^\2\2\u0085\u0087\7^\2\2\u0086\u0082\3\2\2"+
		"\2\u0086\u0084\3\2\2\2\u0087 \3\2\2\2\u0088\u008d\5#\22\2\u0089\u008c"+
		"\5#\22\2\u008a\u008c\t\2\2\2\u008b\u0089\3\2\2\2\u008b\u008a\3\2\2\2\u008c"+
		"\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\"\3\2\2\2"+
		"\u008f\u008d\3\2\2\2\u0090\u0091\t\3\2\2\u0091$\3\2\2\2\u0092\u0093\7"+
		"-\2\2\u0093&\3\2\2\2\u0094\u0095\7/\2\2\u0095(\3\2\2\2\u0096\u0097\7,"+
		"\2\2\u0097*\3\2\2\2\u0098\u0099\7\61\2\2\u0099,\3\2\2\2\u009a\u009b\7"+
		"(\2\2\u009b\u009c\7(\2\2\u009c.\3\2\2\2\u009d\u009e\7~\2\2\u009e\u009f"+
		"\7~\2\2\u009f\60\3\2\2\2\u00a0\u00a2\t\4\2\2\u00a1\u00a0\3\2\2\2\u00a2"+
		"\u00a3\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\3\2"+
		"\2\2\u00a5\u00a6\b\31\2\2\u00a6\62\3\2\2\2\u00a7\u00a8\7\61\2\2\u00a8"+
		"\u00a9\7,\2\2\u00a9\u00ad\3\2\2\2\u00aa\u00ac\13\2\2\2\u00ab\u00aa\3\2"+
		"\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae"+
		"\u00b0\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b1\7,\2\2\u00b1\u00b2\7\61"+
		"\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\b\32\2\2\u00b4\64\3\2\2\2\u00b5\u00b6"+
		"\7\61\2\2\u00b6\u00b7\7\61\2\2\u00b7\u00bb\3\2\2\2\u00b8\u00ba\13\2\2"+
		"\2\u00b9\u00b8\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bb\u00b9"+
		"\3\2\2\2\u00bc\u00be\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00bf\7\f\2\2\u00bf"+
		"\u00c0\3\2\2\2\u00c0\u00c1\b\33\2\2\u00c1\66\3\2\2\2\17\2`ekv{}\u0086"+
		"\u008b\u008d\u00a3\u00ad\u00bb\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}