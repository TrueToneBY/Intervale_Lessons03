package com.intervale.cources.library.openlibrary;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class OpenLibrarySearchResponse {

    private Integer start;

    @JsonProperty("num_found")
    private Integer numFound;

    private List<OpenLibraryDocs> docs;


}
