package dao;

import java.util.List;

public interface Idao<T>{
    boolean create(T c);
    boolean saveOrUpdate(T c);
    boolean update(T c);
    boolean delete(T c);
    T getById(Integer c);
    List<T> getAll();

}
