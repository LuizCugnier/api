package com.rinhadebackend.api.repository;

import com.rinhadebackend.api.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {

    List<Pessoa> findByApelidoContainingOrNomeContainingOrStackContaining(String termo, String termo2, String termo3);

}
