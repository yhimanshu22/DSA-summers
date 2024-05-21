#include <iostream>

using namespace std;

int deleteOneElement(int arr[], int n, int x)
{
    int foundIndex = -1; // Variable to store the index of the element to delete

    // Find the index of the element to delete
    for (int i = 0; i < n; i++)
    {
        if (arr[i] == x)
        {
            foundIndex = i;
            break;
        }
    }

    // If the element was not found, return the original size
    if (foundIndex == -1)
        return n;

    // Shift elements after the deleted element one position to the left
    for (int j = foundIndex; j < n - 1; j++)
    {
        arr[j] = arr[j + 1];
    }

    return n - 1; // Return the new size of the array
}

int main()
{
    int nums[6] = {2, 5, 7, 5, 8, 9};
    int size = 6;
    int x = 8;

    cout << "Original array: ";
    for (int i = 0; i < size; ++i)
    {
        cout << nums[i] << " ";
    }
    cout << endl;

    size = deleteOneElement(nums, size, x);

    cout << "Array after deleting one occurrence of " << x << ": ";
    for (int i = 0; i < size; ++i)
    {
        cout << nums[i] << " ";
    }
    cout << endl;

    return 0;
}
