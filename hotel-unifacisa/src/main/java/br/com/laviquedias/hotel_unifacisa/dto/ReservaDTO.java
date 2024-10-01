package br.com.laviquedias.hotel_unifacisa.dto;

import org.springframework.beans.BeanUtils;

import br.com.laviquedias.hotel_unifacisa.entity.Hospede;
import br.com.laviquedias.hotel_unifacisa.entity.Quarto;
import br.com.laviquedias.hotel_unifacisa.entity.Reserva;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class ReservaDTO {

    private Long idReserva;
    private String dataDeEntrada;
    private String dataDeSaida;
    private String tipoDeQuarto;
    private int qntdHospedes;
    private Quarto quartoEscolhido;
    private Hospede hospedeEscolhido;
    private String registroEntrada;
    private String registroSaida;

    public ReservaDTO(Reserva reserva){
        BeanUtils.copyProperties(reserva, this);
    }

}
