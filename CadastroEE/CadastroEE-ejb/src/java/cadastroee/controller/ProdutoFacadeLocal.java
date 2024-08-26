/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cadastroee.controller;

import cadastroee.model.Produto;
import java.util.List;
import jakarta.ejb.Local;


@Local
public interface ProdutoFacadeLocal {

    void create(Produto produtos);

    void edit(Produto produtos);

    void remove(Produto produtos);

    Produto find(Object id);

    List<Produto> findAll();

    List<Produto> findRange(int[] range);

    int count();
    
}
