package pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "manufacturer")
public class Manufacturer implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// id tự tăng
    private  int id;

    private  String name;
    private String country;

    @ManyToMany(mappedBy = "manufacturerSet")
    private Set<Product> productSet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }
}
