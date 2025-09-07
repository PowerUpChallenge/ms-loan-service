package com.powerup.api;

import com.powerup.api.dto.request.LoanApplicationRequestDTO;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * LoanApplicationRouterRest is responsible for defining the routing configuration for the reactive web application.
 * It maps HTTP requests to their corresponding handler functions.
 *
 * @version 1.0
 * @since 2025-09-04
 */
@Configuration
@Tag(name = "Loan Applications", description = "Endpoints for loan application handling")
public class LoanApplicationRouterRest {

    @Bean
    @RouterOperations({
            @RouterOperation(
                    path = "/api/v1/solicitud",
                    operation = @io.swagger.v3.oas.annotations.Operation(
                            operationId = "loanApplication",
                            summary = "Submit a loan application",
                            description = "Submits a new loan application to the system.",
                            requestBody = @RequestBody(
                                    required = true,
                                    content = @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = LoanApplicationRequestDTO.class)
                                    )
                            ),
                            responses = {
                                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                                            responseCode = "200",
                                            description = "Loan application submitted successfully"
                                    ),
                                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                                            responseCode = "400",
                                            description = "Invalid loan application data"
                                    )
                            }
                    )
            )
    })
    public RouterFunction<ServerResponse> routerFunction(LoanApplicationHandler loanApplicationHandler) {
        return route(POST("/api/v1/solicitud"), loanApplicationHandler::loanApplication);
    }

}
