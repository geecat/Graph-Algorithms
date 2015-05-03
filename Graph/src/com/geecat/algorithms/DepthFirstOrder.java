package com.geecat.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

import com.geecat.graphinterface.Digraph;

/**
 * This class enables clients to iterate through the vertices in various order
 * defined by depth-first search. This ability is very useful in the development
 * of advanced digraph-processing algorithms, because the recursive nature of
 * the search enables us to prove properties of the computation.
 * 
 * @author Geecat
 * 
 */
public class DepthFirstOrder {

	private boolean[] marked;
	private LinkedList<Integer> pre;
	private LinkedList<Integer> post;
	private Deque<Integer> reversePost ;

	public DepthFirstOrder(Digraph G) {
		pre = new LinkedList<Integer>();
		post = new LinkedList<Integer>();
		reversePost = new ArrayDeque<Integer>();
		marked = new boolean[G.V()];
		for (int v = 0; v < G.V(); v++) {
			if (!marked[v])
				dfs(G, v);
		}
	}

	private void dfs(Digraph G, int v) {
		pre.add(v);
		marked[v] = true;
		Iterator<Integer> iter = G.adj(v);
		while (iter.hasNext()) {
			int n = iter.next();
			if (!marked[n]) {
				dfs(G, n);
			}
		}
		post.add(v);
		reversePost.push(v);
	}

	public Iterable<Integer> pre() {
		return pre;
	}

	public Iterable<Integer> post() {
		return post;
	}

	public Iterable<Integer> reversePost() {
		/**
		 * Reverse postorder in a DAG is topological sort.
		 * Consider any edge v->w. One of the following three cases must hold when dfs(v) is called.
		 * 1. dfs(w) has already been called and has returned (it is not on stack) (w is marked.)
		 * 2. dfs(w) has not yet been called(w is unmarked), so v->w will cause dfs(w) to be called (and return),
		 *  either direcly or indirectly before dfs(v) returns.
		 * 3. dfs(w) has been called and not yet return when dfs(v) is called. The key to the proof is that this
		 *    case is impossible in a DAG, because the recursive call chain implies a path from w to v and v->w 
		 *    would complete a directed cycle.
		 *   
		 *  In the two possible cases, dfs(w) is done before dfs(v), so w appears before v in postorder and 
		 *  after v in reverse postorder. Thus each edge v->w points from a vertex earlier in the order to
		 *  a vertex later in the order, as desired.   
		 */
		return reversePost;
	}

}
