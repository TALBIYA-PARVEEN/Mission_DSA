class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int t=times.length;
        Map<Integer,List<int[]>> map=new HashMap<>(); 
        for(int i=0;i<t;i++){
            int u=times[i][0];
            int v=times[i][1];
            int w=times[i][2];
            map.computeIfAbsent(u, o -> new ArrayList<>()).add(new int[]{v, w});

        }
        int[] dist=new int[n+1];
        for(int i=1;i<=n;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[k]=0;
        dfs(dist,map,k,0);
        int max=0;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE)return -1;
            max=Math.max(max,dist[i]);
        }
        return max;
    }
    public void dfs(int[] dist,Map<Integer,List<int[]>> map,int start,int time){
        List<int[]> adj=map.get(start);
        if(adj==null)return;
        for(int i=0;i<adj.size();i++){
            int[] curr=adj.get(i);
            if(time+curr[1]<dist[curr[0]]){
                dist[curr[0]]=curr[1]+time;
                dfs(dist,map,curr[0],time+curr[1]);
            }
            // else return;
        }
        return;
    }
}