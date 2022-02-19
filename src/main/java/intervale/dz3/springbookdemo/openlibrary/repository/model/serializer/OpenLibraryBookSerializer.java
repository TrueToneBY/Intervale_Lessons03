package intervale.dz3.springbookdemo.openlibrary.repository.model.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import intervale.dz3.springbookdemo.openlibrary.repository.model.OpenLibraryBook;

import java.io.IOException;
import java.util.List;

public class OpenLibraryBookSerializer extends StdSerializer<OpenLibraryBook> {
    public OpenLibraryBookSerializer() {
        this(OpenLibraryBook.class);
    }

    public OpenLibraryBookSerializer(Class<OpenLibraryBook> t) {
        super(t);
    }

    @Override
    public void serialize(OpenLibraryBook value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("OLID", value.getOlid());
        gen.writeStringField("title", value.getTitle());
        writeArray(value.getAuthors(), "author", gen);
        if (value.getPageAmount() != 0) {
            gen.writeNumberField("pageAmount", value.getPageAmount());
        }
        if (value.getWeight() != null) {
            gen.writeStringField("weight", value.getWeight());
        }
        writeArray(value.getIsbn(), "ISBN", gen);
        gen.writeEndObject();
    }

    private void writeArray(List<String> fields, String fieldName, JsonGenerator gen) throws IOException{
        if (fields.size() == 1) {
            gen.writeStringField(fieldName, fields.get(0));
        }
        else if (fields.size() > 1) {
            gen.writeFieldName(fieldName);
            gen.writeStartArray();
            for (String field:
                    fields) {
                gen.writeString(field);
            }
            gen.writeEndArray();
        }
    }
}