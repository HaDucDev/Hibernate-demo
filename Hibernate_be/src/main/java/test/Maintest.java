package test;


import org.hibernate.Session;
import pojo.Category;
import pojo.Manufacturer;
import pojo.Product;
import utils.HibernateUtils;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
//        Product p= new Product();
//        p.setName("xe đạp vàng xanh");
//        p.setDescription("rất rẻ");
//        p.setPrice(new BigDecimal(1898651224));
//
//
//        Category c= session.get(Category.class,3);
//        p.setCategory(c);
//
//        Set<Manufacturer> manufacturerSet= new LinkedHashSet<>();
//        // lay nha sx 1
//        Manufacturer n1=session.get(Manufacturer.class,1);
//        manufacturerSet.add(n1);
//         //lay nha sx 2
//        Manufacturer n2=session.get(Manufacturer.class,2);
//        manufacturerSet.add(n2);
//
////        // có viêt tat
////       // manufacturerSet.add(session.get(Manufacturer.class,1));
////        //manufacturerSet.add(session.get(Manufacturer.class,2));
//
//
//        p.setManufacturerSet(manufacturerSet);
//        session.getTransaction().begin();
//        session.save(p);
//        session.getTransaction().commit();;


//        Manufacturer m=session.get(Manufacturer.class,1);
//        m.getProductSet().forEach( a -> System.out.printf("%d - %s- %s",a.getId(),a.getName(),a.getPrice()));


        // criteria query api
//        CriteriaBuilder builder= session.getCriteriaBuilder();
//        CriteriaQuery<Product> query= builder.createQuery(Product.class);
//        // mấy mấy bảng thì tạo mấy root. muốn joinn 2 bảng thì tạo 2 root
//        Root root = query.from(Product.class);
//
//        query =query.select(root); // lấy hết bảng
//
//
//        Query q=session.createQuery(query);// thành ra 4 dòng trên chỉ để xây dựng đối tượng truy vấn thôi.
//        List<Product> productList=q.getResultList();  //getSingleResult() lấy phần tử đầu tiên
//        productList.forEach( a -> System.out.printf("%d - %s- %s",a.getId(),a.getName(),a.getPrice()));


         //criteria query api like - or
        CriteriaBuilder builder= session.getCriteriaBuilder();
        CriteriaQuery<Product> query= builder.createQuery(Product.class);
        // mấy mấy bảng thì tạo mấy root. muốn joinn 2 bảng thì tạo 2 root
        Root root = query.from(Product.class);

        query =query.select(root); // lấy hết bảng


        Predicate p1=builder.like(root.get("name").as(String.class),"%xe_may%" );
                // lấy name trong đối tượng product là kiểu chuỗi
        Predicate p2=builder.like(root.get("name").as(String.class),"%xe_dap%");

        query= query.where(builder.or(p1,p2));

        Query q=session.createQuery(query);
        List<Product> productList= q.getResultList();
        productList.forEach( a -> System.out.printf("%d - %s- %s\n",a.getId(),a.getName(),a.getPrice()));




        session.close();
    }
}
