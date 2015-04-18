package com.geecat.algorithms;

import java.util.Iterator;
import java.util.LinkedList;

import com.geecat.graphinterface.Graph;

public class BreadthFirstSearch {
	private boolean[] marked;

	public BreadthFirstSearch(Graph G, int s) {
		marked = new boolean[G.V()];
		bfs(G, s);

	}

	private void bfs(Graph G, int s) {
		
		//Linked list is being used as queue.
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		// Queue<Integer> queue = new Queue<Integer>();
		marked[s] = true;
		list.add(s);
		while (!list.isEmpty()) {
			int v = list.remove();
			Iterator<Integer> iter = G.adj(v);
			while (iter.hasNext()) {
				int n = iter.next();
				if (!marked[n]) {
					marked[n] = true;
					list.add(n);
				}
			}
		}

	}
	
	public boolean hasPathTo(int w) {
		return marked[w];
	}

}
