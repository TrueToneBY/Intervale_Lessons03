package intervale.dz3.springbookdemo.openlibrary.repository.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import intervale.dz3.springbookdemo.openlibrary.repository.model.serializer.WorkSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class Work {
    @JsonProperty("title")
    private String title;
    @JsonProperty("number_of_pages_median")
    private int number_of_pages_median;
    @JsonProperty("author_name")
    private String[] author_name;
    @JsonProperty("isbn")
    private String[] isbn;
}
