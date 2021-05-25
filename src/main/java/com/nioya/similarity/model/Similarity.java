package com.nioya.similarity.model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Similarity {
    public int frequency;
    @Builder.Default
    public List<String> similarWords = new ArrayList<>();
}
