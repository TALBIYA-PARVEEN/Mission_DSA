class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int r_size=grid.length;
        int c_size=grid[0].length;
        int distance=0;
        int max=Integer.MAX_VALUE;
        for(int i=0;i<r_size;i++){
            for(int j=0;j<c_size;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                    grid[i][j]=0;
                }
            }
        }
        while(!q.isEmpty()){
            int size=q.size();
            boolean changed=false;
            for(int i=0;i<size;i++){
                int[] temp=q.poll();
                int r=temp[0];
                int c=temp[1];
                if(c+1<grid[r].length && grid[r][c+1]==1){
                    q.offer(new int[]{r,c+1});
                    grid[r][c+1]=2;
                    changed=true;
                }
                if(r+1<grid.length &&  grid[r+1][c]==1){
                    q.offer(new int[]{r+1,c});
                    grid[r+1][c]=2;
                    changed=true;
                }
                if( c-1>=0 && grid[r][c-1]==1){
                    q.offer(new int[]{r,c-1});
                    grid[r][c-1]=2;
                    changed=true;
                }
                if(r-1>=0 && grid[r-1][c]==1){
                    q.offer(new int[]{r-1,c});
                    grid[r-1][c]=2;
                    changed=true;
                }
            }
            if(changed)distance++;
        }
        for(int i=0;i<r_size;i++){
            for(int j=0;j<c_size;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return distance;
    }
}