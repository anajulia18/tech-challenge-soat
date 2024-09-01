package com.revenda_veiculos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webhook")
public class WebhookController {

    // Endpoint para receber notificações de pagamento
    @PostMapping("/pagamento")
    public ResponseEntity<String> receberNotificacaoPagamento(@RequestParam String codigoPagamento, @RequestParam String statusPagamento) {
        // Aqui você deve implementar a lógica para processar a notificação
        // Por exemplo, atualizar o status da venda no banco de dados

        // Exemplo simplificado:
        System.out.println("Código do Pagamento: " + codigoPagamento);
        System.out.println("Status do Pagamento: " + statusPagamento);

        return ResponseEntity.ok("Notificação recebida com sucesso.");
    }
}
