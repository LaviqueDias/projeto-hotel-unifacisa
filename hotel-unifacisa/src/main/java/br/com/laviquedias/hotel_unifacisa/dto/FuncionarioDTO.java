package br.com.laviquedias.hotel_unifacisa.dto;

import org.springframework.beans.BeanUtils;

import br.com.laviquedias.hotel_unifacisa.entity.Funcionario;
import br.com.laviquedias.hotel_unifacisa.entity.Hotel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class FuncionarioDTO {

    private String nome;
    private String cpf;
    private String cargo;
    private double salarioPorHora;
    private String turnoDeTrabalho;
    private Hotel hotelFuncionario;

    public FuncionarioDTO(Funcionario funcionario){
        BeanUtils.copyProperties(funcionario, this);
    }

}
