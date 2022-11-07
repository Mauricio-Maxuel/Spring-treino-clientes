package com.maumas.maumaslog.maxuellogapi.domain.repository;

import com.maumas.maumaslog.maxuellogapi.domain.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {

}
