package src.main.java.com.homework.week05.bean;

import com.homework.week05.bean.Tanshuai;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XMLBean {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:bean-definitions-constructor-context.xml");
        applicationContext.refresh();
        Tanshuai tanshuai = applicationContext.getBean(Tanshuai.class);
        System.out.println(tanshuai.toString());
        applicationContext.close();
    }

}
