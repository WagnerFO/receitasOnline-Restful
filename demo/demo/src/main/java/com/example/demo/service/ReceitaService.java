package com.example.demo.service;


import com.example.demo.dto.ReceitaResponse;
import com.example.demo.entity.ReceitaEntity;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.ReceitaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;

@Service
public class ReceitaService {

    private final ReceitaRepository repositoryReceita;

    public ReceitaService(ReceitaRepository repository) {
        this.repositoryReceita = repository;
    }

    public void createReceita(ReceitaEntity receita){
        repositoryReceita.save(receita);
    }

    public Page<ReceitaEntity> getReceitas(Pageable pageable){
        return findAll();
    }

    public Page<ReceitaEntity> findAll(){
        int page = 0;
        int size = 10;
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                "titulo");
        return new PageImpl<>(
                repositoryReceita.findAll(),
                pageRequest, size);
    }
    public ReceitaResponse getReceitaById(Long id) {
        return repositoryReceita.findById(id)
                .map(u -> new ReceitaResponse(u.getTitulo()))
                .orElseThrow(() -> new NotFoundException("Receita não encontrado."));
    }

}
