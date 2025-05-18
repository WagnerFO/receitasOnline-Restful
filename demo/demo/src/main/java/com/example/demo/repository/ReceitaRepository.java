package com.example.demo.repository;

import com.example.demo.entity.ReceitaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaRepository extends JpaRepository<ReceitaEntity, Long> {

}
