package br.com.laviquedias.hotel_unifacisa.dto;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import br.com.laviquedias.hotel_unifacisa.entity.Funcionario;
import br.com.laviquedias.hotel_unifacisa.entity.Hospede;
import br.com.laviquedias.hotel_unifacisa.entity.Hotel;
import br.com.laviquedias.hotel_unifacisa.entity.Quarto;
import br.com.laviquedias.hotel_unifacisa.entity.Reserva;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class HotelDTO {

    private Long idHotel;    
    private String nome;
    private String endereco;
    private Set<Quarto> quartos = new HashSet<Quarto>();
    private Set<Hospede> hospedes = new HashSet<Hospede>();
    private Set<Reserva> reserva = new HashSet<Reserva>();
    private Set<Funcionario> funcionarios = new HashSet<Funcionario>();

    public HotelDTO(Hotel hotel){
        BeanUtils.copyProperties(hotel, this);
    }


}
