#include <iostream>

using namespace std;

int removeDuplicates(int arr[], int n)
{
    int result = 1;
    for (int i = 1; i < n; i++)
    {
        if (arr[i] != arr[result - 1])
        {
            arr[result] = arr[i];
            result++;
        }
    }
    return result;
}

int main()
{
    int nums[] = {1, 2, 2, 3, 4, 4, 4, 5};
    int size = sizeof(nums) / sizeof(nums[0]);

    cout << "Original array: ";
    for (int i = 0; i < size; ++i)
    {
        cout << nums[i] << " ";
    }
    cout << endl;

    int newSize = removeDuplicates(nums, size);

    cout << "Array after removing duplicates: ";
    for (int i = 0; i < newSize; ++i)
    {
        cout << nums[i] << " ";
    }
    cout << endl;

    return 0;
}
