# Microserviço de Pagamento

### Método GET

* PATH: [DOMINIO]/payment/findById/{id}
* DESCRIÇÃO: Busca de pagamento atraves do id do pagamento.


### Método POST

* PATH: [DOMINIO]/payment/save
* DESCRIÇÃO: Criação de pagamento.
* PAYLOAD: 
```json
{
    "id" : "STRING",
    "numeroCartao" : "STRING",
    "validadeCartao" : "STRING",
    "valorCompra" : double,
    "bandeira" : "STRING"
}
```
* FORMATOS:
	- validadeCartao: "MM/YYYY"
### Método PUT

* PATH: [DOMINIO]/payment/update/{id}
* DESCRIÇÃO: Atualização do pagamento.
* PAYLOAD: 

```json
{
    "numeroCartao" : "STRING",
    "validadeCartao" : "STRING",
    "valorCompra" : double,
    "bandeira" : "STRING"
}
```
* FORMATOS:
	- validadeCartao: "MM/YYYY"
### Método DELETE

* PATH: [DOMINIO]/payment/delete/{id}
* DESCRIÇÃO: Exclui um pagamento atraves do ID do pedido.


