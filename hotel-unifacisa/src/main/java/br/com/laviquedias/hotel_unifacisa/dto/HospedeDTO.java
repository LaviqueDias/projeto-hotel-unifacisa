package br.com.laviquedias.hotel_unifacisa.dto;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import br.com.laviquedias.hotel_unifacisa.entity.Hospede;
import br.com.laviquedias.hotel_unifacisa.entity.Reserva;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class HospedeDTO {

    private String nome;
    private String cpf;
    private String dataNascimento;
    private String endereco;
    private String telefone;
    private Set<Reserva> historicoReservas = new HashSet<Reserva>();

    public HospedeDTO(Hospede hospede){
        BeanUtils.copyProperties(hospede, this);
    }


}
