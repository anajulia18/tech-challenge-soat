package com.revenda_veiculos.controller;

import com.revenda_veiculos.model.Veiculo;
import com.revenda_veiculos.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    // Cadastrar um novo veículo
    @PostMapping
    public ResponseEntity<Veiculo> cadastrarVeiculo(@RequestBody Veiculo veiculo) {
        Veiculo novoVeiculo = veiculoService.cadastrarVeiculo(veiculo);
        return ResponseEntity.ok(novoVeiculo);
    }

    // Editar os dados de um veículo existente
    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> editarVeiculo(@PathVariable Long id, @RequestBody Veiculo veiculoAtualizado) {
        Veiculo veiculoEditado = veiculoService.editarVeiculo(id, veiculoAtualizado);
        return veiculoEditado != null ? ResponseEntity.ok(veiculoEditado) : ResponseEntity.notFound().build();
    }

    // Listar veículos disponíveis para venda, ordenados por preço (do mais barato para o mais caro)
    @GetMapping("/disponiveis")
    public ResponseEntity<List<Veiculo>> listarVeiculosDisponiveis() {
        List<Veiculo> veiculos = veiculoService.listarVeiculosDisponiveis();
        return ResponseEntity.ok(veiculos);
    }

    // Listar veículos vendidos, ordenados por preço (do mais barato para o mais caro)
    @GetMapping("/vendidos")
    public ResponseEntity<List<Veiculo>> listarVeiculosVendidos() {
        List<Veiculo> veiculos = veiculoService.listarVeiculosVendidos();
        return ResponseEntity.ok(veiculos);
    }
}
