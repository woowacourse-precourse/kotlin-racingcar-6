## 기능 목록

### Player
- [x] : 경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분) 입력하기
- [x] : 사용자는 몇 번의 이동을 할 것인지를 입력하기
- [x] : 잘못된 값을 입력할 경우 IllegalArgumentException 발생

### Car
- [x] : 자동차에 이름(name)이 있다  
- [x] : 차의 위치(position)가 있다
- [x] : 차를 전진시킨다 - move()
- [x] : toString()에 이름(name)을 반환하도록 overriding

### RacingCarAggregate
Car를 상속받는 레이싱 차 집합
- [x] : Car 객체를 담는 List(cars) 생성
- [x] : move() 함수 호출 시 전진 가능한 car만 move()

### RacingCar : Car
Car를 상속받는 레이싱 차
- [x] : move() 함수 호출시 position +1

### RandomNumberGenerator
무작위 숫자를 만들어내는 객체
- [x] : 무작위 숫자 반환하기

### Referee 
- [x] 차가 움직일 수 있는지 판정한다.
- [x] Race의 결과를 판정한다.
- [x] 게임의 Winner를 판정한다.

### Reader 
- [x] 입력값을 읽어온다
- [x] 잘못된 입력값을 받아올 경우 IllegalArgumentException 발생

## model
### CarState 
차의 상태를 나타내는 data class
- [x] : 차의 이름(name)과 위치(position)가 있다
- [x] : toString()에 이름(name)과 위치(position)을 반환하도록 overriding

### RaceResult
레이싱 결과를 나타내는 data class
- [x] : 레이싱에 참여하는 차들의 CarState를 담는 List(carStateList)가 있다
- [x] : toString()에 CarState를 `\n`으로 구분되어 반환되도록 overriding

### Winner
우승자를 나타내는 data class
- [x] : 우승한 차들을 담은 List(cars)가 있다
- [x] : toString()에 우승한 차들의 이름을 `, `으로 구분되어 반환되도록 overriding  

## 기능 요구 사항
초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
    - ex) `pobi : --`
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
    - ex) `pobi,woni,jun`
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
    - 즉, 0 ~ 3 : 멈춤, 4 ~ 9 : 전진
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
    - ex) `최종 우승자: pobi`
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
    - ex) `최종 우승자: pobi, jun`
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 추가된 요구 사항

- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다. 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다. 힌트: indent(인덴트, 들여쓰기) depth를
  줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
- 테스트 도구 사용법이 익숙하지 않다면 test/kotlin/study를 참고하여 학습한 후 테스트를 구현한다.

## 라이브러리

- camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
- Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
- 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

## 사용 예시

0에서 9까지의 정수 중 한 개의 정수 반환

```kotlin
Randoms.pickNumberInRange(0, 9)
```