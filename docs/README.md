## 기능 목록
- [O] 자동차를 생성한다.  - InputMachine#makeCars()
  - [O] 조건 - 자동차의 이름은 5자 이하이다. - InputMachine#checkCarNameUnder5()
- [O] 만들어진 각각의 자동차의 정보를 저장한다. - Car#
- [O] 몇 번 이동할 것인지 입력 - InputMachine#tryMove()
  - [O] 조건 - 양의 정수만 입력되어야 한다. - InputMachine#checkOnlyNatural()
- [O] 0~9 중 무작위 값을 구한다. - Racing#random09()
- [O] 4 이상일 경우 전진한다. - Racing#forwardOver4()
- [O] 무작위 값이 나온만큼 "-"을 출력한다. - Racing#printHyphen()
- [O] 입력한 이동 횟수만큼 반복 시도 - Racing#playRacing()
- [O] 자동차 경주 게임을 완료 후 누가 우승했는지 알려준다. 여러명 가능 - Referee#notifyWhoWin()
  - [O] 가장 멀리간 자동차의 수를 체크한다. - Referee#checkMaxForward()
  - [O] ","쉼표를 이용해서 구분한다.

## 기능 요구 사항

주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.

각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.

자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.

사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.

전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.

자동차의 무작위 값은 -으로 출력한다.

자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.