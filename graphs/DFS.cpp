#include <iostream>
#include <vector>
using namespace std;

const int N = 1e5 + 10;

vector<int> g[N];
bool visited[N];

void dfs(int vertex)
{
    // take action on vertex after entering the vertex
    // if
    visited[vertex] = true;
    for (int child : g[vertex])
    {
        if (visited[child])
            continue;
        // take action on child before entering the child node
        dfs(child);

        // take action on child after exiting child node
    }
    // take action on vertex before exiting the vertex
}

int main()
{
    int n, m;
    cin >> n >> m; // Number of vertices (n) and edges (m)

    // Input edges
    for (int i = 0; i < m; ++i)
    {
        int u, v;
        cin >> u >> v;
        g[u].push_back(v);
        g[v].push_back(u);
    }

    // Output the adjacency list (optional)
    cout << "Adjacency List:" << endl;
    for (int i = 1; i <= n; ++i)
    {
        cout << "Vertex " << i << ": ";
        for (int j : g[i])
        {
            cout << j << " ";
        }
        cout << endl;
    }

    // Perform DFS from each unvisited vertex
    for (int i = 1; i <= n; ++i)
    {
        if (!visited[i])
        {
            dfs(i);
        }
    }

    return 0;
}
