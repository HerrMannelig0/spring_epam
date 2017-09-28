package ua.epam.spring.hometask;

import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

//@Component
@ShellComponent
public class SimpleCli implements CommandMarker{

 // @CliCommand(value = { "web-get", "wg" })
  @ShellMethod
  public String webGet(){
    return "Hello World!";
  }


}
