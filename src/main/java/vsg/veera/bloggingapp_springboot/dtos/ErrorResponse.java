package vsg.veera.bloggingapp_springboot.dtos;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ErrorResponse {
    private String message;
}
