package com.geecat.algorithms;

import java.io.File;
import java.util.Scanner;

import com.geecat.graphinterface.Graph;

/**
 * 
 * @author Geecat
 *
 */
public class DegreeOfSeparation {

	public static void main(String[] args) {

		File file = new File("D:\\Work\\Workspaces\\wss2\\Graph-Algorithms\\Graph\\resource\\movies.txt");
		
		SymbolGraph sg = new SymbolGraph(file.toString(), "/");
		Graph G = sg.G();
		Scanner scan = new Scanner(System.in);
		//cin
		String source = scan.nextLine();
		if(!sg.contains(source)){
			System.out.println(source+" Not in database");
			return;
		}
		int s = sg.index(source);
		BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);
		
		while(scan.hasNext()){
			String sink = scan.nextLine();
			if(sg.contains(sink)){
				int t = sg.index(sink);
				if(bfs.hasPathTo(t)){
					for(int v : bfs.pathTo(t)){
						System.out.println("  "+sg.name(v));
					}
				}else{
					System.out.println("Not Connected");
				}
			}
			else{
				System.out.println("Not in Database!");
			}
			
		}
	}

}
