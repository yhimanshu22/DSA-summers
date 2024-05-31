#include <iostream>
#include <vector>
using namespace std;

const int N = 1e3 + 10;
int graph1[N][N];

vector<int> graph2[N];

int main()
{
    int n, m;
    // n---->vertices
    // m-----> edges

    cin >> n >> m;
    for (int i = 0; i < m; i++)
    {
        int v1, v2;
        cin >> v1 >> v2;
        // for matrix--->
        graph1[v1][v2] = 1;
        graph1[v2][v1] = 1;

        // for list--->
        graph2[v1].push_back(v2); // Push v2 to v1's adjacency list
        graph2[v2].push_back(v1); // Push v1 to v2's adjacency list
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

    // output of adjacency list----->
    cout << "Adjacency List:" << endl;
    for (int i = 1; i <= n; ++i)
    {
        cout << "Vertex " << i << ": ";
        for (size_t j = 0; j < graph2[i].size(); ++j)
        {
            cout << graph2[i][j] << " ";
        }
        cout << endl;
    }

    return 0;
}
