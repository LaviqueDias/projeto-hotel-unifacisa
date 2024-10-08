package br.com.laviquedias.hotel_unifacisa.entity;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.laviquedias.hotel_unifacisa.dto.HospedeDTO;
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
@ToString
@EqualsAndHashCode(of = "cpf")
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "hospedes")
public class Hospede {
    
    @Id
    private String cpf;
    
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String dataNascimento;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String telefone;

    @JsonIgnore
    @OneToMany(mappedBy = "hospedeEscolhido")
    private Set<Reserva> historicoReservas = new HashSet<Reserva>();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idHotel")
    private Hotel hotelHospede;


    public Hospede(HospedeDTO hospede){
        BeanUtils.copyProperties(hospede, this);
    }

    

    


}
