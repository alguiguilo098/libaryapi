package com.example.libaryapi2.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "autores")
@ToString(exclude = "lista")
@Data
public class Autor {
  @Column(name = "nome", nullable = false)
  private String nome;

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id",nullable = false)
  UUID id;

  @Column(nullable = false,name = "nacionalidade",length = 30)
  String nacionalidade;

  @Column(nullable = false,name = "data")
  LocalDate data;

  @OneToMany(mappedBy = "autor",fetch = FetchType.EAGER)
  List<Livro> lista;
}
