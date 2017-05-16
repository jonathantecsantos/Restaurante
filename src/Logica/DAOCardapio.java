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
    
    public List<Cardapio> getLista(){
        return Dados.listaCardapio;
    }
    
    
    public boolean salvar (Cardapio obj){
        if (obj.getCodigo() == null){
            Integer codigo = Dados.listaCardapio.size() + 1;
            obj.setCodigo(codigo);
            Dados.listaCardapio.add(obj);
        }
        return true;
    }
    public boolean remover (Cardapio obj){
        Dados.listaCardapio.remove(obj);
        return true;
    }
}
