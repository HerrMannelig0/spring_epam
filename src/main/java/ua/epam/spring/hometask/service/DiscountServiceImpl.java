package ua.epam.spring.hometask.service;

import ua.epam.spring.hometask.discount_strategies.DiscountStrategy;
import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DiscountServiceImpl implements DiscountService {

  private List<DiscountStrategy> discountStrategies = new ArrayList<>();

  public DiscountServiceImpl(List<DiscountStrategy> discountStrategies) {
    this.discountStrategies = discountStrategies;
  }

  @Override
  public byte getDiscount(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, long numberOfTickets) {

    byte discount = 0;

    for (DiscountStrategy discountStrategy : discountStrategies) {
      final byte actualDiscount = discountStrategy.calculate(user, event, airDateTime, numberOfTickets);
      if(actualDiscount > discount)
        discount = actualDiscount;
    }

    return discount;
  }
}
