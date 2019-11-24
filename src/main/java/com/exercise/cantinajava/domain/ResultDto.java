package com.exercise.cantinajava.domain;

public class ResultDto {
    private String selectorType;
    private String selectorValue;
    private Integer selectorResult;

    public ResultDto(String selectorType, String selectorValue, Integer selectorResult) {
        this.selectorType = selectorType;
        this.selectorValue = selectorValue;
        this.selectorResult = selectorResult;
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
