
#include <iostream>
#include <vector>

using namespace std;

void leftRotateOne(int arr[], int n)
{
    int temp = arr[0];

    for (int i = 1; i <= n; i++)
    {
        arr[i - 1] = arr[i];
    }
    arr[n - 1] = temp;
}

int main()
{
    int nums[5] = {0, 1, 0, 3, 12};
    leftRotateOne(nums, 5);

    cout << "Array after moving one to the left: ";
    for (int i = 0; i < 5; i++)
    {
        cout << nums[i] << " ";
    }
    cout << endl;

    return 0;
}