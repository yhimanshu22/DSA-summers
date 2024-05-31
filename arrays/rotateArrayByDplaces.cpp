#include <iostream>
#include <algorithm>

using namespace std;

// 1st method==============>

void leftRotateNaive(int arr[], int n, int d)
{
    // Rotate the array by one place 'd' times
    for (int i = 0; i < d; i++)
    {
        int temp = arr[0];
        for (int j = 1; j < n; j++)
        {
            arr[j - 1] = arr[j];
        }
        arr[n - 1] = temp;
    }
}

// 2nd method==============>

void reverseArray(int arr[], int start, int end)
{
    while (start < end)
    {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
    }
}

void leftRotateBetter(int arr[], int n, int d)
{
    reverseArray(arr, 0, d - 1);
    reverseArray(arr, d, n - 1);
    reverseArray(arr, 0, n - 1);
}

// 3rd method================>

int gcd(int a, int b)
{
    if (b == 0)
        return a;
    else
        return gcd(b, a % b);
}

void leftRotateEfficient(int arr[], int n, int d)
{
    d = d % n;
    int sets = gcd(n, d);
    for (int i = 0; i < sets; i++)
    {
        int temp = arr[i];
        int j = i;
        while (1)
        {
            int k = (j + d) % n;
            if (k == i)
                break;
            arr[j] = arr[k];
            j = k;
        }
        arr[j] = temp;
    }
}

int main()
{
    int nums[] = {1, 2, 3, 4, 5};
    int size = sizeof(nums) / sizeof(nums[0]);
    int d = 2; // Number of places to rotate

    cout << "Original array: ";
    for (int i = 0; i < size; ++i)
    {
        cout << nums[i] << " ";
    }
    cout << endl;

    // Naive approach
    leftRotateNaive(nums, size, d);
    cout << "Array after left rotation by " << d << " places (Naive approach): ";
    for (int i = 0; i < size; ++i)
    {
        cout << nums[i] << " ";
    }
    cout << endl;

    // Better approach
    int nums2[] = {1, 2, 3, 4, 5}; // Reset array
    leftRotateBetter(nums2, size, d);
    cout << "Array after left rotation by " << d << " places (Better approach): ";
    for (int i = 0; i < size; ++i)
    {
        cout << nums2[i] << " ";
    }
    cout << endl;

    // Most Efficient approach
    int nums3[] = {1, 2, 3, 4, 5}; // Reset array
    leftRotateEfficient(nums3, size, d);
    cout << "Array after left rotation by " << d << " places (Most Efficient approach): ";
    for (int i = 0; i < size; ++i)
    {
        cout << nums3[i] << " ";
    }
    cout << endl;

    return 0;
}
