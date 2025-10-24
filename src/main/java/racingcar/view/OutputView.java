package racingcar.view;

import racingcar.model.Car;
import racingcar.model.GameData;

import java.util.List;

public class OutputView {

    public static void printGameResult(GameData gameData) {
        int attemptCount = gameData.getAttemptCount();
        List<Car> cars = gameData.getCars();
        List<List<Integer>> history = gameData.getHistory();

        System.out.println("\n실행 결과");
        for (int attempt = 0; attempt < attemptCount; attempt++) {
            printRoundResult(cars, history.get(attempt));
            System.out.println();
        }
    }

    public static void printWinners(List<Car> winners) {
        List<String> winnerNames = winners.stream()
                .map(Car::getName).toList();
        String outputString = String.join(", ", winnerNames);

        System.out.print("최종 우승자 : " + outputString);
    }

    private static void printRoundResult(List<Car> cars, List<Integer> roundResult) {
        int carCount = cars.size();

        for (int carIndex = 0; carIndex < carCount; carIndex++) {
            Car car = cars.get(carIndex);
            String name = car.getName();
            int moveCount = roundResult.get(carIndex);

            System.out.print(name + " : ");
            for (int i = 0; i < moveCount; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
}
