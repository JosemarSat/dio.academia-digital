package me.dio.academia.digital.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.service.impl.AvaliacaoFisicaServiceImpl;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    @Autowired
    private AvaliacaoFisicaServiceImpl service;

    @PostMapping
    public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaForm formUpdate) {
        return service.create(formUpdate);
    }
    @PutMapping("atualizacao/{id}")
    public AvaliacaoFisica update(@PathVariable Long id, @Valid @RequestBody AvaliacaoFisicaUpdateForm formUpdate) {
    return service.update(id, formUpdate);
  }

  @DeleteMapping(value = "delete/{id}")//, method = RequestMethod.DELETE)
  public void delete(@PathVariable Long id) {
    try {
      service.delete(id);
    } catch (Exception e) {
      //Essa mensagem será sempre mostrada porquê seria necessário usarmos o CASCADE
        System.err.println(e + " - Avaliação não pode ser excluída.");
    }
  }
}
