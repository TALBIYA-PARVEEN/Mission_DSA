class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        int n1=edges.length;
        Map<Integer,List<Integer>> map=new HashMap<>();
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        return dfs(0,-1,map,hasApple);
    }

    private int dfs(int node, int parent, Map<Integer, List<Integer>> map, List<Boolean> hasApple) {
        if (!map.containsKey(node)) {
            return 0;
        }

        int totalTime = 0;
        for (int child : map.get(node)) {
            if (child == parent) {
                continue;
            }
            int childTime = dfs(child, node, map, hasApple);
            if (childTime > 0 || hasApple.get(child)) {
                totalTime += childTime + 2;
            }
        }
        return totalTime;
    }
}
