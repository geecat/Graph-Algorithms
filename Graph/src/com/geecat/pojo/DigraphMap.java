package com.geecat.pojo;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.geecat.graphinterface.Digraph;
import com.geecat.lib.In;

public class DigraphMap implements Digraph{
	private final int V;
	private int E;
	
	HashMap<Integer,ArrayList<Integer>> adj ;//= new HashMap<>();
	
	public DigraphMap(int v){
		this.V=v;
		this.E=0;
		adj= new HashMap<Integer,ArrayList<Integer>>();
		//instead of initilizing the map with all the element , at the time of adding element we can do get and check if null then create new one.
		for (int i = 0; i < V; i++){
			adj.put(i, new ArrayList<Integer>());
		}
			
	}
	
	public DigraphMap(In in) {
		this(in.readInt());
		int E = in.readInt();
		for(int i = 0;i<E;i++){
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v, w);
		}
	}
	
	public void addEdge(int v, int e) {
		adj.get(v).add(e);
		//adj.get(v).add(0, e);
		E++;
	}
	
	public Digraph reverse(){
		Digraph R = new DigraphMap(V);
		for(int v=0;v<V;v++){
			Iterator<Integer> iter = this.adj(v);
			while(iter.hasNext()){
				R.addEdge(iter.next(), v);
			}
		}
		
		return R;
	}
	public int V() {
		return V;

	}

	public int E() {
		return E;

	}
	
	public Iterator<Integer> adj(int v) {

		return adj.get(v).iterator();
	}

	public String toString() {
		String s = V+" vertices, "+E+" edges\n";
		for(int v=0;v<V;v++){
			//s += v+":-> ";
			s += v+": ";
			Iterator<Integer> iter = this.adj(v);
			while(iter.hasNext()){
				//s += iter.next()+ " -> ";
				s += iter.next()+ " ";
			}
			//int i = s.lastIndexOf(" ->");
			//s = s.substring(0,i);
			s+="\n";
		}
		return s;
	}
	
	public static void main(String[] args){
		File file = new File("D:\\Work\\Workspaces\\wss2\\Graph-Algorithms\\Graph\\resource\\tinyDG.txt");
		In in = new In(file);
		DigraphMap digraph = new DigraphMap(in);
		System.out.println(digraph.toString());
	}
}
