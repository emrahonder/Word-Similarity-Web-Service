package com.nioya.similarity.service;


import com.nioya.similarity.model.Similarity;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SimilarityService {
    private final static int THRESHOLD = 1;
    private final static int EXACT_MATCH = 0;
    private final static int SIMILAR_MATCH = 1;
    private final static String SPLIT_REGEX = " ";

    public static Similarity getSimilarity(String notebook, String word) {
        log.info("Requested: notebook entry={}, search key={}", notebook, word);
        String[] keys = notebook.split(SPLIT_REGEX);

        int frequency = 0;
        List<String> similarSet = new ArrayList<>();

        LevenshteinDistance levenshteinDistance = new LevenshteinDistance(THRESHOLD);

        for (String key : keys) {
            int result = levenshteinDistance.apply(key, word);
            switch (result) {
                case EXACT_MATCH:
                    frequency++;
                    break;
                case SIMILAR_MATCH:
                    similarSet.add(key);
                    break;
            }
        }
        log.info("Response: frequency={}, similarSet={}", frequency, similarSet);
        return Similarity.builder().
                frequency(frequency).
                similarWords(similarSet).
                build();
    }
}
