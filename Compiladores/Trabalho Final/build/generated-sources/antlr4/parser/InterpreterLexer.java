// Generated from C:\Users\Mário\Documents\NetBeansProjects\Interpretador\grammar\parser\Interpreter.g4 by ANTLR 4.6

package parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class InterpreterLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, RELOP=2, IF=3, ELSEIF=4, ELSE=5, READ=6, TYPE=7, PRINT=8, EOL=9, 
		ASSIGN=10, SUM=11, SUB=12, REST=13, MULT=14, DIV=15, CLOSE=16, OPEN=17, 
		OPEN_BL=18, CLOSE_BL=19, INT=20, DBL=21, VAR=22, STR=23, WS=24;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "RELOP", "IF", "ELSEIF", "ELSE", "READ", "TYPE", "PRINT", "EOL", 
		"ASSIGN", "SUM", "SUB", "REST", "MULT", "DIV", "CLOSE", "OPEN", "OPEN_BL", 
		"CLOSE_BL", "INT", "DBL", "VAR", "STR", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", null, "'if'", "'else if'", "'else'", "'input'", null, "'print'", 
		"';'", "'='", "'+'", "'-'", "'%'", "'*'", "'/'", "')'", "'('", "'{'", 
		"'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "RELOP", "IF", "ELSEIF", "ELSE", "READ", "TYPE", "PRINT", 
		"EOL", "ASSIGN", "SUM", "SUB", "REST", "MULT", "DIV", "CLOSE", "OPEN", 
		"OPEN_BL", "CLOSE_BL", "INT", "DBL", "VAR", "STR", "WS"
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


	public InterpreterLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Interpreter.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\32\u00ac\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3?\n\3\3\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b"+
		"f\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3"+
		"\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\6"+
		"\25\u0085\n\25\r\25\16\25\u0086\3\26\6\26\u008a\n\26\r\26\16\26\u008b"+
		"\3\26\3\26\6\26\u0090\n\26\r\26\16\26\u0091\3\27\3\27\7\27\u0096\n\27"+
		"\f\27\16\27\u0099\13\27\3\30\3\30\3\30\3\30\7\30\u009f\n\30\f\30\16\30"+
		"\u00a2\13\30\3\30\3\30\3\31\6\31\u00a7\n\31\r\31\16\31\u00a8\3\31\3\31"+
		"\2\2\32\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\3\2\n\4\2>>@@\3\2"+
		"\62;\3\2\60\60\5\2C\\aac|\6\2\62;C\\aac|\4\2$$^^\6\2\f\f\17\17$$^^\5\2"+
		"\13\f\16\17\"\"\u00b8\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\3\63\3\2\2\2\5>\3\2\2\2\7@\3\2\2"+
		"\2\tC\3\2\2\2\13K\3\2\2\2\rP\3\2\2\2\17e\3\2\2\2\21g\3\2\2\2\23m\3\2\2"+
		"\2\25o\3\2\2\2\27q\3\2\2\2\31s\3\2\2\2\33u\3\2\2\2\35w\3\2\2\2\37y\3\2"+
		"\2\2!{\3\2\2\2#}\3\2\2\2%\177\3\2\2\2\'\u0081\3\2\2\2)\u0084\3\2\2\2+"+
		"\u0089\3\2\2\2-\u0093\3\2\2\2/\u009a\3\2\2\2\61\u00a6\3\2\2\2\63\64\7"+
		".\2\2\64\4\3\2\2\2\65?\t\2\2\2\66\67\7@\2\2\67?\7?\2\289\7>\2\29?\7?\2"+
		"\2:;\7?\2\2;?\7?\2\2<=\7#\2\2=?\7?\2\2>\65\3\2\2\2>\66\3\2\2\2>8\3\2\2"+
		"\2>:\3\2\2\2><\3\2\2\2?\6\3\2\2\2@A\7k\2\2AB\7h\2\2B\b\3\2\2\2CD\7g\2"+
		"\2DE\7n\2\2EF\7u\2\2FG\7g\2\2GH\7\"\2\2HI\7k\2\2IJ\7h\2\2J\n\3\2\2\2K"+
		"L\7g\2\2LM\7n\2\2MN\7u\2\2NO\7g\2\2O\f\3\2\2\2PQ\7k\2\2QR\7p\2\2RS\7r"+
		"\2\2ST\7w\2\2TU\7v\2\2U\16\3\2\2\2VW\7k\2\2WX\7p\2\2Xf\7v\2\2YZ\7f\2\2"+
		"Z[\7q\2\2[\\\7w\2\2\\]\7d\2\2]^\7n\2\2^f\7g\2\2_`\7u\2\2`a\7v\2\2ab\7"+
		"t\2\2bc\7k\2\2cd\7p\2\2df\7i\2\2eV\3\2\2\2eY\3\2\2\2e_\3\2\2\2f\20\3\2"+
		"\2\2gh\7r\2\2hi\7t\2\2ij\7k\2\2jk\7p\2\2kl\7v\2\2l\22\3\2\2\2mn\7=\2\2"+
		"n\24\3\2\2\2op\7?\2\2p\26\3\2\2\2qr\7-\2\2r\30\3\2\2\2st\7/\2\2t\32\3"+
		"\2\2\2uv\7\'\2\2v\34\3\2\2\2wx\7,\2\2x\36\3\2\2\2yz\7\61\2\2z \3\2\2\2"+
		"{|\7+\2\2|\"\3\2\2\2}~\7*\2\2~$\3\2\2\2\177\u0080\7}\2\2\u0080&\3\2\2"+
		"\2\u0081\u0082\7\177\2\2\u0082(\3\2\2\2\u0083\u0085\t\3\2\2\u0084\u0083"+
		"\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087"+
		"*\3\2\2\2\u0088\u008a\t\3\2\2\u0089\u0088\3\2\2\2\u008a\u008b\3\2\2\2"+
		"\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008f"+
		"\t\4\2\2\u008e\u0090\t\3\2\2\u008f\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091"+
		"\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092,\3\2\2\2\u0093\u0097\t\5\2\2"+
		"\u0094\u0096\t\6\2\2\u0095\u0094\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095"+
		"\3\2\2\2\u0097\u0098\3\2\2\2\u0098.\3\2\2\2\u0099\u0097\3\2\2\2\u009a"+
		"\u00a0\7$\2\2\u009b\u009c\7^\2\2\u009c\u009f\t\7\2\2\u009d\u009f\n\b\2"+
		"\2\u009e\u009b\3\2\2\2\u009e\u009d\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e"+
		"\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a3\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3"+
		"\u00a4\7$\2\2\u00a4\60\3\2\2\2\u00a5\u00a7\t\t\2\2\u00a6\u00a5\3\2\2\2"+
		"\u00a7\u00a8\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa"+
		"\3\2\2\2\u00aa\u00ab\b\31\2\2\u00ab\62\3\2\2\2\f\2>e\u0086\u008b\u0091"+
		"\u0097\u009e\u00a0\u00a8\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}