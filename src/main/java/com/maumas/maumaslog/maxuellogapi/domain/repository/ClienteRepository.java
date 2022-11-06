package com.maumas.maumaslog.maxuellogapi.domain.repository;

import com.maumas.maumaslog.maxuellogapi.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNomeContaining(String nome);
    List<Cliente> findByNome(String nome);
    Optional<Cliente> findByEmail(String email);

}
