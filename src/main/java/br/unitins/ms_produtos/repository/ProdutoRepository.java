package br.unitins.ms_produtos.repository;

import br.unitins.ms_produtos.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}