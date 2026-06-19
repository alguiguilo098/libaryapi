package com.example.libaryapi2.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table
@ToString(exclude = "autor")
@Data
public class Livro {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id")
  UUID id;

  @Column(name = "data_de_publicaçao")
  LocalDate data_de_publicaçao;

  @Column
  @Enumerated(value = EnumType.STRING)
  GeneroLivro generoLivro;

  @Column
  BigDecimal preco;

  @Column(nullable = false,name = "titulo",length = 255)
  String titulo;

  @Column
  String isbn;

  @ManyToOne(fetch =FetchType.EAGER)
  @JoinColumn(name="autor_id")
  Autor autor;
}
