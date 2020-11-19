package Week_12_assignment;

import java.util.Iterator;
import java.util.Stack;

public class DepthFirstPaths {
	//vertex 방문 여부를 확인하여 
	private boolean[] marked;
	private int[] edgeTo;
	private int s;
	
	//초기값 설정
	public DepthFirstPaths(Graph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		dfs(G,s);
	}

	//v에서 모든 점들을 방문하며 edgeTo배열에 기록하는 핵심 알고리즘
	private void dfs(Graph G, int v) {
		marked[v] = true;
		for(int w : G.adj(v)) {
			if(!marked[w]) {
				edgeTo[w] = v;
				dfs(G,w);
			}
		}
	}
	
	// s -> v 까지의 path를 Stack에 담아 return
	public Iterable<Integer> pathTo(int v){
		if(!marked[v]) return null;
		Stack<Integer> st = new Stack<Integer>();
		for(int i=v; i!=s; i=edgeTo[i]) {
			st.push(i);
		}
		st.push(s);
		
		return st;
	}
}
