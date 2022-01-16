package intervale.dz3.springbookdemo.util;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import intervale.dz3.springbookdemo.model.Dto;


import java.io.IOException;
import java.util.Objects;

public class DtoDeserializer extends JsonDeserializer<Dto> {
    @Override
    public Dto deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {

//        Dto dto = new ObjectMapper().readValue(json,Dto.class);

        String id = p.getText();

        Dto dto = new Dto();
        if(Objects.isNull(id)){
            return dto;
        }
//        String[] parts = id.split(" : ");
//        String[] minSecs = parts[1].split(":");
        dto.setAuthor("Litvinenko");
        dto.setId("1");
        dto.setName("pavel");
        dto.setLastName("I am iz author");


        return dto;
    }
}
