#include <iostream>
using namespace std;

void leaders(int arr[], int n)
{
    int curr_ldr = arr[n - 1]; // The last element is always a leader
    cout << curr_ldr << " ";   // Print the last element
    // Traverse the array from right to left
    for (int i = n - 2; i >= 0; i--)
    {
        if (curr_ldr < arr[i])
        {                            // If current element is greater than the leader so far
            curr_ldr = arr[i];       // Update current leader
            cout << curr_ldr << " "; // Print the current leader
        }
    }
}

int main()
{
    int arr[] = {16, 17, 4, 3, 5, 2};
    int n = sizeof(arr) / sizeof(arr[0]);
    leaders(arr, n);
    return 0;
}
