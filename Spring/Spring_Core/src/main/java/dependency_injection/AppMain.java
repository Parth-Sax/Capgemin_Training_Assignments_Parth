package dependency_injection;

import ioc_with_xml.Laptop;
import map_dependency_injection.Kit;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class AppMain {
    public static void main(String[] args) {
//        BeanFactory beanFactory1 = new XmlBeanFactory(new ClassPathResource("dependencyInjection.xml"));
//        Library library1 = (Library) beanFactory1.getBean("L1");
//        System.out.println(library1);

//        BeanFactory beanFactory2 = new XmlBeanFactory(new ClassPathResource("listDependencies.xml"));
//        Library1 library2 = (Library1) beanFactory2.getBean("Lib1");
//        System.out.println(library2);

        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("mapKit.xml"));
        Kit kit = (Kit) factory.getBean("kit_id");
        System.out.println(kit);
    }
}
