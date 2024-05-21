#include <iostream>
#include <vector>

using namespace std;

//

void moveZeroes(vector<int> &nums)
{
    int n = nums.size();
    int left = 0, right = 0;

    while (right < n)
    {
        if (nums[right] != 0)
        {
            swap(nums[left], nums[right]);
            left++;
        }
        right++;
    }
}

int main()
{
    vector<int> nums = {0, 1, 0, 3, 12};
    moveZeroes(nums);

    cout << "Array after moving zeroes to the right: ";
    for (int num : nums)
    {
        cout << num << " ";
    }
    cout << endl;

    return 0;
}
