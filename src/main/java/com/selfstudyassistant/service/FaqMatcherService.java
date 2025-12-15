package com.selfstudyassistant.service;

import com.selfstudyassistant.model.Faq;
import java.util.*;

public class FaqMatcherService {

    public Faq findBestMatch(String query, List<Faq> faqs) {
        String[] words = query.toLowerCase().split(" ");
        Faq bestMatch = null;
        int maxScore = 0;

        for (Faq faq : faqs) {
            int score = 0;
            for (String word : words) {
                if (faq.getQuestionKeywords().toLowerCase().contains(word)) {
                    score++;
                }
            }
            if (score > maxScore) {
                maxScore = score;
                bestMatch = faq;
            }
        }
        return bestMatch;
    }
}
