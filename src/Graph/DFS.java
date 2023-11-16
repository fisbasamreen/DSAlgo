package src.Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DFS {
    int V;
    LinkedList<Integer> adj[];

    DFS (int v) {
        V= v;
        adj = new LinkedList[v];
        for(int i=0;i<v;i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void dfs(int s) {
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++) {
            visited[i] = false;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(s);

        while(!stack.isEmpty()) {
            s = stack.peek();
            stack.pop();

            if(!visited[s]) {
                System.out.print(s + " ");
                visited[s] = true;
            }

            for (int v : adj[s]) {
                if (!visited[v]) {
                    stack.push(v);
                }
            }
        }
    }

    public static void main(String args[])
    {
        DFS g = new DFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(
                "Following is Depth First Traversal "
                        + "(starting from vertex 2)");

        // Function call
        g.dfs(2);
    }
}
