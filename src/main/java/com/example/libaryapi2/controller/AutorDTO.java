package com.example.libaryapi2.controller;

import com.example.libaryapi2.model.Autor;

import java.time.LocalDate;
import java.util.UUID;

public record AutorDTO(UUID id, String nome, LocalDate dataNascimento, String nacionalidade) {


  Autor toEntity() {
    Autor autor = new Autor();
    autor.setNome(nome);
    autor.setData(dataNascimento);
    autor.setNacionalidade(nacionalidade);
    return autor;
  }
}
