package ar.uba.fi.maxsat.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import ar.uba.fi.maxsat.domain.Clause;
import ar.uba.fi.maxsat.domain.SATProblem;

public class CNFSATReader implements ISATReader {

	@Override
	public SATProblem readFile(String path) {
		
		SATProblem sat = new SATProblem();		
		int amountClauses = 0;
		
		try{			
			BufferedReader br = new BufferedReader(new FileReader(path));
		
			try {			
			    String line = br.readLine();
		
			    while (line != null) {
			    	if (line.startsWith("c")){
			    		// Ignore line
			    	}
			    	else if (line.startsWith("p")){
			    		// Problem definition
			    		String[] defElements = line.split(" ");
			    		sat.setAmountVariables(Integer.parseInt(defElements[2]));
			    		amountClauses = Integer.parseInt(defElements[3]);
			    	}
			    	else if (line.trim() != "" ){
			    		String[] clauseElements = line.split(" ");
			    		Clause clause = new Clause();
			    		// Assumes 0 is always last. Not exactly like CNF states
			    		for(int i=0; i < clauseElements.length - 1; i++){
			    			clause.add(Integer.parseInt(clauseElements[i]));
			    		}
			    		
			    		if(Integer.parseInt(clauseElements[clauseElements.length-1]) != 0)
			    			throw new RuntimeException("Should have ended with 0");
			    		
			    		sat.addClause(clause);
			    	}			       		
			        line = br.readLine();			       
			    }
			    
			} finally {
			    br.close();
			}
		}
		catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}
		
		assert sat.getAmountClauses() == amountClauses;
		return sat;
	}
	
	
	
}
