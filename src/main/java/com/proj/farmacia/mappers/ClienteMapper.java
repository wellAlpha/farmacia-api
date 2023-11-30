package com.proj.farmacia.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.proj.farmacia.dtos.cliente.ClienteDTO;
import com.proj.farmacia.entities.Cliente;

@Mapper
public interface ClienteMapper {
 
    ClienteMapper INSTANCE = Mappers.getMapper( ClienteMapper.class );
 
    ClienteDTO clienteToClienteDto(Cliente cliente); 
    Cliente clienteDtoToCliente(ClienteDTO clienteDTO); 
}