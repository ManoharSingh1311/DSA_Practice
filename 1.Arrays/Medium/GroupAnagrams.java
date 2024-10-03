/*
 Problem Description:
Given a list of strings, group all anagrams together. An anagram is a word formed by rearranging the letters of another word, using all original letters exactly once.

Naive Approach:
Idea: For each word, compare it with every other word to check if they are anagrams by sorting both strings and comparing.
Time Complexity: O(n² * m * log(m)), where n is the number of strings and m is the average length of the strings. Sorting each string takes O(m log m), and the outer loop compares each pair of strings.
Space Complexity: O(n * m), for storing the results and sorting each string.

Better Approach:
Idea: Use a HashMap where the key is the sorted version of each word, and the value is the list of anagrams corresponding to that sorted key.
Time Complexity: O(n * m * log(m)), since we sort each string (O(m log m)) and there are n strings to process.
Space Complexity: O(n * m), for the HashMap and the result list.

Optimal Approach:
Idea: Instead of sorting, use an array of size 26 to count the frequency of each character. Use this frequency count array to generate a unique key for each group of anagrams. Group strings with the same frequency count.
Time Complexity: O(n * m), where n is the number of strings and m is the length of the strings. We only count characters, which takes O(m) for each string.
Space Complexity: O(n * m), for storing the frequency count arrays and the results.
*/

import java.util.*;


public class GroupAnagrams {

    // Naive Approach
    public static List<List<String>> groupAnagramsNaive(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];
        
        for (int i = 0; i < strs.length; i++) {
            if (visited[i]) continue; // Skip already grouped elements
            
            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            visited[i] = true;
            
            for (int j = i + 1; j < strs.length; j++) {
                if (isAnagram(strs[i], strs[j])) {
                    group.add(strs[j]);
                    visited[j] = true;
                }
            }
            result.add(group);
        }
        return result;
    }

    // Helper function to check if two strings are anagrams
    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }

    // Better Approach (Using a HashMap with sorted strings as keys)
    public static List<List<String>> groupAnagramsBetter(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray); // Sort characters to make the key
            String sorted = new String(charArray);

            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(s);
        }

        return new ArrayList<>(map.values());
    }

    // Optimal Approach (Using a HashMap with frequency counts as keys)
    public static List<List<String>> groupAnagramsOptimal(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] charCount = new int[26]; // For storing frequency of characters

            // Fill the character frequency array
            for (char c : s.toCharArray()) {
                charCount[c - 'a']++;
            }

            // Create a unique key using the frequency array
            StringBuilder sb = new StringBuilder();
            for (int count : charCount) {
                sb.append("#").append(count);
            }

            String key = sb.toString();

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    // Main function to call all three approaches
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        // Call Naive Approach
        List<List<String>> naiveResult = groupAnagramsNaive(strs);
        System.out.println("Grouped Anagrams (Naive): " + naiveResult);

        // Call Better Approach
        List<List<String>> betterResult = groupAnagramsBetter(strs);
        System.out.println("Grouped Anagrams (Better): " + betterResult);

        // Call Optimal Approach
        List<List<String>> optimalResult = groupAnagramsOptimal(strs);
        System.out.println("Grouped Anagrams (Optimal): " + optimalResult);
    }
}
