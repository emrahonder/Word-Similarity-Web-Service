package com.nioya.similarity.controller;

import com.nioya.similarity.model.Similarity;
import com.nioya.similarity.service.SimilarityService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Size;
import java.util.List;

@RestController
@Validated
public class OperationController {

    private final static int MIN = 2;
    private final static int MAX = 2048;
    private final static String NOTEBOOK_MSG = "notebook length must be between "+ MIN +" and "+MAX;
    private final static String WORD_MSG = "word length must be between "+ MIN +" and "+MAX;


    @GetMapping("/similarity")
    @ResponseBody
    public Similarity getSimilarity(@RequestParam("notebook") @Size(min = MIN, max = 2048,
                                            message = NOTEBOOK_MSG) String notebook,
                                    @RequestParam
                                    @Size(min = MIN, max = 2048, message = WORD_MSG) String word) {
        return SimilarityService.getSimilarity(notebook, word);
    }

    @GetMapping("/frequency")
    @ResponseBody
    public int getFrequency(@RequestParam("notebook") @Size(min = MIN, max = 2048,
                                    message = NOTEBOOK_MSG) String notebook,
                            @RequestParam @Size(min = MIN, max = 2048, message = WORD_MSG) String word) {
        Similarity similarity = SimilarityService.getSimilarity(notebook, word);
        return similarity.getFrequency();
    }

    @GetMapping("/similarwords")
    @ResponseBody
    public List<String> getSimilarWords(@RequestParam("notebook") @Size(min = MIN, max = 2048,
                                                message = NOTEBOOK_MSG) String notebook,
                                        @RequestParam @Size(min = MIN, max = 2048, message = WORD_MSG) String word) {
        Similarity similarity = SimilarityService.getSimilarity(notebook, word);
        return similarity.getSimilarWords();
    }
}
