package com.geecat.algorithms;

import java.util.Iterator;

import com.geecat.graphinterface.Graph;

public class Cycle {
	private boolean[] marked;
	private boolean hasCycle;

	/**
	 * Loop through all the vertices.
	 * @param G
	 */
	public Cycle(Graph G) {
		marked = new boolean[G.V()];
		for (int s = 0; s < G.V(); s++) {
			if (!marked[s]) {
				dfs(G, s, s);
			}
		}
	}

	/**
	 * If the vertex is marked and source and destination are not same that means there is a cysle.
	 * 
	 * @param G
	 * @param v source vertex
	 * @param u destination vertex.
	 */
	private void dfs(Graph G, int v, int u) {
		marked[v] = true;
		Iterator<Integer> iter = G.adj(v);
		while (iter.hasNext()) {
			int n = iter.next();
			if (!marked[n]) {
				dfs(G, n, v);
			} else if (n != u) {
				hasCycle = true;
			}
		}

	}

	public boolean hasCycle() {
		return hasCycle;
	}
}
