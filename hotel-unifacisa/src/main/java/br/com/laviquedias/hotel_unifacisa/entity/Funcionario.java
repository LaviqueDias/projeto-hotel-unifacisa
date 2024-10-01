package br.com.laviquedias.hotel_unifacisa.entity;


import org.springframework.beans.BeanUtils;

import br.com.laviquedias.hotel_unifacisa.dto.FuncionarioDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "cpf")

@Entity
@Table(name = "funcionarios")
public class Funcionario {

    @Column(nullable = false)
    private String nome;
    
    @Id
    private String cpf;

    @Column(nullable = false)
    private String cargo;

    @Column(nullable = false)
    private double salarioPorHora;

    @Column(nullable = false)
    private String turnoDeTrabalho;

    public Funcionario(String nome, String cpf, String cargo, double salarioPorHora, String turnoDeTrabalho) {
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.salarioPorHora = salarioPorHora;
        this.turnoDeTrabalho = turnoDeTrabalho;
    }

    public Funcionario(FuncionarioDTO funcionario){
        BeanUtils.copyProperties(funcionario, this);
    }
    

    
    
}
