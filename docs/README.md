# 구현할 기능 목록
- [X] 사용자는 경주 할 자동차들의 이름을 입력할 수 있다. - Player#inputRacingCarNames()
  - [X] 사용자의 입력이 null일 경우 IllegalArgumentException을 발생시킨다.
  - [X] 자동차 이름은 쉼표를 기준으로 구분한다.
  - [X] 이름 목록으로 자동차들을 생성할 수 있다. - RacingCars#RacingCars()
    - [X] 경주할 자동차의 수는 2대 이상이어야 한다.
    - [X] 이름과 함께 자동차를 생성할 수 있다. - RacingCar#RacingCar()
      - [X] 자동차 이름을 생성할 수 있다. - CarName#CarName()
        - [X] 자동차 이름의 양 옆의 공백이 있다면 제거한다.
        - [X] 자동차 이름이 1자 미만, 5자 초과일 경우 IllegalException을 발생시킨다.
- [X] 사용자는 시도할 횟수를 입력할 수 있다. - Player#inputTryCount()
  - [X] 시도 횟수는 숫자여야 한다.
  - [X] 시도 횟수는 1 이상이어야 한다.
- [X] 자동차들을 전진 또는 정지시킨다. RacingCars#move()
  - [X] 자동차가 전진 또는 정지한다. - RacingCar#move()
    - [X] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
    - [X] 자동차가 전진할 경우 자동차의 위치를 1 증가시킨다.
    - [X] 자동차가 멈출 경우 자동차의 위치를 그대로 유지한다.
- [X] 우승자를 판단할 수 있다. - RacingCars#findWinners()
  - [X] 위치가 가장 큰 자동차가 우승자이다.
  - [X] 우승자는 한 명 이상일 수 있다.
- [X] 우승자를 출력할 수 있다. - DisplayBoard#display()
  - [X] 단독 우승자를 출력할 수 있다.
    - ```최종 우승자 : pobi```
  - [X] 공동 우승자를 출력할 수 있다.
    - ```최종 우승자 : pobi, jun```
- [X] 각 차수별 실행결과를 출력할 수 있다. - DisplayBoard#display()
  - [X] 위치 한 칸은 -로 표시한다.
  - ```
    pobi : --
    woni : ----
    jun : ---
    ```