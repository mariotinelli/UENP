// Generated from C:\Users\Mario\Documents\NetBeansProjects\Interpretador\grammar\parser\Interpreter.g4 by ANTLR 4.6

package parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link InterpreterParser}.
 */
public interface InterpreterListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link InterpreterParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(InterpreterParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterpreterParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(InterpreterParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lineInput}
	 * labeled alternative in {@link InterpreterParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLineInput(InterpreterParser.LineInputContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lineInput}
	 * labeled alternative in {@link InterpreterParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLineInput(InterpreterParser.LineInputContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lineOutput}
	 * labeled alternative in {@link InterpreterParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLineOutput(InterpreterParser.LineOutputContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lineOutput}
	 * labeled alternative in {@link InterpreterParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLineOutput(InterpreterParser.LineOutputContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lineExpr}
	 * labeled alternative in {@link InterpreterParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLineExpr(InterpreterParser.LineExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lineExpr}
	 * labeled alternative in {@link InterpreterParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLineExpr(InterpreterParser.LineExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lineAtrb}
	 * labeled alternative in {@link InterpreterParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLineAtrb(InterpreterParser.LineAtrbContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lineAtrb}
	 * labeled alternative in {@link InterpreterParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLineAtrb(InterpreterParser.LineAtrbContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterpreterParser#input}.
	 * @param ctx the parse tree
	 */
	void enterInput(InterpreterParser.InputContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterpreterParser#input}.
	 * @param ctx the parse tree
	 */
	void exitInput(InterpreterParser.InputContext ctx);
	/**
	 * Enter a parse tree produced by the {@code outVar}
	 * labeled alternative in {@link InterpreterParser#output}.
	 * @param ctx the parse tree
	 */
	void enterOutVar(InterpreterParser.OutVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code outVar}
	 * labeled alternative in {@link InterpreterParser#output}.
	 * @param ctx the parse tree
	 */
	void exitOutVar(InterpreterParser.OutVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code outExpr}
	 * labeled alternative in {@link InterpreterParser#output}.
	 * @param ctx the parse tree
	 */
	void enterOutExpr(InterpreterParser.OutExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code outExpr}
	 * labeled alternative in {@link InterpreterParser#output}.
	 * @param ctx the parse tree
	 */
	void exitOutExpr(InterpreterParser.OutExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code outStr}
	 * labeled alternative in {@link InterpreterParser#output}.
	 * @param ctx the parse tree
	 */
	void enterOutStr(InterpreterParser.OutStrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code outStr}
	 * labeled alternative in {@link InterpreterParser#output}.
	 * @param ctx the parse tree
	 */
	void exitOutStr(InterpreterParser.OutStrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atrbExpr}
	 * labeled alternative in {@link InterpreterParser#atrb}.
	 * @param ctx the parse tree
	 */
	void enterAtrbExpr(InterpreterParser.AtrbExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atrbExpr}
	 * labeled alternative in {@link InterpreterParser#atrb}.
	 * @param ctx the parse tree
	 */
	void exitAtrbExpr(InterpreterParser.AtrbExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atrbStr}
	 * labeled alternative in {@link InterpreterParser#atrb}.
	 * @param ctx the parse tree
	 */
	void enterAtrbStr(InterpreterParser.AtrbStrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atrbStr}
	 * labeled alternative in {@link InterpreterParser#atrb}.
	 * @param ctx the parse tree
	 */
	void exitAtrbStr(InterpreterParser.AtrbStrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprSub}
	 * labeled alternative in {@link InterpreterParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprSub(InterpreterParser.ExprSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprSub}
	 * labeled alternative in {@link InterpreterParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprSub(InterpreterParser.ExprSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprSum}
	 * labeled alternative in {@link InterpreterParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprSum(InterpreterParser.ExprSumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprSum}
	 * labeled alternative in {@link InterpreterParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprSum(InterpreterParser.ExprSumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprTerm}
	 * labeled alternative in {@link InterpreterParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprTerm(InterpreterParser.ExprTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprTerm}
	 * labeled alternative in {@link InterpreterParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprTerm(InterpreterParser.ExprTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code termDiv}
	 * labeled alternative in {@link InterpreterParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTermDiv(InterpreterParser.TermDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code termDiv}
	 * labeled alternative in {@link InterpreterParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTermDiv(InterpreterParser.TermDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code termMult}
	 * labeled alternative in {@link InterpreterParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTermMult(InterpreterParser.TermMultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code termMult}
	 * labeled alternative in {@link InterpreterParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTermMult(InterpreterParser.TermMultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code termRest}
	 * labeled alternative in {@link InterpreterParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTermRest(InterpreterParser.TermRestContext ctx);
	/**
	 * Exit a parse tree produced by the {@code termRest}
	 * labeled alternative in {@link InterpreterParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTermRest(InterpreterParser.TermRestContext ctx);
	/**
	 * Enter a parse tree produced by the {@code termFact}
	 * labeled alternative in {@link InterpreterParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTermFact(InterpreterParser.TermFactContext ctx);
	/**
	 * Exit a parse tree produced by the {@code termFact}
	 * labeled alternative in {@link InterpreterParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTermFact(InterpreterParser.TermFactContext ctx);
	/**
	 * Enter a parse tree produced by the {@code factExpr}
	 * labeled alternative in {@link InterpreterParser#fact}.
	 * @param ctx the parse tree
	 */
	void enterFactExpr(InterpreterParser.FactExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code factExpr}
	 * labeled alternative in {@link InterpreterParser#fact}.
	 * @param ctx the parse tree
	 */
	void exitFactExpr(InterpreterParser.FactExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code factInt}
	 * labeled alternative in {@link InterpreterParser#fact}.
	 * @param ctx the parse tree
	 */
	void enterFactInt(InterpreterParser.FactIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code factInt}
	 * labeled alternative in {@link InterpreterParser#fact}.
	 * @param ctx the parse tree
	 */
	void exitFactInt(InterpreterParser.FactIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code factDbl}
	 * labeled alternative in {@link InterpreterParser#fact}.
	 * @param ctx the parse tree
	 */
	void enterFactDbl(InterpreterParser.FactDblContext ctx);
	/**
	 * Exit a parse tree produced by the {@code factDbl}
	 * labeled alternative in {@link InterpreterParser#fact}.
	 * @param ctx the parse tree
	 */
	void exitFactDbl(InterpreterParser.FactDblContext ctx);
	/**
	 * Enter a parse tree produced by the {@code factVar}
	 * labeled alternative in {@link InterpreterParser#fact}.
	 * @param ctx the parse tree
	 */
	void enterFactVar(InterpreterParser.FactVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code factVar}
	 * labeled alternative in {@link InterpreterParser#fact}.
	 * @param ctx the parse tree
	 */
	void exitFactVar(InterpreterParser.FactVarContext ctx);
}