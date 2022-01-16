package intervale.dz3.springbookdemo.custom;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import intervale.dz3.springbookdemo.custom.SWEngineer;

import java.io.IOException;

public abstract class CustomSerializer extends StdSerializer {
    public CustomSerializer(Class t) {
        super(t);
    }


    public void serialize(SWEngineer swe,
                          JsonGenerator jgen,
                          SerializerProvider sp) throws IOException, JsonGenerationException {

        StringBuilder lang = new StringBuilder();
        jgen.writeStartObject();
        jgen.writeNumberField("id", swe.getId());
        jgen.writeStringField("name", swe.getName());

        for (String s: swe.getLanguages()) {
            lang.append(s).append(";");
        }
        jgen.writeStringField("languages", lang.toString());

        jgen.writeEndObject();
    }

}
