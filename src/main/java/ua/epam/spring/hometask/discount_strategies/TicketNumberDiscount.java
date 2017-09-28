package ua.epam.spring.hometask.discount_strategies;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;

public class TicketNumberDiscount implements DiscountStrategy{

  private static final int THRESHOLD_1 = 10;
  private static final int THRESHOLD_2 = 20;
  private static final byte DISCOUNT_FOR_TRESHOLD_1 = 5;
  private static final byte DISCOUNT_FOR_TRESHOLD_2 = 10;
  private static final byte NO_DISCOUNT = 0;


  /**
   * Calculate discount: DISCOUNT_FOR_TRESHOLD_X if number of tickets exceeds TRESHOLD_X
   */
  @Override
  public byte calculate(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, long numberOfTickets) {

    if(numberOfTickets > THRESHOLD_2)
      return DISCOUNT_FOR_TRESHOLD_2;

    if(numberOfTickets > THRESHOLD_1)
      return DISCOUNT_FOR_TRESHOLD_1;

    return NO_DISCOUNT;
  }
}
