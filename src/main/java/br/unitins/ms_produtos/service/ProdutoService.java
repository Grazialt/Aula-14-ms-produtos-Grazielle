package br.unitins.ms_produtos.service;

import br.unitins.ms_produtos.entity.Produto;
import br.unitins.ms_produtos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> listar() {
        return repository.findAll();
    }

    public Produto buscar(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    public Produto atualizar(Long id, Produto produto) {
        produto.setId(id);
        return repository.save(produto);
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }
}