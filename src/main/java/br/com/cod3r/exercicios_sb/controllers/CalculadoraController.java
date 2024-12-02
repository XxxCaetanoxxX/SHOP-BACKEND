package br.com.cod3r.exercicios_sb.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/calculadora")
public class CalculadoraController {

    @GetMapping("/somar/{num1}/{num2}")
    public int somar(@PathVariable int num1, @PathVariable int num2) {
        return num1 + num2;
    }

    @GetMapping(path = "/subtrair")
    public int subtrair(
            @RequestParam(name = "num1") int num1,
            @RequestParam(name = "num2") int num2) {
        return num1 - num2;
    }
}
