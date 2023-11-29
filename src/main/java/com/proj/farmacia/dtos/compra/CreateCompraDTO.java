package com.proj.farmacia.dtos.compra;

import com.proj.farmacia.dtos.cliente.CreateClienteDTO;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCompraDTO {
    @Valid
    private CreateClienteDTO cliente;
}
