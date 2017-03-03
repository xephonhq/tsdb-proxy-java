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
		ID=10, INT=11, STRING=12, ADD=13, MINUS=14, WS=15, SL_COMMENT=16;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"ID", "LETTER", "INT", "STRING", "ESC", "ADD", "MINUS", "WS", "SL_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'int'", "'bool'", "'string'", "'date'", "'='", "';'", "'('", "')'", 
		"','", null, null, null, "'+'", "'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "ID", "INT", 
		"STRING", "ADD", "MINUS", "WS", "SL_COMMENT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\22}\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13"+
		"\3\13\3\13\7\13J\n\13\f\13\16\13M\13\13\3\f\3\f\3\r\6\rR\n\r\r\r\16\r"+
		"S\3\16\3\16\3\16\7\16Y\n\16\f\16\16\16\\\13\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\5\17d\n\17\3\20\3\20\3\21\3\21\3\22\6\22k\n\22\r\22\16\22l\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\7\23u\n\23\f\23\16\23x\13\23\3\23\3\23\3\23"+
		"\3\23\4Zv\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\2\31\r"+
		"\33\16\35\2\37\17!\20#\21%\22\3\2\5\3\2\62;\4\2C\\c|\5\2\13\f\17\17\""+
		"\"\u0082\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3"+
		"\'\3\2\2\2\5+\3\2\2\2\7\60\3\2\2\2\t\67\3\2\2\2\13<\3\2\2\2\r>\3\2\2\2"+
		"\17@\3\2\2\2\21B\3\2\2\2\23D\3\2\2\2\25F\3\2\2\2\27N\3\2\2\2\31Q\3\2\2"+
		"\2\33U\3\2\2\2\35c\3\2\2\2\37e\3\2\2\2!g\3\2\2\2#j\3\2\2\2%p\3\2\2\2\'"+
		"(\7k\2\2()\7p\2\2)*\7v\2\2*\4\3\2\2\2+,\7d\2\2,-\7q\2\2-.\7q\2\2./\7n"+
		"\2\2/\6\3\2\2\2\60\61\7u\2\2\61\62\7v\2\2\62\63\7t\2\2\63\64\7k\2\2\64"+
		"\65\7p\2\2\65\66\7i\2\2\66\b\3\2\2\2\678\7f\2\289\7c\2\29:\7v\2\2:;\7"+
		"g\2\2;\n\3\2\2\2<=\7?\2\2=\f\3\2\2\2>?\7=\2\2?\16\3\2\2\2@A\7*\2\2A\20"+
		"\3\2\2\2BC\7+\2\2C\22\3\2\2\2DE\7.\2\2E\24\3\2\2\2FK\5\27\f\2GJ\5\27\f"+
		"\2HJ\t\2\2\2IG\3\2\2\2IH\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2L\26\3\2"+
		"\2\2MK\3\2\2\2NO\t\3\2\2O\30\3\2\2\2PR\t\2\2\2QP\3\2\2\2RS\3\2\2\2SQ\3"+
		"\2\2\2ST\3\2\2\2T\32\3\2\2\2UZ\7$\2\2VY\5\35\17\2WY\13\2\2\2XV\3\2\2\2"+
		"XW\3\2\2\2Y\\\3\2\2\2Z[\3\2\2\2ZX\3\2\2\2[]\3\2\2\2\\Z\3\2\2\2]^\7$\2"+
		"\2^\34\3\2\2\2_`\7^\2\2`d\7$\2\2ab\7^\2\2bd\7^\2\2c_\3\2\2\2ca\3\2\2\2"+
		"d\36\3\2\2\2ef\7-\2\2f \3\2\2\2gh\7/\2\2h\"\3\2\2\2ik\t\4\2\2ji\3\2\2"+
		"\2kl\3\2\2\2lj\3\2\2\2lm\3\2\2\2mn\3\2\2\2no\b\22\2\2o$\3\2\2\2pq\7\61"+
		"\2\2qr\7\61\2\2rv\3\2\2\2su\13\2\2\2ts\3\2\2\2ux\3\2\2\2vw\3\2\2\2vt\3"+
		"\2\2\2wy\3\2\2\2xv\3\2\2\2yz\7\f\2\2z{\3\2\2\2{|\b\23\2\2|&\3\2\2\2\13"+
		"\2IKSXZclv\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}