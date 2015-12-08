package ar.uba.fi.maxsat.domain.strategies;

import java.util.HashSet;
import java.util.Set;

import ar.uba.fi.maxsat.domain.Clause;
import ar.uba.fi.maxsat.domain.SATProblem;
import ar.uba.fi.maxsat.domain.SATSolution;

public class SimpleGreedySolvingStrategy extends SolvingStrategy{

	@Override
	public SATSolution solve(SATProblem satProblem) {
		int[] occurrences = new int[satProblem.getAmountVariables()+1];
		
		for (Clause clause : satProblem.getClauses()){
			for(Integer element : clause.getElements()){
				if(element>0){
					occurrences[element]++; 
				}
				else
					occurrences[-1*element]--;					
			}
			
			
		}
		System.out.println(occurrences);
		Set<Integer> positiveValues = new HashSet<Integer>();
		for(int i=1 ; i<occurrences.length ; i++){
			if (occurrences[i]>0)
				positiveValues.add(i);
		}
		
		SATSolution solution = evaluateClauses( satProblem, positiveValues);
		return solution;
	}

}
