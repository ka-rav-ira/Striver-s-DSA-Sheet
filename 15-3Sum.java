class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //Boundary Condition
        if(nums == null || nums.length<3) return new ArrayList<>();

        //Sort the elements 
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();

        //Fixing the first element and finding the other two elements
        for(int i=0;i<nums.length-2;i++){

            //finding other two elements using the two sum approach
            int left = i+1;
            int right = nums.length-1;

            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];

                if(sum==0){
                    //Adding the set to the set
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;right--;
                }else if(sum<0){
                    left++;
                }else{
                    right--;
                }
            }
    
    }
     return new ArrayList<>(result);
    }
}