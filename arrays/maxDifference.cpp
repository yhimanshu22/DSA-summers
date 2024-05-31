#include <iostream>
using namespace std;

// 1st method------------->

int maxDiffNaive(int arr[], int n)
{
    int maxDiff = arr[1] - arr[0];
    for (int i = 0; i < n; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            if (arr[j] - arr[i] > maxDiff)
            {
                maxDiff = arr[j] - arr[i];
            }
        }
    }
    return maxDiff;
}

// 2nd method--------->

int maxDiffEfficient(int arr[], int n)
{
    int maxDiff = arr[1] - arr[0];
    int minElement = arr[0];
    for (int i = 1; i < n; i++)
    {
        if (arr[i] - minElement > maxDiff)
        {
            maxDiff = arr[i] - minElement;
        }
        if (arr[i] < minElement)
        {
            minElement = arr[i];
        }
    }
    return maxDiff;
}

int main()
{
    int arr[] = {7, 9, 5, 6, 3, 2};
    int n = sizeof(arr) / sizeof(arr[0]);
    cout << "Maximum difference (naive): " << maxDiffNaive(arr, n) << endl;
    cout << "Maximum difference(efficient): " << maxDiffEfficient(arr, n) << endl;

    return 0;
}