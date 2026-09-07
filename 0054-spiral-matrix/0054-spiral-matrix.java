// class Solution {
//     public List<Integer> spiralOrder(int[][] matrix) {
//         ArrayList<Integer> lst=new ArrayList<>();
//         int n=matrix.length;
//         int idx=0;
//         while(idx<=n/2){
//             int i=idx,j=0;
//             for(;j<n-idx;j++){
//                 lst.add(matrix[i][j]);
//             }
//             j--;
//             for(;i<n-idx;i++){
//                 lst.add(matrix[i][j]);
//             }
//             for(;j>=idx;j--){
//                 lst.add(matrix[i][j]); 
//             }
//             i--;
//             for(;i>=idx;i--){
//                 lst.add(matrix[i][j]);
//             }
//             idx++;
//         }
//         return lst;
//     }
// }
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        List<Integer> spiral = new ArrayList<>();

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++)
                spiral.add(matrix[top][i]);
            top++;

            for (int j = top; j <= bottom; j++)
                spiral.add(matrix[j][right]);
            right--;

            if (top <= bottom) {
                for (int k = right; k >= left; k--)
                    spiral.add(matrix[bottom][k]);
                bottom--;
            }

            if (left <= right) {
                for (int l = bottom; l >= top; l--)
                    spiral.add(matrix[l][left]);
                left++;
            }
        }

        return spiral;
    }
}