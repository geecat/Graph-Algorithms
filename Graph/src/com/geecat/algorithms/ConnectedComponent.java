package com.geecat.algorithms;

import java.util.Iterator;

import com.geecat.graphinterface.Graph;

public class ConnectedComponent {

	private int count = 0;
	private int[] id;
	private boolean[] marked;

	public ConnectedComponent(Graph G) {
		this.id = new int[G.V()];
		this.marked = new boolean[G.V()];
		for (int s = 0; s < G.V(); s++) {
			if (!marked[s]) {
				dfs(G, s);
				count++;
			}
		}
	}

	private void dfs(Graph G, int v) {

		marked[v] = true;
		id[v] = count;
		Iterator<Integer> iter = G.adj(v);
		while (iter.hasNext()) {
			int n = iter.next();
			if (!marked[n]) {
				dfs(G, n);
			}
		}

	}

	public boolean connected(int v, int w) {
		return id[v] == id[w];
	}

	public int count() {
		return count;
	}

	public int id(int v) {
		return id[v];
	}
}
