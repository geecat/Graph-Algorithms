package com.geecat.algorithms;

import java.io.File;

import com.geecat.graphinterface.Digraph;

public class Topological {
	private Iterable<Integer> order;

	public Topological(Digraph G) {
		DirectedCyle cycleFinder = new DirectedCyle(G);
		if (!cycleFinder.hasCycle()) {
			DepthFirstOrder dfs = new DepthFirstOrder(G);
			order = dfs.reversePost();
		}
	}

	public Iterable<Integer> order() {
		return order;
	}

	public boolean isDAG() {
		return order != null;
	}

	public static void main(String[] args) {
		File file = new File("D:\\Work\\Workspaces\\wss2\\Graph-Algorithms\\Graph\\resource\\jobs.txt");
		
		SymbolDigraph sg = new SymbolDigraph(file.toString(), "/");
		System.out.println(sg.G().toString());
		Topological top = new Topological(sg.G());
		
		for(int v: top.order){
			System.out.println(sg.name(v));
		}
	}

}
