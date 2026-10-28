class Solution {
    public String[] createGrid(int m, int n) {
        String[] ans=new String[m];
        Character[][] grid=new Character[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                grid[i][j]='#'; 
            }
        }
        for(int j=0;j<n;j++){
            grid[0][j]='.';
        }
        for(int i=0;i<m;i++){
            grid[i][n-1]='.';
        }
        for(int i=0;i<m;i++){
            String temp="";
            for(int j=0;j<n;j++){
                temp+=grid[i][j];
            }
            ans[i]=temp;
        }
        return ans;
    }
}