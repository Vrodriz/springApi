package com.nagata.appapi;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagata.appapi.entidade.Funcionario;
import com.nagata.appapi.database.RepositorioFuncionario;


@RestController
@RequestMapping("/funcionario")
public class FuncionarioREST {
    @Autowired
    private RepositorioFuncionario repositorio;

    @GetMapping
    public List<Funcionario> listar(){
        return repositorio.findAll();   
    }

    @PostMapping
    public void salvar(@RequestBody Funcionario funcionario){    
       repositorio.save(funcionario);
    }

    @PatchMapping
    public void alterar(@RequestBody Funcionario funcionario){
        if(funcionario.getId() > 0)    
            repositorio.save(funcionario);
    }

    @DeleteMapping(path = "/{id}")
    public void excluir(@PathVariable Long id){
        repositorio.deleteById(id);        
            
    }
}


