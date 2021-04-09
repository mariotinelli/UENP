// Generated from C:\Users\Mário\Documents\NetBeansProjects\Interpretador\grammar\parser\Interpreter.g4 by ANTLR 4.6

package parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class InterpreterParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, RELOP=2, IF=3, ELSEIF=4, ELSE=5, READ=6, TYPE=7, PRINT=8, EOL=9, 
		ASSIGN=10, SUM=11, SUB=12, REST=13, MULT=14, DIV=15, CLOSE=16, OPEN=17, 
		OPEN_BL=18, CLOSE_BL=19, INT=20, DBL=21, VAR=22, STR=23, WS=24;
	public static final int
		RULE_prog = 0, RULE_line = 1, RULE_input = 2, RULE_output = 3, RULE_atrb = 4, 
		RULE_expr = 5, RULE_term = 6, RULE_fact = 7, RULE_ifstmt = 8, RULE_cond = 9, 
		RULE_block = 10;
	public static final String[] ruleNames = {
		"prog", "line", "input", "output", "atrb", "expr", "term", "fact", "ifstmt", 
		"cond", "block"
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

	@Override
	public String getGrammarFileName() { return "Interpreter.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public InterpreterParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterpreterVisitor ) return ((InterpreterVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(22);
				line();
				}
				}
				setState(25); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << READ) | (1L << TYPE) | (1L << PRINT) | (1L << OPEN) | (1L << INT) | (1L << DBL) | (1L << VAR))) != 0) );
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

	public static class LineContext extends ParserRuleContext {
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
	 
		public LineContext() { }
		public void copyFrom(LineContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LineAtrbContext extends LineContext {
		public AtrbContext atrb() {
			return getRuleContext(AtrbContext.class,0);
		}
		public TerminalNode EOL() { return getToken(InterpreterParser.EOL, 0); }
		public LineAtrbContext(LineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).enterLineAtrb(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).exitLineAtrb(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterpreterVisitor ) return ((InterpreterVisitor<? extends T>)visitor).visitLineAtrb(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LineIfContext extends LineContext {
		public IfstmtContext ifstmt() {
			return getRuleContext(IfstmtContext.class,0);
		}
		public LineIfContext(LineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).enterLineIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).exitLineIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterpreterVisitor ) return ((InterpreterVisitor<? extends T>)visitor).visitLineIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LineExprContext extends LineContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode EOL() { return getToken(InterpreterParser.EOL, 0); }
		public LineExprContext(LineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).enterLineExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).exitLineExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterpreterVisitor ) return ((InterpreterVisitor<? extends T>)visitor).visitLineExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LineOutputContext extends LineContext {
		public OutputContext output() {
			return getRuleContext(OutputContext.class,0);
		}
		public TerminalNode EOL() { return getToken(InterpreterParser.EOL, 0); }
		public LineOutputContext(LineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).enterLineOutput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).exitLineOutput(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterpreterVisitor ) return ((InterpreterVisitor<? extends T>)visitor).visitLineOutput(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LineInputContext extends LineContext {
		public InputContext input() {
			return getRuleContext(InputContext.class,0);
		}
		public TerminalNode EOL() { return getToken(InterpreterParser.EOL, 0); }
		public LineInputContext(LineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).enterLineInput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).exitLineInput(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterpreterVisitor ) return ((InterpreterVisitor<? extends T>)visitor).visitLineInput(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_line);
		try {
			setState(40);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case READ:
				_localctx = new LineInputContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(27);
				input();
				setState(28);
				match(EOL);
				}
				break;
			case PRINT:
				_localctx = new LineOutputContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(30);
				output();
				setState(31);
				match(EOL);
				}
				break;
			case OPEN:
			case INT:
			case DBL:
			case VAR:
				_localctx = new LineExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(33);
				expr(0);
				setState(34);
				match(EOL);
				}
				break;
			case TYPE:
				_localctx = new LineAtrbContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(36);
				atrb();
				setState(37);
				match(EOL);
				}
				break;
			case IF:
				_localctx = new LineIfContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(39);
				ifstmt();
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

	public static class InputContext extends ParserRuleContext {
		public TerminalNode READ() { return getToken(InterpreterParser.READ, 0); }
		public TerminalNode TYPE() { return getToken(InterpreterParser.TYPE, 0); }
		public TerminalNode VAR() { return getToken(InterpreterParser.VAR, 0); }
		public InputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).enterInput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).exitInput(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterpreterVisitor ) return ((InterpreterVisitor<? extends T>)visitor).visitInput(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputContext input() throws RecognitionException {
		InputContext _localctx = new InputContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_input);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(READ);
			setState(43);
			match(OPEN);
			setState(44);
			match(TYPE);
			setState(45);
			match(T__0);
			setState(46);
			match(VAR);
			setState(47);
			match(CLOSE);
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

	public static class OutputContext extends ParserRuleContext {
		public OutputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_output; }
	 
		public OutputContext() { }
		public void copyFrom(OutputContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class OutStrContext extends OutputContext {
		public TerminalNode PRINT() { return getToken(InterpreterParser.PRINT, 0); }
		public TerminalNode STR() { return getToken(InterpreterParser.STR, 0); }
		public OutStrContext(OutputContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).enterOutStr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).exitOutStr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterpreterVisitor ) return ((InterpreterVisitor<? extends T>)visitor).visitOutStr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OutVarContext extends OutputContext {
		public TerminalNode PRINT() { return getToken(InterpreterParser.PRINT, 0); }
		public TerminalNode VAR() { return getToken(InterpreterParser.VAR, 0); }
		public OutVarContext(OutputContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).enterOutVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).exitOutVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterpreterVisitor ) return ((InterpreterVisitor<? extends T>)visitor).visitOutVar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OutExprContext extends OutputContext {
		public TerminalNode PRINT() { return getToken(InterpreterParser.PRINT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public OutExprContext(OutputContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).enterOutExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).exitOutExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterpreterVisitor ) return ((InterpreterVisitor<? extends T>)visitor).visitOutExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OutputContext output() throws RecognitionException {
		OutputContext _localctx = new OutputContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_output);
		try {
			setState(62);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new OutVarContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				match(PRINT);
				setState(50);
				match(OPEN);
				setState(51);
				match(VAR);
				setState(52);
				match(CLOSE);
				}
				break;
			case 2:
				_localctx = new OutExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
				match(PRINT);
				setState(54);
				match(OPEN);
				setState(55);
				expr(0);
				setState(56);
				match(CLOSE);
				}
				break;
			case 3:
				_localctx = new OutStrContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(58);
				match(PRINT);
				setState(59);
				match(OPEN);
				setState(60);
				match(STR);
				setState(61);
				match(CLOSE);
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

	public static class AtrbContext extends ParserRuleContext {
		public AtrbContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atrb; }
	 
		public AtrbContext() { }
		public void copyFrom(AtrbContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AtrbExprContext extends AtrbContext {
		public TerminalNode TYPE() { return getToken(InterpreterParser.TYPE, 0); }
		public TerminalNode VAR() { return getToken(InterpreterParser.VAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AtrbExprContext(AtrbContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).enterAtrbExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).exitAtrbExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterpreterVisitor ) return ((InterpreterVisitor<? extends T>)visitor).visitAtrbExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtrbStrContext extends AtrbContext {
		public TerminalNode TYPE() { return getToken(InterpreterParser.TYPE, 0); }
		public TerminalNode VAR() { return getToken(InterpreterParser.VAR, 0); }
		public TerminalNode STR() { return getToken(InterpreterParser.STR, 0); }
		public AtrbStrContext(AtrbContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).enterAtrbStr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).exitAtrbStr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterpreterVisitor ) return ((InterpreterVisitor<? extends T>)visitor).visitAtrbStr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtrbContext atrb() throws RecognitionException {
		AtrbContext _localctx = new AtrbContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_atrb);
		try {
			setState(72);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new AtrbExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				match(TYPE);
				setState(65);
				match(VAR);
				setState(66);
				match(ASSIGN);
				setState(67);
				expr(0);
				}
				break;
			case 2:
				_localctx = new AtrbStrContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				match(TYPE);
				setState(69);
				match(VAR);
				setState(70);
				match(ASSIGN);
				setState(71);
				match(STR);
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

	public static class ExprContext extends ParserRuleContext {
		public Object val;
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
			this.val = ctx.val;
		}
	}
	public static class ExprSubContext extends ExprContext {
		public ExprContext expr1;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprSubContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).enterExprSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).exitExprSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterpreterVisitor ) return ((InterpreterVisitor<? extends T>)visitor).visitExprSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprSumContext extends ExprContext {
		public ExprContext expr1;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprSumContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).enterExprSum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).exitExprSum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterpreterVisitor ) return ((InterpreterVisitor<? extends T>)visitor).visitExprSum(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprTermContext extends ExprContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ExprTermContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).enterExprTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).exitExprTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterpreterVisitor ) return ((InterpreterVisitor<? extends T>)visitor).visitExprTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ExprTermContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(75);
			term(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(85);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(83);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new ExprSumContext(new ExprContext(_parentctx, _parentState));
						((ExprSumContext)_localctx).expr1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(77);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(78);
						match(SUM);
						setState(79);
						term(0);
						}
						break;
					case 2:
						{
						_localctx = new ExprSubContext(new ExprContext(_parentctx, _parentState));
						((ExprSubContext)_localctx).expr1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(80);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(81);
						match(SUB);
						setState(82);
						term(0);
						}
						break;
					}
					} 
				}
				setState(87);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public Object val;
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	 
		public TermContext() { }
		public void copyFrom(TermContext ctx) {
			super.copyFrom(ctx);
			this.val = ctx.val;
		}
	}
	public static class TermDivContext extends TermContext {
		public TermContext term1;
		public FactContext fact() {
			return getRuleContext(FactContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TermDivContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).enterTermDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).exitTermDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterpreterVisitor ) return ((InterpreterVisitor<? extends T>)visitor).visitTermDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TermMultContext extends TermContext {
		public TermContext term1;
		public FactContext fact() {
			return getRuleContext(FactContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TermMultContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).enterTermMult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).exitTermMult(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterpreterVisitor ) return ((InterpreterVisitor<? extends T>)visitor).visitTermMult(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TermRestContext extends TermContext {
		public TermContext term1;
		public FactContext fact() {
			return getRuleContext(FactContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TermRestContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).enterTermRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).exitTermRest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterpreterVisitor ) return ((InterpreterVisitor<? extends T>)visitor).visitTermRest(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TermFactContext extends TermContext {
		public FactContext fact() {
			return getRuleContext(FactContext.class,0);
		}
		public TermFactContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).enterTermFact(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).exitTermFact(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterpreterVisitor ) return ((InterpreterVisitor<? extends T>)visitor).visitTermFact(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new TermFactContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(89);
			fact();
			}
			_ctx.stop = _input.LT(-1);
			setState(102);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(100);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new TermMultContext(new TermContext(_parentctx, _parentState));
						((TermMultContext)_localctx).term1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(91);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(92);
						match(MULT);
						setState(93);
						fact();
						}
						break;
					case 2:
						{
						_localctx = new TermDivContext(new TermContext(_parentctx, _parentState));
						((TermDivContext)_localctx).term1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(94);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(95);
						match(DIV);
						setState(96);
						fact();
						}
						break;
					case 3:
						{
						_localctx = new TermRestContext(new TermContext(_parentctx, _parentState));
						((TermRestContext)_localctx).term1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(97);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(98);
						match(REST);
						setState(99);
						fact();
						}
						break;
					}
					} 
				}
				setState(104);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FactContext extends ParserRuleContext {
		public Object val;
		public FactContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fact; }
	 
		public FactContext() { }
		public void copyFrom(FactContext ctx) {
			super.copyFrom(ctx);
			this.val = ctx.val;
		}
	}
	public static class FactVarContext extends FactContext {
		public TerminalNode VAR() { return getToken(InterpreterParser.VAR, 0); }
		public FactVarContext(FactContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).enterFactVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).exitFactVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterpreterVisitor ) return ((InterpreterVisitor<? extends T>)visitor).visitFactVar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FactExprContext extends FactContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FactExprContext(FactContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).enterFactExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).exitFactExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterpreterVisitor ) return ((InterpreterVisitor<? extends T>)visitor).visitFactExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FactDblContext extends FactContext {
		public TerminalNode DBL() { return getToken(InterpreterParser.DBL, 0); }
		public FactDblContext(FactContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).enterFactDbl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).exitFactDbl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterpreterVisitor ) return ((InterpreterVisitor<? extends T>)visitor).visitFactDbl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FactIntContext extends FactContext {
		public TerminalNode INT() { return getToken(InterpreterParser.INT, 0); }
		public FactIntContext(FactContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).enterFactInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).exitFactInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterpreterVisitor ) return ((InterpreterVisitor<? extends T>)visitor).visitFactInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactContext fact() throws RecognitionException {
		FactContext _localctx = new FactContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_fact);
		try {
			setState(112);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN:
				_localctx = new FactExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				match(OPEN);
				setState(106);
				expr(0);
				setState(107);
				match(CLOSE);
				}
				break;
			case INT:
				_localctx = new FactIntContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				match(INT);
				}
				break;
			case DBL:
				_localctx = new FactDblContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(110);
				match(DBL);
				}
				break;
			case VAR:
				_localctx = new FactVarContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(111);
				match(VAR);
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

	public static class IfstmtContext extends ParserRuleContext {
		public IfstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifstmt; }
	 
		public IfstmtContext() { }
		public void copyFrom(IfstmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfElseIfElseContext extends IfstmtContext {
		public CondContext c1;
		public BlockContext b1;
		public CondContext c2;
		public BlockContext b2;
		public BlockContext b3;
		public TerminalNode IF() { return getToken(InterpreterParser.IF, 0); }
		public TerminalNode ELSEIF() { return getToken(InterpreterParser.ELSEIF, 0); }
		public TerminalNode ELSE() { return getToken(InterpreterParser.ELSE, 0); }
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public IfElseIfElseContext(IfstmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).enterIfElseIfElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).exitIfElseIfElse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterpreterVisitor ) return ((InterpreterVisitor<? extends T>)visitor).visitIfElseIfElse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfElseContext extends IfstmtContext {
		public CondContext c1;
		public BlockContext b1;
		public BlockContext b2;
		public TerminalNode IF() { return getToken(InterpreterParser.IF, 0); }
		public TerminalNode ELSE() { return getToken(InterpreterParser.ELSE, 0); }
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public IfElseContext(IfstmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).enterIfElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).exitIfElse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterpreterVisitor ) return ((InterpreterVisitor<? extends T>)visitor).visitIfElse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfContext extends IfstmtContext {
		public CondContext c1;
		public BlockContext b1;
		public TerminalNode IF() { return getToken(InterpreterParser.IF, 0); }
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public IfContext(IfstmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).exitIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterpreterVisitor ) return ((InterpreterVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfElseIfContext extends IfstmtContext {
		public CondContext c1;
		public BlockContext b1;
		public CondContext c2;
		public BlockContext b2;
		public TerminalNode IF() { return getToken(InterpreterParser.IF, 0); }
		public TerminalNode ELSEIF() { return getToken(InterpreterParser.ELSEIF, 0); }
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public IfElseIfContext(IfstmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).enterIfElseIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).exitIfElseIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterpreterVisitor ) return ((InterpreterVisitor<? extends T>)visitor).visitIfElseIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfstmtContext ifstmt() throws RecognitionException {
		IfstmtContext _localctx = new IfstmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ifstmt);
		try {
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				match(IF);
				setState(115);
				match(OPEN);
				setState(116);
				((IfContext)_localctx).c1 = cond();
				setState(117);
				match(CLOSE);
				setState(118);
				((IfContext)_localctx).b1 = block();
				}
				break;
			case 2:
				_localctx = new IfElseIfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				match(IF);
				setState(121);
				match(OPEN);
				setState(122);
				((IfElseIfContext)_localctx).c1 = cond();
				setState(123);
				match(CLOSE);
				setState(124);
				((IfElseIfContext)_localctx).b1 = block();
				setState(125);
				match(ELSEIF);
				setState(126);
				match(OPEN);
				setState(127);
				((IfElseIfContext)_localctx).c2 = cond();
				setState(128);
				match(CLOSE);
				setState(129);
				((IfElseIfContext)_localctx).b2 = block();
				}
				break;
			case 3:
				_localctx = new IfElseIfElseContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(131);
				match(IF);
				setState(132);
				match(OPEN);
				setState(133);
				((IfElseIfElseContext)_localctx).c1 = cond();
				setState(134);
				match(CLOSE);
				setState(135);
				((IfElseIfElseContext)_localctx).b1 = block();
				setState(136);
				match(ELSEIF);
				setState(137);
				match(OPEN);
				setState(138);
				((IfElseIfElseContext)_localctx).c2 = cond();
				setState(139);
				match(CLOSE);
				setState(140);
				((IfElseIfElseContext)_localctx).b2 = block();
				setState(141);
				match(ELSE);
				setState(142);
				((IfElseIfElseContext)_localctx).b3 = block();
				}
				break;
			case 4:
				_localctx = new IfElseContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(144);
				match(IF);
				setState(145);
				match(OPEN);
				setState(146);
				((IfElseContext)_localctx).c1 = cond();
				setState(147);
				match(CLOSE);
				setState(148);
				((IfElseContext)_localctx).b1 = block();
				setState(149);
				match(ELSE);
				setState(150);
				((IfElseContext)_localctx).b2 = block();
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

	public static class CondContext extends ParserRuleContext {
		public Object val;
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
	 
		public CondContext() { }
		public void copyFrom(CondContext ctx) {
			super.copyFrom(ctx);
			this.val = ctx.val;
		}
	}
	public static class CondRelopContext extends CondContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RELOP() { return getToken(InterpreterParser.RELOP, 0); }
		public CondRelopContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).enterCondRelop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).exitCondRelop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterpreterVisitor ) return ((InterpreterVisitor<? extends T>)visitor).visitCondRelop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondExprContext extends CondContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CondExprContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).enterCondExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).exitCondExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterpreterVisitor ) return ((InterpreterVisitor<? extends T>)visitor).visitCondExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondRelopStrContext extends CondContext {
		public List<TerminalNode> STR() { return getTokens(InterpreterParser.STR); }
		public TerminalNode STR(int i) {
			return getToken(InterpreterParser.STR, i);
		}
		public TerminalNode RELOP() { return getToken(InterpreterParser.RELOP, 0); }
		public CondRelopStrContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).enterCondRelopStr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).exitCondRelopStr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterpreterVisitor ) return ((InterpreterVisitor<? extends T>)visitor).visitCondRelopStr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondContext cond() throws RecognitionException {
		CondContext _localctx = new CondContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cond);
		try {
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new CondExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				expr(0);
				}
				break;
			case 2:
				_localctx = new CondRelopStrContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				match(STR);
				setState(156);
				match(RELOP);
				setState(157);
				match(STR);
				}
				break;
			case 3:
				_localctx = new CondRelopContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(158);
				expr(0);
				setState(159);
				match(RELOP);
				setState(160);
				expr(0);
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

	public static class BlockContext extends ParserRuleContext {
		public Object val;
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	 
		public BlockContext() { }
		public void copyFrom(BlockContext ctx) {
			super.copyFrom(ctx);
			this.val = ctx.val;
		}
	}
	public static class BlockStmtContext extends BlockContext {
		public ProgContext prog() {
			return getRuleContext(ProgContext.class,0);
		}
		public BlockStmtContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).enterBlockStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).exitBlockStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterpreterVisitor ) return ((InterpreterVisitor<? extends T>)visitor).visitBlockStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_block);
		try {
			_localctx = new BlockStmtContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(OPEN_BL);
			setState(165);
			prog();
			setState(166);
			match(CLOSE_BL);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 6:
			return term_sempred((TermContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\32\u00ab\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\3\2\6\2\32\n\2\r\2\16\2\33\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\5\3+\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5A\n\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\5\6K\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7V\n\7\f"+
		"\7\16\7Y\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\bg\n\b"+
		"\f\b\16\bj\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\ts\n\t\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u009b"+
		"\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00a5\n\13\3\f\3\f\3"+
		"\f\3\f\3\f\2\4\f\16\r\2\4\6\b\n\f\16\20\22\24\26\2\2\u00b4\2\31\3\2\2"+
		"\2\4*\3\2\2\2\6,\3\2\2\2\b@\3\2\2\2\nJ\3\2\2\2\fL\3\2\2\2\16Z\3\2\2\2"+
		"\20r\3\2\2\2\22\u009a\3\2\2\2\24\u00a4\3\2\2\2\26\u00a6\3\2\2\2\30\32"+
		"\5\4\3\2\31\30\3\2\2\2\32\33\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\3"+
		"\3\2\2\2\35\36\5\6\4\2\36\37\7\13\2\2\37+\3\2\2\2 !\5\b\5\2!\"\7\13\2"+
		"\2\"+\3\2\2\2#$\5\f\7\2$%\7\13\2\2%+\3\2\2\2&\'\5\n\6\2\'(\7\13\2\2(+"+
		"\3\2\2\2)+\5\22\n\2*\35\3\2\2\2* \3\2\2\2*#\3\2\2\2*&\3\2\2\2*)\3\2\2"+
		"\2+\5\3\2\2\2,-\7\b\2\2-.\7\23\2\2./\7\t\2\2/\60\7\3\2\2\60\61\7\30\2"+
		"\2\61\62\7\22\2\2\62\7\3\2\2\2\63\64\7\n\2\2\64\65\7\23\2\2\65\66\7\30"+
		"\2\2\66A\7\22\2\2\678\7\n\2\289\7\23\2\29:\5\f\7\2:;\7\22\2\2;A\3\2\2"+
		"\2<=\7\n\2\2=>\7\23\2\2>?\7\31\2\2?A\7\22\2\2@\63\3\2\2\2@\67\3\2\2\2"+
		"@<\3\2\2\2A\t\3\2\2\2BC\7\t\2\2CD\7\30\2\2DE\7\f\2\2EK\5\f\7\2FG\7\t\2"+
		"\2GH\7\30\2\2HI\7\f\2\2IK\7\31\2\2JB\3\2\2\2JF\3\2\2\2K\13\3\2\2\2LM\b"+
		"\7\1\2MN\5\16\b\2NW\3\2\2\2OP\f\5\2\2PQ\7\r\2\2QV\5\16\b\2RS\f\4\2\2S"+
		"T\7\16\2\2TV\5\16\b\2UO\3\2\2\2UR\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2"+
		"\2X\r\3\2\2\2YW\3\2\2\2Z[\b\b\1\2[\\\5\20\t\2\\h\3\2\2\2]^\f\6\2\2^_\7"+
		"\20\2\2_g\5\20\t\2`a\f\5\2\2ab\7\21\2\2bg\5\20\t\2cd\f\4\2\2de\7\17\2"+
		"\2eg\5\20\t\2f]\3\2\2\2f`\3\2\2\2fc\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2"+
		"\2\2i\17\3\2\2\2jh\3\2\2\2kl\7\23\2\2lm\5\f\7\2mn\7\22\2\2ns\3\2\2\2o"+
		"s\7\26\2\2ps\7\27\2\2qs\7\30\2\2rk\3\2\2\2ro\3\2\2\2rp\3\2\2\2rq\3\2\2"+
		"\2s\21\3\2\2\2tu\7\5\2\2uv\7\23\2\2vw\5\24\13\2wx\7\22\2\2xy\5\26\f\2"+
		"y\u009b\3\2\2\2z{\7\5\2\2{|\7\23\2\2|}\5\24\13\2}~\7\22\2\2~\177\5\26"+
		"\f\2\177\u0080\7\6\2\2\u0080\u0081\7\23\2\2\u0081\u0082\5\24\13\2\u0082"+
		"\u0083\7\22\2\2\u0083\u0084\5\26\f\2\u0084\u009b\3\2\2\2\u0085\u0086\7"+
		"\5\2\2\u0086\u0087\7\23\2\2\u0087\u0088\5\24\13\2\u0088\u0089\7\22\2\2"+
		"\u0089\u008a\5\26\f\2\u008a\u008b\7\6\2\2\u008b\u008c\7\23\2\2\u008c\u008d"+
		"\5\24\13\2\u008d\u008e\7\22\2\2\u008e\u008f\5\26\f\2\u008f\u0090\7\7\2"+
		"\2\u0090\u0091\5\26\f\2\u0091\u009b\3\2\2\2\u0092\u0093\7\5\2\2\u0093"+
		"\u0094\7\23\2\2\u0094\u0095\5\24\13\2\u0095\u0096\7\22\2\2\u0096\u0097"+
		"\5\26\f\2\u0097\u0098\7\7\2\2\u0098\u0099\5\26\f\2\u0099\u009b\3\2\2\2"+
		"\u009at\3\2\2\2\u009az\3\2\2\2\u009a\u0085\3\2\2\2\u009a\u0092\3\2\2\2"+
		"\u009b\23\3\2\2\2\u009c\u00a5\5\f\7\2\u009d\u009e\7\31\2\2\u009e\u009f"+
		"\7\4\2\2\u009f\u00a5\7\31\2\2\u00a0\u00a1\5\f\7\2\u00a1\u00a2\7\4\2\2"+
		"\u00a2\u00a3\5\f\7\2\u00a3\u00a5\3\2\2\2\u00a4\u009c\3\2\2\2\u00a4\u009d"+
		"\3\2\2\2\u00a4\u00a0\3\2\2\2\u00a5\25\3\2\2\2\u00a6\u00a7\7\24\2\2\u00a7"+
		"\u00a8\5\2\2\2\u00a8\u00a9\7\25\2\2\u00a9\27\3\2\2\2\r\33*@JUWfhr\u009a"+
		"\u00a4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}