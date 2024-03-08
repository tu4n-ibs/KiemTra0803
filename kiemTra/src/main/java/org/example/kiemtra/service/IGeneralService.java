package org.example.kiemtra.service;

import java.util.Optional;

public interface IGeneralService<E>{
    Iterable<E> findAll();

    Optional<E> findById(int id);


    E save(E e);


    void remove(int id);
}
