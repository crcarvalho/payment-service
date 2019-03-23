package br.com.fiap.paymentservice.dto;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {

    private String id;
    private String numeroCartao;
    private String validadeCartao;
    private Double valorCompra;
    private String bandeira;

    @Override
    public String toString() {
        return String.valueOf( "Payment: { Id: " + this.getId()
                +", Número do Cartão: " + this.getNumeroCartao()
                +", Validade do Cartão: " + this.getValidadeCartao()
                +", Valor compra: "+ this.getValorCompra()
                +", Bandeira: "+ this.getBandeira() +" }");
    }
}
