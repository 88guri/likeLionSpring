package com.example.study.controller.calculator;
import com.example.study.dto.calculator.CalculatorResult;

import com.example.study.dto.calculator.CalculatorRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    @PostMapping("/calculator")
    public CalculatorResult calculate(@RequestBody CalculatorRequest request) {
        int addResult = request.getNum1() + request.getNum2();
        int minusResult = request.getNum1() - request.getNum2();
        int multiplyResult = request.getNum1() * request.getNum2();
        int divisionResult;
        if (request.getNum2() != 0) {
            divisionResult = request.getNum1() / request.getNum2();
        } else {
            // 나누는 숫자가 0인 경우. 이거 안했더니 500 에러가 떠서 추가하게 되었습니당
            divisionResult = 0;
        }


        return new CalculatorResult(addResult, minusResult, multiplyResult, divisionResult);
    }
}
