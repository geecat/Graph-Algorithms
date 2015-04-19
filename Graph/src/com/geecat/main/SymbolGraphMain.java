package com.geecat.main;

import java.io.File;
import java.util.Iterator;
import java.util.Scanner;

import com.geecat.algorithms.SymbolGraph;
import com.geecat.graphinterface.Graph;

public class SymbolGraphMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//In in = new In(new File("D:\\Work\\Workspaces\\wss2\\Graph-Algorithms\\Graph\\resource\\routes.txt"));
		//File file = new File("D:\\Work\\Workspaces\\wss2\\Graph-Algorithms\\Graph\\resource\\routes.txt");
		File file = new File("D:\\Work\\Workspaces\\wss2\\Graph-Algorithms\\Graph\\resource\\movies.txt");
		//In in = new In(new File("D:\\Work\\Workspaces\\wss2\\Graph-Algorithms\\Graph\\resource\\movies.txt"));
		
		//for routes
		//SymbolGraph sg = new SymbolGraph(file.toString(), " ");
		//for movies
		SymbolGraph sg = new SymbolGraph(file.toString(), "/");
		Graph G = sg.G();
		Scanner scan = new Scanner(System.in);
		//cin
		while(scan.hasNext()){
			String source = scan.nextLine();
			
			Iterator<Integer> iter = G.adj(sg.index(source));
			while (iter.hasNext()) {
				System.out.println("  "+sg.name(iter.next()));
			}
		}
		
	}

}
