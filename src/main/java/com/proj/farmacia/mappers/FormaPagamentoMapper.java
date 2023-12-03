package com.proj.farmacia.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.proj.farmacia.dtos.formaPagamento.FormaPagamentoDTO;
import com.proj.farmacia.entities.FormaPagamento;

@Mapper
public interface FormaPagamentoMapper {
 
    FormaPagamentoMapper INSTANCE = Mappers.getMapper( FormaPagamentoMapper.class );
 
    FormaPagamentoDTO formaPagamentoToFormaPagamentoDTO(FormaPagamento formaPagamento); 
    FormaPagamento formaPagamentoDtoToFormaPagamento(FormaPagamentoDTO FormaPagamentoDTO); 
}