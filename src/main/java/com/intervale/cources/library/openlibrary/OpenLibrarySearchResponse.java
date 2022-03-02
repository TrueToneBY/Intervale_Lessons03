package com.intervale.cources.library.openlibrary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.intervale.cources.library.model.BooksDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenLibrarySearchResponse {

    @JsonProperty("start")
    private Integer start;

    @JsonProperty("num_found")
    private Integer numFound;

    @JsonProperty("docs")
    private List<OpenLibraryDocs> docs;


}
