public class _154_FindMinimuminRotatedSortedArrayII {
    /**
     * Binary Search
     * time: O(logn)
     * space: O(1)
     */
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low + 1 < high) {
            while (low + 1 < high && nums[low + 1] == nums[low])
                low++;
            while (high - 1 > low && nums[high - 1] == nums[high])
                high--;
            if (nums[low] < nums[high]) {
                return nums[low];
            }
            int mid = (high - low) / 2 + low;
            if (nums[mid] > nums[low]) {
                low = mid + 1;
            }
            if (nums[mid] < nums[high]) {
                high = mid;
            }
        }

        if (nums[low] < nums[high])
            return nums[low];
        else
            return nums[high];
    }
}
