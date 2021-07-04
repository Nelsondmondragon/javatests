package com.cursoplatzi.javatest.payments;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PaymentProcessorTest {

    @Test
    public void payment_is_correct() {
        //Simulate_payment_gateway
        PaymentGateway paymentGateway = Mockito.mock(PaymentGateway.class);

        //When_the_payment_requested_answer_ok
        Mockito.when(paymentGateway.requestPayment(Mockito.any())).
                thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));

        PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway);
        assertTrue(paymentProcessor.makePayment(1000));
    }

    @Test
    public void payment_is_wrong() {
        //Simulate_payment_gateway
        PaymentGateway paymentGateway = Mockito.mock(PaymentGateway.class);
        //when_payment_requested_answer_error
        Mockito.when(paymentGateway.requestPayment(Mockito.any())).
                thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));

        PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway);
        assertFalse(paymentProcessor.makePayment(1000));

    }

}