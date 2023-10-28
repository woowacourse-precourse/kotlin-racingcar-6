# 자동차 경주 게임

## 기능 목록

- 경기에 대한 정보를 입력 받는다: 1) 경주할 자동차 이름 & 2) 시도할 횟수
  - [ ] n대의 **자동차의 이름**을 입력 받는다. - RaceGenerator#generateCars()
    - [ ] 자동차 이름은 **쉼표**(,)를 기준으로 구분한다.
    - [ ] 5자 이하만 가능하다.
  - [ ] **몇 번의 시도**(**이동**)을 할 것인지를 입력 받는다. - RaceGenerator#askNumberOfMoves()
- [ ] 각 차수마다의 모든 자동차의 기록을 출력한다. - Commentator#commentRace()
  - [ ] 자동차 이름을 같이 출력한다.
  - [ ] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다. - Car#moveOrNot()
    - [ ] 전진하는 조건: 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- [ ] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. - Commentator#theWinnerIs()
  - [ ] 우승자는 한 명 이상일 수 있다.
  - [ ] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- [ ] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다. - RaceGenerator#checkNumberOfMoves(), .#checkCarNames()

## (추가된) 프로그래밍 요구 사항
- [ ] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 해결책: 함수(또는 메서드)를 분리한다.
  - 이때, 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [ ] JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
  - 테스트 도구 사용법이 익숙하지 않다면 test/kotlin/study를 참고하여 학습한 후 테스트를 구현한다.
- [ ] `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.

### 사용 예시

- 0에서 9까지의 정수 중 한 개의 정수 반환

```kotlin
Randoms.pickNumberInRange(0, 9)
```

## 구현 성공 시의 실행 결과 예시

```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 횟수는 몇 회인가요?
5

실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun
```

