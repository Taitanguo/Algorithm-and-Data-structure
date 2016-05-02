public class Solution {
    /**
     * @param s : A string
     * @return : The length of the longest substring
     *           that contains at most k distinct characters.
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
 int slow = 0;
        int maxLen = 0;

        //key: letter value: the number of occurances
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int fast;
        for(fast = 0; fast < s.length(); fast++){
            char c = s.charAt(fast);
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else{
                map.put(c, 1);
            }

            while(map.size() > k){
                char slowChar = s.charAt(slow++);
                if(map.get(slowChar) > 1){
                    map.put(slowChar, map.get(slowChar) - 1);
                }else{
                    map.remove(slowChar);
                }
                }

            maxLen = Math.max(maxLen, fast - slow + 1);
        }

        return maxLen;
    }
}

