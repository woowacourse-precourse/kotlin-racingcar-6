# 자동차 경주 게임

## 기능 목록

- [x] 참가하는 자동차들의 이름을 입력받는다. - RacingCarGameManager#setRacingCars()
  - [x] 자동차 이름이 올바른 형태로 입력되었는지 확인한다. - Validator#validateCarNames()
- [x] 자동차가 이동을 시도하는 총 횟수를 입력받는다. - RacingCarGameManager#setTotalRound()
  - [x] 횟수가 올바른 형태로 입력되었는지 확인한다. - Validator#validateTotalRoundNumber()
- [x] 자동차별로 난수를 생성한다. - RacingNumberGenerator#get()
- [x] 4 이상의 수가 나온 자동차는 이동하고, 그렇지 않은 자동차는 멈춰있는다. - RacingCarGame#playRound()
- [x] 자동차별로 이동에 대한 결과를 자동차 이름과 함께 출력한다. - RacingCarGameViewer#showRoundResult()
- [ ] 주어진 횟수만큼 이동이 완료되면 우승자 정보를 출력하고 게임이 종료된다.

## 기능 요구 사항

주어진 횟수동안 자동차가 일정 확률로 이동하며 진행되는 자동차 경주 게임입니다.

- 자동차 이름을 입력받을 때는 쉼표(`,`) 를 기준으로 구분하여 입력받으며, 5자 이하만 입력 가능합니다.  
- 최소 2대 이상의 자동차가 모여 경주를 진행하며, 0 부터 9 까지의 난수를 생성하여 4 이상의 값이 나온 경우에만 이동합니다.
- 이동에 대한 결과는 하이픈 (`-`) 으로 나타냅니다.
- 공동 우승이 가능하며, 공동 우승의 경우 우승자 정보는 쉼표(`,`) 를 기준으로 구분하여 출력합니다.
- 프로그램이 진행되는 동안 사용자가 잘못된 값을 입력한 경우에는 IllegalArgumentException 을 발생시키고 프로그램을 종료합니다.