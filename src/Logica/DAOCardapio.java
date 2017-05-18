/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;

import java.util.List;

/**
 *
 * @author Jonathan e teste
 */
public class DAOCardapio {
    
    public List<Prato> getLista(){
        return Dados.listaPratos;
    }
    
    
    public boolean salvar (Prato obj){
       // if (obj.getCodigo()== null){
            Integer codigo = Dados.listaPratos.size() + 1;
            obj.setCodigo(codigo);
            Dados.listaPratos.add(obj);
        //}
        return true;
    }
    public boolean remover (Prato obj){
        Dados.listaPratos.remove(obj);
        return true;
    }
}
