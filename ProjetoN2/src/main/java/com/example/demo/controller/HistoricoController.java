package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Animal;
import com.example.demo.entity.Historico;
import com.example.demo.repository.HistoricoRepository;

@RestController
@RequestMapping("/historico")
public class HistoricoController {

  @Autowired
  private HistoricoRepository historicoRepository;

  @GetMapping
  public List<Historico> listarTodos() {
    return historicoRepository.findAll();
  }

  @GetMapping("/{id}")
  public Historico findById(@PathVariable Long id) {
      return historicoRepository.findById(id)
              .orElseThrow();
  }
  
  
  @PutMapping("/{id}")
  public Historico update(@PathVariable Long id, @RequestBody Historico historicoDetails) {
      Historico historico = historicoRepository.findById(id)
      		.orElseThrow();        
      historico.setIdAnimal(historicoDetails.getIdAnimal());
      historico.setIdCliente(historicoDetails.getIdCliente());
      historico.setData(historicoDetails.getData());
      historico.setTipoOperacao(historicoDetails.getTipoOperacao());
      Historico updateHistorico = historicoRepository.save(historico);
      return updateHistorico;
  }

  @PostMapping
  public Historico adicionar(@RequestBody Historico historico) {
    return historicoRepository.save(historico);
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<Historico> deleteHistorico(@PathVariable(value = "id") Long historicoID) {
  	Historico historico = historicoRepository.findById(historicoID)
      		.orElseThrow(); 
      if (historico == null) {
          return ResponseEntity.notFound().build();
      }

      historicoRepository.delete(historico);
      return ResponseEntity.ok().build();
  }

}
