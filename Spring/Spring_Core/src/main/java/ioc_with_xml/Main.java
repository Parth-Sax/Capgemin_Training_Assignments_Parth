package ioc_with_xml;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
//import org.springframework.context.ApplicationContext;

public class Main {
    public static void main(String[] args) {

        // bean creation using BeanFactory
        // bean creation using classpath
        BeanFactory beanFactory1 = new XmlBeanFactory(new ClassPathResource("beanConfiguration.xml"));
        Laptop l2 = (Laptop) beanFactory1.getBean("bean_id");
        System.out.println(l2);

//        BeanFactory beanFactory2 = new XmlBeanFactory(new ClassPathResource("beanConfiguration.xml"));
//        Laptop l3 = (Laptop) beanFactory1.getBean(Laptop.class); // we can use this when we have only one bean in our configuration file
//        System.out.println(l3);

        Laptop laptop2 = (Laptop) beanFactory1.getBean("bean2");
        System.out.println(laptop2);


        // bean creation using ApplicationContext
        // bean creation using classpath

//        ApplicationContext context = new ClassPathXmlApplicationContext("beans_configuration_1.xml");
//        Laptop laptop3 = (Laptop) context.getBean("bean_id");
//        System.out.println(laptop3);



    }
}
