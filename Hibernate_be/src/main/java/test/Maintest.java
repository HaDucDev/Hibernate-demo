package test;


import org.hibernate.Session;
import pojo.Category;
import pojo.Manufacturer;
import pojo.Product;
import utils.HibernateUtils;

import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Maintest {
    public static void main(String[] args) {

        Session session= HibernateUtils.getFactory().openSession();
        // làm như OOP thôi
//        Category a= new Category(); // trạng thái transient
//        a.setName("ô tô");
//        a.setDescription("giá đắt quá");
//        session.save(a);
//        Category b = session.get(Category.class,2); // trạng thái persistent
//        //b.setDescription("giá rẻ bèo vậy");
//        session.getTransaction().begin();
//        //session.save(b);
//        session.delete(b);
//        session.getTransaction().commit();

//       Query q = session.createQuery("FROM Category where id=2");// HQL
//        List<Category> list= q.getResultList();
//
//        list.forEach( c -> System.out.printf("%d - %s", c.getId(), c.getName()));

//        Product p = new Product();
//        p.setName("Xe máy trắng");
//        p.setPrice(new BigDecimal(1589000000));
//
//        Category c = session.get(Category.class,2);
//        p.setCategory(c);
//
//        session.save(p);
        //thêm va get ko can transaction
//        Product p1= session.get(Product.class,4);
//        System.out.println(p1.getName());

//        Category cate= session.get(Category.class,2);
//        cate.getProductList().forEach(p -> System.out.printf("%d - %s",p.getId(),p.getName()) );

        // them san pham manytomany
        Product p= new Product();
        p.setName("xe máy nâu trắng");
        p.setDescription("rất rẻ");
        p.setPrice(new BigDecimal(123456789));


        Category c= session.get(Category.class,2);
        p.setCategory(c);

        Set<Manufacturer> manufacturerSet= new LinkedHashSet<>();
        // lay nha sx 1
        Manufacturer n1=session.get(Manufacturer.class,1);
        manufacturerSet.add(n1);
        // lay nha sx 2
        Manufacturer n2=session.get(Manufacturer.class,2);
        manufacturerSet.add(n2);

        // có viêt tat
       // manufacturerSet.add(session.get(Manufacturer.class,1));
        //manufacturerSet.add(session.get(Manufacturer.class,2));
        p.setManufacturerSet(manufacturerSet);

        session.getTransaction().begin();
        session.save(p);
        session.getTransaction().commit();;


        session.close();
    }
}
