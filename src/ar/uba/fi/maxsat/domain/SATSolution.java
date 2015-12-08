package ar.uba.fi.maxsat.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SATSolution {
	
	public List<Clause> fullfilledClauses = null;
	public List<Clause> rejectedClauses = null;
	public Set<Integer> positiveVars = null;
	public int totalClauses = 0;
	
	public SATSolution(){
		positiveVars = new HashSet();
		fullfilledClauses = new ArrayList();
		rejectedClauses = new ArrayList();
	}
	
	public void print(){
		System.out.println("----------------------------------");
		System.out.println("Solution!!");
		System.out.println("Positive variables " + positiveVars);
		System.out.println("Amount clauses fullfilled: " + fullfilledClauses.size());
		System.out.println("Percentage clauses fullfilled: " + ((float) fullfilledClauses.size() / totalClauses));
//		System.out.println("Fullfilled clauses:");
//		for(Clause clause : fullfilledClauses){
//			clause.print();
//		}
//		System.out.println("Rejected clauses:");
//		for(Clause clause : rejectedClauses){
//			clause.print();
//		}
	}
}
