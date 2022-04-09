package com.springboot.SpringBootProject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class UserResDTO {

    List<UserResponseDTO> response;
    Map<?,?> params;
}
