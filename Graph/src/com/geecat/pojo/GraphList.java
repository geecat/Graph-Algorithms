package com.geecat.pojo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.geecat.graphinterface.Graph;
import com.geecat.lib.In;

public class GraphList implements Graph{
	
	private final int V;
	private int E;
	
	private List<Integer>[] adj;

	public GraphList(int V) {
		this.V = V;
		this.E=0;
		
		adj = (List<Integer>[])new List[V];
        for (int i = 0; i < V; i++) 
            adj[i] = new ArrayList<Integer>();
	}

	public GraphList(In in) {
		this(in.readInt());
		int E = in.readInt();
		for(int i = 0;i<E;i++){
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v, w);
		}
	}

	public int V() {
		return V;

	}

	public int E() {
		return E;

	}

	public void addEdge(int v, int e) {
		adj[v].add(e);
		adj[e].add(v);
		E++;
	}

	public Iterator<Integer> adj(int v) {

		return adj[v].iterator();
	}

	public String toString() {
		String s = V+" vertices, "+E+" edges\n";
		for(int v=0;v<V;v++){
			s += v+":-> ";
			Iterator<Integer> iter = this.adj(v);
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
