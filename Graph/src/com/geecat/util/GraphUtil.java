package com.geecat.util;

import java.util.Iterator;

import com.geecat.graphinterface.Graph;



public class GraphUtil {

	//compute the degree of vertex v.
	public static int degree(Graph G, int v){
		int degree = 0;
		
		Iterator<Integer> iter = G.adj(v);
		while(iter.hasNext()){
			degree++;
		}
		
		return degree;
	}
	
	//compute maximum degree.
	public static int maxDegree(Graph G){
		int max=0;
		for(int v = 0;v<G.V();v++){
			int deg = degree(G, v);
			if(deg>max){
				max=deg;
			}
		}
		return max;
	}
	
	//compute average degree.
	public static double averageDegree(Graph G){
		return 2.0*G.E()/G.V();
	}
	
	//count self loop.
	public static int numberOfSelfLoops(Graph G){
		int count = 0;
		for(int v = 0;v<G.V();v++){
			Iterator<Integer> iter = G.adj(v);
			while(iter.hasNext()){
				if(v==iter.next())count++;
			}
		}
		return count/2;
	}
	
	
	//string representation of the graph adjencency list.
	public static String toString(Graph G) {
		String s = G.V()+" vertices, "+G.E()+" edges\n";
		for(int v=0;v<G.V();v++){
			s += v+":-> ";
			Iterator<Integer> iter = G.adj(v);
			while(iter.hasNext()){
				s += iter.next()+ " -> ";
			}
			int i = s.lastIndexOf(" ->");
			s = s.substring(0,i);
			s+="\n";
		}
		return s;
	}
}
