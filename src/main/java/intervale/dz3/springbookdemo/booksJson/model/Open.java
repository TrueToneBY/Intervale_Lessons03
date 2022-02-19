package intervale.dz3.springbookdemo.booksJson.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Open {
    @JsonProperty("result")
    String isbn_10;

    @JsonProperty("subject_place")
    String title;

    @JsonProperty("genres")
    String[] authors;

    @JsonProperty("title")
    String key;

    @JsonProperty("languages")
    String[] isbn_13;

//    @JsonAnyGetter
//    public String[] getAdd(){
//        return this.isbn_10;
//    }




}
