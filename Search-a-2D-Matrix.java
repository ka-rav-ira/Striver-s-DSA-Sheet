class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //flatening the array into 1d array
        int rows = matrix.length;
        int cols = matrix[0].length;

        int low = 0;
        int high = rows*cols-1;

        while(low<=high){
            int mid = low+(high-low)/2;
            int midValue = matrix[mid/cols][mid%cols];

            if(midValue ==target){
                return true;
            }else if(midValue<target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
         return false;
    }

   
}