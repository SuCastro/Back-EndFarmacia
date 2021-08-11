package com.exercicio.farmacia.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.exercicio.farmacia.Model.ProdutoModel;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
	public List<ProdutoModel> findAllByDescricaoContainingIgnoreCase( String descricao);
}