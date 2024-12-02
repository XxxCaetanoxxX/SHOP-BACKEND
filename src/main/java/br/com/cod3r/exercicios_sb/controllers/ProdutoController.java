package br.com.cod3r.exercicios_sb.controllers;

import br.com.cod3r.exercicios_sb.models.entities.Produto;
import br.com.cod3r.exercicios_sb.models.repositories.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public @ResponseBody Produto novoProduto(@RequestParam String nome,
                                             @RequestParam double preco,
                                             @RequestParam double desconto){
        Produto produto = new Produto(nome, preco, desconto);
        produtoRepository.save(produto);
        return produto;
    }

    //dar preferencia
    @RequestMapping(method = {RequestMethod.PUT, RequestMethod.POST}, path = "/objetoCompleto")
    public @ResponseBody Produto salvarProduto(@Valid @RequestBody Produto produto){
        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping
    public Iterable<Produto> obterProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping("/nome/{nome}")
    public Iterable<Produto> obterProdutosPorNome(@PathVariable String nome){
//        return produtoRepository.findByNomeContainingIgnoreCase(nome);
        return produtoRepository.searchByNameLike(nome);
    }


    //busca paginada
    @GetMapping(path = "/pagina/{numeroDaPagina}/{itensPorPag}")
    public Iterable<Produto> obterProdutoPorPagina(@PathVariable int numeroDaPagina,
                                                   @PathVariable int itensPorPag){
        if(itensPorPag >5) itensPorPag = 5;

        //org.springframework.data.domain.Pageable;
        Pageable page = PageRequest.of(numeroDaPagina, itensPorPag);
        return produtoRepository.findAll(page);
    }

    @GetMapping("/{id}")
    public Optional<Produto> obterProdutoPorId(@PathVariable int id){
        return produtoRepository.findById(id);
    }

//    @PutMapping
//    public Produto atualizarProduto(@Valid Produto produto){
//        produtoRepository.save(produto);
//        return produto;
//    }

    @DeleteMapping(path = "/{id}")
    public void excluirProduto(@PathVariable int id){
        produtoRepository.deleteById(id);
    }

}
