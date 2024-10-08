package br.com.laviquedias.hotel_unifacisa.entity;

import java.util.Set;

import org.springframework.beans.BeanUtils;

import br.com.laviquedias.hotel_unifacisa.dto.HotelDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "idHotel")

@Entity
@Table(name = "hoteis")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHotel;
    
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String endereco;

    @OneToMany(mappedBy = "hotelQuarto")
    private Set<Quarto> quartos;

    @OneToMany(mappedBy = "hotelHospede")
    private Set<Hospede> hospedes;

    @OneToMany(mappedBy = "hotelReserva")
    private Set<Reserva> reservas;

    @OneToMany(mappedBy = "hotelFuncionario")
    private Set<Funcionario> funcionarios;

    public Hotel(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public Hotel(HotelDTO hotel){
        BeanUtils.copyProperties(hotel, this);
    }
    

    

    
}
