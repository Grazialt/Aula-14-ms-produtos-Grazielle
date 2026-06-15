package br.unitins.ms_produtos.controller;

import br.unitins.ms_produtos.entity.Produto;
import br.unitins.ms_produtos.repository.ProdutoRepository;
import jakarta.validation.Valid;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository repository;

    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Produto> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrar(@Valid @RequestBody Produto produto) {

        produto.setId(null);

        Produto salvo = repository.save(produto);

        return ResponseEntity.status(201).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody Produto produto) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        produto.setId(id);

        Produto atualizado = repository.save(produto);

        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}