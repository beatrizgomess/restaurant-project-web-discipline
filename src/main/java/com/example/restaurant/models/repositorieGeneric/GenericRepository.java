package com.example.restaurant.models.repositorieGeneric;

import java.util.List;

public interface GenericRepository<T, I> {

    public void create(T t);
    public List<T> readAll();
    public T read(I t);

    /*
    public void update(T t);
    public T read(I i);
    public void delete(I i);
    public List<T> readAll();
*/
}
