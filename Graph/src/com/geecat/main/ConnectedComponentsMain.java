package com.geecat.main;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.geecat.algorithms.ConnectedComponent;
import com.geecat.lib.In;
import com.geecat.pojo.GraphMap;

public class ConnectedComponentsMain {

	public static void main(String[] args) {
		In in = new In(new File("E:\\Ravi\\Lecture Video\\Coursera\\Algorithms Part 2\\1. Undirected Graphs\\tineyG.txt"));
		//Graph g = new Graph(in);
		//System.out.println(g.V());
		//System.out.println(g.toString());
		GraphMap gm = new GraphMap(in);
		System.out.println(gm.V());
		System.out.println(gm.toString());
		ConnectedComponent cc = new ConnectedComponent(gm);
		int m = cc.count();
		System.out.println(m +" components");
		
		HashMap<Integer,ArrayList<Integer>> ccArray = new HashMap<Integer,ArrayList<Integer>>();
		
		/*for (int i = 0; i < m; i++){
			ccArray.put(i, new ArrayList<Integer>());
		}
		
		for(int v=0;v<gm.V();v++){
			
			int component = cc.id(v);
			ArrayList<Integer> list = ccArray.get(component);
			
			list.add(v);
		}*/
		
		for(int v=0;v<gm.V();v++){
			
			int component = cc.id(v);
			ArrayList<Integer> list = ccArray.get(component);
			if(list==null){
				list = new ArrayList<Integer>();
				ccArray.put(component, list);
			}
			list.add(v);
		}
		
		//
		for(int v = 0; v<m;v++){
			ArrayList<Integer> list = ccArray.get(v);
			
			Iterator<Integer> iter = list.iterator();
			while (iter.hasNext()) {
				int n = iter.next();
				System.out.print(n +" ");
			}
			System.out.println();
		}
		

	}

}
