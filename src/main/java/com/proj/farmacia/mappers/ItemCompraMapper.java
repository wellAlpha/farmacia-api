package com.proj.farmacia.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.proj.farmacia.dtos.funcionario.FuncionarioDTO;
import com.proj.farmacia.dtos.itemCompra.ItemCompraDTO;
import com.proj.farmacia.entities.Funcionario;
import com.proj.farmacia.entities.ItemCompra;

@Mapper
public interface ItemCompraMapper {
 
    ItemCompraMapper INSTANCE = Mappers.getMapper( ItemCompraMapper.class );
 
    ItemCompraDTO itemCompraToItemCompraDto(ItemCompra itemCompra); 
    ItemCompra ItemCompraDtoToItemCompra(ItemCompraDTO itemCompraDTO); 
}