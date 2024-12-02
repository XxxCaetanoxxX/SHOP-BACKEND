package br.com.cod3r.exercicios_sb.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/metodos")
public class MetodosHttpController {

    @GetMapping
    public String get(){
        return "requisição GET";
    }

    @PostMapping
    public String post(){
        return "requisição POST";
    }

    @PutMapping
    public String put(){
        return "requisição PUT";
    }

    @PatchMapping
    public String path(){
        return "requisição PATH";
    }

    @DeleteMapping
    public String delete(){
        return "requisição DELETE";
    }
}
