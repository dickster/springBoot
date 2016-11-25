package com.brovada.document;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class LayoutHint {

    public LayoutHint() {
    }

    public int numColumns() {
        return 1;
    }

    public boolean labelOverInput() {
        return true;
    }

}
