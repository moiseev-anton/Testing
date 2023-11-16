package seminar04.test;

import org.junit.jupiter.api.Test;
import seminar04.card.CreditCard;
import seminar04.card.PaymentForm;

import static org.mockito.Mockito.*;

public class TestPaymentForm {
    @Test
    public void testPaymentForm(){
        CreditCard mockCreditCard = mock(CreditCard.class);
        when(mockCreditCard.getCardNumber()).thenReturn("45677894");
        when(mockCreditCard.getCardHolder()).thenReturn("Ivan Ivanvo");
        when(mockCreditCard.getExpiryDate()).thenReturn("10/28");
        when(mockCreditCard.getCvv()).thenReturn("123");

        PaymentForm paymentForm = new PaymentForm(mockCreditCard);
        paymentForm.pay(100);
        verify(mockCreditCard, times(1)).charge(100);
    }
}
