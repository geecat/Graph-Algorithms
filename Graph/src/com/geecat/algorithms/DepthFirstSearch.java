package com.geecat.algorithms;

import java.util.Iterator;

import com.geecat.graphinterface.Graph;



public class DepthFirstSearch {

	private boolean[] marked;
	private int count;

	public DepthFirstSearch(Graph G, int s) {
		marked = new boolean[G.V()];
		dfs(G, s);
	}

	private void dfs(Graph G, int v) {

		marked[v] = true;
		count++;
		Iterator<Integer> iter = G.adj(v);
		while (iter.hasNext()) {
			int n = iter.next();
			if (!marked[n]) {
				dfs(G, n);
			}
		}

	}

	public boolean marked(int w) {
		return marked[w];
	}

	public int count() {
		return count;
	}
}
