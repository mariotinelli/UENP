/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import parser.InterpreterListener;
import parser.InterpreterParser;

/**
 *
 * @author Mario
 */
public class Listener implements InterpreterListener{

    @Override
    public void enterProg(InterpreterParser.ProgContext ctx) {}

    @Override
    public void exitProg(InterpreterParser.ProgContext ctx) {}

    @Override
    public void enterLineInput(InterpreterParser.LineInputContext ctx) {}

    @Override
    public void exitLineInput(InterpreterParser.LineInputContext ctx) {}

    @Override
    public void enterLineOutput(InterpreterParser.LineOutputContext ctx) {}

    @Override
    public void exitLineOutput(InterpreterParser.LineOutputContext ctx) {}

    @Override
    public void enterLineExpr(InterpreterParser.LineExprContext ctx) {}

    @Override
    public void exitLineExpr(InterpreterParser.LineExprContext ctx) {
        if (ctx.expr().val != null){
            System.out.println(ctx.expr().val);
        }
    }

    @Override
    public void enterLineAtrb(InterpreterParser.LineAtrbContext ctx) {}

    @Override
    public void exitLineAtrb(InterpreterParser.LineAtrbContext ctx) {}

    @Override
    public void enterInput(InterpreterParser.InputContext ctx){
        if (!SymbolsTable.getInstance().memory.containsKey(ctx.VAR().getText())){
            System.out.print(">>> ");
            Scanner sc = new Scanner(System.in);
            Symbol s = new Symbol();
            Object temp = null;

            switch (ctx.TYPE().getText()) {
                case "int":
                    try {
                        temp = sc.nextInt();
                        s.setType(Type.t_int);
                        s.setValue(temp);
                        SymbolsTable.getInstance().addSymbol(ctx.VAR().getText(), s);
                    } catch (InputMismatchException e) {
                        System.out.println("Erro: era esperado um valor inteiro");
                    } 
                    break;

                case "double":
                    try {
                        temp = sc.nextDouble();
                        s.setType(Type.t_double);
                        s.setValue(temp);
                        SymbolsTable.getInstance().addSymbol(ctx.VAR().getText(), s);
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Erro: era esperado um valor double");
                    } 
                    break;
                case "string":
                    try {
                        temp = sc.nextLine();
                        s.setType(Type.t_string);
                        s.setValue(temp);
                        SymbolsTable.getInstance().addSymbol(ctx.VAR().getText(), s);
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Erro: era esperado um valor string");
                    }
                    break;
                default:
                    break;
            }
        }
        else {
            try {
                throw new Exception();
            } catch (Exception ex) {
                System.out.println("A váriavel " + ctx.VAR().getText() + " já existe!!");
            }
        }
    }

    @Override
    public void exitInput(InterpreterParser.InputContext ctx) {}

    @Override
    public void enterOutVar(InterpreterParser.OutVarContext ctx) {}

    @Override
    public void exitOutVar(InterpreterParser.OutVarContext ctx) {
        
        try {
            System.out.println(SymbolsTable.getInstance().getSymbol(ctx.VAR().getText()).getValue());
        } catch (NullPointerException e){
            System.out.println("Variável " + ctx.VAR().getText() + " não existe!!");
        }
    }

    @Override
    public void enterOutExpr(InterpreterParser.OutExprContext ctx) {}

    @Override
    public void exitOutExpr(InterpreterParser.OutExprContext ctx) {
        System.out.println(ctx.expr().val);
    }

    @Override
    public void enterOutStr(InterpreterParser.OutStrContext ctx) {}

    @Override
    public void exitOutStr(InterpreterParser.OutStrContext ctx) {
        System.out.println(ctx.STR().getText());
    }

    @Override
    public void enterAtrbExpr(InterpreterParser.AtrbExprContext ctx) {}

    @Override
    public void exitAtrbExpr(InterpreterParser.AtrbExprContext ctx) {
        Symbol s = new Symbol();
        if (!SymbolsTable.getInstance().memory.containsKey(ctx.VAR().getText())){
            switch (ctx.TYPE().getText()) {
                case "int":
                    if (ctx.expr().val instanceof Integer){
                        Integer i = (Integer) ctx.expr().val;
                        s.setType(Type.t_int);
                        s.setValue(i);
                        SymbolsTable.getInstance().addSymbol(ctx.VAR().getText(), s);
                    }else if (ctx.expr().val instanceof Double){
                        System.out.println("Erro: perca de precisão -> nao é possivel gravar um double em uma variável int!");
                    }else if (ctx.expr().val instanceof String){
                        System.out.println("Erro: nao é possivel gravar uma string em uma variável int!");
                    }   break;
                case "double":
                    if (ctx.expr().val instanceof Double){
                        Double d = Double.parseDouble(ctx.expr().val+"");
                        s.setType(Type.t_double);
                        s.setValue(d);
                        SymbolsTable.getInstance().addSymbol(ctx.VAR().getText(), s);
                    }else if (ctx.expr().val instanceof String){
                        System.out.println("Erro: nao é possivel gravar uma string em uma variável double!");
                    }   break;
                case "string":
                    if (ctx.expr().val instanceof Integer){
                        System.out.println("Erro: nao é possivel gravar um inteiro em uma variável string!");
                    }else if (ctx.expr().val instanceof Double){
                        System.out.println("Erro: nao é possivel gravar um double em uma variável string!");
                    }   break;
                default:
                    break;
            }
        }
        else {
            try {
                throw new Exception();
            } catch (Exception ex) {
                System.out.println("A váriavel " + ctx.VAR().getText() + " já existe!!");
            }
        }
    }

    @Override
    public void enterAtrbStr(InterpreterParser.AtrbStrContext ctx) {}

    @Override
    public void exitAtrbStr(InterpreterParser.AtrbStrContext ctx) {
        Symbol s = new Symbol();
        if (!SymbolsTable.getInstance().memory.containsKey(ctx.VAR().getText())){
            if (ctx.TYPE().getText().equals("string")){
                if (ctx.STR().getText() instanceof String){
                    String str = ctx.STR().getText();
                    s.setType(Type.t_string);
                    s.setValue(str);
                    SymbolsTable.getInstance().addSymbol(ctx.VAR().getText(), s);
                }
            }
        }else {
            try {
                throw new Exception();
            } catch (Exception ex) {
                System.out.println("A váriavel " + ctx.VAR().getText() + " já existe!!");
            }
        }
    }

    @Override
    public void enterExprSub(InterpreterParser.ExprSubContext ctx) {}

    @Override
    public void exitExprSub(InterpreterParser.ExprSubContext ctx) {
        Double a = Double.parseDouble(ctx.expr1.val+"");
        Double b = Double.parseDouble(ctx.term().val+"");
        if (ctx.expr1.val instanceof Integer && ctx.term().val instanceof Integer){
            Integer sub = a.intValue() - b.intValue();
            ctx.val = sub;
        }
        else {
            ctx.val = a - b;
        }
    }

    @Override
    public void enterExprSum(InterpreterParser.ExprSumContext ctx) {}

    @Override
    public void exitExprSum(InterpreterParser.ExprSumContext ctx) {
        Double a = Double.parseDouble(ctx.expr1.val+"");
        Double b = Double.parseDouble(ctx.term().val+"");
        if (ctx.expr1.val instanceof Integer && ctx.term().val instanceof Integer){
            Integer sum = a.intValue() + b.intValue();
            ctx.val = sum;
        }
        else {
            ctx.val = a + b;
        }
    }

    @Override
    public void enterExprTerm(InterpreterParser.ExprTermContext ctx) {}

    @Override
    public void exitExprTerm(InterpreterParser.ExprTermContext ctx) {
        ctx.val = ctx.term().val;
    }

    @Override
    public void enterTermDiv(InterpreterParser.TermDivContext ctx) {}

    @Override
    public void exitTermDiv(InterpreterParser.TermDivContext ctx) {
        Double a = Double.parseDouble(ctx.term1.val+"");
        Double b = Double.parseDouble(ctx.fact().val+"");
        if (ctx.term1.val instanceof Integer && ctx.fact().val instanceof Integer){
            Integer div = a.intValue() / b.intValue();
            ctx.val = div;
        }
        else {
            ctx.val = a / b;
        }
    }

    @Override
    public void enterTermMult(InterpreterParser.TermMultContext ctx) {}

    @Override
    public void exitTermMult(InterpreterParser.TermMultContext ctx) {
        Double a = Double.parseDouble(ctx.term1.val+"");
        Double b = Double.parseDouble(ctx.fact().val+"");
        if (ctx.term1.val instanceof Integer && ctx.fact().val instanceof Integer){
            Integer mult = a.intValue() * b.intValue();
            ctx.val = mult;
        }
        else {
            ctx.val = a * b;
        }
    }

    @Override
    public void enterTermRest(InterpreterParser.TermRestContext ctx) {}

    @Override
    public void exitTermRest(InterpreterParser.TermRestContext ctx) {
        Double a = Double.parseDouble(ctx.term1.val+"");
        Double b = Double.parseDouble(ctx.fact().val+"");
        if (ctx.term1.val instanceof Integer && ctx.fact().val instanceof Integer){
            Integer rest = a.intValue() % b.intValue();
            ctx.val = rest;
            
        }
        else {
            ctx.val = a % b;
        }
    }

    @Override
    public void enterTermFact(InterpreterParser.TermFactContext ctx) {}

    @Override
    public void exitTermFact(InterpreterParser.TermFactContext ctx) {
        ctx.val = ctx.fact().val;
    }

    @Override
    public void enterFactExpr(InterpreterParser.FactExprContext ctx) {}

    @Override
    public void exitFactExpr(InterpreterParser.FactExprContext ctx) {
        ctx.val = ctx.expr().val;
    }

    @Override
    public void enterFactInt(InterpreterParser.FactIntContext ctx) {}

    @Override
    public void exitFactInt(InterpreterParser.FactIntContext ctx) {
        ctx.val = Integer.parseInt(ctx.INT().getText());
    }

    @Override
    public void enterFactDbl(InterpreterParser.FactDblContext ctx) {}

    @Override
    public void exitFactDbl(InterpreterParser.FactDblContext ctx) {
        ctx.val = Double.parseDouble(ctx.DBL().getText());
    }

    @Override
    public void enterFactVar(InterpreterParser.FactVarContext ctx) {}

    @Override
    public void exitFactVar(InterpreterParser.FactVarContext ctx) {
        try {
            ctx.val = SymbolsTable.getInstance().getSymbol(ctx.VAR().getText()).getValue();
        } catch (NullPointerException e){
            System.out.println("Váriavel " + ctx.VAR().getText() + " não existe!");
        } 
    }

    @Override
    public void visitTerminal(TerminalNode node) {}

    @Override
    public void visitErrorNode(ErrorNode node) {}

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {}

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {} 
}
