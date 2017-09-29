package ua.epam.spring.hometask;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.Ticket;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Application {


  public static void main(String[] args) throws IOException {

    ApplicationContext context = new FileSystemXmlApplicationContext("src/main/resources/beans.xml");
    ConsoleUi consoleUi = context.getBean(ConsoleUi.class);

    consoleUi.prepare();

    System.out.println("Hello! Welcome to the Theatre!");
    System.out.println("Choose event:");
    consoleUi.showAllEvents();

    Scanner scanner = new Scanner(System.in);
    String inputEventId = scanner.nextLine();

    Event event = consoleUi.getEvent(inputEventId);
    LocalDateTime date = consoleUi.chooseDate(event, scanner);

    long seat = consoleUi.chooseSeat(event, date, scanner);

    if (seat < 1) return;

    final Ticket ticket = consoleUi.bookTicketsForEvent(event, date, seat);
    if(ticket != null){
      consoleUi.showPrice(ticket);
    }

    scanner.close();
    System.out.println("Thanks for visiting our theatre! Have a nice day!");
  }


}
