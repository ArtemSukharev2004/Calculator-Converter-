package com.example.calculatorandconverter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConverterController {
    @GetMapping("/converter")
    public String converterForm() {
        return "conv";
    }

    @PostMapping("/converter")
    public String convertCurrency(
            @RequestParam("fromCurrency") String fromCurrency,
            @RequestParam("toCurrency") String toCurrency,
            @RequestParam("amount") double amount,
            Model model) {

        double USD = 97.31;
        double EUR = 102.55;
        double convertedAmount;

        if ("RUB".equals(fromCurrency) && "USD".equals(toCurrency)) {
            convertedAmount = amount * USD;
        } else if ("RUB".equals(fromCurrency) && "EUR".equals(toCurrency)) {
            convertedAmount = amount * EUR;
        } else if ("USD".equals(fromCurrency) && "EUR".equals(toCurrency)) {
            convertedAmount = amount * (USD / EUR);
        } else if ("USD".equals(fromCurrency) && "RUB".equals(toCurrency)) {
            convertedAmount = amount / USD;
        } else if ("EUR".equals(fromCurrency) && "USD".equals(toCurrency)) {
            convertedAmount = amount / EUR;
        } else if ("EUR".equals(fromCurrency) && "RUB".equals(toCurrency)) {
            convertedAmount = amount * EUR;
        } else {

            return "error";
        }

        model.addAttribute("fromCurrency", fromCurrency);
        model.addAttribute("toCurrency", toCurrency);
        model.addAttribute("amount", amount);
        model.addAttribute("convertedAmount", convertedAmount);

        return "conv";
    }
}
