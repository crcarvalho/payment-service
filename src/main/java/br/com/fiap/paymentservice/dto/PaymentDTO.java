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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getValidadeCartao() {
        return validadeCartao;
    }

    public void setValidadeCartao(String validadeCartao) {
        this.validadeCartao = validadeCartao;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public void setValorCompra(BigDecimal value){
        this.valorCompra = value.setScale(2, BigDecimal.ROUND_UP);
    }

    public Double getValorCompra(){
        return this.valorCompra.doubleValue();
    }
}
