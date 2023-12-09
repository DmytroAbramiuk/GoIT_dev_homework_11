package org.example.crudServices;

import java.util.List;

public interface Dao<T, V> {
    void save(T entity);

    T findById(V id);

    void update(T entity);

    void delete(T entity);

    void deleteById(V id);

    List<T> getAll();
}
