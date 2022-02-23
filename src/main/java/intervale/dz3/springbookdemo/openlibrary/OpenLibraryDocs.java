package intervale.dz3.springbookdemo.openlibrary;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class OpenLibraryDocs {

    @JsonProperty("cover_i")
    private Integer cover;

    @JsonProperty("has_fulltext")
    private boolean hasFulltext;

    @JsonProperty("edition_count")
    private Integer editionCount;

    private String title;

    @JsonProperty("author_name")
    private ArrayList<String> authorName;

    @JsonProperty("first_publish_year")
    private Integer firstPublishYear;

    private String key;

    private ArrayList<String> ia;

    @JsonProperty("author_key")
    private ArrayList<String> authorKey;

    @JsonProperty("public_scan_b")
    private boolean publicScanB;

}
