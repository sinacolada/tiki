package com.sinacolada.tiki.custom.annotation.pii;

import com.fasterxml.jackson.databind.module.SimpleModule;

public class PiiDataModule extends SimpleModule {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public PiiDataModule() {
        setSerializerModifier(new PiiDataSerializationModifier());
    }

}