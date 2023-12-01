package com.proj.farmacia.dtos.compra;

import java.util.List;

import com.proj.farmacia.dtos.cliente.ClienteDTO;
import com.proj.farmacia.dtos.formaPagamento.FormaPagamentoDTO;
import com.proj.farmacia.dtos.funcionario.FuncionarioDTO;
import com.proj.farmacia.dtos.itemCompra.ItemCompraDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraDTO {
    private int parcelas;
    @Valid
    @NotNull(message = "cliente {notnull}")
    private ClienteDTO cliente;
    @Valid
    @NotNull(message = "formaPagamento {notnull}")
    private FormaPagamentoDTO formaPagamento;
    @Valid
    @NotNull(message = "funcionario {notnull}")
    private FuncionarioDTO funcionario;

    @Valid
    @NotNull(message = "itensCompra {notnull}")
    @NotEmpty(message = "itensCompra {notempty}")
    private List<ItemCompraDTO> itensCompra;

    public Double getTotal() {
        Double total =  Double.MIN_NORMAL;
        for (ItemCompraDTO itemCompraDTO : itensCompra) {
            if(itemCompraDTO.getPrecoUnitario() != null) {
                total += itemCompraDTO.getPrecoUnitario();
            }
        }
        return total;
    }
}
