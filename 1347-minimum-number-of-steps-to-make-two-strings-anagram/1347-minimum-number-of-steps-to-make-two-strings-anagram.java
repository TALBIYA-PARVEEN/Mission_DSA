class Solution {
    public int minSteps(String s, String t) {
        int n1=s.length();
        HashMap<Character,Integer> map=new HashMap<>(); 
        for(int i=0;i<n1;i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        int n2=t.length();
        for(int j=0;j<n2;j++){
            if(map.containsKey(t.charAt(j))){     
                int ans=map.get(t.charAt(j));
                if(ans==1)map.remove(t.charAt(j));
                else map.put(t.charAt(j),ans-1);  
            }
        }
        int count=0;
        for(int entry: map.values()){
            count+=entry;
        }
        return count;
    }
}