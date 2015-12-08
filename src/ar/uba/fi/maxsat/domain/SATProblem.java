package ar.uba.fi.maxsat.domain;

import java.util.ArrayList;
import java.util.List;

import ar.uba.fi.maxsat.domain.strategies.SolvingStrategy;

public class SATProblem {
	
	private int amountVariables;
	private SolvingStrategy strategy;
	
	// As contained in file.
	List<Clause> clauses = null;
	

	public SATProblem(){
		clauses = new ArrayList<Clause>();
	}
	
	public int getAmountVariables() {
		return amountVariables;
	}
	public void setAmountVariables(int amountVariables) {
		this.amountVariables = amountVariables;
	}
	
	public void addClause(Clause clause){
		clauses.add(clause);
	}
	
	public int getAmountClauses(){
		return clauses.size();
	}
	
	public List<Clause> getClauses() {
		return clauses;
	}
	
	public void setStrategy(SolvingStrategy strategy){
		this.strategy = strategy;
	}
	
	public SATSolution solve(){
		return strategy.solve(this);
	}
	
	public void print(){
		System.out.println("Amount of vars " + amountVariables);
		System.out.println("------");
		for(Clause clause : clauses){
			clause.print();
		}
	}

}
