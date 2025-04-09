package chapter05;

import java.time.Duration;
import java.util.List;

public class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    public Money calculateMovieFee(Screening screening) {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountedFee());
        }
        return fee;
    }

    private boolean isDiscountable(Screening screening) {
        return discountConditions.stream()
            .anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    private Money calculateDiscountedFee() {
        switch (movieType) {
            case AMOUNT_DISCOUNT:
                return calculateAmountDiscountedFee();
            case PERCENT_DISCOUNT:
                return calculatePercentDiscountedFee();
            case NONE_DISCOUNT:
                return calculateNoneDiscountedFee();
            default:
                throw new IllegalArgumentException();
        }   
    }

    private Money calculateAmountDiscountedFee() {
        return fee.minus(discountAmount);
    }

    private Money calculatePercentDiscountedFee() {
        return fee.minus(fee.times(discountPercent));
    }

    private Money calculateNoneDiscountedFee() {
        return fee;
    }
}
