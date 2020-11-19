package Week_12_assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

//Graph representation for De-Coupling
public class Graph {
	//정점, 간선, 인접리스트로 구현하기 위한
	private int V = 0;
	private int E=0;
	private List<Integer>[] adj;
	
	//graph 생성자, vertex를 직접 생성
	public Graph(int V) {
		this.V = V;
		adj = new List[V];
		for(int v=0;v<V;v++) {
			adj[v] = new LinkedList<Integer>();
		}
	}
	
	public Graph(File file) {	
		int index=0;
		try {
			file = new File("C:\\Users\\tjfru\\Desktop\\알고리즘 깃허브\\3-2Algorithm\\11차 과제\\"+file);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufRead = new BufferedReader(fileReader);
			String line = "";
			
			while((line = bufRead.readLine())!= null) {
				switch(index) {
					case 0:
						V=Integer.parseInt(line);
						adj = new List[V];
						
						//System.out.println(V);
						
						for(int v=0;v<V;v++) {
							adj[v] = new LinkedList<Integer>();
						}
						break;
					case 1:
						E=Integer.parseInt(line);
						//System.out.println(E);
						break;
					default:
						String[] tmp = line.split(" ");
						adj[Integer.parseInt(tmp[0])].add(Integer.parseInt(tmp[1]));
						//System.out.print(adj[Integer.parseInt(tmp[0])]+" ");
						adj[Integer.parseInt(tmp[1])].add(Integer.parseInt(tmp[0]));
						//System.out.println(adj[Integer.parseInt(tmp[1])]);
						break;
				}
				index++;
			}
			
			bufRead.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일을 읽어오는 도중에 오류가 발생했습니다.");
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	//정점에 대한 간선 추가
	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}
	
	//리스트 iterable
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	
	//정점 수 반환
	public int V() {
		return V;
	}
	
	//간선의 수 반환
	public int E() {
		for(List<Integer> list : adj) {
			E += list.size();
		}
		return E/2;
	}
	
	//주어진 정점의 차수
	public static int degree(Graph G, int v) {
		int degree = 0;
		for(int w : G.adj(v)) degree++;
		return degree;
	}
	
	//최대 차수
	public static int maxDegree(Graph G) {
		int max = 0;
		for(int v=0;v<G.V();v++) {
			if(degree(G,v)>max) {
				max=degree(G,v);
			}
		}
		return max;
	}
	
	//평균 차수
	public static double averageDegree(Graph G) {
		return 2.0 * G.E() /G.V();
	}
	
	//자기 순환 갯수
	public static int numberOfSelfLoops(Graph G) {
		int count =0;
		for(int v=0;v<G.V();v++) {
			for(int w : G.adj(v)) {
				if(v==w) count ++;
			}
		}
		return count/2;
	}
	
	//리스트 구조 문자열 반환
	public String toString() {
		String s = V +" vertices, "+ E + " edges\n";
		for(int v=0;v < V; v++) {
			s+=v+": ";
			for(int w : this.adj(v))
				s += w+" ";
			s+="\n";
		}
		return s;
	}
	
}
