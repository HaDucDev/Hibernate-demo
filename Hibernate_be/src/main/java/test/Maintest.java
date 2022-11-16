package test;


import org.hibernate.Session;
import pojo.Category;
import utils.HibernateUtils;

public class Maintest {
    public static void main(String[] args) {

        Session session= HibernateUtils.getFactory().openSession();
        // làm như OOP thôi
        Category a= new Category();
        a.setName("ô tô");
        a.setDescription("giá đắt quá");
        session.save(a);
        session.close();
    }
}
