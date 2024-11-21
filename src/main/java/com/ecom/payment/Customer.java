package com.ecom.payment;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.apache.kafka.common.protocol.types.Field;

public record Customer(String id,
                        @NotNull(message = "firstName is required")
                        String firstName,
                       @NotNull(message = "lastName is required")
                       String lastName,
                       @Email(message = "email is required")
                       String email
                       ) {
}
