package com.sinacolada.tiki.util.custom.annotation.pii;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.function.Supplier;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.sinacolada.tiki.util.ClassUtils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.ReflectionUtils;

public class PiiDataSerializer extends JsonSerializer<Object> {

    private static final Log log = LogFactory.getLog(PiiDataSerializer.class);

    private static final String PII_DATA = "[PII_DATA]";

    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        boolean isClassPiiData = isClassPiiData(value.getClass());
        ClassUtils.getAllFieldsList(value.getClass())
                .forEach(f -> writeToJson(value, gen, f, () -> isClassPiiData || isFieldPiiData(f)));
    }

    private void writeToJson(Object value, JsonGenerator gen, Field field, Supplier<Boolean> piiResolver) {
        try {
            ReflectionUtils.makeAccessible(field);
            gen.writeStringField(field.getName(), piiResolver.get() ? PII_DATA : String.valueOf(field.get(value)));
        } catch (IOException | IllegalArgumentException | IllegalAccessException e) {
            log.trace(e.getMessage());
            log.error("Failed to write object to JSON.");
        }
    }

    private boolean isClassPiiData(Class<?> clazz) {
        return clazz.isAnnotationPresent(PiiData.class);
    }

    private boolean isFieldPiiData(Field field) {
        return field.isAnnotationPresent(PiiData.class);
    }

}