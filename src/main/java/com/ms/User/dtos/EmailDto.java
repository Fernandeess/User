package com.ms.User.dtos;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmailDto {
        private UUID userID;
        private String emailTo;
        private String subject;
        private String text;
}
