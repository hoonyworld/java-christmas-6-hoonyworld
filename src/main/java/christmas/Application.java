package christmas;

import christmas.controller.ChristmasController;

public class Application {
    public static void main(String[] args) {
        try {
            ChristmasController controller = new ChristmasController();
            controller.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
