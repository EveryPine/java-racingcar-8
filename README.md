# java-racingcar-precourse

## 기능 구현 목록
1. 경주할 자동차 이름을 입력받는다.
    - [InputView] 사용자가 자동차 이름을 입력한다.
    - [CarNameValidator] 자동차 이름에 대한 사용자 입력을 검증한다. 조건은 다음과 같다.
        - 구분자는 쉼표(,)만 허용한다.
        - 자동차 이름은 알파벳(a-z, A-Z)으로 이루어진 1~5자 문자열만 허용한다.
        - 자동차 개수는 1에서 50 사이의 정수만 허용한다.
        - [CarNameValidator] 위 조건을 위반하는 경우, `IllegalArgumentException` 을 발생시킨다.
    - [CarNameParser] 입력한 문자열에서 자동차 이름을 추출한다.


2. 시도 횟수를 입력받는다.
    - [InputView] 사용자가 시도 횟수를 입력한다.
    - [AttemptValidator] 시도 횟수에 대한 사용자 입력을 검증한다. 조건은 다음과 같다.
        - [AttemptValidator] 시도 횟수는 1에서 100 사이의 정수만 허용한다.
        - [AttemptValidator] 위 조건을 위반하는 경우, `IllegalArgumentException` 을 발생시킨다.


3. 자동차 경주 게임의 결과를 계산한다.
    - [Car] 각 차수에서 모든 자동차에 대해 전진 여부를 결정한다.
        - [RandomUtil] 0에서 9 사이의 무작위값을 구한다.
        - [Car] 위에서 구한 값이 4 이상인 경우, 자동차를 전진시킨다.
        - [Car] 위에서 구한 값이 3 이하인 경우, 자동차를 그대로 둔다.
    - [GameService] 위 과정을 시도 횟수만큼 반복 진행한다.


4. 자동차 경주 게임의 우승자를 계산한다.
    - [GameService] 자동차 경주 게임의 우승자를 계산한다.


5. 게임 결과를 출력한다.
    - [OutputView] 차수별 실행 결과를 출력한다.
    - [OutputView] 우승자를 출력한다.