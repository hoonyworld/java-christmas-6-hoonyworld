package christmas.domain;

import christmas.constant.ChristmasConstant;
import java.util.Arrays;
import java.util.List;

public class Badge {
    private static final List<String> BADGES = Arrays.asList(ChristmasConstant.STAR_BADGE, ChristmasConstant.TREE_BADGE,
            ChristmasConstant.SANTA_BADGE);

    public static String getBadge(int totalBenefits) {
        if (totalBenefits >= ChristmasConstant.FIRST_THRESHOLD) {
            return BADGES.get(2);
        }
        if (totalBenefits >= ChristmasConstant.SECOND_THRESHOLD) {
            return BADGES.get(1);
        }
        if (totalBenefits >= ChristmasConstant.THIRD_THRESHOLD) {
            return BADGES.get(0);
        }
        return "없음";
    }
}
