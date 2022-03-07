package at.sinclothing.backend.pojos;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JsonDeserializer extends StdDeserializer<LocalDateTime> {

                private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-M-d, H:m:s");

        public JsonDeserializer() {
                super(LocalDateTime.class);
        }

        @Override
        public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                return LocalDateTime.parse(deserializationContext.readValue(jsonParser, String.class), DTF);
        }
}
