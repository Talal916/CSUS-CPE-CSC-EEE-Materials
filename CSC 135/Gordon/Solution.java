class Solution {
    public int numJewelsInStones(String J, String S) {
        HashMap<Character,Integer> map = new HashMap();
        for(char c:S.toCharArray()){
            int freq=0;
            if(map.containsKey(c))
                freq=map.get(c);
            map.put(c,++freq);
        }
        
        int count=0;
        for(char c:J.toCharArray()){
            if(map.containsKey(c))
                count+=map.get(c);
        }
        return count;
    }
}