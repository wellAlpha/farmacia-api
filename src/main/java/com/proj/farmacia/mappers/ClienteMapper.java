package com.proj.farmacia.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.proj.farmacia.dtos.cliente.CreateClienteDTO;
import com.proj.farmacia.entities.Cliente;

@Mapper
public interface ClienteMapper {
 
    ClienteMapper INSTANCE = Mappers.getMapper( ClienteMapper.class );
 
    // @Mapping(source = "numberOfSeats", target = "seatCount")
    CreateClienteDTO clienteToCreateClienteDto(Cliente cliente); 
    Cliente createClienteDtoToCliente(CreateClienteDTO createClienteDTO); 
}