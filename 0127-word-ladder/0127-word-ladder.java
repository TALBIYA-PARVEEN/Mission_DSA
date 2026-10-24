class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet<>(wordList);
        if(!st.contains(endWord))return 0;
        Queue<String> q=new LinkedList<>();
        q.offer(beginWord);
        st.remove(beginWord);
        int distance=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int k=0;k<size;k++){
                String temp=q.poll();
                if(endWord.equals(temp))return distance;
                for(String curr: new ArrayList<>(st)){
                    int c=0;
                    for(int i=0;i<curr.length();i++){
                        if(curr.charAt(i)!=temp.charAt(i))c++;
                    }
                    if(c==1){
                        q.offer(curr);
                        st.remove(curr);
                    }
                }
            }
            distance++;
        }
        return 0;
    }
}


        
