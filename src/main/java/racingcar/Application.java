package racingcar;

import racingcar.controller.RacingController;

import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        RacingController racingController = new RacingController();
        racingController.run();
    }

}