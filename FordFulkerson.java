/* Implements: Ford Fulkerson Algorithm for the given graph.
 * Reference: http://www.geeksforgeeks.org/ford-fulkerson-algorithm-for-maximum-flow-problem*/
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.LinkedList;
 
class NetraBhadkamkarFordFulkerson
{
    static final int V = 8; 
    int[] flow = new int[60];
    boolean bfs(int rGraph[][], int s, int t, int parent[])
    {
        boolean visited[] = new boolean[V];
        for(int i=0; i<V; ++i)
            visited[i]=false;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = true;
        parent[s]=-1;
        while (queue.size()!=0)
        {
            int u = queue.poll();
 
            for (int v=0; v<V; v++)
            {
                if (visited[v]==false && rGraph[u][v] > 0)
                {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }
 
        return (visited[t] == true);
    }
 
     int fordFulkerson(int graph[][], int s, int t)
    {
        int u, v;
 
      
	 	int queue = 0;
        int rGraph[][] = new int[V][V];
 
        for (u = 0; u < V; u++)
            for (v = 0; v < V; v++)
                rGraph[u][v] = graph[u][v];
 
        
        int parent[] = new int[V];
 
        int max_flow = 0;  
        while (bfs(rGraph, s, t, parent))
        {
           
            int path_flow = Integer.MAX_VALUE;
            int z = 0;
            for (v=t; v!=s; v=parent[v])
            {
                u = parent[v];
                flow[z] = v;
					z++;
                path_flow = Math.min(path_flow, rGraph[u][v]);
            }
            flow[z]=s;
			 System.out.println("The flow in " +queue );
			 for(int x=z; x>0; x--)
				{
					System.out.print(+flow[x]+ "-" );
	            }
				System.out.println(+flow[0]);
				System.out.println("The Maximum flow in this iteration is "+path_flow);
            for (v=t; v != s; v=parent[v])
            {
                u = parent[v];
                rGraph[u][v] -= path_flow;
                rGraph[v][u] += path_flow;
            }
 
            // Add path flow to overall flow
            queue++;
            max_flow += path_flow;
        }
 
        // Return the overall flow
        return max_flow;
    }
 
    // Driver program to test above functions
    public static void main (String[] args) throws java.lang.Exception
    {
        // Let us create a graph shown in the above example
        int graph[][] =new int[][] { {0, 16, 11, 0, 0, 15, 0, 0},
        							 {0, 0, 6, 7, 8, 0, 0, 0},
        							 {0, 0, 0, 0, 12, 0, 0, 0},
        							 {0, 0, 0, 0, 0, 0, 0, 18},
        							 {0, 0, 0, 6, 0, 0, 8, 10},
        							 {0, 0, 4, 0, 5, 0, 6, 0},
        							 {0, 0, 0, 0, 0, 0, 0, 13},
        							 {0, 0, 0, 0, 0, 0, 0, 0}
                                   };
        NetraBhadkamkarFordFulkerson m = new NetraBhadkamkarFordFulkerson();
 
        System.out.println("The maximum possible flow is " +
                           m.fordFulkerson(graph, 0, 7));
 
    }
}