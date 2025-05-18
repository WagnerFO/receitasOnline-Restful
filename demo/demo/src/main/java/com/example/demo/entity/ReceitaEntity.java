package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Schema(description = "Entidade que representa uma receita")
public class ReceitaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID da receita", example = "1")
    private Integer id;

    @Schema(description = "Título da receita", example = "Bolo de Cenoura")
    private String titulo;

    @Schema(description = "Descrição da receita", example = "Um bolo delicioso para o café da tarde.")
    private String descricao;

    @Schema(description = "Modo de preparo da receita", example = "Misture tudo e leve ao forno por 40 minutos.")
    private String modoPreparo;

    @ElementCollection
    @Schema(description = "Lista de ingredientes", example = "[\"2 cenouras\", \"2 ovos\", \"1 xícara de açúcar\"]")
    private List<String> ingredientes;

    @OneToMany(mappedBy = "receita", cascade = CascadeType.ALL)
    @Schema(description = "Avaliações feitas para esta receita")
    private List<AvaliacaoEntity> avaliacoes;

    // Getters e Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getModoPreparo() {
        return modoPreparo;
    }

    public void setModoPreparo(String modoPreparo) {
        this.modoPreparo = modoPreparo;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public List<AvaliacaoEntity> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<AvaliacaoEntity> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
}
