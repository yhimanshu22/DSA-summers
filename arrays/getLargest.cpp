#include <iostream>

using namespace std;

int getLargestElement(int arr[], int n)
{
    int result = 0;
    for (int i = 1; i < n; i++)
    {
        if (arr[i] > arr[result])
        {
            result = arr[i];
        }
    }
    return result;
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

    int largestIndex = getLargestElement(nums, size);

    cout << "largest element: " << largestIndex << endl;

    return 0;
}
