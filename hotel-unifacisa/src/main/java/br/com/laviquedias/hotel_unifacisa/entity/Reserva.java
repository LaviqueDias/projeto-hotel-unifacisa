package br.com.laviquedias.hotel_unifacisa.entity;



import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.laviquedias.hotel_unifacisa.dto.ReservaDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@EqualsAndHashCode(of = "idReserva")
@ToString

@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;

    @Column(nullable = false)
    private String dataDeEntrada;

    @Column(nullable = false)
    private String dataDeSaida;

    @Column(nullable = false)
    private String tipoDeQuarto;

    @Column(nullable = false)
    private int qntdHospedes;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "quartosEscolhidos",  referencedColumnName = "numeroQuarto")
    private Quarto quartoEscolhido;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "hospedesEscolhidos",  referencedColumnName = "cpf")
    private Hospede hospedeEscolhido;

    @Column(nullable = false)
    private String registroEntrada;


    @Column(nullable = false)
    private String registroSaida;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idHotel")
    private Hotel hotelReserva;

    public Reserva(ReservaDTO reserva){
        BeanUtils.copyProperties(reserva, this);
    }
    
}
