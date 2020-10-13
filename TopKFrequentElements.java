/**
cerner_2^5_2020

Given a non-empty list of words, return the k most frequent elements. Answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

For EX: 
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.
**/
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        if (words == null || words.length == 0)
        {
            return new ArrayList<>(){};
        }
        
        final Map<String, Integer> wordsToFrequency = new HashMap<>();
        
        for (String w : words)
        {
            wordsToFrequency.put(w, wordsToFrequency.getOrDefault(w, 0) + 1);
        }
        
        final Queue<Map.Entry<String,Integer>> queue = new PriorityQueue<>((a,b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
        queue.addAll(wordsToFrequency.entrySet());
        
        final List<String> result = new ArrayList<>();
        
        while (!queue.isEmpty() && k > 0)
        {
            result.add(queue.poll().getKey());
            k--;
        }
        
        
        return result;
    }
}