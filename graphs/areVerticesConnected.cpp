#include <iostream>
#include <vector>
using namespace std;

const int N = 1e3 + 10;
int graph1[N][N];
vector<pair<int, int>> graph2[N];

bool areVerticesConnected(int i, int j)
{
    // Check the adjacency matrix
    if (graph1[i][j] != 0)
        return true;

    // Check the adjacency list
    for (pair<int, int> child : graph2[i])
    {
        if (child.first == j)
        {
            // Vertices are connected in the adjacency list
            return true;
        }
    }

    // Vertices are not connected
    return false;
}

int main()
{
    // Example graph
    graph1[1][2] = 4;
    graph1[2][1] = 6;
    graph2[1].push_back({2, 4});
    graph2[2].push_back({1, 6});

    // Check if vertices 1 and 2 are connected
    if (areVerticesConnected(1, 2))
    {
        cout << "Vertices 1 and 2 are connected." << endl;
    }
    else
    {
        cout << "Vertices 1 and 2 are not connected." << endl;
    }

    // Check if vertices 1 and 3 are connected
    if (areVerticesConnected(1, 3))
    {
        cout << "Vertices 1 and 3 are connected." << endl;
    }
    else
    {
        cout << "Vertices 1 and 3 are not connected." << endl;
    }

    return 0;
}
