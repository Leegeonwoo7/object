package movie.DiscountPolicy;

import movie.DiscountCondition.DiscountCondition;
import movie.Money;
import movie.Screening;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DiscountPolicy {
    private List<DiscountCondition> conditions = new ArrayList<>();

    public DiscountPolicy(DiscountCondition... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    /**
     * 할인요금을 반환하는 메서드
     * 할인조건을 순회하며 하나라도 조건에 만족하면 할인금액을 계산한다
     * @param screening 상영정보
     * @return 할인요금
     */
    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition condition : conditions) {
            if (condition.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }

        return Money.ZERO;
    }

    abstract protected Money getDiscountAmount(Screening screening);

}
