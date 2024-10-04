package br.com.laviquedias.hotel_unifacisa.entity;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.laviquedias.hotel_unifacisa.dto.QuartoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "numeroQuarto")
@ToString

@Entity
@Table(name = "quartos")
public class Quarto {

    @Id
    private Long numeroQuarto;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private int capacidade;

    @Column(nullable = false)
    private double preco;

    @Column(nullable = false)
    private String status;
    
    @JsonIgnore
    @OneToMany(mappedBy = "quartoEscolhido")
    private Set<Reserva> listaReservas = new HashSet<Reserva>();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "IdHotel")
    private Hotel hotel;

    
    public Quarto(QuartoDTO quarto){
        BeanUtils.copyProperties(quarto, this);
    }

}
