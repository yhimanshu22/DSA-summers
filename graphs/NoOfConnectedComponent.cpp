#include <iostream>
#include <vector>
using namespace std;

const int N = 1e5 + 10;
vector<int> g[N];
bool visited[N];
vector<vector<int>> cc; // To store all connected components
vector<int> current_cc; // To store the current connected component

// dfs algo----->
void dfs(int vertex)
{
    visited[vertex] = true;
    current_cc.push_back(vertex);

    for (int child : g[vertex])
    {
        if (!visited[child])
        {
            dfs(child);
        }
    }
}

int countConnectedComponents(int n)
{
    int count = 0;
    for (int i = 1; i <= n; i++)
    {
        if (!visited[i])
        {
            current_cc.clear(); // Start a new connected component
            dfs(i);
            cc.push_back(current_cc); // Save the current connected component
            count++;
        }
    }
    return count;
}

void printConnectedComponents()
{
    for (const auto &component : cc)
    {
        cout << "Connected Component: ";
        for (int vertex : component)
        {
            cout << vertex << " ";
        }
        cout << endl;
    }
}

int main()
{
    int n, m;
    cin >> n >> m;

    // Input edges
    for (int i = 0; i < m; ++i)
    {
        int u, v;
        cin >> u >> v;
        g[u].push_back(v);
        g[v].push_back(u);
    }

    int components = countConnectedComponents(n);
    cout << "Number of connected components: " << components << endl;

    printConnectedComponents();

    return 0;
}
