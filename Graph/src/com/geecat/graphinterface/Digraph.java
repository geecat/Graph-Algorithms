package com.geecat.graphinterface;

import java.util.Iterator;

public interface Digraph {
	public int V();
	public int E();
	public void addEdge(int v, int e);
	public Iterator<Integer> adj(int v) ;
	public String toString();
	public Digraph reverse();
}
