package br.com.fiap.repository;

import java.net.URI;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.to.VendaTO;

public class Servico {
    
    private Client cliente = Client.create();
    private WebResource resource = null;
    private ClientResponse response = null;
    
    
    public VendaTO[] getService() {
        resource = cliente.resource("http://localhost:8080/MarceloShibuya83752Server/rest/venda");
        response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
   
        if (response.getStatus() == 200) {
            return response.getEntity(VendaTO[].class);
        } else {
            return null;
        }
    }
    
    // ----------------------------- //
    
    public VendaTO getService(int cod) {
        
        resource = cliente.resource("http://localhost:8080/MarceloShibuya83752Server/rest/venda/" + cod);
        response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        
        if (response.getStatus() == 200) {
            return response.getEntity(VendaTO.class);
        } else {
            return null;
        }
    }
 
    // ----------------------------- //
    
    public URI postService(VendaTO venda) {
        
         resource = cliente.resource("http://localhost:8080/MarceloShibuya83752Server/rest/venda");
         response = resource.type("application/json").post(ClientResponse.class, venda);
 
         if (response.getStatus() == 201) {
             return response.getLocation();
         } else {
             return null;
         }
    }
    
    
    public int putService(VendaTO venda, int cod) {
 
        resource = cliente.resource("http://localhost:8080/MarceloShibuya83752Server/rest/venda/" + cod);
        response = resource.type("application/json").put(ClientResponse.class, venda);
 
        if (response.getStatus() == 200) {
            return response.getStatus();
        } else {
            return response.getStatus();
        }
 
    }
    
    
   // ----------------------------- //
    
   public int deleteService(int cod) {
    
       resource = cliente.resource("http://localhost:8080/MarceloShibuya83752Server/rest/venda/" + cod);
       response = resource.delete(ClientResponse.class);
       
       if (response.getStatus() == 204) {
           return response.getStatus();
       } else {
           return response.getStatus();
       }
       
   }
   
   // ----------------------------- //
   
   public static void main(String[] args) {
	   
    Servico servico = new Servico();
    
//    Teste listar()        
    for (VendaTO vto : servico.getService()) {
      System.out.println("Vendas " + vto.getDescricao());
  }
    
    
    }
   
}
