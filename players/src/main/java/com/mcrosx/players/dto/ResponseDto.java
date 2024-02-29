package com.mcrosx.players.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data@AllArgsConstructor
public class ResponseDto {
    private String statusCode;

    private String statusMessage;
}
