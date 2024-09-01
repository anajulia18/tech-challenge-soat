package com.revenda_veiculos.service;

import com.revenda_veiculos.model.Venda;
import com.revenda_veiculos.repository.VeiculoRepository;
import com.revenda_veiculos.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    public Venda registrarVenda(Long veiculoId, String cpfComprador) {
        return veiculoRepository.findById(veiculoId).map(veiculo -> {
            veiculo.setVendido(true);
            veiculoRepository.save(veiculo);
            Venda venda = new Venda(null, cpfComprador, new Date(), veiculo);
            return vendaRepository.save(venda);
        }).orElse(null); // ou lançar exceção
    }
}
