package ar.uba.fi.maxsat.domain.strategies;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import ar.uba.fi.maxsat.domain.Clause;
import ar.uba.fi.maxsat.domain.SATProblem;
import ar.uba.fi.maxsat.domain.SATSolution;

public class RandomSolvingStrategy extends SolvingStrategy {

	private static final int AMOUNT_ITERATIONS = 10;

	@Override
	public SATSolution solve(SATProblem satProblem) {	
		SATSolution maxSolution = new SATSolution();
		Random random = new Random();
		
		for(int it=0;it<AMOUNT_ITERATIONS;it++){
						
			// Init values o variables according to randomness		
			Set<Integer> positiveValues = new HashSet<Integer>();
			for(int i=0; i < satProblem.getAmountVariables(); i++){
				if(random.nextDouble()<0.5){
					positiveValues.add(i);
				}
			}
			
			SATSolution solution = evaluateClauses(satProblem, positiveValues);
			
			if(solution.fullfilledClauses.size() > maxSolution.fullfilledClauses.size())
				maxSolution = solution;
		}
		
		return maxSolution;
	}

}
