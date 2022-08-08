package com.leetcode.exercises.wordladder;


/*
6 Word Ladder

The problem:
Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
Only one letter can be changed at a time Each intermediate word must exist in the
dictionary For example,
Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log","cog"]
As one shortest transformation is "hit" ->"hot" ->"dot" ->"dog" ->"cog", the program
should return its length 5.
Note: Return 0 if there is no such transformation sequence. All words have the same
length. All words contain only lowercase alphabetic characters.
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class WordLadder {

    private final Set<String> dict;

    public WordLadder(Set<String> dict) {
        this.dict = dict;
    }

    public int ladderLength(String start, String end) {
        if (!dict.contains(end)) {
            return 0;
        }
        String[] bestPath = null;
        Set<String> leftOver = new HashSet<>(dict);
        leftOver.remove(start);

        LinkedList<String[]> paths = new LinkedList<>();
        paths.add(new String[]{start});

        while (!paths.isEmpty()) {

            String[] path = paths.pop();
            if (bestPath != null && path.length >= bestPath.length) {
                continue;
            }

            String word = path[path.length - 1];
            if (word.equals(end)) {
                bestPath = path;
                continue;
            }

            for (int i = 0; i < word.length(); i++) {
                char[] charArray = word.toCharArray();
                for(char c = 'a'; c <= 'z'; c++) {
                    charArray[i] = c;
                    String wordStep = new String(charArray);
                    if (leftOver.contains(wordStep)) {
                        String[] newPath = new String[path.length + 1];
                        newPath[path.length] = wordStep;
                        System.arraycopy(path, 0, newPath, 0, path.length);
                        paths.add(newPath);
                        leftOver.remove(wordStep);
                    }
                }
            }
        }

        return  bestPath == null ? 0 : bestPath.length;
    }

}
