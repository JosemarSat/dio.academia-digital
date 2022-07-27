package me.dio.academia.digital.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.service.impl.MatriculaServiceImpl;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

  @Autowired
  private MatriculaServiceImpl service;

  @PostMapping
  public Matricula create(@Valid @RequestBody MatriculaForm form) {
    return service.create(form);
  }

  @GetMapping
  public List<Matricula> getAll(@RequestParam(value = "bairro", required = false) String bairro) {
    return service.getAll(bairro);
  }

  @DeleteMapping(value = "delete/{id}")//, method = RequestMethod.DELETE)
  public void delete(@PathVariable Long id) {
    try {
      service.delete(id);
    } catch (Exception e) {
        //Essa mensagem será sempre mostrada porquê seria necessário usarmos o CASCADE
        System.err.println(e + " - Matrícula não pode ser excluída.");
    }
  }

}