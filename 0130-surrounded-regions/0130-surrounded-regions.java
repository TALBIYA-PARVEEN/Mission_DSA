class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        char[][] result = new char[m][n];
        Queue<Pair<Integer,Integer>> q=new LinkedList<>();
        boolean[][] vis = new boolean[m][n];

        //first row +last row
        for(int i=0;i<n;i++){
            if(board[0][i]=='O'){
                q.add(new Pair(0,i));
                vis[0][i]=true;
            }
            if(board[m-1][i]=='O'){
                q.add(new Pair(m-1,i));
                vis[m-1][i]=true;
            }
        }
        //first col and last col
        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
                q.add(new Pair(i,0));
                vis[i][0]=true;
            }
            if(board[i][n-1]=='O'){
                q.add(new Pair(i,n-1));
                vis[i][n-1]=true;
            }
        }
        int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};
        while(!q.isEmpty()){
            Pair<Integer, Integer> curr = q.poll();
            int row=curr.getKey();
            int col=curr.getValue();
            for(int i=0;i<4;i++){
                int r=row+delrow[i];
                int c=col+delcol[i];
                if(r>=0 &&r<m && c>=0 &&c<n){
                    if(!vis[r][c] && board[r][c]=='O'){
                        q.add(new Pair(r,c));
                        vis[r][c]=true;
                    }
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j]){
                    board[i][j]='X';
                }
            }
        }

    }
}