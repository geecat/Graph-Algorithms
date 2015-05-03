package com.geecat.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

import com.geecat.graphinterface.Graph;

public class BreadthFirstPaths {
	private boolean[] marked;
	private int[] edgeTo;
	private final int s;

	public BreadthFirstPaths(Graph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
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
					edgeTo[n] = v;
					marked[n] = true;
					list.add(n);
				}
			}
		}

	}
	
	public boolean hasPathTo(int w) {
		return marked[w];
	}

	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v))return null;
		//Stack<Integer> path = new Stack<Integer>();//this does not work.use deque instead.
		Deque<Integer> path = new ArrayDeque<Integer>();
		for(int x = v;x!=s;x=edgeTo[x]){
			path.push(x);
		}
		path.push(s);
		return path;
		
	}
}
