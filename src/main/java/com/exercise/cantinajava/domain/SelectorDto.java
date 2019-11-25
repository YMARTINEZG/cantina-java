package com.exercise.cantinajava.domain;

public class SelectorDto {
    private String selectorType;
    private String selectorValue;
    private Integer selectorResult;

    public SelectorDto() {
    }

    public SelectorDto(String selectorType, String selectorValue) {
        this.selectorType = selectorType;
        this.selectorValue = selectorValue;
        this.selectorResult = 0;
    }

    public String getSelectorType() {
        return selectorType;
    }

    public void setSelectorType(String selectorType) {
        this.selectorType = selectorType;
    }

    public String getSelectorValue() {
        return selectorValue;
    }

    public void setSelectorValue(String selectorValue) {
        this.selectorValue = selectorValue;
    }

    public Integer getSelectorResult() {
        return selectorResult;
    }

    public void setSelectorResult(Integer selectorResult) {
        this.selectorResult = selectorResult;
    }
}
