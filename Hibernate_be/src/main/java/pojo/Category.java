package pojo;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

//import java.util.List;
@Entity
@Table(name = "category")
public class Category implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// id tự tăng
    private int id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private List<Product> productList;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
