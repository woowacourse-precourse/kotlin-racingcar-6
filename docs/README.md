## 기능 목록(한 눈에 보기)

```
• 게임 시작 전
    ◦ 경주할 자동차 이름을 입력받는다. (1) - RacingGame#inputCarNames
        ▫︎ 자동차 이름은 쉼표로 구분한다. - CarManager#separateCarNames
        ▫︎ 자동차 이름은 5자 이하여야 하며, 넘어갈 시 애러를 발생시킨다. (3) - Validator#validateNameLength
        ▫︎ 자동자 이름에 중복이 있다면 에러를 발생시킨다. (3) - Validator#validateDuplicate
        ▫︎ 자동차 이름에 null값이 들어오면 에러를 발생시킨다. (3) - Validator#validateNull
    ◦ 게임 횟수를 입력받는다. (2) - RacingGame#inputRaceCount
        ▫︎ 입력이 숫자가 아닐 시 이러를 발생시킨다. (3) - Validator#validateNumber
        ▫︎ 횟수가 0일 시 에러를 발생시킨다. (3) - Validator#validateRange

• 게임 중
    ◦ 0부터 9까지의 숫자를 랜덤하게 구한다. (1) - RacingGame#getRandomNumber
        ▫︎ 구한 숫자가 4이상의 숫자인지 확인한다. - RacingGame#checkMovable
    ◦ 4이상의 숫자일 시 자동차를 전진한다. - Car#moveOneStep
        ▫︎ 자동차 전진은 '-'으로 표기한다. - RacingGame#printCarDistance
        ▫︎ 단 첫번째 출력시에는 자동차 이름도 같이 표기한다.
        (ex. pobi : -)
    ◦ 게임 횟수만큼 반복한다. - RacingGame#gameStart

• 게임 종료
    ◦ 최종 우승자 리스트를 가져온다. - Cars#getWinners
    ◦ 최종 우승자를 출력한다. (4) - RacingGame#printWinner
        ▫︎ 게임 우승자는 여러명이 나올 수도 있으며, 여러명일 경우에는 쉼표로 구분하여 출력한다.

(1) 랜덤값 추출은 camp.nextstep.edu.missionutils.Randoms.pickNumberInRange()을 이용한다.
(2) 사용자 입력은 camp.nextstep.edu.missionutils.Console.readLine()을 이용한다.
(3) 예외처리는 IllegalArgumentException을 발생시켜 애플리케이션을 종료시킨다. 
(4) 게임 종료 시 System.exit()를 호출하지 않는다.
```

<br><br>

## 기능 목록 체크리스트

- 게임 시작 전
- [x]  게임 시작 문구를 출력한다.
- [x]  자동차 경주 이름을 입력받는다. `inputCarNames`
- [x]  자동차 이름들을 구분한다. `separateCarNames`
- [x]  자동차 이름의 유효성을 검사한다. `validateNameLength` `validateNull` `validateDuplicate`
- [x]  게임 횟수를 입력받는다. `inputRaceCount`
- [x]  게임 횟수의 유효성을 검사한다. `validateNumber` `validateRange`

<br>

- 게임 시작
- [x]  0부터 9까지의 숫자를 정한다. `getRandomNumber`
- [x]  만약 정한 숫자가 4보다 크면 한칸 움직인다. `moveOrStop`
- [x]  처음에 입력 받는 횟수만큼 반복한다. `gameStart`

<br>

- 게임 종료
- [x]  최종 우승자를 출력한다. `getWinners` `printWinner`
- [x]  여러 명일 경우에는 쉼표로 구분하여 출력한다.

<br><br>

## 프로그래밍 요구 사항

- [x]  indent(인덴트, 들여쓰기)는 depth를 3이 넘지 않도록 구현한다.
- [x]  함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [x]  JUnit 5와 AssertJ를 이용하여 기능 목록이 정상적으로 작동하는지 테스트 코드를 작성하여 확인한다.