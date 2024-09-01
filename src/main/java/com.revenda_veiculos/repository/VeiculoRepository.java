package com.revenda_veiculos.repository;

import com.revenda_veiculos.model.Veiculo;
import com.revenda_veiculos.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    List<Veiculo> findByVendidoFalseOrderByPrecoAsc();
    List<Veiculo> findByVendidoTrueOrderByPrecoAsc();
}

