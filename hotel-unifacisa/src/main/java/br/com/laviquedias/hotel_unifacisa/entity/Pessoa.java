package br.com.laviquedias.hotel_unifacisa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@EqualsAndHashCode(of = "cpf")
public class Pessoa {

    @Column(nullable = false)
    protected String nome;
    
    @Id
    protected String cpf;

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    
}
