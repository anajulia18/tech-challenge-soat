package com.revenda_veiculos.repository;

import com.revenda_veiculos.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    List<Veiculo> findByVendidoFalseOrderByPrecoAsc();
    List<Veiculo> findByVendidoTrueOrderByPrecoAsc();
}
