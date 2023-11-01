## 🚀 기능 요구 사항

초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.

### 경주 할 자동차 이름 입력 받기

- [X] 사용자로부터 경주에 참여하는 자동차 이름을 문자열로 입력받는다. `inputString()`
    - [X] 입력 받은 문자열이 빈 문자열인 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션을 종료한다. `validateCarInput()`
    - [X] 입력 받은 문자열이 `,`로 시작하거나 끝나는 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션을 종료한다. `validateCarInput()`
    - [X] 입력 받은 문자열이 `,`가 연속으로 있거나 `,` 사이에 공백이 있는 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션을 종료한다.
- [X] 자동차 이름을 쉼표(,)를 기준으로 구분하고 자동차 개수를 파악한다. `processCarInput()`
    - [X] 각 자동차 이름이 5자 이하인지 확인한다. `processCarInput()`
    - [X] 쉼표가 없는 경우는 한 단어로 취급해야 한다. `processCarInput()`
    - [X] 중복된 자동차 이름이 있는지 확인한다. `checkRepeatCar()`
    - [X] 자동차 이름이 6자 이상인 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션을 종료한다. `processCarInput()`

---

### 이동 횟수 입력 받기

- [X] 사용자로부터 몇 번의 이동을 할 것인지 입력받는다. `inputMoveNum()`
- [X] 사용자로부터 빈 문자열을 입력받은 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션을 종료한다. `checkMoveNum()`
- [X] 입력받은 문자열이 정수가 아닌 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션을 종료한다. `isInteger()`

---

### 자동차 전진, 멈춤 및 출력

- [X] 아래의 과정을 이동할 횟수 만큼 반복한다. `moveCars()`
    - [X] 0에서 9 사이에서 무작위 값을 구한다. `generateRandomNum()`
    - [X] 무작위 값이 4 이상인 경우에는 전진한다. `carMoveOnce()`
    - [X] 무작위 값이 0이상 3이하인 경우에는 멈춘다. `checkMove()`
    - [X] 전진하는 경우 '-'를 출력한다. `printMove()`
    - [X] 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.

---

### 우승자 출력

- [x] 자동차 경주 게임을 완료한 후 우승자를 출력한다. `printWinner()`
- [X] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

---