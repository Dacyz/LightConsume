package Modelo;

public class CategoryDTO {

    private String name; // Nombre de Categoria
    private int idCategory;

    public CategoryDTO(String categoryName, int idCategory) {
        this.name = categoryName;
        this.idCategory = idCategory;
    }

    public CategoryDTO() {
       
    }

    public CategoryDTO(String Email) {
        this.name = Email;
    }
    
    @Override
    public String toString() {
        return '[' + getName() + ']';
    }

// <editor-fold defaultstate="collapsed" desc="Getter and Setter code">

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }
// </editor-fold> 
}
