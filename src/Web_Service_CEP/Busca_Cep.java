/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web_Service_CEP;

import Web_Service_CEP.WebServiceCep;

/**
 *
 * @author Usuario
 */
public class Busca_Cep {
    
    public static void main(String[] args) {
        WebServiceCep webservicecep = WebServiceCep.searchCep("83702-240");
    
        if(webservicecep.wasSuccessful()){
            System.out.println("Logradouro : "+ webservicecep.getLogradouro());
            System.out.println("Bairro : "+webservicecep.getBairro());
            System.out.println("Cidade : "+webservicecep.getCidade());
            System.out.println("Estado : "+webservicecep.getUf());
        }
        else{
            System.out.println("O Cep informado é incorreto!");
        }       

    }               
}
