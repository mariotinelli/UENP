/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;

/**
 *
 * @author Mario
 */
public class DescriptiveErrorListener  extends BaseErrorListener{
    
    public static DescriptiveErrorListener INSTANCE = new DescriptiveErrorListener();
    
    @Override
	public void syntaxError(final Recognizer<?, ?> recognizer, final Object offendingSymbol, 
                                final int line, final int charPositionInLine, 
                                final String msg, final RecognitionException e) 
        {
           
            String sourceName = recognizer.getInputStream().getSourceName();
            
            String s = "none";
            
            if (offendingSymbol instanceof CommonToken){
                
                CommonToken ct = (CommonToken) offendingSymbol;
                s = ct.getText();
                
            }
            
            System.out.println("Error in line: " + line + " char: " + charPositionInLine + " unexpected symbol: " + s);
            
        }
    
}
