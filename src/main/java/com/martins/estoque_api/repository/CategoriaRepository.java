package com.martins.estoque_api.repository;

import com.martins.estoque_api.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
