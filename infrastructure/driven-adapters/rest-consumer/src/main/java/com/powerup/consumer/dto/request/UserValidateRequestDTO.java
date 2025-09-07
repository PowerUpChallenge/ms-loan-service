package com.powerup.consumer.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserValidateRequestDTO {

    private String idNumber;

}
