package utils;

import org.hibernate.SessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import pojo.Category;

import java.util.Properties;


public  class HibernateUtils
{// đê nó hàng số cấp một lần thôi - static để có thể dùng chung luôn
    private static final SessionFactory FACTORY ;

    static {
        Configuration conf=new Configuration();
        Properties props=new Properties();

        props.put(Environment.DIALECT,"org.hibernate.dialect.MySQLDialect");
        props.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
        props.put(Environment.URL,"jdbc:mysql://localhost:3306/demobe");
        props.put(Environment.USER,"root");
        props.put(Environment.PASS,"123456");
        //props.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");
       // props.put(Environment.HBM2DDL_AUTO,"update");

        props.put(Environment.SHOW_SQL,"true");// bật cái này để khi truy vấn bằng code java hibernate tựu sinh code sql cho ta xem ở cmd

        conf.setProperties(props);
        conf.addAnnotatedClass(Category.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();

        FACTORY=conf.buildSessionFactory(registry);

    }

    // này này trong intelij ko tự sinh như eclipse đc. mình phai tự code
    public static  SessionFactory getFactory(){
        return FACTORY;
    }
   //ko thể thay đổi nên ko có hàm set

}
