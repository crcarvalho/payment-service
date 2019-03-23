package br.com.fiap.paymentservice.controller;

import br.com.fiap.paymentservice.dto.PaymentDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@Slf4j
@RestController
public class MicroservicePayment {

    private HashMap<String, PaymentDTO> mapPayments = new HashMap<>();

    @GetMapping("/payment/findById/{id}")
    public ResponseEntity<PaymentDTO> findOrderById(@PathVariable(value="id", required = true) String id){
        System.out.println("**** ID: "+ id);

        PaymentDTO payment = new PaymentDTO();
        ResponseEntity res;

        try{
            if( mapPayments.containsKey(id)){
                payment = mapPayments.get(id);
                res = new ResponseEntity(payment, HttpStatus.OK);
            } else res = new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }catch(Exception e){
            res = new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }

        return res;
    }


    @PostMapping("/payment/save")
    public String savePayment(@RequestBody PaymentDTO aPayment){

        String url = "http://localhost:8080/order/findById/";
        PaymentDTO payment = new PaymentDTO();
        try{
            if( aPayment.getId() == null || aPayment.getId().equals("")){
                payment = aPayment;
                //Gera um novo ID
                String idNovo = String.valueOf(Math.random());
                idNovo = idNovo.replace(".","");
                payment.setId(idNovo);
                //Preenche o Id na URL de retorno
                url += payment.getId();
                System.out.println("CR=payment= "+ payment.toString());
                mapPayments.put( payment.getId(), payment );
            }
        }catch(Exception e){
            System.out.println("Exceção: "+e.getMessage());
            url += null;
        }

        return url;
    }


    @PutMapping("/payment/update/{id}")
    public String updatePayment( @PathVariable(value = "id") String id,
                                 @RequestBody PaymentDTO aPayment ){

        String url = "http://localhost:8081/payment/findById/";
        PaymentDTO payment = new PaymentDTO();
        try{

            if( id == null || id.equals("") )
                throw new Exception("Favor informar o Id do registro para alteração.");

            payment = mapPayments.get( id );
            if( payment == null ) throw new Exception("Pagamento não encontrado!");

            //Atualiza dados de pagamento
            payment.setBandeira(aPayment.getBandeira());
            payment.setNumeroCartao(aPayment.getNumeroCartao());
            payment.setBandeira(aPayment.getBandeira());
            payment.setBandeira(aPayment.getBandeira());

        }catch(Exception e){
            System.out.println("Exceção: "+e.getMessage());
            url += null;
        }

        return url;
    }

    @DeleteMapping("/payment/delete/{id}")
    public String deletePayment(@PathVariable( value = "id", required = true) String id){
        String retorno = "";
        PaymentDTO payment = new PaymentDTO();
        try{
            if( id == null && id.equals("") )
                throw new Exception("Favor informar o Id do registro para exclusão.");
            if( !mapPayments.containsKey(id) )
                throw new Exception("Id não consta da base de dados.");

            mapPayments.remove(id);
            retorno = "Registro " + id + " excluído com sucesso!";
        }catch(Exception e){
            retorno = "Exceção: "+e.getMessage();
            System.out.println(retorno);
        }

        return retorno;
    }


}
