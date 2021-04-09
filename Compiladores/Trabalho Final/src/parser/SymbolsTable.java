/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.util.HashMap;

/**
 *
 * @author Mario
 */
public class SymbolsTable {
    
    HashMap<String, Symbol> memory;
    
    protected SymbolsTable(){
        memory = new HashMap();
    }
    
    private static SymbolsTable INSTANCE;
    
    public static SymbolsTable getInstance(){
        if (INSTANCE == null)
            INSTANCE = new SymbolsTable();
        return INSTANCE;
    }
    
    public void addSymbol(String symbol, Symbol value){
        memory.put(symbol, value);
    }
    
    public Symbol getSymbol(String symbol){
        if (memory.containsKey(symbol)){
            return memory.get(symbol);
        }
        return null;
    }
  
}
