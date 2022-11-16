package pojo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "category")
public class Category implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// id tự tăng
    private int id;
    private String name;
    private String description;

    public int getD() {
        return id;
    }

    public void setD(int id) {
        this.id = id;
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
}
