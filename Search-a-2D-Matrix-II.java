class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        for(int i=0;i<row;i++){
            if(target>=matrix[i][0] && target<=matrix[i][col-1]){
                if(binarySearch(matrix[i],target)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean binarySearch(int[] row,int target){
        int low = 0, high = row.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;

            if(row[mid]==target){
                return true;
            }else if(row[mid]<target){
                        low = mid+1;
            }else{
                high = mid-1;
            }

        }

        return false;
    }
}