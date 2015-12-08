package ar.uba.fi.maxsat.domain.strategies;

import java.util.Set;

import ar.uba.fi.maxsat.domain.Clause;
import ar.uba.fi.maxsat.domain.SATProblem;
import ar.uba.fi.maxsat.domain.SATSolution;

public abstract class SolvingStrategy {

	public abstract SATSolution solve(SATProblem satProblem);

	protected SATSolution evaluateClauses(SATProblem satProblem, Set<Integer> positiveValues){
		SATSolution solution = new SATSolution();
		
		// Evaluate clauses
		for(Clause clause : satProblem.getClauses()){
			
			// Iterate through clause elements
			boolean found = false;
			for(Integer element : clause.getElements() ){				
				if(positiveValues.contains(element) 
						|| (element < 0 && !positiveValues.contains(-1*element))){					
					found = true;
					break;
				}
			}	
			
			if(found)
				solution.fullfilledClauses.add(clause);			
			else
				solution.rejectedClauses.add(clause);
		}			
		solution.totalClauses = satProblem.getAmountClauses();
		solution.positiveVars = positiveValues;
		return solution;
	}
	
}
