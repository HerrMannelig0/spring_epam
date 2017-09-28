package ua.epam.spring.hometask.domain;

/**
 * @author Yuriy_Tkach
 */
public enum EventRating {

    LOW(0.8),

    MID(1),

    HIGH(1.2);

    double rate;

    EventRating(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }
}
