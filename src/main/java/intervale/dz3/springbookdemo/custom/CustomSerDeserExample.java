package intervale.dz3.springbookdemo.custom;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;

public class CustomSerDeserExample {
    public static void main (String[] args) {

        SWEngineer swe1 = new SWEngineer(1, "Mark", new String[]{"Java", "Python", "C++", "Scala"});

        ObjectMapper mapper = new ObjectMapper();

        SimpleModule mod = new SimpleModule("MyModule");
        mod.addSerializer(new CustomSerializer(SWEngineer.class) {
            @Override
            public void serialize(Object value, JsonGenerator gen, SerializerProvider provider) throws IOException {

            }
        });
        mod.addDeserializer(SWEngineer.class, new CustomDeserializer(SWEngineer.class));
        mapper.registerModule(mod);

        System.out.println("--- ORIGINAL OBJECT ---\n" + swe1);

        String s = null;

        try {
            s = mapper.writeValueAsString(swe1);
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println("\n--- JAVA to JSON (Custom) ---\n" + s);

        SWEngineer sweOut = null;
        try {
            sweOut = mapper.readValue(s, SWEngineer.class);

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n--- JSON to JAVA ---\n" + sweOut);
    }
}
