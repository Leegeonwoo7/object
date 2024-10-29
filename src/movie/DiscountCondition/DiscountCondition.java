package movie.DiscountCondition;

import movie.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
