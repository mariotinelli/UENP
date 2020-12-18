/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.sun.org.apache.xml.internal.utils.DefaultErrorHandler;
import java.awt.HeadlessException;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parser.InterpreterLexer;
import parser.InterpreterParser;

/**
 *
 * @author Mario
 */
public class RunREPL {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()){
            String input = s.nextLine();
            parse(input);
        }
    }

    private static void parse(String text) throws RecognitionException {
        CharStream input = new ANTLRInputStream(text+"\n");
        InterpreterLexer lexer = new InterpreterLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        InterpreterParser parser = new InterpreterParser(tokens);
        
//        parser.removeErrorListeners();
//        parser.addErrorListener(ThrowingErrorListener.INSTANCE);
//        parser.setErrorHandler(new BailErrorStrategy());
        
        lexer.removeErrorListeners();
        lexer.addErrorListener(DescriptiveErrorListener.INSTANCE);
        parser.removeErrorListeners();
        parser.addErrorListener(DescriptiveErrorListener.INSTANCE);
        
        parser.setErrorHandler(new DefaultErrorStrategy());
        
        try {
            
            Listener listener = new Listener();
            ParseTreeWalker walker = new ParseTreeWalker();
            ParseTree tree = parser.prog(); 
            walker.walk(listener, tree);
        } catch (ParseCancellationException e){
            System.out.println(e.getMessage());
        }

        
    }
}
