class Solution {
    public int maximumWealth(int[][] accounts) {
        int ans = Integer.MIN_VALUE;
        for(int[] ints: accounts){
            //when you start a new row take the sum back to zero
            int sum = 0;
            for(int anInt: ints){
                sum+=anInt;
            }
            //now we have sum of accounts of that person 
            //check with overall ans
            if(sum>ans){
                ans = sum;
            }
        }
        return ans;
    }
}