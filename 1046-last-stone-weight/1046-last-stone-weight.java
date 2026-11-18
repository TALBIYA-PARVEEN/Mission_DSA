class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            pq.offer(stone);
        }
        while(pq.size()>1){
            int x=pq.poll();
            int y=pq.poll();
            if(x!=y)pq.add(Math.abs(y-x));
        }
        if(pq.isEmpty())return 0;
        int ans=pq.poll();
        return ans;
    }
}