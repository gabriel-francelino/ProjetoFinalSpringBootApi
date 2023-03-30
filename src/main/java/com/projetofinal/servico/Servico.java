package com.projetofinal.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projetofinal.modelo.Aluno;
import com.projetofinal.modelo.Mensagem;
import com.projetofinal.repositorio.Repositorio;

@Service
public class Servico {
    @Autowired
    private Mensagem msg;

    @Autowired
    private Repositorio acao;

    // cadastrar aluno
    public ResponseEntity<?> cadastrar(Aluno obj){
        if (obj.getNome().equals("")) {
            msg.setMensagem("O nome não pode ser nulo!");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        } else if(obj.getNota1() < 0 || obj.getNota2() < 0) {
            msg.setMensagem("As notas devem ser maiores que zero!");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(acao.save(obj), HttpStatus.CREATED);
        }
    }

    // buscar aluno
    public ResponseEntity<?> buscar(){
        return new ResponseEntity<>(acao.findAll(), HttpStatus.OK);
    }

    // buscar aluno
    public ResponseEntity<?> buscarId(int id){
        if (!acao.existsById(id)) {
            msg.setMensagem("Id não encontrado!");
            return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
        } else{
            return new ResponseEntity<>(acao.findById(id), HttpStatus.OK);
        }
    }

    // atualizar dados do aluno
    public ResponseEntity<?> atualizar(Aluno obj){
        if (!acao.existsById(obj.getId())) {
            msg.setMensagem("Aluno não encontrado!");
            return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
        } 
        else if(obj.getNome().equals("")) {
            msg.setMensagem("O nome não pode ser vazio!");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);            
        }
        else if(obj.getNota1() < 0 || obj.getNota2() < 0) {
            msg.setMensagem("As notas devem ser maiores que zero!");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);            
        }
        else {
            return new ResponseEntity<>(acao.save(obj), HttpStatus.OK);
        }
    }

    //remover aluno
    public ResponseEntity<?> remover(int id){
        if (!acao.existsById(id)) {
            msg.setMensagem("Aluno não encontrado!");
            return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
        } else {
            Aluno obj = acao.findById(id);
            acao.delete(obj);
            msg.setMensagem("Aluno removido com sucesso!");
            return new ResponseEntity<>(msg, HttpStatus.OK);
        }
    }

    // contar quantos alunos tem
    public ResponseEntity<?> contar(){
        msg.setMensagem("O número de alunos é: " + acao.count());
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
