package Week_12_assignment;

import java.util.Iterator;
import java.util.Stack;

public class DepthFirstPaths {
	//vertex �湮 ���θ� Ȯ���Ͽ� 
	private boolean[] marked;
	private int[] edgeTo;
	private int s;
	
	//�ʱⰪ ����
	public DepthFirstPaths(Graph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		dfs(G,s);
	}

	//v���� ��� ������ �湮�ϸ� edgeTo�迭�� ����ϴ� �ٽ� �˰���
	private void dfs(Graph G, int v) {
		marked[v] = true;
		for(int w : G.adj(v)) {
			if(!marked[w]) {
				edgeTo[w] = v;
				dfs(G,w);
			}
		}
	}
	
	// s -> v ������ path�� Stack�� ��� return
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
