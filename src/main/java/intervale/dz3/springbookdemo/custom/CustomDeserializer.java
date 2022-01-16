package intervale.dz3.springbookdemo.custom;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import intervale.dz3.springbookdemo.custom.SWEngineer;

import java.io.IOException;

public class CustomDeserializer extends StdDeserializer {
    public CustomDeserializer(Class t) {
        super(t);
    }

    @Override
    public SWEngineer deserialize(JsonParser jp, DeserializationContext dc)
            throws IOException, JsonProcessingException {

        long id = 0;
        String name = null;
        String[] languages = null;
        JsonToken currentToken = null;
        while ((currentToken = jp.nextValue()) != null) {
            switch (currentToken) {
                case VALUE_NUMBER_INT:
                    if (jp.getCurrentName().equals("id")) {
                        id = jp.getLongValue();
                    }
                    break;
                case VALUE_STRING:
                    switch (jp.getCurrentName()) {
                        case "name":
                            name = jp.getText();
                            break;
                        case "languages":
                            languages = jp.getText().split(";");
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
            return new SWEngineer(id, name, languages);

    }
}
