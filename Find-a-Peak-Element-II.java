class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;  // Number of rows
        int m = mat[0].length;  // Number of columns
        int low = 0, high = m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int maxRowIndex = findMaxIndex(mat, n, mid); // Find the row with the maximum value in the current column
            
            int left = (mid - 1 >= 0) ? mat[maxRowIndex][mid - 1] : -1; // Check left neighbor
            int right = (mid + 1 < m) ? mat[maxRowIndex][mid + 1] : -1; // Check right neighbor

            // Check if the current cell is a peak
            if (mat[maxRowIndex][mid] > left && mat[maxRowIndex][mid] > right) {
                return new int[]{maxRowIndex, mid};
            } else if (mat[maxRowIndex][mid] < left) {
                high = mid - 1; // Move to the left
            } else {
                low = mid + 1; // Move to the right
            }
        }

        return new int[]{-1, -1}; // Should not reach here since a peak always exists
    }

    // Helper function to find the row with the maximum value in a given column
    public int findMaxIndex(int[][] mat, int n, int col) {
        int maxValue = -1;
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (mat[i][col] > maxValue) {
                maxValue = mat[i][col];
                index = i;
            }
        }
        return index;
    }
}