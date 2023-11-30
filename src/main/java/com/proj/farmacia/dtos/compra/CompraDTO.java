package com.proj.farmacia.dtos.compra;

import java.math.BigDecimal;
import java.util.List;

import com.proj.farmacia.dtos.cliente.ClienteDTO;
import com.proj.farmacia.dtos.formaPagamento.FormaPagamentoDTO;
import com.proj.farmacia.dtos.funcionario.FuncionarioDTO;
import com.proj.farmacia.dtos.itemCompra.ItemCompraDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraDTO {
    private int parcelas;
    @Valid
    private ClienteDTO cliente;
    @Valid
    private FormaPagamentoDTO formaPagamento;
    @Valid
    private FuncionarioDTO funcionario;

    
    @NotEmpty(message = "itensCompra {notempty}")
    private List<@Valid ItemCompraDTO> itensCompra;

    public BigDecimal getTotal() {
        BigDecimal total =  BigDecimal.ZERO;
        for (ItemCompraDTO itemCompraDTO : itensCompra) {
            total.add(itemCompraDTO.getPrecoUnitario());
        }
        return total;
    }
}
