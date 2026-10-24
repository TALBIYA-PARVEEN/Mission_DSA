class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree=new int[numCourses];
        int[] status=new int[numCourses];
        List<List<Integer>> adj=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        int r_size=prerequisites.length;
        for (int i = 0; i < numCourses; i++)        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<r_size;i++){
            int r=prerequisites[i][0];
            int c=prerequisites[i][1];
            adj.get(c).add(r); 
            indegree[r]+=1;
        }
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
                // status[i]=1;
            }
        }
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int temp_course=q.poll();
                status[temp_course]=1;
                List temp=adj.get(temp_course);
                for(int j=0;j<temp.size();j++){
                    indegree[(int)temp.get(j)]-=1;
                    if(indegree[(int)temp.get(j)]==0){
                        q.offer((int)temp.get(j));
                    }
                }
            }
        }
        for(int i=0;i<numCourses;i++){
            if(status[i]==0)return false;
        }
        return true;
    }
}

// class Solution {
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         int[] indegree = new int[numCourses];
//         List<List<Integer>> adj = new ArrayList<>();
//         Queue<Integer> q = new LinkedList<>();

//         for (int i = 0; i < numCourses; i++) {
//             adj.add(new ArrayList<>());
//         }

//         for (int i = 0; i < prerequisites.length; i++) {
//             int r = prerequisites[i][0];
//             int c = prerequisites[i][1];

//             adj.get(c).add(r);
//             indegree[r]++;
//         }

//         for (int i = 0; i < numCourses; i++) {
//             if (indegree[i] == 0) {
//                 q.offer(i);
//             }
//         }

//         int count = 0;

//         while (!q.isEmpty()) {
//             int temp_course = q.poll();
//             count++;
//             for (int next : adj.get(temp_course)) {
//                 indegree[next]--;

//                 if (indegree[next] == 0) {
//                     q.offer(next);
//                 }
//             }
//         }
//         return count == numCourses;
//     }
// }
