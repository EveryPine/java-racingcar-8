package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.model.User;

import java.util.List;

public class OutputView {

    public static void printCarNameInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printAttemptCountInputMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void printGameResult(Game game) {
        User user = game.getUser();
        int attemptCount = user.getAttemptCount();
        List<Car> cars = user.getCars();
        List<List<Integer>> history = game.getHistory();

        System.out.println("\n실행 결과");
        for (int attempt = 0; attempt < attemptCount; attempt++) {
            printRoundResult(cars, history.get(attempt));
            System.out.println();
        }
    }

    public static void printWinners(List<Car> winners) {
        List<String> winnerNames = winners.stream()
                .map(Car::getName).toList();
        String joiningDelimiter = ", ";
        String joinedWinners = String.join(joiningDelimiter, winnerNames);

        System.out.print("최종 우승자 : " + joinedWinners);
    }

    private static void printRoundResult(List<Car> cars, List<Integer> roundResult) {
        int carCount = cars.size();

        for (int carIndex = 0; carIndex < carCount; carIndex++) {
            Car car = cars.get(carIndex);
            String name = car.getName();
            int moveCount = roundResult.get(carIndex);
            String moveDistance = "-".repeat(moveCount);

            System.out.println(name + " : " + moveDistance);
        }
    }
}
