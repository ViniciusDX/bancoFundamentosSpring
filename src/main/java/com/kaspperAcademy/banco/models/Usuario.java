package com.kaspperAcademy.banco.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", unique = true, nullable = false, length = 60)
    @NotBlank(message = "Campo [nome] é obrigatorio")
    @Size(min = 5, max = 60, message = "O [nome] deve ter entre 5 e 60 caracteres!")
    private String nome;

    @OneToMany(mappedBy = "usuario")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Apontamento> apontamentos = new ArrayList <Apontamento>();

    @Column(name = "email", length = 60)
    @NotBlank
    @Email(message = "Informe um email válido")
    private String email;

    @Column(name = "data_nascimento")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Past
    private LocalTime dataNascimento;


}
