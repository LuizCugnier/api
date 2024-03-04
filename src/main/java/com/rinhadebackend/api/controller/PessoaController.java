package com.rinhadebackend.api.controller;

import com.rinhadebackend.api.model.Pessoa;
import com.rinhadebackend.api.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class PessoaController {
    private final PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @RequestMapping(value = "/pessoas", method = RequestMethod.POST)
    public Pessoa Post(@Valid @RequestBody Pessoa pessoa)
    {
        return pessoaService.salvarPessoa(pessoa);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex)
    {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Requisição inválida: " + ex.getMessage());
    }

    //APENAS PARA TESTES (RETIRAR DPS)
//    @RequestMapping(value = "/pessoas/all", method = RequestMethod.GET)
//    public List<Pessoa> Get()
//    {
//        return pessoaService.findPessoas();
//    }

    @RequestMapping(value = "/pessoas/{id}", method = RequestMethod.GET)
    public Optional<Pessoa> GetPessoaId(@PathVariable("id") UUID id)
    {
        return pessoaService.getPessoa(id);
    }

    @RequestMapping(value = "/pessoas", method = RequestMethod.GET)
    public List<Pessoa> GetPessoaTerms(@RequestParam(value = "t") String termo)
    {
        return pessoaService.buscaPessoaTermo(termo);
    }

    @RequestMapping(value = "/contagem-pessoas", method = RequestMethod.GET)
    public Long GetPessoaCount()
    {
        return pessoaService.contagemPessoas();
    }

}
