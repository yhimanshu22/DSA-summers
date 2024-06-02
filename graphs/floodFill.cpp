#include <vector>
using namespace std;

// Depth First Search (DFS) function for flood fill
void dfs(int i, int j, int initialColor, int newColor, vector<vector<int>> &image)
{
    int n = image.size();    // Number of rows in the image
    int m = image[0].size(); // Number of columns in the image

    // Base cases: Check if the current pixel is out of bounds or does not have the initial color
    if (i < 0 || j < 0 || i >= n || j >= m || image[i][j] != initialColor)
        return;

    // Set the color of the current pixel to the new color
    image[i][j] = newColor;

    // Recursively call DFS for adjacent pixels: up, down, left, and right
    dfs(i - 1, j, initialColor, newColor, image); // Up
    dfs(i + 1, j, initialColor, newColor, image); // Down
    dfs(i, j - 1, initialColor, newColor, image); // Left
    dfs(i, j + 1, initialColor, newColor, image); // Right
}

// Function to perform flood fill on the image
vector<vector<int>> floodFill(vector<vector<int>> &image, int sr, int sc, int newColor)
{
    int initialColor = image[sr][sc]; // Get the color of the starting pixel (sr, sc)

    // Check if the new color is different from the initial color
    if (initialColor != newColor)
    {
        // Start the flood fill process from the starting pixel (sr, sc)
        dfs(sr, sc, initialColor, newColor, image);
    }

    // Return the modified image after flood filling
    return image;
}
