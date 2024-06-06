import java.util.ArrayList;

public class possiblePaths {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // stacks is used to track the current

    // normal dfs------------->
    public static void createGraph(ArrayList<Edge> graph[]) {
        // Create ArrayLists for each vertex
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        // Add edges to the graph
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));
        graph[6].add(new Edge(6, 5));
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        System.out.print(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }

    // time complexity--> 0(v^v)
    // modified dfs---------------->
    public static void printAllPath(ArrayList<Edge>[] graph, boolean vis[], int curr, String path, int tar) {

        // base case:
        if (curr == tar) {
            System.out.println(path);
            return;
        }

        for (int i = 0; i < graph[curr].size(); i++) {

            Edge e = graph[curr].get(i);

            if (!vis[e.dest]) {
                vis[curr] = true;
                printAllPath(graph, vis, e.dest, path + e.dest, tar);
                vis[curr] = false;
            }

        }

    }

    public static void main(String args[]) {
        int V = 7;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        int src = 0, tar = 5;
        printAllPath(graph, new boolean[V], src, "0", tar);
    }
}
