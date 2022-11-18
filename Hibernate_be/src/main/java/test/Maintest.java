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
//        CriteriaBuilder builder= session.getCriteriaBuilder();
//        CriteriaQuery<Product> query= builder.createQuery(Product.class);
//        // mấy mấy bảng thì tạo mấy root. muốn joinn 2 bảng thì tạo 2 root
//        Root root = query.from(Product.class);
//
//        query =query.select(root); // lấy hết bảng
//
//
//        Predicate p1=builder.like(root.get("name").as(String.class),"%xe_may%" );
//                // lấy name trong đối tượng product là kiểu chuỗi
//        Predicate p2=builder.like(root.get("name").as(String.class),"%xe_dap%");
//
//        query= query.where(builder.or(p1,p2));
//
//        Query q=session.createQuery(query);
//        List<Product> productList= q.getResultList();
//        productList.forEach( a -> System.out.printf("%d - %s- %s\n",a.getId(),a.getName(),a.getPrice()));


//        // bettween
//        CriteriaBuilder builder= session.getCriteriaBuilder();
//        CriteriaQuery<Product> query= builder.createQuery(Product.class);
//        // mấy mấy bảng thì tạo mấy root. muốn joinn 2 bảng thì tạo 2 root
//        Root root = query.from(Product.class);
//
//        query =query.select(root); // lấy hết bảng
//
//
//        Predicate p1=builder.greaterThanOrEqualTo(root.get("price").as(BigDecimal.class),new BigDecimal(1200000) );
//        // lấy name trong đối tượng product là kiểu chuỗi
//        Predicate p2=builder.lessThanOrEqualTo(root.get("price").as(BigDecimal.class),new BigDecimal(1200000000));
//        query= query.where(builder.and(p1,p2));
//
////        // hoặc có thẻ thay
////        Predicate p=builder.between(root.get("price").as(BigDecimal.class),new BigDecimal(1200000),new BigDecimal(1200000000));
////        query= query.where(p);
//
//
//        Query q=session.createQuery(query);
//        List<Product> productList= q.getResultList();
//        productList.forEach( a -> System.out.printf("%d - %s- %.2f\n",a.getId(),a.getName(),a.getPrice()));



//        // query revenue
//        CriteriaBuilder builder= session.getCriteriaBuilder();
//        CriteriaQuery<Object[]> query= builder.createQuery(Object[].class);
//        // mấy mấy bảng thì tạo mấy root. muốn joinn 2 bảng thì tạo 2 root
//        Root root = query.from(Product.class);// đây vẫn là produc vì truy ván vào product
//        query = query.multiselect(builder.count(root.get("id").as(Integer.class)),
//                builder.max(root.get("price").as(BigDecimal.class))); // lấy cong trả vê
//
//
//        Query q=session.createQuery(query);
//        Object[] kq= (Object[]) q.getSingleResult();// truy vấn ra 1 dòng
//        System.out.println("Count:" + kq[0]);
//        System.out.println("Max:" + kq[1]);

//        List<Product> productList= q.getResultList();
//        productList.forEach( a -> System.out.printf("%d - %s- %.2f\n",a.getId(),a.getName(),a.getPrice()));


//        // query revenue
//        CriteriaBuilder builder= session.getCriteriaBuilder();
//        CriteriaQuery<Object[]> query= builder.createQuery(Object[].class);
//        // mấy mấy bảng thì tạo mấy root. muốn joinn 2 bảng thì tạo 2 root
//        Root pRoot = query.from(Product.class);
//        Root cRoot = query.from(Category.class);
//
//        query.where(builder.equal(pRoot.get("category"),cRoot.get("id")));// điều kiện join
//        query =query.multiselect(cRoot.get("name").as(String.class),builder.count(pRoot.get("id").as(Integer.class)),
//                builder.max(pRoot.get("price").as(BigDecimal.class)));// dêm bao nhiêu sp, giá max nhất
//
//        query =query.groupBy(cRoot.get("name").as(String.class));
//        query = query.orderBy(builder.asc(cRoot.get("name").as(String.class)));
//
//
//        Query q=session.createQuery(query);
//        List<Object[]> list= q.getResultList();
//        list.forEach(k -> {
//            System.out.printf("%s - count: %d - max: %.2f\n",k[0],k[1],k[2] );
//        });

//        //HQL: ít thuộc tính. ko cẩn thận có thể bị cast
//       Query q = session.createQuery("SELECT c.id, c.name,c.price FROM Product c");// HQL
//        List<Object[]> list= q.getResultList();
//
//        list.forEach( c -> System.out.printf("%d - count: %s - max: %.2f\n", c[0],c[1], c[2]));

// truyen tham so
//        Query q = session.createQuery("SELECT c.id, c.name,c.price FROM Product c where c.id=:id");// HQL
//        q.setParameter("id",1);
//        List<Object[]> list= q.getResultList();
//
//        list.forEach( c -> System.out.printf("%d - ten: %s - max: %.2f\n", c[0],c[1], c[2]));


//        Query q = session.createQuery("SELECT c.id, c.name,c.price FROM Product c where c.name like :kw order by c.id desc ");// HQL
//
//        q.setParameter("kw","%xe_m%");
//        List<Object[]> list= q.getResultList();
//
//        list.forEach( c -> System.out.printf("%d - count: %s - max: %.2f\n", c[0],c[1], c[2]));

        Query q = session.createQuery("SELECT  c.name, count(p.id), max(p.price), min(p.price) FROM Product p inner join Category c " +
                "on p.category.id=c.id group by c.name ");// HQL
//        Query q = session.createQuery("SELECT  c.name, count(p.id), max(p.price), min(p.price) FROM Product p right outer join Category c " +
//                "on p.category.id=c.id group by c.name ");

        List<Object[]> list= q.getResultList();

        list.forEach( c -> System.out.printf("%s - count: %d - max: %.2f - min: %.2f\n", c[0],c[1], c[2], c[3]));
        session.close();
    }
}
