package com.powerup.api;

import com.powerup.api.dto.request.LoanApplicationRequestDTO;
import com.powerup.api.mapper.LoanApplicationMapper;
import com.powerup.usecase.loanapplication.LoanApplicationUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;

import static com.powerup.api.util.LogMessages.*;

@Component
@RequiredArgsConstructor
@Slf4j
public class LoanApplicationHandler {

    private final LoanApplicationMapper loanApplicationMapper;
    private final LoanApplicationUseCase loanApplicationUseCase;

    public Mono<ServerResponse> loanApplication(ServerRequest request) {
        log.info(LOAN_APPLICATION_START, request.path());

        return request.bodyToMono(LoanApplicationRequestDTO.class)
                .doOnNext(dto -> log.info(LOAN_APPLICATION_DATA, request.path(), dto))
                .map(loanApplicationMapper::toModel)
                .flatMap(loan ->
                        loanApplicationUseCase.saveLoanApplication(loan)
                                .doOnSuccess(v -> log.info(LOAN_APPLICATION_SUCCESS, request.path()))
                                .doOnError(e -> log.error(LOAN_APPLICATION_ERROR, request.path(), e.getMessage()))
                                .then(ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(Map.of(
                                                "status", "success",
                                                "message", "Loan Application saved successfully",
                                                "user", loanApplicationMapper.toResponseDTO(loan)
                                        ))
                                )
                );
    }

}
