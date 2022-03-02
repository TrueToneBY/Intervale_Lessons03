package com.intervale.cources.library.openlibrary;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenLibraryDocs {

    @JsonProperty("cover_i")
    private Integer cover;

    @JsonProperty("has_fulltext")
    private boolean hasFulltext;

    @JsonProperty("edition_count")
    private Integer editionCount;

    @JsonProperty("title")
    private String title;

    @JsonProperty("author_name")
    private ArrayList<String> authorName;

    @JsonProperty("first_publish_year")
    private Integer firstPublishYear;

    @JsonProperty("key")
    private String key;

    @JsonProperty("ia")
    private ArrayList<String> ia;

    @JsonProperty("author_key")
    private ArrayList<String> authorKey;

    @JsonProperty("public_scan_b")
    private boolean publicScanB;

}
