# 자동차 경주
> 초간단 자동차 경주 게임을 구현한다.

- [x] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.

   🧐 생각한 방법 : 레이싱 게임을 담당하는 `RacingGame` 클래스와 레이싱게임에 참여하는 `Car` 클래스를 생성해, 레이싱 게임을 진행해야겠다!
      
       (완료) RacingGame Class를 생성해, 레이싱 게임의 프로세스를 구현할 준비를 한다.
       (완료) Car Class를 생성해, 레이싱 게임의 참여할 수 있도록 구성한다.
       (완료) Car class에 이동하는 메서드인 move 메서드를 구성한다.
       (완료) RacingGame에 n대의 자동차를 참가시키는 메서드인 inviteRacer()를 생성한다.

- [x] 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.

  🧐 생각한 방법 : `Car class`를 생성할 때 이름을 입력하고, `toString()` 메서드를 `override`해서 이름을 같이 출력하자!
  
      (완료) Car class를 생성할 때, name을 프로퍼티로 받는다.
      (완료) Car class의 toString()을 override해서 전진하는 자동차 출력시, 이름을 같이 출력하도록 구현한다.


- [ ] 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.

  🧐 생각한 방법 : 쉼표(,)를 기준으로 구분하는 메서드와, 이름을 5자 이하만 가능하도록 하는 메서드를 구현한다.

      () RacingGame class 내부에 inviteRacer()를 쉼표를 기준으로 입력받는 메서드로 구현한다.
      () RacingGame class 내부에 이름을 5자 이하만 가능하도록 하는 checkName 메서드를 구현한다.

- [ ] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.

  🧐 생각한 방법 : 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
  
      () RacingGame 클래스 내부에, 이동 횟수를 입력 받는 inputTotalRound 메서드를 구현한다.

- [ ] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.

  🧐 생각한 방법 : 0 ~ 9 사이의 무작위 값 중, 4 이상인 경우 전진하는 메서드를 구현한다.

      () Car 클래스 내부에, 0 ~ 9 사이의 무작위 수를 생성하는 startEngine 메서드를 구현한다.
      () checkEngineLevelAvaliable 메서드를 생성해, 4 이상인 경우 true를 리턴한다.
      () startEngine 내부에서, checkEngineLevelAvaliable가 true 리턴한 경우 전진한다.

- [ ] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

  🧐 생각한 방법 : 우승 여부를 알려주는 메서드 `startAwardCeremony`를 구현한다!

      () rateAllRacers 메서드를 구현해, 우승 여부를 체크한다.
      () startAwardCeremony 메서드를 구현해, 우승 여부를 알려 주는 메서드를 구현한다.

- [ ] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

  🧐 생각한 방법 : 우승자를 출력하는 printWinner를 구현한다.

      () printWinner 메서드를 구현해, startAwardCeremony에서 호출해, 우승자를 출력한다.
      () printWinner 메서드를, 여러 명의 우승자를 쉼표로 구분하는 로직을 구현한다.

- [ ] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

  🧐 생각한 방법 : 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException` 발생시키고 통일성 있게 관리하기 위해, `UserInputChecker`이라는 클래스를 구현한다!

      () UserInputChecker Class를 생성한다.
      () UserInputChecker Class를 구현해, 각 입력 메서드에서 입력 값을 check하는 로직을 구성한다.
<hr />

### 추가된 요구 사항

- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
    - 테스트 도구 사용법이 익숙하지 않다면 test/kotlin/study를 참고하여 학습한 후 테스트를 구현한다.