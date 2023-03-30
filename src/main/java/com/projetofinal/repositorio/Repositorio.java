package com.projetofinal.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.projetofinal.modelo.Aluno;

public interface Repositorio extends CrudRepository<Aluno, Integer>{
    List<Aluno> findAll();
    Aluno findById(int id);
}
