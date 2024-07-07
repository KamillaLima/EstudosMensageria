package com.ms.email.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="tb_email")
@Setter
@Getter
public class Email implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy= GenerationType.AUTO)
    private UUID emailId;
    //Id do usuário
    private UUID userId;
    //Quem enviou o email
    private String emailFrom;
    //Pra quem foi mandado o email
    private String emailTo;
    //Titulo
    private String subject;
    //Texto do email
    //Esse column é pra definir q é do tipo text,pra conseguir guardar mais caracteres
    @Column(columnDefinition = "TEXT")
    private String text;
    //Quando o email foi enviado
    private LocalDateTime sendDateEmail;
    @Enumerated(EnumType.STRING)
    private StatusEmail statusEmail;
}
