package br.com.cod3r.exercicios_sb.controllers;

import br.com.cod3r.exercicios_sb.models.entities.Cliente;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {

    @GetMapping(path = "/qualquer")
    public Cliente obterCliente(){
        return new Cliente(28, "Pedro", "123.456.789");
    }

    @GetMapping("/{id}") //clientes / id
    public Cliente obterClientePorId1(@PathVariable int id){
        return new Cliente(id, "Maria", "987.654.321-00");
    }

    @GetMapping//clientes?id=12321
    public Cliente obterClientePorId2(@RequestParam(name = "id", defaultValue = "1") int id){
        return new Cliente(id, "Joao", "111.111.111-00");
    }
}
