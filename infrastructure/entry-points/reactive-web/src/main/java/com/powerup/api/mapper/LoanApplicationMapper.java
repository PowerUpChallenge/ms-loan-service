package com.powerup.api.mapper;

import com.powerup.api.dto.request.LoanApplicationRequestDTO;
import com.powerup.api.dto.response.LoanApplicationResponseDTO;
import com.powerup.model.loanapplication.LoanApplication;
import org.mapstruct.Mapper;

/**
 * LoanApplicationMapper is responsible for mapping between LoanApplication domain model
 * and its corresponding DTOs (Data Transfer Objects) for requests and responses.
 *
 * @version 1.0
 * @since 2025-09-04
 */
@Mapper(componentModel = "spring")
public interface LoanApplicationMapper {

    /**
     * Maps a LoanApplication domain model to a LoanApplicationResponseDTO.
     *
     * @param loanApplication the LoanApplication domain model
     * @return the corresponding LoanApplicationResponseDTO
     */
    LoanApplicationResponseDTO toResponseDTO(LoanApplication loanApplication);

    /**
     * Maps a LoanApplicationRequestDTO to a LoanApplication domain model.
     *
     * @param requestDTO the LoanApplicationRequestDTO
     * @return the corresponding LoanApplication domain model
     */
    LoanApplication toModel(LoanApplicationRequestDTO requestDTO);

}
