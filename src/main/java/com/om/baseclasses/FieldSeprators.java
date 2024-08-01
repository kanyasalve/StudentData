package com.om.baseclasses;

public enum FieldSeprators {

    BLANK(" ");
    private final String stringValue;

    FieldSeprators(final String s) {
        stringValue = s;
    }

    public String toFaceValue() {
        return stringValue;
    }

}
