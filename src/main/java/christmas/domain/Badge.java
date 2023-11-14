package christmas.domain;

import java.util.Arrays;
import java.util.List;

public class Badge {
    private static final List<String> BADGES = Arrays.asList("별", "트리", "산타");

    public static String getBadge(int totalBenefits) {
        if (totalBenefits >= 20000) {
            return BADGES.get(2);
        }
        if (totalBenefits >= 10000) {
            return BADGES.get(1);
        }
        if (totalBenefits >= 5000) {
            return BADGES.get(0);
        }
        return "없음";
    }
}
