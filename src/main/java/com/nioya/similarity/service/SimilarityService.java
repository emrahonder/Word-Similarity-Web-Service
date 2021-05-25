package com.nioya.similarity.service;


import com.nioya.similarity.model.Similarity;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class SimilarityService {
    private final static int THRESHOLD = 1;
    private final static int EXACT_MATCH = 0;
    private final static int SIMILAR_MATCH = 1;

    public static Similarity getSimilarity(String notebook, String word) {
        log.info("Requested: notebook entry={}, search key={}", notebook, word);

        List<String> entries = Arrays.asList(notebook.split(StringUtils.SPACE));
        Similarity similarity = Similarity.builder().build();
        entries.stream().forEach(entry -> calculate(entry, word, similarity)  );

        log.info("Response: frequency={}, similarSet={}", similarity.getFrequency(),
                similarity.getSimilarWords());
        return similarity;
    }

    private static void calculate(String key, String word, Similarity similarity){
        LevenshteinDistance levenshteinDistance = new LevenshteinDistance(THRESHOLD);
        int result = levenshteinDistance.apply(key, word);
        switch (result) {
            case EXACT_MATCH:
                int frequency = similarity.getFrequency();
                frequency++;
                similarity.setFrequency(frequency);
                break;
            case SIMILAR_MATCH:
                List<String> similarWords = similarity.getSimilarWords();
                similarWords.add(key);
                similarity.setSimilarWords(similarWords);
                break;
        }
    }
}
