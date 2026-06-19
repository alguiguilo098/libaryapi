package com.example.libaryapi2.repository;

import com.example.libaryapi2.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AutorRespository extends JpaRepository<Autor, UUID> {
  List<Autor> findByNome(String nome);
  List<Autor>findByNacionalidade(String nacionalidade);
  List<Autor> findByNacionalidadeAndNome(String nome,String nacionalidade);
}
