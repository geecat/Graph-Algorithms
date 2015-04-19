package com.geecat.algorithms;

import java.util.TreeMap;

import com.geecat.graphinterface.Graph;
import com.geecat.lib.In;
import com.geecat.pojo.GraphMap;

/**
 * This graph client allows clients to define graph with String vertex name
 * instead of integer indices. It maintains instance variable st (a symbol table
 * that maps names to indices), keys (an array that map indices to names), and G
 * (a graph with integer vertex name) To build these data structure it makes two
 * passes through the graph definition -Each line has a string and list of
 * adjacent strings separated by the delimiter sp.
 * 
 * @author Geecat
 * 
 */
public class SymbolGraph {
	private TreeMap<String, Integer> st; // string->key
	private String[] keys; // key->string
	private Graph G; // the graph

	public SymbolGraph(String stream, String sp) {
		st = new TreeMap<String, Integer>();
		In in = new In(stream); //first pass build the indexO
		while (in.hasNextLine()) {
			String[] a = in.readLine().split(sp);
			for (int i = 0; i < a.length; i++) {
				if (!st.containsKey(a[i])) {
					st.put(a[i], st.size());
				}
			}
		}

		keys = new String[st.size()];
		for (String name : st.keySet()) {
			keys[st.get(name)] = name;
		}
		G = new GraphMap(st.size());
		in = new In(stream); //second pass build the graph.
		while (in.hasNextLine()) {
			String[] a = in.readLine().split(sp);
			int v = st.get(a[0]);
			for (int i = 1; i < a.length; i++) {
				G.addEdge(v, st.get(a[i]));
			}
		}
	}

	public boolean contains(String s) {
		return st.containsKey(s);
	}

	public int index(String s) {
		return st.get(s);
	}

	public String name(int v) {
		return keys[v];
	}

	public Graph G() {
		return G;
	}

}
