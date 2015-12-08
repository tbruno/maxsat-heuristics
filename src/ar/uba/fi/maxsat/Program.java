package ar.uba.fi.maxsat;

import ar.uba.fi.maxsat.domain.SATProblem;
import ar.uba.fi.maxsat.domain.SATSolution;
import ar.uba.fi.maxsat.domain.strategies.SimpleGreedySolvingStrategy;
import ar.uba.fi.maxsat.input.CNFSATReader;
import ar.uba.fi.maxsat.input.ISATReader;

public class Program {
	

	public static void main(String[] args) {
		
		ISATReader reader = new CNFSATReader();		
		SATProblem problem = reader.readFile("input/datos4.cnf");
		
		problem.setStrategy(new SimpleGreedySolvingStrategy());
		SATSolution sol = problem.solve();
		sol.print();
	}

}
