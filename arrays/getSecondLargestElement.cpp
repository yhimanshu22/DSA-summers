#include <iostream>

using namespace std;

pair<int, int> getTwoLargestElements(int arr[], int n)
{
    // Initialize variables to store indices of the largest and second-largest elements
    int largestIndex = 0;
    int secondLargestIndex = -1;

    // Traverse the array to find the largest and second-largest elements
    for (int i = 1; i < n; i++)
    {
        if (arr[i] > arr[largestIndex])
        {
            secondLargestIndex = largestIndex;
            largestIndex = arr[i];
        }
        else if (secondLargestIndex == -1 || arr[i] > arr[secondLargestIndex])
        {
            secondLargestIndex = arr[i];
        }
    }

    // Return a pair of indices (largestIndex, secondLargestIndex)
    return make_pair(largestIndex, secondLargestIndex);
}

int main()
{
    int nums[] = {5, 3, 8, 2, 7, 1, 9};
    int size = sizeof(nums) / sizeof(nums[0]);

    cout << "Original array: ";
    for (int i = 0; i < size; ++i)
    {
        cout << nums[i] << " ";
    }
    cout << endl;

    pair<int, int> result = getTwoLargestElements(nums, size);

    cout << "largest element: " << result.first << endl;
    cout << "second largest element: " << result.second << endl;

    return 0;
}
