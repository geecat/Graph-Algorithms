package com.geecat.algorithms;

import java.util.Iterator;
import java.util.Stack;

import com.geecat.graphinterface.Digraph;

/**
 * This class adds to our standard recursive dfs() a boolean array
 * onStack[] to keep track of the vertices for which the recursive call
 * has not completed. When it finds an edge v->w to a vertex w that is on the 
 * stack, it has discovered a directed cycle, which it can recover by following 
 * edgeTo[] links.
 * 
 * @author Geecat
 *
 */
public class DirectedCyle {
	private boolean[] marked;
	private int[] edgeTo;
	private Stack<Integer> cycle; // vertices on cycle if any exists
	private boolean[] onStack; // vertices on recusive call stack;

	public DirectedCyle(Digraph G) {

		onStack = new boolean[G.V()];
		edgeTo = new int[G.V()];
		marked = new boolean[G.V()];
		for (int v = 0; v < G.V(); v++) {
			if (!marked[v])
				dfs(G, v);
		}

	}

	private void dfs(Digraph G, int v) {

		onStack[v] = true;//v is set to true on entry 
		marked[v] = true;
		Iterator<Integer> iter = G.adj(v);
		while (iter.hasNext()) {
			int n = iter.next();
			if (this.hasCycle()) {
				return;
			} else if (!marked[n]) {
				edgeTo[n] = v;
				dfs(G, n);
			} else if (onStack[n]) {
				//if the node which we are visiting is already on the stack that means there is cycle present
				cycle = new Stack<Integer>();
				for (int x = v; x != n; x = edgeTo[x]) {
					cycle.push(x);
				}
				cycle.push(n);
				cycle.push(v);
			}
			
		}
		
		onStack[v] = false; // v is set to false on exit.
	}

	public boolean hasCycle() {

		return cycle != null;
	}

	public Iterable<Integer> cycle() {
		return cycle();
	}
}
