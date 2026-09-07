class Solution {
    public void rotate(int[][] matrix) {
        int len=matrix.length;
        int[][] mat=new int[len][len];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                mat[i][j]=matrix[i][j];
            }
        }
        int m=0,n=len-1;
        for(int i=0;i<len;i++){
            m=0;
            for(int j=0;j<len;j++){
                matrix[m][n]=mat[i][j]; 
                m++;
            }
            n--;
        }
    }
}