package christmas.constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Day {
    WEEKEND(Arrays.asList(1, 2, 8, 9, 15, 16, 22, 23, 29, 30)),
    WEEKDAY(Arrays.asList(3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31)),
    STARDAY(Arrays.asList(3, 10, 17, 24, 25, 31));

    private List<Integer> days;

    Day(List<Integer> days) {
        this.days = new ArrayList<>(days);
    }

    public List<Integer> getDays() {
        return days;
    }
}


