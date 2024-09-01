package com.revenda_veiculos.controller;

import com.revenda_veiculos.model.Venda;
import com.revenda_veiculos.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    // Registrar a venda de um veículo
    @PostMapping
    public ResponseEntity<Venda> registrarVenda(@RequestParam Long veiculoId, @RequestParam String cpfComprador) {
        Venda venda = vendaService.registrarVenda(veiculoId, cpfComprador);
        return venda != null ? ResponseEntity.ok(venda) : ResponseEntity.badRequest().build();
    }
}
