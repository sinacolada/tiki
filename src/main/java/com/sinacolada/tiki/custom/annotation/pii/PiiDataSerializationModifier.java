package com.sinacolada.tiki.custom.annotation.pii;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.sinacolada.tiki.util.ClassUtils;

public class PiiDataSerializationModifier extends BeanSerializerModifier {

    @Override
    public JsonSerializer<?> modifySerializer(SerializationConfig config, BeanDescription beanDesc,
            JsonSerializer<?> serializer) {
        return containsPiiData(beanDesc.getBeanClass()) ? new PiiDataSerializer() : serializer;
    }

    private boolean containsPiiData(Class<?> clazz) {
        return isClassPiiData(clazz) || hasFieldPiiData(clazz);
    }

    private boolean isClassPiiData(Class<?> clazz) {
        return clazz.isAnnotationPresent(PiiData.class);
    }

    private boolean hasFieldPiiData(Class<?> clazz) {
        return ClassUtils.getAllFieldsList(clazz).stream().anyMatch(f -> f.isAnnotationPresent(PiiData.class));
    }

}