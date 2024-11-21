package com.ecom.payment;

import com.ecom.kafka.PaymentConformation;
import com.ecom.kafka.PaymentProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
 private PaymentRepository paymentRepository;
    @Autowired
    private PaymentMapper  paymentMapper;
    @Autowired
   private PaymentProducer paymentProducer;
    public Integer createPayment(PaymentRequest paymentRequest){
Payment payment=paymentRepository.save(paymentMapper.toPayment(paymentRequest));
     paymentProducer.sendMessage(
                new PaymentConformation(
                        paymentRequest.orderReference(),
                        paymentRequest.amount(),
                        paymentRequest.paymentMethod(),
                        paymentRequest.customer().firstName(),
                        paymentRequest.customer().lastName(),
                        paymentRequest.customer().email()
                )
        );
        return payment.getId();
    }

}
