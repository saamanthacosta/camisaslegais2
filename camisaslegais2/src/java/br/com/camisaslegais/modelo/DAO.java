package br.com.camisaslegais.modelo;

import java.util.List;
import java.util.Optional;

/**
 * Interface de acesso ao banco de dados
 */
public interface DAO<T> {
  
    T buscarPorId(int id);
     
    List<T> buscarTodos();
     
    void inserir(T t);
     
    void alterar(T t);
     
    void remover(int id);
}