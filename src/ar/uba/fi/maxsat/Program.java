package ar.uba.fi.maxsat;

import ar.uba.fi.maxsat.domain.SATProblem;
import ar.uba.fi.maxsat.domain.SATSolution;
import ar.uba.fi.maxsat.domain.strategies.RandomSolvingStrategy;
import ar.uba.fi.maxsat.input.CNFSATReader;
import ar.uba.fi.maxsat.input.ISATReader;

public class Program {
	

	public static void main(String[] args) {
		
		ISATReader reader = new CNFSATReader();		
		SATProblem problem = reader.readFile("input/datos3.cnf");
		
		problem.setStrategy(new RandomSolvingStrategy());
		SATSolution sol = problem.solve();
		sol.print();
	}

}
