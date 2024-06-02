#include <iostream>
#include <vector>
using namespace std;

const int N = 1e5 + 10;
vector<int> g[N]; // Adjacency list representation of the graph
bool visited[N];  // Array to mark visited nodes during DFS

// Depth First Search (DFS) function to check for cycles in the graph
bool dfs(int vertex, int parent)
{
    visited[vertex] = true;
    // Mark the current vertex as visited
    bool isLoopExists = false; // Flag to indicate if a loop is found in the current DFS traversal

    // Traverse all neighbors of the current vertex
    for (int child : g[vertex])
    {
        // Skip the parent vertex to avoid going back to the parent
        if (visited[child] && child == parent)
            continue;
        // If the neighbor is already visited and not the parent, then a cycle is found
        if (visited[child])
            return true;

        // Recursively call DFS for unvisited neighbors
        isLoopExists |= dfs(child, vertex);
    }

    return isLoopExists;
}

// Function to check if a given undirected graph contains a cycle
bool cycleInGraph(int n)
{
    fill(visited, visited + n + 1, false); // Initialize visited array to mark all vertices as unvisited

    // Iterate through each vertex and call DFS to check for cycles
    for (int i = 1; i <= n; ++i)
    {
        if (!visited[i] && dfs(i, -1))
        {                // Call DFS only for unvisited vertices
            return true; // If a cycle is found in any DFS traversal, return true
        }
    }

    return false; // If no cycle is found after checking all vertices, return false
}

int main()
{
    int n, m;
    cin >> n >> m; // Input the number of vertices (n) and edges (m)

    // Input edges and construct the graph
    for (int i = 0; i < m; ++i)
    {
        int u, v;
        cin >> u >> v;
        g[u].push_back(v); // Add edge u->v
        g[v].push_back(u); // Add edge v->u (for undirected graph)
    }

    // Check if the graph contains a cycle and print the result
    if (cycleInGraph(n))
    {
        cout << "The graph contains a cycle." << endl;
    }
    else
    {
        cout << "The graph does not contain a cycle." << endl;
    }

    return 0;
}
