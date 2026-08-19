class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<reservedSeats.length;i++){
            map.computeIfAbsent(reservedSeats[i][0],m -> new ArrayList<>()).add(reservedSeats[i][1]);
        }
        int cnt=(n-map.size())*2;
        for(int i:map.keySet()){
            List<Integer> lst=new ArrayList<>(map.get(i));
            int cnt_1=0;
            int cnt_2=0;
            int cnt_3=0;
            for(int j=0;j<lst.size();j++){
                if(lst.get(j)>1 && lst.get(j)<6)cnt_1++;
                if(lst.get(j)>5 && lst.get(j)<10)cnt_2++;
                if(lst.get(j)>3 && lst.get(j)<8)cnt_3++;
            }
            if(cnt_3==0 && cnt_1!=0 && cnt_2!=0)cnt++;
            else{
                if(cnt_1==0)cnt++;
                if(cnt_2==0)cnt++;
            }
        }
        return cnt;
    }
}