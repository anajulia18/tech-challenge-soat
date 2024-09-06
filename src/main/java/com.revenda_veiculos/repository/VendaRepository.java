package com.revenda_veiculos.repository;

import com.revenda_veiculos.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {}
