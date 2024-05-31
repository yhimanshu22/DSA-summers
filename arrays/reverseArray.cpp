#include <iostream>

using namespace std;

void reverseArray(int arr[], int n)
{
    int start = 0;
    int end = n - 1;

    while (start < end)
    {
        // Swap elements at start and end indices
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        // Move start index forward and end index backward
        start++;
        end--;
    }
}

int main()
{
    int nums[] = {1, 2, 3, 4, 5};
    int size = sizeof(nums) / sizeof(nums[0]);

    cout << "Original array: ";
    for (int i = 0; i < size; ++i)
    {
        cout << nums[i] << " ";
    }
    cout << endl;

    reverseArray(nums, size);

    cout << "Reversed array: ";
    for (int i = 0; i < size; ++i)
    {
        cout << nums[i] << " ";
    }
    cout << endl;

    return 0;
}
