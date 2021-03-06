package br.com.fiap.paymentservice;

import br.com.fiap.paymentservice.restcontroller.MicroservicePayment;
import br.com.fiap.paymentservice.dto.PaymentDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class PaymentServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(PaymentServiceApplication.class, args);


		PaymentDTO pay = new PaymentDTO();
		pay.setNumeroCartao("1234123412341234");
		pay.setBandeira("VISA");
		pay.setId("12345");
		pay.setValidadeCartao("05/2022");
		pay.setValorCompra(new BigDecimal(1500.00));

		MicroservicePayment service = new MicroservicePayment();
		service.savePayment(pay);


	}

}
