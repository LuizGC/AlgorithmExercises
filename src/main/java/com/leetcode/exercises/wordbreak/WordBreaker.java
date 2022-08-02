package com.leetcode.exercises.wordbreak;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class WordBreaker {

    private final Collection<String> wordDict;
    private final Set<String> cache;

    public WordBreaker(String... wordDict) {
        this.wordDict = Set.of(wordDict);
        this.cache = new HashSet<>();
    }

    public boolean isBreakable(String text) {
        if (cache.contains(text)) {
            return false;
        }
        if (text.isEmpty()) {
            return true;
        }
        for (String word : wordDict) {
            if (text.startsWith(word)) {
                if (isBreakable(text.substring(word.length()))) {
                    return true;
                }
            }
        }
        cache.add(text);
        return false;
    }

}
