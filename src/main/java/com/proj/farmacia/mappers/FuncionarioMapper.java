package com.proj.farmacia.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.proj.farmacia.dtos.funcionario.FuncionarioDTO;
import com.proj.farmacia.entities.Funcionario;

@Mapper
public interface FuncionarioMapper {
 
    FuncionarioMapper INSTANCE = Mappers.getMapper( FuncionarioMapper.class );
 
    FuncionarioDTO funcionarioToFuncionarioDto(Funcionario funcionario); 
    Funcionario funcionarioDtoToFuncionario(FuncionarioDTO funcionarioDto); 
}