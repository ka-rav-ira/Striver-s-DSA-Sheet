class Solution {
    public List<Integer> majorityElement(int[] nums) {
         int n = nums.length;

        Integer maj1 =  Integer.MIN_VALUE;
        int count1 = 0;

        Integer maj2 =  Integer.MIN_VALUE;
        int count2 = 0;

        int freq = n / 3;  // Integer division suffices, no need for Math.floor
        
        // First pass: find candidates
        for (int i = 0; i < n; i++) {
            if (nums[i] == maj1) {
                count1++;
            } else if (nums[i] == maj2) {
                count2++;
            } else if (count1 == 0) {
                maj1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                maj2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        
        // Second pass: verify candidates
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == maj1) {
                count1++;
            } else if (num == maj2) {
                count2++;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        if (count1 > freq) {
            res.add(maj1);
        }
        if (count2 > freq) {
            res.add(maj2);
        }

        return res;
    }
}