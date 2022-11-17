package test;


import org.hibernate.Session;
import pojo.Category;
import pojo.Product;
import utils.HibernateUtils;

import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;

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

        Category cate= session.get(Category.class,2);
        cate.getProductList().forEach(p -> System.out.printf("%d - %s",p.getId(),p.getName()) );

        session.close();
    }
}
