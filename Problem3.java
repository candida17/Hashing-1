// Time Complexity : O(N) where N is the length of the input string
// Space Complexity : O(N) where N is the length of the input string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, while comparing the strings where equals to be used


// Your code here along with comments explaining your approach:
/*
Idea is to maintain who hash maps one to store patterns as key and other to store the words in the strings as key
check if the char in pattern associated with each word if indifferent then its a violation and return false
*/
class Solution {
    public boolean wordPattern(String pattern, String s) {
        int pl = pattern.length();
        int sl = s.split(" ").length;

        if(pl != sl) return false;
        HashMap<Character, String> pmap = new HashMap();
        HashMap<String, Character> wmap = new HashMap();

        for(int i=0;i<s.split(" ").length;i++) {
            char pKey = pattern.charAt(i);
            String[] wKey = s.split(" ");
            //check if this key is associated with any string
            if(pmap.containsKey(pKey)) {
                if(!pmap.get(pKey).equals(wKey[i])) {
                    //breach
                    return false;
                }
            } else {
                pmap.put(pKey, wKey[i]);
            }
            // check if the word in string is already associated with pattern
            if(wmap.containsKey(wKey[i])) {
                if(wmap.get(wKey[i])!= pKey) {
                    //breach
                    return false;
                }
            } else {
                wmap.put(wKey[i], pKey);
            }
        }
        return true;
    }
}
