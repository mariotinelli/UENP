/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import parser.DescriptiveErrorListener;
import java.io.IOException;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.InterpreterLexer;
import parser.InterpreterParser;
import parser.Visitor;

/**
 *
 * @author Mario
 */
public class RunREPL {
    
    public static void main(String[] args) throws RecognitionException, IOException {
        System.out.println("Iniciando o interpretador\n\n*************");
        ANTLRInputStream input = new ANTLRFileStream("input.txt");
        InterpreterLexer lexer = new InterpreterLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        InterpreterParser parser = new InterpreterParser(tokens);  

        lexer.removeErrorListeners();
        parser.removeErrorListeners();
                        
        lexer.addErrorListener(DescriptiveErrorListener.INSTANCE);
        parser.addErrorListener(DescriptiveErrorListener.INSTANCE);

        
        DefaultErrorStrategy ee = new DefaultErrorStrategy();
        parser.setErrorHandler(ee);
                
        
        try {
            ParseTree tree = parser.prog();
            Visitor eval = new Visitor();
            eval.visit(tree);
        } catch (ParseCancellationException e){
            System.out.println("Ops."+e.getMessage());
        }
    }
}
