
package br.com.sislivros.valueobject;

/**
 *
 * @author Zilderlan
 */
public class Grupo {
    private int id;
    private String name;
    private String photo;
    private String description;

    public Grupo() {}
    
    public Grupo(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.description = description;
    }
   
    public int getId() {
        return id;
    }

    public void setI(int id) {
        this.id = id;
    }
 
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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
        return "Grupo{" + "id=" + id +  ", name=" + name + ", photo=" + photo + ", description=" + description + '}';
    }

   

    
}
