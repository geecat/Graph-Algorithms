package com.geecat.algorithms;

import java.util.Iterator;
import java.util.Stack;

import com.geecat.graphinterface.Graph;

public class DepthFirstPath {

	private boolean[] marked;
	private int[] edgeTo;
	private final int s;

	public DepthFirstPath(Graph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		dfs(G, s);
	}

	private void dfs(Graph G, int v) {

		marked[v] = true;
		Iterator<Integer> iter = G.adj(v);
		while (iter.hasNext()) {
			int n = iter.next();
			if (!marked[n]) {
				edgeTo[n]=v;
				dfs(G, n);
			}
		}

	}

	public boolean hasPathTo(int w) {
		return marked[w];
	}

	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v))return null;
		Stack<Integer> path = new Stack<Integer>();
		for(int x = v;x!=s;x=edgeTo[x]){
			path.push(x);
		}
		path.push(s);
		return path;
		
	}
}
