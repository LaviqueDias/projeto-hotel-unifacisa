package br.com.laviquedias.hotel_unifacisa.dto;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import br.com.laviquedias.hotel_unifacisa.entity.Hotel;
import br.com.laviquedias.hotel_unifacisa.entity.Quarto;
import br.com.laviquedias.hotel_unifacisa.entity.Reserva;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class QuartoDTO {

    private Long numeroQuarto;
    private String tipo;
    private int capacidade;
    private double preco;
    private String status;
    private Set<Reserva> listaReservas = new HashSet<Reserva>();
    private Hotel hotelQuarto;

    public QuartoDTO(Quarto quarto){
        BeanUtils.copyProperties(quarto, this);
    }


}
