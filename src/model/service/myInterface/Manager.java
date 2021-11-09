package model.service.myInterface;

public interface Manager <T>{
    void add(T t);
    void print();
    void edit(String name,T t);
    void delete(String name);
}
