package com.geecat.main;

import java.io.File;

import com.geecat.algorithms.TwoColor;
import com.geecat.lib.In;
import com.geecat.pojo.GraphMap;

public class TwoColorMain {

	public static void main(String[] args) {

		In in = new In(
				new File(
						"E:\\Ravi\\Lecture Video\\Coursera\\Algorithms Part 2\\1. Undirected Graphs\\tineyG.txt"));

		GraphMap gm = new GraphMap(in);

		TwoColor tc = new TwoColor(gm);
		System.out.println(tc.isBipartite());
	}

}
