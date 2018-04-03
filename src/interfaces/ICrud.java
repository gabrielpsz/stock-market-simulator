package interfaces;

import java.util.ArrayList;

public interface ICrud<E> {
    void create(E e);

    void update(E e);

    void delete(String e);

    ArrayList<E> read();
}
