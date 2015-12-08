package ar.uba.fi.maxsat.domain.strategies;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import ar.uba.fi.maxsat.domain.Clause;
import ar.uba.fi.maxsat.domain.SATProblem;
import ar.uba.fi.maxsat.domain.SATSolution;

public class RandomSolvingStrategy extends SolvingStrategy {

	@Override
	public SATSolution solve(SATProblem satProblem) {
		SATSolution solution = new SATSolution();
		
		
		
		// Init values o variables according to randomness
		Random random = new Random();
		Set<Integer> positiveValues = new HashSet<Integer>();
		for(int i=0; i < satProblem.getAmountClauses(); i++){
			if(random.nextDouble()<0.5){
				positiveValues.add(i);
			}
		}
		solution.positiveVars = positiveValues;
		
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
		return solution;
	}

}
