package br.com.laviquedias.hotel_unifacisa.entity;

import java.util.Set;

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
    protected Long idHotel;
    
    @Column(nullable = false)
    protected String nome;

    @Column(nullable = false)
    protected String endereco;

    @OneToMany(mappedBy = "hotel")
    private Set<Quarto> listaQuartos;

    @OneToMany(mappedBy = "hotel")
    private Set<Hospede> listaHospedes;

    @OneToMany(mappedBy = "hotel")
    private Set<Reserva> listaReserva;

    @OneToMany(mappedBy = "hotel")
    private Set<Reserva> listaFuncionarios;

    public Hotel(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }
    

    

    
}
