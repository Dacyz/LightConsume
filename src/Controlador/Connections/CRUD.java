
package Controlador.Connections;

import java.util.List;
public interface CRUD<T> {
    public List<T> listar();
    public boolean agregar(T obj);
    public boolean actualizar(T obj);
    public boolean eliminar(T obj);
    public T buscar(T obj);
}