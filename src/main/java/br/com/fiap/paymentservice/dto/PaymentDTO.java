package br.com.fiap.paymentservice.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {

    private String id;
    private String numeroCartao;
    private String validadeCartao;
    private BigDecimal valorCompra;
    private String bandeira;

    @Override
    public String toString() {
        return String.valueOf( "Payment: { Id: " + this.getId()
                +", Número do Cartão: " + this.getNumeroCartao()
                +", Validade do Cartão: " + this.getValidadeCartao()
                +", Valor compra: "+ this.getValorCompra()
                +", Bandeira: "+ this.getBandeira() +" }");
    }


    public void setValorCompra(BigDecimal value){
        this.valorCompra = value.setScale(2, BigDecimal.ROUND_UP);
    }

    public Double getValorCompra(){
        return this.valorCompra.doubleValue();
    }
}
