package com.geecat.main;

import java.io.File;

import com.geecat.algorithms.Cycle;
import com.geecat.lib.In;
import com.geecat.pojo.GraphMap;

public class CycleMain {

	public static void main(String[] args) {
		In in = new In(new File("E:\\Ravi\\Lecture Video\\Coursera\\Algorithms Part 2\\1. Undirected Graphs\\tineyG.txt"));
		
		GraphMap gm = new GraphMap(in);
		
		Cycle c = new Cycle(gm);
		System.out.println(c.hasCycle());

	}

}
