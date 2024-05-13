package com.example.study.dto.calculator;

public class CalculatorMinusRequest {
    private final int number1;
    private final int number2;
    public CalculatorMinusRequest(int  number1, int number2){
        this.number1=number1;
        this.number2=number2;
    }
    public int getNumber1() {
        return number1;//Lombok을 사용하라고 권장하는것
    }
    public int getNumber2() {
        return number2;
    }
}