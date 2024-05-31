#include <iostream>

using namespace std;

bool isSorted(int arr[], int n)
{
    for (int i = 0; i < n - 1; ++i)
    {
        if (arr[i] > arr[i + 1])
        {
            return false; // Array is not sorted
        }
    }
    return true; // Array is sorted
}

int main()
{
    int nums[] = {1, 2, 3, 6, 5};
    int size = sizeof(nums) / sizeof(nums[0]);

    cout << "Is the array sorted? " << (isSorted(nums, size) ? "Yes" : "No") << endl;

    return 0;
}
