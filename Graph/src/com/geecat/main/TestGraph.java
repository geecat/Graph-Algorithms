package com.geecat.main;

import java.io.File;

import com.geecat.algorithms.BreadthFirstPaths;
import com.geecat.lib.In;
import com.geecat.pojo.GraphMap;

public class TestGraph {

	public static void main(String args[]){
		In in = new In(new File("E:\\Ravi\\Lecture Video\\Coursera\\Algorithms Part 2\\1. Undirected Graphs\\tineyG.txt"));
		//Graph g = new Graph(in);
		//System.out.println(g.V());
		//System.out.println(g.toString());
		GraphMap gm = new GraphMap(in);
		System.out.println(gm.V());
		System.out.println(gm.toString());
		
		//DepthFirstSearch dfs = new DepthFirstSearch(gm, 0);
		//System.out.println(dfs.count());
		
		//DepthFirstPath dfsPath = new DepthFirstPath(gm, 0);
		//System.out.println(dfsPath.pathTo(4));
		
		BreadthFirstPaths bfs = new BreadthFirstPaths(gm, 0);
		System.out.println(bfs.pathTo(3));
	}
}
