package Week_12_assignment;

import java.io.File;
import java.util.Stack;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("DFS.txt");
		Graph graph = new Graph(file);
		
		DepthFirstPaths dfs = new DepthFirstPaths(graph,0);
		
		System.out.println(graph.toString());
		System.out.println(dfs.pathTo(3));
	}
}
