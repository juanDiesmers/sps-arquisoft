package com.arquisoft.negociocomercio.clientes.service;

import com.arquisoft.negociocomercio.clientes.config.RabbitMQConfiguration;
import com.arquisoft.negociocomercio.clientes.dto.ClienteMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListenerEventos {

    private final ClienteService clienteService;

    public ListenerEventos(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @RabbitListener(queues = RabbitMQConfiguration.COLA_CLIENTES)
    public void recibirClientes(List<ClienteMessage> clientes) {
        System.out.println("Clientes recibidos desde RabbitMQ: " + clientes.size());

        clientes.forEach(cliente -> System.out.println(" -> " + cliente));

        clienteService.guardarDesdeEventos(clientes);
    }
}