package com.nioya.similarity.service;

import com.nioya.similarity.model.Similarity;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimilarityServiceTest {

    @Test
    public void shouldReturn_whenProperInputsProvided() {
        Similarity similarity = SimilarityService.getSimilarity("Word Words Wor word", "Word");

        assertEquals(1, similarity.getFrequency());
        assertEquals( Arrays.asList("Words", "Wor", "word"),
                similarity.getSimilarWords());
    }

}
