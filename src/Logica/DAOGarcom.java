/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;

import java.util.List;

/**
 *
 * @author Supervisor
 */
public class DAOGarcom {
    
    public List<Garcom> getLista(){
        return Dados.listaGarcons;
    }
    
    public boolean salvar (Garcom obj){
        if (obj.getCodigo() == null){
            Integer codigo = Dados.listaGarcons.size() + 1;
            obj.setCodigo(codigo);
            Dados.listaGarcons.add(obj);
        }
        return true;
    }
    public boolean remover (Garcom obj){
        Dados.listaGarcons.remove(obj);
        return true;
    }
}
