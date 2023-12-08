package com.example.calculatorandconverter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CalculatorController {

    @GetMapping("/")
    public String getHome(Model model) {
        model.addAttribute("name", "Defloyder");
        return "index";
    }

    @GetMapping("/calc")
    public String calculatorForm() {
        return "calc";
    }

    @GetMapping("/conv")
    public String converterForm() {
        return "/conv";
    }

    @PostMapping("/ResultCalc")
    public String calculateResult(
            @RequestParam("num1") double num1,
            @RequestParam("num2") double num2,
            @RequestParam("operation") String operation,
            Model model) {
        double result = 0;

        switch (operation) {
            case "add":
                result = num1 + num2;
                break;
            case "subtract":
                result = num1 - num2;
                break;
            case "multiply":
                result = num1 * num2;
                break;
            case "divide":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    model.addAttribute("error", "Деление на ноль!");
                    return "calc";
                }
                break;
            default:
                model.addAttribute("error", "Неизвестная операция");
                return "calc";
        }

        model.addAttribute("result", result);
        return "resultcalc";
    }
}
