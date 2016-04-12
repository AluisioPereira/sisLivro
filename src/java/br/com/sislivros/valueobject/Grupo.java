
package br.com.sislivros.valueobject;

/**
 *
 * @author Zilderlan
 */
public class Grupo {
    private int id;
    private Usuario usuario;
    private String name;
    private String description;

    public Grupo() {}
    
    public Grupo(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public String getEmailUsuario(){
        return usuario.getEmail();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Grupo{" + "id=" + id + ", name=" + name + ", description=" + description + '}';
    }

    
}
