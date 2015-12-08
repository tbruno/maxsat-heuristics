package ar.uba.fi.maxsat.domain.strategies;

import ar.uba.fi.maxsat.domain.SATProblem;
import ar.uba.fi.maxsat.domain.SATSolution;

public abstract class SolvingStrategy {

	public abstract SATSolution solve(SATProblem satProblem);

	
}
