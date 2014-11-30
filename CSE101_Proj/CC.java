package c101;

import java.util.ArrayList;


public class CC {
	private boolean[] visited;
	//private int[] ID;
	private int count;
	//private Graph g;
	private ArrayList<ArrayList<Integer>> list;
	public CC(Graph g){
		int numofV = g.getNumberOfVertices();
		visited = new boolean[numofV];
		//ID = new int[numofV];
		this.list = g.list;
		//this.g = g;
		for(int i = 0; i < numofV; ++i){
			if(!visited[i]){
				DFS( i);
				count++;
			}
		}
	}
	private void DFS(int i) {
		// TODO Auto-generated method stub
		visited[i] = true;
		//ID[i] = count;
		//int[][] mat = g.getEdgeMatrix();
		ArrayList<Integer> curr = list.get(i);
		for(int j : curr){
            if(visited[j]==false)
            	DFS(j);
         }
//		for(int j = 0; j < mat.length; ++j)
//		{
//				if(mat[i][j] == 1 && visited[j] == false)
//					DFS(g,j);
//					
//					
//		}
	}
	public int getCount(){
		return count;
	}
}
