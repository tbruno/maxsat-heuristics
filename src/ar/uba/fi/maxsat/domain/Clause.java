package ar.uba.fi.maxsat.domain;

import java.util.HashSet;
import java.util.Set;

public class Clause {
	
	Set<Integer> elements;
	
	public Clause(){
		elements = new HashSet<Integer>();
	}
	
	public void add(Integer element){
		elements.add(element);
	}
	
	public void print(){
		StringBuilder sb = new StringBuilder();
		for(Integer integer : elements){
			sb.append(integer + " ");
		}
		System.out.println(sb.toString());
	}
	
	public boolean contains(Integer element){
		return elements.contains(element);
	}
	
	public Set<Integer> getElements() {
		return elements;
	}

	public void setElements(Set<Integer> elements) {
		this.elements = elements;
	}
	
	
}
