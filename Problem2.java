//Time Complexity - O(n)
//Space complexity - o(1)
//Did it run in leetcode - yes

//Approach
/*
Use two Hash Maps, one to check isomorphability from S to T and other to check isomorphability from T to S
If same char is associated to two different characters then it is considered to be breach and strings are not isomorphic
*/
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        if (sl != tl) return false; //strings of different lengths are not isomorphic

        HashMap<Character, Character> sMap = new HashMap();
        HashMap<Character, Character> tMap = new HashMap();
        for(int i=0; i<sl; i++) {
            char sChar= s.charAt(i);
            char tChar= t.charAt(i);

            //check the isomorphability from s to t
            if (sMap.containsKey(sChar)) {
                if(sMap.get(sChar) != tChar) {
                    //breach
                    return false;
                }
            } else {
                sMap.put(sChar, tChar);
            }
            //check the isomorphability from t to s
            if(tMap.containsKey(tChar)) {
                if (tMap.get(tChar)!= sChar) {
                    //breach
                    return false;
                }
            } else {
                tMap.put(tChar, sChar);
            }
            }
            return true;
        }   
    }
