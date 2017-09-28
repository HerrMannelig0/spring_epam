package ua.epam.spring.hometask;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.shell.Bootstrap;
import ua.epam.spring.hometask.domain.Auditorium;

import java.io.IOException;

public class Application {

  public static void main(String[] args) throws IOException {
    Bootstrap.main(args);

    ApplicationContext context = new FileSystemXmlApplicationContext("src/main/resources/beans.xml");
    Auditorium bean = context.getBean(Auditorium.class);
  }

}
