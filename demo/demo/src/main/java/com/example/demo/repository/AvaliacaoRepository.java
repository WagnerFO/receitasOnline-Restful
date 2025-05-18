package com.example.demo.repository;

import com.example.demo.entity.AvaliacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoRepository extends JpaRepository<AvaliacaoEntity, Long> {
}
