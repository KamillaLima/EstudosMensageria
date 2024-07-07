package com.ms.email.dto;

import java.util.UUID;

public record EmailRecordDto(UUID userId ,
                             String emailTo,
                             String subject,
                             String text) {
                //Id do usuário
                //email do usuário
                // titulo do email
                // texto do email
}
