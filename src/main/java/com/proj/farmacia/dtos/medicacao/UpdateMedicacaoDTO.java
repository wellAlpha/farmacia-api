package com.proj.farmacia.dtos.medicacao;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.proj.farmacia.dtos.TipoMedicacao.TipoMedicacaoDTO;
import com.proj.farmacia.dtos.composicao.ComposicaoDTO;
import com.proj.farmacia.dtos.fabricante.FabricanteDto;
import com.proj.farmacia.dtos.fornecedor.FornecedorDto;
import com.proj.farmacia.dtos.tipoConteudo.TipoConteudoDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateMedicacaoDTO {


    @NotBlank(message = "nome {notblank}")
	@NotNull(message = "nome {notnull}")
	@Length(max = 254, message = "nome {len}") 
    private String nome;

    @Positive(message = "deve ser numero inteiro positivo")
	@NotNull(message = "nome {notnull}")
    private Integer conteudo;

    @NotNull(message = "tipoConteudo {notnull}")
    @Valid
    private TipoConteudoDTO tipoConteudo;

    @NotNull(message = "fabricante {notnull}")
    @Valid
    private FabricanteDto fabricante;

    @NotNull(message = "fornecedor {notnull}")
    @Valid
    private FornecedorDto fornecedor;

    @Valid
    @NotNull(message = "composicoes {notnull}")
    @NotEmpty(message = "composicoes {notempty}")
    private List<ComposicaoDTO> composicoes;

    @Valid
    @NotNull(message = "tipoMedicacao {notnull}")
    @NotEmpty(message = "tipoMedicacao {notempty}")
    private List<TipoMedicacaoDTO> tipoMedicacao;

    
}
