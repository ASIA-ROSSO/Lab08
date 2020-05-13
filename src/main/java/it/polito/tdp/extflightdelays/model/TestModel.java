package it.polito.tdp.extflightdelays.model;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		
		model.creaGrafo(200);
		System.out.println(model.getGraph().vertexSet().size()+" "+model.getGraph().edgeSet().size()+"\n "+model.getGraph().edgeSet().toString());

	}

}
