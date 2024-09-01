package com.revenda_veiculos.service;

import com.revenda_veiculos.model.Veiculo;
import com.revenda_veiculos.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public Veiculo cadastrarVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public Veiculo editarVeiculo(Long id, Veiculo veiculoAtualizado) {
        Optional<Veiculo> veiculoExistente = veiculoRepository.findById(id);
        if (veiculoExistente.isPresent()) {
            Veiculo veiculo = veiculoExistente.get();
            veiculo.setMarca(veiculoAtualizado.getMarca());
            veiculo.setModelo(veiculoAtualizado.getModelo());
            veiculo.setAno(veiculoAtualizado.getAno());
            veiculo.setCor(veiculoAtualizado.getCor());
            veiculo.setPreco(veiculoAtualizado.getPreco());
            return veiculoRepository.save(veiculo);
        }
        return null; // ou lançar exceção
    }

    public List<Veiculo> listarVeiculosDisponiveis() {
        return veiculoRepository.findByVendidoFalseOrderByPrecoAsc();
    }

    public List<Veiculo> listarVeiculosVendidos() {
        return veiculoRepository.findByVendidoTrueOrderByPrecoAsc();
    }
}
