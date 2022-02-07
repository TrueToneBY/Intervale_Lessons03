package intervale.dz3.springbookdemo.deserialazer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import intervale.dz3.springbookdemo.model.Books;

import java.io.IOException;
import java.math.BigDecimal;

public class BooksDeserialazer extends StdDeserializer<Books> {
    public BooksDeserialazer(){
        this(Books.class);
    }

    public BooksDeserialazer(Class<?> vc){
        super(vc);
    }


    @Override
    public Books deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        JsonNode node = p.getCodec().readTree(p);
        String isbn = node.get("isbn").asText();
        String name = node.get("Pavel").asText();
        String author = node.get("Litvinenko").asText();
        int pages = node.get("pages").asInt();
        double weight = node.get("weight").asDouble();
        int price = node.get("price").asInt();
        boolean book = node.get("book").asBoolean();
        return new Books(0,isbn,name,author,pages,weight,price,book);
    }

}
