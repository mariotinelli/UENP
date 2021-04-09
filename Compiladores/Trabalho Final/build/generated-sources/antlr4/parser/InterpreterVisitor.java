// Generated from C:\Users\Mário\Documents\NetBeansProjects\Interpretador\grammar\parser\Interpreter.g4 by ANTLR 4.6

package parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link InterpreterParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface InterpreterVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link InterpreterParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(InterpreterParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lineInput}
	 * labeled alternative in {@link InterpreterParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLineInput(InterpreterParser.LineInputContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lineOutput}
	 * labeled alternative in {@link InterpreterParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLineOutput(InterpreterParser.LineOutputContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lineExpr}
	 * labeled alternative in {@link InterpreterParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLineExpr(InterpreterParser.LineExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lineAtrb}
	 * labeled alternative in {@link InterpreterParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLineAtrb(InterpreterParser.LineAtrbContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lineIf}
	 * labeled alternative in {@link InterpreterParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLineIf(InterpreterParser.LineIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterpreterParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput(InterpreterParser.InputContext ctx);
	/**
	 * Visit a parse tree produced by the {@code outVar}
	 * labeled alternative in {@link InterpreterParser#output}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutVar(InterpreterParser.OutVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code outExpr}
	 * labeled alternative in {@link InterpreterParser#output}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutExpr(InterpreterParser.OutExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code outStr}
	 * labeled alternative in {@link InterpreterParser#output}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutStr(InterpreterParser.OutStrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atrbExpr}
	 * labeled alternative in {@link InterpreterParser#atrb}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtrbExpr(InterpreterParser.AtrbExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atrbStr}
	 * labeled alternative in {@link InterpreterParser#atrb}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtrbStr(InterpreterParser.AtrbStrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprSub}
	 * labeled alternative in {@link InterpreterParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSub(InterpreterParser.ExprSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprSum}
	 * labeled alternative in {@link InterpreterParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSum(InterpreterParser.ExprSumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprTerm}
	 * labeled alternative in {@link InterpreterParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprTerm(InterpreterParser.ExprTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code termDiv}
	 * labeled alternative in {@link InterpreterParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermDiv(InterpreterParser.TermDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code termMult}
	 * labeled alternative in {@link InterpreterParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermMult(InterpreterParser.TermMultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code termRest}
	 * labeled alternative in {@link InterpreterParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermRest(InterpreterParser.TermRestContext ctx);
	/**
	 * Visit a parse tree produced by the {@code termFact}
	 * labeled alternative in {@link InterpreterParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermFact(InterpreterParser.TermFactContext ctx);
	/**
	 * Visit a parse tree produced by the {@code factExpr}
	 * labeled alternative in {@link InterpreterParser#fact}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactExpr(InterpreterParser.FactExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code factInt}
	 * labeled alternative in {@link InterpreterParser#fact}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactInt(InterpreterParser.FactIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code factDbl}
	 * labeled alternative in {@link InterpreterParser#fact}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactDbl(InterpreterParser.FactDblContext ctx);
	/**
	 * Visit a parse tree produced by the {@code factVar}
	 * labeled alternative in {@link InterpreterParser#fact}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactVar(InterpreterParser.FactVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if}
	 * labeled alternative in {@link InterpreterParser#ifstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(InterpreterParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifElseIf}
	 * labeled alternative in {@link InterpreterParser#ifstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElseIf(InterpreterParser.IfElseIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfElseIfElse}
	 * labeled alternative in {@link InterpreterParser#ifstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElseIfElse(InterpreterParser.IfElseIfElseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfElse}
	 * labeled alternative in {@link InterpreterParser#ifstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElse(InterpreterParser.IfElseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condExpr}
	 * labeled alternative in {@link InterpreterParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondExpr(InterpreterParser.CondExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condRelopStr}
	 * labeled alternative in {@link InterpreterParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondRelopStr(InterpreterParser.CondRelopStrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condRelop}
	 * labeled alternative in {@link InterpreterParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondRelop(InterpreterParser.CondRelopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockStmt}
	 * labeled alternative in {@link InterpreterParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStmt(InterpreterParser.BlockStmtContext ctx);
}