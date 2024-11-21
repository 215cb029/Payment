package com.ecom.kafka;

import com.ecom.payment.PaymentMethod;

import java.math.BigDecimal;

public record PaymentConformation(String orderReference,
                                  BigDecimal amount,
                                  PaymentMethod paymentMethod,
                                  String customerFirstname,
                                  String customerLastname,
                                  String customerEmail) {
}
