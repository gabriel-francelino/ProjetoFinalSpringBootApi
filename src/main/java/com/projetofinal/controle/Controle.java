package com.projetofinal.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projetofinal.modelo.Aluno;
import com.projetofinal.servico.Servico;

@RestController
public class Controle {

    @Autowired
    private Servico servico;

    @GetMapping("/alunos")
    public ResponseEntity<?> buscar(){
        return servico.buscar();
    }

    @GetMapping("/alunos/{id}")
    public ResponseEntity<?> buscarId(@PathVariable int id){
        return servico.buscarId(id);
    }

    @PostMapping("/alunos")
    public ResponseEntity<?> cadastrar(@RequestBody Aluno obj){
        return servico.cadastrar(obj);
    }

    @PutMapping("/alunos")
    public ResponseEntity<?> atualizar(@RequestBody Aluno obj){
        return servico.atualizar(obj);
    }

    @DeleteMapping("alunos/{id}")
    public ResponseEntity<?> remover(@PathVariable int id){
        return servico.remover(id);
    }

    @GetMapping("alunos/contador")
    public ResponseEntity<?> contar(){
        return servico.contar();
    }
     
}
