package com.rinhadebackend.api.service;

import com.rinhadebackend.api.model.Pessoa;
import com.rinhadebackend.api.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository)
    {
        this.pessoaRepository = pessoaRepository;
    }

    public Pessoa salvarPessoa(Pessoa pessoa)
    {
        return pessoaRepository.save(pessoa);
    }

//    public List<Pessoa> findPessoas()
//    {
//        return pessoaRepository.findAll();
//    }

    public Optional<Pessoa> getPessoa(UUID id)
    {
        return pessoaRepository.findById(id);
    }

    //Pega todas as instancias dentro do repositorio pessoas e filtra
//    public List<Pessoa> getPessoaByTerms(String termo)
//    {
//        return pessoaRepository.findAll().stream()
//                .filter(pessoa ->
//                        pessoa.getApelido().contains(termo) ||
//                        pessoa.getNome().contains(termo) ||
//                        pessoa.getStack().stream().anyMatch(s -> s.contains(termo))
//                )
//                .limit(50)
//                .collect(Collectors.toList());
//    }

    public List<Pessoa> buscaPessoaTermo(String termo)
    {
        return pessoaRepository.findByApelidoContainingOrNomeContainingOrStackContaining(termo, termo, termo);
    }

    public Long contagemPessoas()
    {
        return pessoaRepository.count();
    }
}
