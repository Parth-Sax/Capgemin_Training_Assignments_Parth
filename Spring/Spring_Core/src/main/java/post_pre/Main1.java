package post_pre;

import ioc_with_xml.Laptop;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Main1 {
    public static void main(String[] args) {
//        BeanFactory beanFactory1 = new XmlBeanFactory(new ClassPathResource("postAndPre.xml"));
//        Vehicle v1 = (Vehicle) beanFactory1.getBean("v_id");

        ApplicationContext context = new ClassPathXmlApplicationContext("postAndPre.xml");
        Vehicle v2 = (Vehicle) context.getBean("v_id");
    }
}
