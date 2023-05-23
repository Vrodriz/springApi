package com.nagata.appapi.database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagata.appapi.entidade.Funcionario;

public interface RepositorioFuncionario extends JpaRepository<Funcionario,Long> {
      


}