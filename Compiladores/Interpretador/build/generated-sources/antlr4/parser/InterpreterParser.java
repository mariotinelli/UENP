// Generated from C:\Users\Mario\Documents\NetBeansProjects\Interpretador\grammar\parser\Interpreter.g4 by ANTLR 4.6

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
		TYPE=1, PRINT=2, READ=3, EOL=4, ASSIGN=5, SUM=6, SUB=7, REST=8, MULT=9, 
		DIV=10, CLOSE=11, OPEN=12, INT=13, DBL=14, VAR=15, STR=16, WS=17;
	public static final int
		RULE_prog = 0, RULE_line = 1, RULE_input = 2, RULE_output = 3, RULE_atrb = 4, 
		RULE_expr = 5, RULE_term = 6, RULE_fact = 7;
	public static final String[] ruleNames = {
		"prog", "line", "input", "output", "atrb", "expr", "term", "fact"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "'print'", "'input'", "';'", "'='", "'+'", "'-'", "'%'", "'*'", 
		"'/'", "')'", "'('"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "TYPE", "PRINT", "READ", "EOL", "ASSIGN", "SUM", "SUB", "REST", 
		"MULT", "DIV", "CLOSE", "OPEN", "INT", "DBL", "VAR", "STR", "WS"
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
		public LineContext line() {
			return getRuleContext(LineContext.class,0);
		}
		public TerminalNode EOL() { return getToken(InterpreterParser.EOL, 0); }
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			line();
			setState(17);
			match(EOL);
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
	public static class LineExprContext extends LineContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
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
			setState(23);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new LineInputContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(19);
				input();
				}
				break;
			case 2:
				_localctx = new LineOutputContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(20);
				output();
				}
				break;
			case 3:
				_localctx = new LineExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(21);
				expr(0);
				}
				break;
			case 4:
				_localctx = new LineAtrbContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(22);
				atrb();
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

	public static class InputContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(InterpreterParser.TYPE, 0); }
		public TerminalNode VAR() { return getToken(InterpreterParser.VAR, 0); }
		public TerminalNode READ() { return getToken(InterpreterParser.READ, 0); }
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
			setState(25);
			match(TYPE);
			setState(26);
			match(VAR);
			setState(27);
			match(ASSIGN);
			setState(28);
			match(READ);
			setState(29);
			match(OPEN);
			setState(30);
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
			setState(45);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new OutVarContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				match(PRINT);
				setState(33);
				match(OPEN);
				setState(34);
				match(VAR);
				setState(35);
				match(CLOSE);
				}
				break;
			case 2:
				_localctx = new OutExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(36);
				match(PRINT);
				setState(37);
				match(OPEN);
				setState(38);
				expr(0);
				setState(39);
				match(CLOSE);
				}
				break;
			case 3:
				_localctx = new OutStrContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(41);
				match(PRINT);
				setState(42);
				match(OPEN);
				setState(43);
				match(STR);
				setState(44);
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
			setState(55);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new AtrbExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				match(TYPE);
				setState(48);
				match(VAR);
				setState(49);
				match(ASSIGN);
				setState(50);
				expr(0);
				}
				break;
			case 2:
				_localctx = new AtrbStrContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				match(TYPE);
				setState(52);
				match(VAR);
				setState(53);
				match(ASSIGN);
				setState(54);
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

			setState(58);
			term(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(68);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(66);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new ExprSumContext(new ExprContext(_parentctx, _parentState));
						((ExprSumContext)_localctx).expr1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(60);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(61);
						match(SUM);
						setState(62);
						term(0);
						}
						break;
					case 2:
						{
						_localctx = new ExprSubContext(new ExprContext(_parentctx, _parentState));
						((ExprSubContext)_localctx).expr1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(63);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(64);
						match(SUB);
						setState(65);
						term(0);
						}
						break;
					}
					} 
				}
				setState(70);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

			setState(72);
			fact();
			}
			_ctx.stop = _input.LT(-1);
			setState(85);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(83);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new TermMultContext(new TermContext(_parentctx, _parentState));
						((TermMultContext)_localctx).term1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(74);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(75);
						match(MULT);
						setState(76);
						fact();
						}
						break;
					case 2:
						{
						_localctx = new TermDivContext(new TermContext(_parentctx, _parentState));
						((TermDivContext)_localctx).term1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(77);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(78);
						match(DIV);
						setState(79);
						fact();
						}
						break;
					case 3:
						{
						_localctx = new TermRestContext(new TermContext(_parentctx, _parentState));
						((TermRestContext)_localctx).term1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(80);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(81);
						match(REST);
						setState(82);
						fact();
						}
						break;
					}
					} 
				}
				setState(87);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
			setState(95);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN:
				_localctx = new FactExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				match(OPEN);
				setState(89);
				expr(0);
				setState(90);
				match(CLOSE);
				}
				break;
			case INT:
				_localctx = new FactIntContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
				match(INT);
				}
				break;
			case DBL:
				_localctx = new FactDblContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(93);
				match(DBL);
				}
				break;
			case VAR:
				_localctx = new FactVarContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(94);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\23d\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\5\3\32\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\60\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\5\6:\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7E\n\7\f\7\16\7H\13"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\bV\n\b\f\b\16\bY"+
		"\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tb\n\t\3\t\2\4\f\16\n\2\4\6\b\n\f"+
		"\16\20\2\2i\2\22\3\2\2\2\4\31\3\2\2\2\6\33\3\2\2\2\b/\3\2\2\2\n9\3\2\2"+
		"\2\f;\3\2\2\2\16I\3\2\2\2\20a\3\2\2\2\22\23\5\4\3\2\23\24\7\6\2\2\24\3"+
		"\3\2\2\2\25\32\5\6\4\2\26\32\5\b\5\2\27\32\5\f\7\2\30\32\5\n\6\2\31\25"+
		"\3\2\2\2\31\26\3\2\2\2\31\27\3\2\2\2\31\30\3\2\2\2\32\5\3\2\2\2\33\34"+
		"\7\3\2\2\34\35\7\21\2\2\35\36\7\7\2\2\36\37\7\5\2\2\37 \7\16\2\2 !\7\r"+
		"\2\2!\7\3\2\2\2\"#\7\4\2\2#$\7\16\2\2$%\7\21\2\2%\60\7\r\2\2&\'\7\4\2"+
		"\2\'(\7\16\2\2()\5\f\7\2)*\7\r\2\2*\60\3\2\2\2+,\7\4\2\2,-\7\16\2\2-."+
		"\7\22\2\2.\60\7\r\2\2/\"\3\2\2\2/&\3\2\2\2/+\3\2\2\2\60\t\3\2\2\2\61\62"+
		"\7\3\2\2\62\63\7\21\2\2\63\64\7\7\2\2\64:\5\f\7\2\65\66\7\3\2\2\66\67"+
		"\7\21\2\2\678\7\7\2\28:\7\22\2\29\61\3\2\2\29\65\3\2\2\2:\13\3\2\2\2;"+
		"<\b\7\1\2<=\5\16\b\2=F\3\2\2\2>?\f\5\2\2?@\7\b\2\2@E\5\16\b\2AB\f\4\2"+
		"\2BC\7\t\2\2CE\5\16\b\2D>\3\2\2\2DA\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2"+
		"\2\2G\r\3\2\2\2HF\3\2\2\2IJ\b\b\1\2JK\5\20\t\2KW\3\2\2\2LM\f\6\2\2MN\7"+
		"\13\2\2NV\5\20\t\2OP\f\5\2\2PQ\7\f\2\2QV\5\20\t\2RS\f\4\2\2ST\7\n\2\2"+
		"TV\5\20\t\2UL\3\2\2\2UO\3\2\2\2UR\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2"+
		"\2X\17\3\2\2\2YW\3\2\2\2Z[\7\16\2\2[\\\5\f\7\2\\]\7\r\2\2]b\3\2\2\2^b"+
		"\7\17\2\2_b\7\20\2\2`b\7\21\2\2aZ\3\2\2\2a^\3\2\2\2a_\3\2\2\2a`\3\2\2"+
		"\2b\21\3\2\2\2\n\31/9DFUWa";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}