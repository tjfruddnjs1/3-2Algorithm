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
	//����, ����, ��������Ʈ�� �����ϱ� ����
	private int V = 0;
	private int E=0;
	private List<Integer>[] adj;
	
	//graph ������, vertex�� ���� ����
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
			file = new File("C:\\Users\\tjfru\\Desktop\\�˰��� �����\\3-2Algorithm\\11�� ����\\"+file);
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
			System.out.println("������ �о���� ���߿� ������ �߻��߽��ϴ�.");
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	//������ ���� ���� �߰�
	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}
	
	//����Ʈ iterable
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	
	//���� �� ��ȯ
	public int V() {
		return V;
	}
	
	//������ �� ��ȯ
	public int E() {
		for(List<Integer> list : adj) {
			E += list.size();
		}
		return E/2;
	}
	
	//�־��� ������ ����
	public static int degree(Graph G, int v) {
		int degree = 0;
		for(int w : G.adj(v)) degree++;
		return degree;
	}
	
	//�ִ� ����
	public static int maxDegree(Graph G) {
		int max = 0;
		for(int v=0;v<G.V();v++) {
			if(degree(G,v)>max) {
				max=degree(G,v);
			}
		}
		return max;
	}
	
	//��� ����
	public static double averageDegree(Graph G) {
		return 2.0 * G.E() /G.V();
	}
	
	//�ڱ� ��ȯ ����
	public static int numberOfSelfLoops(Graph G) {
		int count =0;
		for(int v=0;v<G.V();v++) {
			for(int w : G.adj(v)) {
				if(v==w) count ++;
			}
		}
		return count/2;
	}
	
	//����Ʈ ���� ���ڿ� ��ȯ
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
