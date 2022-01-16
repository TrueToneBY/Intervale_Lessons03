package intervale.dz3.springbookdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import intervale.dz3.springbookdemo.util.DtoDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.IOException;

@Data
//@JsonIgnoreProperties(ignoreUnknown = true )
@AllArgsConstructor
@JsonDeserialize(using = DtoDeserializer.class)
public class Dto {
   // @JsonDeserialize(using = DtoDeserializer.class)
    @JsonProperty("id")
    private String id;


    @JsonProperty(value = "first_name")
    private String name;
    @JsonProperty(value ="author_name")
    private String author;

    @JsonProperty(value = "last_name",defaultValue = "Pac")
    private String lastName;

public Dto() throws IOException {}

 private String json = "json";
// Dto itemWithOwner = new ObjectMapper().readValue(json,Dto.class);
}
//@Data
//class EventOddPart {
//
//    private String part;
//    private String minute;
//    private String second;
//}