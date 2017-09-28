package ua.epam.spring.hometask.discount_strategies;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.time.Period;

public class BirthdayDiscount implements DiscountStrategy {

  public static final int BIRTHDAY_DISCOUNT = 5;
  public static final int BIRTHDAY_AREA = 5;

  @Override
  public byte calculate(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, long numberOfTickets) {
    LocalDateTime userBirthday = user.getBirthday();

    if (userBirthday == null)
      return 0;

    if(isBirthdayOnTheDate(userBirthday, airDateTime))
      return BIRTHDAY_DISCOUNT;

    return 0;
  }

  private boolean isBirthdayOnTheDate(LocalDateTime userBirthday, LocalDateTime dateTime) {
    Period betweenPeriod = Period.between(userBirthday.toLocalDate(), dateTime.toLocalDate());
    return Math.abs(betweenPeriod.getDays()) <= BIRTHDAY_AREA;
  }

}
