package com.example.study.dto.calculator;

public class CalculatorResult {
    private int addResult;
    private int minusResult;
    private int multiplyResult;
    private int divisionResult;

    public CalculatorResult(int addResult, int minusResult, int multiplyResult, int divisionResult) {
        this.addResult = addResult;
        this.minusResult = minusResult;
        this.multiplyResult = multiplyResult;
        this.divisionResult = divisionResult;
    }

    public int getAddResult() {
        return addResult;
    }

    public int getMinusResult() {
        return minusResult;
    }

    public int getMultiplyResult() {
        return multiplyResult;
    }

    public int getDivisionResult() {
        return divisionResult;
    }
}
