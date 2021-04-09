/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Mário
 */
public class Visitor extends InterpreterBaseVisitor<Object>{

    @Override
    public Object visitLineExpr(InterpreterParser.LineExprContext ctx) {
        if (visit(ctx.expr()) != null){
            System.out.println(visit(ctx.expr()));
        }
        return super.visitLineExpr(ctx);
    }

    @Override
    public Object visitIf(InterpreterParser.IfContext ctx) {
        Boolean c1 = (Boolean) visit(ctx.c1);
        if (c1) {
            return visit(ctx.b1);
        }
        return null;
    }

    @Override
    public Object visitIfElseIf(InterpreterParser.IfElseIfContext ctx) {
        Boolean c1 = (Boolean) visit(ctx.c1);
        Boolean c2 = (Boolean) visit(ctx.c2);
        if (c1) {
            return visit(ctx.b1);
        }
        else if (c2){
            return visit(ctx.b2);
        }
        return null;
    }

    @Override
    public Object visitIfElseIfElse(InterpreterParser.IfElseIfElseContext ctx) {
        Boolean c1 = (Boolean) visit(ctx.c1);
        Boolean c2 = (Boolean) visit(ctx.c2);
        if (c1) {
            return visit(ctx.b1);
        }
        else if (c2){
            return visit(ctx.b2);
        } else {
            return visit(ctx.b3);
        }
    }

    @Override
    public Object visitIfElse(InterpreterParser.IfElseContext ctx) {
        Boolean c1 = (Boolean) visit(ctx.c1);
        if (c1) {
            return visit(ctx.b1);
        } else {
            return visit(ctx.b2);
        }
    }

    @Override
    public Object visitBlockStmt(InterpreterParser.BlockStmtContext ctx) {
        return visit(ctx.prog());
    }
    
    @Override
    public Object visitCondRelop(InterpreterParser.CondRelopContext ctx) {
        Object a = visit(ctx.expr(0));
        Object b = visit(ctx.expr(1));
        
        if (ctx.RELOP().getText().equals("==")){
            return  Objects.equals(a, b);  
        } else if (ctx.RELOP().getText().equals("!=")){
            return !Objects.equals(a, b); 
        } else {
            if (a instanceof Integer && b instanceof Integer){
                switch(ctx.RELOP().getText()){
                    case "<" : return (Object) ( (Integer) a <  (Integer) b );  
                    case "<=": return (Object) ( (Integer) a <= (Integer) b );
                    case ">" : return (Object) ( (Integer) a >  (Integer) b );
                    case ">=": return (Object) ( (Integer) a >= (Integer) b );
                    default  : System.out.println("Relop inexistente!"); break;
                } 
            } else if (a instanceof Double && b instanceof Double){
                switch(ctx.RELOP().getText()){
                    case "<" : return (Object) ( (Double) a <  (Double) b );  
                    case "<=": return (Object) ( (Double) a <= (Double) b );
                    case ">" : return (Object) ( (Double) a >  (Double) b );
                    case ">=": return (Object) ( (Double) a >= (Double) b ); 
                    default  : System.out.println("Relop inexistente!"); break;
                }
            } else if (a instanceof Integer && b instanceof Double){
                switch(ctx.RELOP().getText()){
                    case "<" : return (Object) ( (Integer) a <  (Double) b );  
                    case "<=": return (Object) ( (Integer) a <= (Double) b );
                    case ">" : return (Object) ( (Integer) a >  (Double) b );
                    case ">=": return (Object) ( (Integer) a >= (Double) b ); 
                    default  : System.out.println("Relop inexistente!"); break;
                }
            } else if (a instanceof Double && b instanceof Integer){
                switch(ctx.RELOP().getText()){
                    case "<" : return (Object) ( (Double) a <  (Integer) b );  
                    case "<=": return (Object) ( (Double) a <= (Integer) b );
                    case ">" : return (Object) ( (Double) a >  (Integer) b );
                    case ">=": return (Object) ( (Double) a >= (Integer) b ); 
                    default  : System.out.println("Relop inexistente!"); break;
                }
            }
        }
        return super.visitCondRelop(ctx);
    }

    @Override
    public Object visitCondRelopStr(InterpreterParser.CondRelopStrContext ctx) {
        String a = ctx.STR(0).getText();
        String b = ctx.STR(1).getText();
        switch(ctx.RELOP().getText()){
            case "<" : System.out.println("Não é possivel comparar se uma string é menor que outra"); System.exit(0);
            case "<=": System.out.println("Não é possivel comparar se uma string é menor ou igual que outra"); System.exit(0);
            case ">" : System.out.println("Não é possivel comparar se uma string é maior que outra"); System.exit(0);
            case ">=": System.out.println("Não é possivel comparar se uma string é maior ou igual que outra"); System.exit(0);
            case "==": return  Objects.equals(a, b);
            case "!=": return !Objects.equals(a, b); 
            default  : System.out.println("Relop inexistente!"); break;
        }

        return super.visitCondRelopStr(ctx); 
    }

    @Override
    public Object visitCondExpr(InterpreterParser.CondExprContext ctx) {
        Object value = visit(ctx.expr());
        return value;
    }

    @Override
    public Object visitInput(InterpreterParser.InputContext ctx) {
        Object value = null;
        
        if (!SymbolsTable.getInstance().memory.containsKey(ctx.VAR().getText())){
            
            System.out.print(">>> ");
            Scanner sc = new Scanner(System.in);
            Symbol s = new Symbol();
            
            switch (ctx.TYPE().getText()) {
                
                case "int":
                    try {
                        value = sc.nextInt();
                        s.setType(Type.t_int);
                        s.setValue(value);
                        SymbolsTable.getInstance().addSymbol(ctx.VAR().getText(), s);
                    } catch (InputMismatchException e) {
                        System.out.println("Erro: era esperado um valor inteiro...");
                        System.exit(0);
                    } 
                    break;
                    
                case "double":
                    try {
                        value = sc.nextDouble();
                        s.setType(Type.t_double);
                        s.setValue(value);
                        SymbolsTable.getInstance().addSymbol(ctx.VAR().getText(), s);
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Erro: era esperado um valor double...");
                        System.exit(0);
                    } 
                    break;
                    
                case "string":
                    try {
                        value = sc.nextLine();
                        s.setType(Type.t_string);
                        s.setValue(value);
                        SymbolsTable.getInstance().addSymbol(ctx.VAR().getText(), s);
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Erro: era esperado um valor string...");
                        System.exit(0);
                    }
                    break;
                    
                default:
                    System.out.println("Tipo não reconhecido.");
                    System.exit(0);
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
        return value;
    }
       
    @Override
    public Object visitOutVar(InterpreterParser.OutVarContext ctx) {
        Object value = null;
        try {      
            value = SymbolsTable.getInstance().memory.get(ctx.VAR().getText()).getValue();
            System.out.println(value);
        } catch (NullPointerException e){
            System.out.println("Variável " + ctx.VAR().getText() + " não existe!!");
        }

        return value;
    }

    @Override
    public Object visitOutExpr(InterpreterParser.OutExprContext ctx) {
        Object value = visit(ctx.expr());
        System.out.println(value);
        return value;
    }

    @Override
    public Object visitOutStr(InterpreterParser.OutStrContext ctx) {
        Object value = ctx.STR().getText();
        System.out.println(value);
        return value;
    }
    
    @Override
    public Object visitAtrbExpr(InterpreterParser.AtrbExprContext ctx) {
        Object value = visit(ctx.expr());
        Symbol s = new Symbol();
        if (!SymbolsTable.getInstance().memory.containsKey(ctx.VAR().getText())){
            switch (ctx.TYPE().getText()) {
                case "int":
                    if (value instanceof Integer){
                        Integer i = (Integer) value;
                        s.setType(Type.t_int);
                        s.setValue(i);
                        SymbolsTable.getInstance().addSymbol(ctx.VAR().getText(), s);
                        return value;
                    } else if (value instanceof Double){
                        System.out.println("Erro: perca de precisão -> nao é possivel gravar um double em uma variável int!");
                    } break;
                    
                case "double":

                    Double d = Double.parseDouble(value+"");
                    s.setType(Type.t_double);
                    s.setValue(d);
                    SymbolsTable.getInstance().addSymbol(ctx.VAR().getText(), s);
                    break;
                    
                case "string":
                    if (value instanceof Integer){
                        System.out.println("Erro: nao é possivel gravar um inteiro em uma variável string!");
                    } else if (value instanceof Double){
                        System.out.println("Erro: nao é possivel gravar um double em uma variável string!");
                    } break;
                    
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
        return value;
    }

    @Override
    public Object visitAtrbStr(InterpreterParser.AtrbStrContext ctx) {
        Object value = ctx.STR().getText();
        Symbol s = new Symbol();
        if (!SymbolsTable.getInstance().memory.containsKey(ctx.VAR().getText())){
            if (ctx.TYPE().getText().equals("string")){
                if (value instanceof String){
                    String str = ctx.STR().getText();
                    s.setType(Type.t_string);
                    s.setValue(str);
                    SymbolsTable.getInstance().addSymbol(ctx.VAR().getText(), s);
                    return value;
                }
            }else if (ctx.TYPE().getText().equals("int")){
                System.out.println("Erro: nao é possivel gravar uma string em uma variável int!");
            }else if (ctx.TYPE().getText().equals("double")){
                System.out.println("Erro: nao é possivel gravar uma string em uma variável double!");
            }
        }else {
            try {
                throw new Exception();
            } catch (Exception ex) {
                System.out.println("A váriavel " + ctx.VAR().getText() + " já existe!!");
            }
        }
        return value;
    }
          
    @Override
    public Object visitExprSub(InterpreterParser.ExprSubContext ctx) {
        Object a = visit(ctx.expr1);
        Object b = visit(ctx.term());
        
        if (a instanceof Integer && b instanceof Integer){
            return (Integer) a - (Integer) b;
        }
        
        return Double.parseDouble(a+"") - Double.parseDouble(b+"");
    }

    @Override
    public Object visitExprSum(InterpreterParser.ExprSumContext ctx) {
        Object a = visit(ctx.expr1);
        Object b = visit(ctx.term());
        if (a instanceof Integer && b instanceof Integer){
            return (Integer) a + (Integer) b;
        }

        return Double.parseDouble(a+"") + Double.parseDouble(b+"");
    }

    @Override
    public Object visitTermMult(InterpreterParser.TermMultContext ctx) {
        Object a = visit(ctx.term1);
        Object b = visit(ctx.fact());
        if (a instanceof Integer && b instanceof Integer){
            return (Integer) a * (Integer) b;
        }

        return Double.parseDouble(a+"") * Double.parseDouble(b+"");
    }

    @Override
    public Object visitTermDiv(InterpreterParser.TermDivContext ctx) {
        Object a = visit(ctx.term1);
        Object b = visit(ctx.fact());
        if (a instanceof Integer && b instanceof Integer){
            return (Integer) a / (Integer) b;
        }

        return Double.parseDouble(a+"") / Double.parseDouble(b+"");
    }

    @Override
    public Object visitTermRest(InterpreterParser.TermRestContext ctx) {
        Object a = visit(ctx.term1);
        Object b = visit(ctx.fact());
        if (a instanceof Integer && b instanceof Integer){
            return (Integer) a % (Integer) b;
        }

        return Double.parseDouble(a+"") % Double.parseDouble(b+"");
    }
    
    @Override
    public Object visitExprTerm(InterpreterParser.ExprTermContext ctx) {
        return visit(ctx.term());
    }

    @Override
    public Object visitTermFact(InterpreterParser.TermFactContext ctx) {
        return visit(ctx.fact());
    }

    @Override
    public Object visitFactInt(InterpreterParser.FactIntContext ctx) {
        return Integer.parseInt(ctx.INT().getText());
    }

    @Override
    public Object visitFactDbl(InterpreterParser.FactDblContext ctx) {
        return Double.parseDouble(ctx.DBL().getText());
    }

    @Override
    public Object visitFactVar(InterpreterParser.FactVarContext ctx) {
        try {
            return SymbolsTable.getInstance().getSymbol(ctx.VAR().getText()).getValue();
        } catch (NullPointerException e){
            System.out.println("Váriavel " + ctx.VAR().getText() + " não existe!");
        }
        
        return null;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
