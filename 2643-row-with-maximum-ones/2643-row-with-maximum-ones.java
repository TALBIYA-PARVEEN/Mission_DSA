class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int n=mat.length;
        int min=0;
        int count=0;
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]==1){
                    arr[i]++;
                }
            }
            if(arr[i]>count){
                min=i;
                count=arr[i];
            }
        }
        // for(int i=0;i<n;i++){
        //     if(arr[i]>count){
        //         min=i;
        //         count=arr[i];
        //     }
        // }
        // if(min==-1)min=0;
        return  new int[]{min,count};
    }
}