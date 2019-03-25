package br.com.fiap.paymentservice;

import br.com.fiap.paymentservice.controller.MicroservicePayment;
import br.com.fiap.paymentservice.dto.PaymentDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaymentServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(PaymentServiceApplication.class, args);


		PaymentDTO pay = new PaymentDTO();
		pay.setNumeroCartao("1234123412341234");
		pay.setBandeira("VISA");
		pay.setId("12345");
		pay.setValidadeCartao("15/05/2022");
		pay.setValorCompra(1500.00);

		MicroservicePayment service = new MicroservicePayment();
		service.savePayment(pay);


	}

}
