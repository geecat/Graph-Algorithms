package com.geecat.algorithms;

import java.util.Iterator;

import com.geecat.graphinterface.Graph;

/**
 * Can the vertices of given graph be assigned one of two colors in such a way
 * that no edge connects vertices of the same color? i.e. Is the graph
 * bipartite?
 * 
 * @author Geecat
 * 
 */
public class TwoColor {
	private boolean[] marked;
	private boolean[] color;
	private boolean isTwoColorable = true;

	/**
	 * 
	 * @param G
	 */
	public TwoColor(Graph G) {
		marked = new boolean[G.V()];
		color = new boolean[G.V()];
		for (int s = 0; s < G.V(); s++) {
			if (!marked[s]) {
				dfs(G, s);
			}
		}
	}

	/**
	 * If the vertices is not marked, do a dfs, and change the adjacent color to
	 * opposite of the current. If the vertices is marked and if adjacent vertex
	 * has same color then it is not bipartite.
	 * 
	 * @param G
	 * @param v
	 */
	private void dfs(Graph G, int v) {
		marked[v] = true;
		Iterator<Integer> iter = G.adj(v);
		while (iter.hasNext()) {
			int n = iter.next();
			if (!marked[n]) {
				color[n] = !color[v];
				dfs(G, n);
			} else if (color[n] == color[v]) {
				isTwoColorable = false;
			}
		}

	}

	public boolean isBipartite() {
		return isTwoColorable;
	}

}
