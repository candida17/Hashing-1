//Time Complexity - O(n*k)
//Space complexity - O(n*k)
//Did it run in leetcode - yes

//Approach
/*
For every string a unique hash value is defined using the prime product in such a way that all anagrams will hold same hash values
Hash values serves as key in the Hash Map and strings with similar hashes will be listed 
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Double, List<String>> map = new HashMap();
        
        for (String str: strs) {
            // Get the primeproduct for every string in array
            double hashValue = getPrimeProduct(str);

            if (!map.containsKey(hashValue)) {
                //No hash value entered
                map.put(hashValue, new ArrayList<>());
            }
            map.get(hashValue).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private double getPrimeProduct(String strs) {
        int[] primes = {
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 
            41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101
        };
        double hash = 1;
        for(char ch: strs.toCharArray()) {
            hash = hash * primes[ch - 'a']; //calculate the prime product using acsii of characters
        }
        return hash;
    }
}
