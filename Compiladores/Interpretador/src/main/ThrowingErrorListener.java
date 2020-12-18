/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;

/**
 *
 * @author Mario
 */
public class ThrowingErrorListener extends BaseErrorListener {
    
    public static final ThrowingErrorListener INSTANCE = new ThrowingErrorListener();
    
        @Override
	public void syntaxError(final Recognizer<?, ?> recognizer, final Object offendingSymbol, 
                                final int line, final int charPositionInLine, 
                                final String msg, final RecognitionException e) 
                throws ParseCancellationException {
            //System.out.println("Esperava: " + e.getCtx() + " Recebi: " + e.getOffendingToken());
            throw new ParseCancellationException("Error in line " + line + " character " + charPositionInLine + " " + msg);
        }
}
