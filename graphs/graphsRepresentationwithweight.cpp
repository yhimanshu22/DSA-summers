
#include <iostream>
#include <vector>
using namespace std;

const int N = 1e3 + 10;
int graph1[N][N];

vector<pair<int, int>> graph2[N];

int main()
{
    int n, m;
    // n---->vertices
    // m-----> edges

    cin >> n >> m;
    for (int i = 0; i < m; i++)
    {
        int v1, v2, wt;
        cin >> v1 >> v2 >> wt;
        // for matrix--->
        graph1[v1][v2] = wt;
        graph1[v2][v1] = wt;

        // for list--->
        graph2[v1].push_back({v2, wt}); // Push v2 to v1's adjacency list
        graph2[v2].push_back({v2, wt}); // Push v1 to v2's adjacency list
    }

    // Output the adjacency matrix------>

    cout << "Adjacency Matrix:" << endl;
    for (int i = 1; i <= n; ++i)
    {
        for (int j = 1; j <= n; ++j)
        {
            cout << graph1[i][j] << " ";
        }
        cout << endl;
    }

    // Output the adjacency list
    cout << "Adjacency List:" << endl;
    for (int i = 1; i <= n; ++i)
    {
        cout << "Vertex " << i << ": ";
        for (const auto &edge : graph2[i])
        {
            cout << "(" << edge.first << ", " << edge.second << ") ";
        }
        cout << endl;
    }

    return 0;
}