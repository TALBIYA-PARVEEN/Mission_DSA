class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        Set<String> remaining = new HashSet<>(wordList);
        if (!remaining.contains(endWord)) return ans;
        remaining.remove(beginWord);
        Map<String, List<String>> parents = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        boolean found = false;
        while (!q.isEmpty() && !found) {
            int size = q.size();
            Set<String> visitedThisLevel = new HashSet<>();
            for (int i = 0; i < size; i++) {
                String word = q.poll();
                for (String next : match(word, remaining)) {
                    parents.computeIfAbsent(next, k -> new ArrayList<>()).add(word);
                    if (visitedThisLevel.add(next)) {
                        q.offer(next);
                    }
                    if (next.equals(endWord)) {
                        found = true;
                    }
                }
            }
            remaining.removeAll(visitedThisLevel);
        }
        if (!found) return ans;
        List<String> path = new ArrayList<>();
        path.add(endWord);
        backtrack(endWord, beginWord, parents, path, ans);
        return ans;
    }

    public void backtrack(
            String word, String beginWord,
            Map<String, List<String>> parents,
            List<String> path, List<List<String>> ans) {

        if (word.equals(beginWord)) {
            List<String> result = new ArrayList<>(path);
            Collections.reverse(result);
            ans.add(result);
            return;
        }

        for (String parent : parents.getOrDefault(
                word, Collections.emptyList())) {

            path.add(parent);

            backtrack(parent, beginWord, parents, path, ans);

            path.remove(path.size() - 1);
        }
    }

    // public List<String> match(String word, Set<String> st) {
    //     List<String> list = new ArrayList<>();
    //     char[] arr = word.toCharArray();
    //     for (int i = 0; i < arr.length; i++) {
    //         char original = arr[i];
    //         for (char ch = 'a'; ch <= 'z'; ch++) {
    //             if (ch == original) continue;
    //             arr[i] = ch;
    //             String next = new String(arr);
    //             if (st.contains(next)) {
    //                 list.add(next);
    //             }
    //         }
    //         arr[i] = original;
    //     }
    //     return list;
    // }
    public List<String> match(String temp,Set<String> st){
        List<String> list=new ArrayList(); 
        for(String curr: new ArrayList<>(st)){
            int c=0;
            for(int i=0;i<curr.length();i++){
                if(curr.charAt(i)!=temp.charAt(i))c++;
            }
            if(c==1){
                list.add(curr);
            }
        }
        return list;
    } 
}


// class Solution {
//     public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//         Set<String> st = new HashSet<>(wordList);
//         List<List<String>> ans=new ArrayList<>();
//         if(!st.contains(endWord))return ans;
//         st.remove(beginWord);
//         List<String> path = new ArrayList<>();
//         path.add(beginWord);
//         Map<String, Integer> dist = new HashMap<>();
//         Queue<String> q = new LinkedList<>();
//         q.offer(beginWord);
//         dist.put(beginWord, 0);

//         while (!q.isEmpty()) {
//             String temp = q.poll();

//             for (String curr : match(temp, st)) {
//                 if (!dist.containsKey(curr)) {
//                     dist.put(curr, dist.get(temp) + 1);
//                     q.offer(curr);
//                 }
//             }
//         }
//         backtrack(beginWord, endWord, st, ans, path, dist);
//         return ans;
//     } 
//     // public void backtrack(Set<String> st,String endWord, List<List<String>> ans,List<String> list){
//     //     if (list.get(list.size() - 1).equals(endWord)) {
//     //         ans.add(new ArrayList<>(list));
//     //         return;
//     //     }
//     //     List<String> currList=new ArrayList<>();
//     //     String temp = list.get(list.size() - 1);
//     //     currList.addAll(match(temp, st));
//     //     for(String temp:currList){
//     //         list.add(temp);
//     //         backtrack(unvisitedst,endWord,ans,list);
//     //         list.remove(list.size()-1);
//     //     }
//     // }
//     public void backtrack(String word, String endWord, Set<String> st,
//                           List<List<String>> ans, List<String> list,
//                           Map<String, Integer> dist) {

//         if (word.equals(endWord)) {
//             ans.add(new ArrayList<>(list));
//             return;
//         }

//         for (String temp : match(word, new HashSet<>(st))) {
//             if (dist.containsKey(temp)
//                     && dist.containsKey(word)
//                     && dist.get(temp) == dist.get(word) + 1) {

//                 list.add(temp);
//                 backtrack(temp, endWord, st, ans, list, dist);
//                 list.remove(list.size() - 1);
//             }
//         }
//     }
//     // public List<String> match(String temp,Set<String> st){
//     //     List<String> list=new ArrayList(); 
//     //     for(String curr: new ArrayList<>(st)){
//     //         int c=0;
//     //         for(int i=0;i<curr.length();i++){
//     //             if(curr.charAt(i)!=temp.charAt(i))c++;
//     //         }
//     //         if(c==1){
//     //             list.add(curr);
//     //         }
//     //     }
//     //     return list;
//     // } 
//     public List<String> match(String word, Set<String> st) {
//         List<String> list = new ArrayList<>();
//         char[] arr = word.toCharArray();

//         for (int i = 0; i < arr.length; i++) {
//             char original = arr[i];

//             for (char ch = 'a'; ch <= 'z'; ch++) {
//                 if (ch == original) continue;

//                 arr[i] = ch;
//                 String next = new String(arr);

//                 if (st.contains(next)) {
//                     list.add(next);
//                 }
//             }

//             arr[i] = original;
//         }

//         return list;
//     }
    
// }


// class Solution {
//     public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//         Set<String> st = new HashSet<>(wordList);
//         if(!st.contains(endWord))return new ArrayList<>();
//         Queue<String> q=new LinkedList<>();
//         List<List<String>> ans= new ArrayList<>();
//         q.offer(beginWord);
//         st.remove(beginWord);
//         int distance=1;
//         while(!q.isEmpty()){
//             int size=q.size();
//             for(int k=0;k<size;k++){
//                 String temp=q.poll();
//                 if(k==0)ans.add(temp);
//                 if(endWord.equals(temp))return ans;
//                 for(String curr: new ArrayList<>(st)){
//                     int c=0;
//                     for(int i=0;i<curr.length();i++){
//                         if(curr.charAt(i)!=temp.charAt(i))c++;
//                     }
//                     if(c==1){
//                         q.offer(curr);
//                         st.remove(curr);
//                     }
//                 }
//             }
//             distance++;
//         }
//         return new ArrayList<>();
//     }
// }