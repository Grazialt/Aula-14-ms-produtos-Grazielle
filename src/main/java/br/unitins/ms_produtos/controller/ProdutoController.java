package br.unitins.ms_produtos;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @GetMapping
    public String teste() {
        return "API de produtos funcionando!";
    }
}