package intervale.dz3.springbookdemo.openlibrary.repository.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import intervale.dz3.springbookdemo.openlibrary.repository.model.deserializer.OpenLibraryBookDeserializer;
import intervale.dz3.springbookdemo.openlibrary.repository.model.serializer.OpenLibraryBookSerializer;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonDeserialize(using = OpenLibraryBookDeserializer.class)
@JsonSerialize(using = OpenLibraryBookSerializer.class)
public class OpenLibraryBook {
    private String olid;
    private String title;
    private List<String> authors;
    private int pageAmount;
    private String weight;
    private List<String> isbn;
}
