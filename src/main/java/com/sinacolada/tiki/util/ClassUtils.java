package com.sinacolada.tiki.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassUtils {

    public static List<Field> getAllFieldsList(final Class<?> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("Must be instantiated.");
        } else {
            final List<Field> allFields = new ArrayList<>();
            Class<?> currentClass = clazz;
            while (currentClass != null) {
                final Field[] declaredFields = currentClass.getDeclaredFields();
                Collections.addAll(allFields, declaredFields);
                currentClass = currentClass.getSuperclass();
            }
            return allFields;
        }
    }

}