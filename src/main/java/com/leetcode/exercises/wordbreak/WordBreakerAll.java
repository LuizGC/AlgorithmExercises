package com.leetcode.exercises.wordbreak;

import java.util.*;

/*
5 Word Break II

Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word.
Return all such possible sentences in any order.

Note that the same word in the dictionary may be reused multiple times in the segmentation.
 */
public class WordBreakerAll {

    private final Collection<String> wordDict;
    private final List<String> sentences;

    public WordBreakerAll(String... wordDict) {
        this.wordDict = Set.of(wordDict);
        this.sentences = new ArrayList<>();
    }

    public List<String> isBreakable(String text) {
        this.sentences.clear();
        if (text.isEmpty()) {
            this.sentences.add(text);
        } else {
            isBreakable(text, "");
        }
        return sentences;
    }

    private void isBreakable(String text, String sentence) {
        if (text.isEmpty()) {
            sentences.add(sentence.trim());
        }
        for (String word : wordDict) {
            if (text.startsWith(word)) {
                isBreakable(text.substring(word.length()), sentence + " " + word);
            }
        }
    }
}
