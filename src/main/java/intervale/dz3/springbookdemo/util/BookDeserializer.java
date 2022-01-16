package intervale.dz3.springbookdemo.util;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import intervale.dz3.springbookdemo.model.Book;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Objects;


public class BookDeserializer extends JsonDeserializer<Book> {

    private static final long serialVersionUID = 1883547683050039861L;

//    public BookDeserializer(){
//        this(null);
//    }

//    public BookDeserializer(Class<?> vc) {
//        super(vc);
//    }



    @Override
    public Book deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)throws IOException , JacksonException {

//        final JsonNode node = jsonParser.getCodec().readTree(jsonParser);
//        final String id = node.get("id").asText();
//        final String name = node.get("name").asText();
//        final String author = node.get("author").asText();
//        JsonNode author = node.get("author");
//        String isbn = node.get("12121313131").toString();
//        String value = node.get("value").toString();
//
//        String authorname = author.get("Pavel").toString();
//        String authorSurname = author.get("Litvinenka").toString();
//        String name = node.get("Pavel").toString();

        String id = jsonParser.getText();

        Book book = new Book();
        if(Objects.isNull(id)){
            return book;
        }

        book.setId("10");
        book.setName("Pavel");
        book.setAuthor("I");
        book.setIsbn("13131246656");
        book.setPages(235);
        book.setPrice(BigDecimal.valueOf(23));


        return book;
    }
}
