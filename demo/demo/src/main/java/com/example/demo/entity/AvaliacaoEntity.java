package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import java.util.List;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Schema(description = "Representa uma avaliação de um usuário para uma receita")
public class AvaliacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Schema(description = "ID da avaliação", example = "101")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Schema(description = "Usuário que fez a avaliação")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "receita_id")
    @Schema(description = "Receita que foi avaliada")
    private ReceitaEntity receita;

    @Min(1)
    @Max(5)
    @Schema(description = "Nota atribuída, de 1 a 5", example = "4")
    private int nota;

    @Size(max = 500)
    @Schema(description = "Comentário adicional da avaliação", example = "Receita maravilhosa!")
    private String comentario;

    public AvaliacaoEntity() {}

    public AvaliacaoEntity(Integer id, UserEntity user, ReceitaEntity receita, int nota, String comentario) {
        this.id = id;
        this.user = user;
        this.receita = receita;
        this.nota = nota;
        this.comentario = comentario;
    }

    public String formatarAvaliacao() {
        String nomeUsuario = user != null && user.getName() != null ? user.getName() : "Usuário desconhecido";
        return nomeUsuario + " - avaliou com " + nota + "estrelas: " + comentario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public ReceitaEntity getReceita() {
        return receita;
    }

    public void setReceita(ReceitaEntity receita) {
        this.receita = receita;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
