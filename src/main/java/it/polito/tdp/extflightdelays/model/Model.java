package it.polito.tdp.extflightdelays.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {

	
	// grafo semplice non orientato e pesato
	private Graph<Airport, DefaultWeightedEdge> graph;
	private List<Airport> aeroporti;
	private Map<Integer, Airport> airportIdMap;
	private ExtFlightDelaysDAO dao;

	private List<VoliDistanzaMedia> voli;

	public Model() {

		dao = new ExtFlightDelaysDAO();
		
		this.aeroporti = dao.loadAllAirports(); // mi dà una lista che contiene tutti gli aeroporti
		
		// creo l'IdMap
		this.airportIdMap = new HashMap<>();
		for (Airport a : this.aeroporti) {
			airportIdMap.put(a.getId(), a);
		}

	}

	public void creaGrafo(Integer min) {
		this.graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		// 1) CREAZIONE DEI VERTICI
		Graphs.addAllVertices(this.graph, this.aeroporti);
		
		voli = dao.getVoli(airportIdMap, min);
		
		
		//creo gli archi e gli attribuisco il peso
		for (VoliDistanzaMedia v : voli) {
			if (!graph.containsEdge(v.getOriginAirport(), v.getDestinationAirport())) {
				Graphs.addEdge(graph, v.getOriginAirport(), v.getDestinationAirport(), v.getDistanzaMedia());
				
			} else {
				double media = (graph.getEdgeWeight(graph.getEdge(v.getOriginAirport(), v.getDestinationAirport()))
						+ v.getDistanzaMedia()) / 2; // aggiorno la media

				this.graph.setEdgeWeight(v.getOriginAirport(), v.getDestinationAirport(), media);
			}
		}
		
		/*
		for(DefaultEdge d : this.graph.edgeSet()) {
			if(this.graph.getEdgeWeight(d)<min) {
				this.graph.removeEdge(d);
			}
		}*/
		System.out.println(this.graph);
		System.out.format("Grafo caricato con %d vertici %d archi", this.graph.vertexSet().size(),
				this.graph.edgeSet().size());
	}

	public Graph<Airport, DefaultWeightedEdge> getGraph() {
		return graph;
	}
	
	public List<VoliDistanzaMedia> getVoli(){
		return voli;
	}

}
