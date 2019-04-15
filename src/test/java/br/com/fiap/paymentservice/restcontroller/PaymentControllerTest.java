package br.com.fiap.paymentservice.restcontroller;

import br.com.fiap.paymentservice.dto.PaymentDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MicroservicePayment.class)
public class PaymentControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void notFoundPayment() throws Exception {
        mvc.perform(
                get("/payment/findById/1")
                        .accept( MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void paymentFound() throws Exception {
        PaymentDTO payment = new PaymentDTO();
        when(MicroservicePayment.mapPayments.get("1")).thenReturn(payment);
        mvc.perform(get("/payment/findById/" + payment.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(response -> {
                    String json = response.getResponse().getContentAsString();
                    PaymentDTO paymentFounded = new ObjectMapper().readValue(json, PaymentDTO.class);
                    Assert.assertNotNull( paymentFounded );
                });
    }
}
