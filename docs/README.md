## ️🔍 프로그램 기능 목록 🏎

---

### 입력 
- [x] 경주할 자동차의 이름을 입력받는다. // UserInput.readCarName()
  - [x] 입력받은 이름을 리스트에 저장한다. // String.createNameList()
  - [x] 쉼표(,)를 기준으로 이름을 구분한다. // String.split(",") 사용
  - [x] 이름이 5글자 이하인지 검사한다. // InputValidator.checkNamesLength

- [x] 자동차의 이동 횟수를 입력받는다. // UserInput.readAttemptCount()
  - [x] 입력을 정수로 변환한다.
  - [x] 입력이 숫자로만 되어있는지 검사한다. // InputValidator.checkOnlyDigit


❗️ 사용자가 잘못된 값을 입력할 경우, `IllegalArgumentException`을 발생시킨 후 애플리케이션을 종료한다.
- 사용자 입력에서, 문자열 앞 뒤 공백은 무시한다. (trim() 사용)  

📖 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 이용하여 사용자 입력을 받는다.

---
### 출력

- [x] 실행 결과를 출력한다. // UserOutput.displayRoundResult()
  - [x] 각 차수별 결과(전진, 멈춤)와 자동차의 이동을 같이 출력한다.  
  

- [x] 최종 우승자를 출력한다. 
  - [x] 자동차 리스트에서 distance의 최댓값을 구한다.
  - [x] 최댓값을 가진 자동차들의 name을 찾아 리스트로 만든다.
  - [x] 2명 이상의 우승자가 있을 경우, 쉼표로 구분하여 출력한다.

### 게임 기능
- [x] 0에서 9 사이의 무작위 값을 구한다. // createRandomNumber()
  - [x] 값이 4 이상인 경우, 자동차가 전진한다. // RacingCar.move()

📖 무작위 값은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.

### 게임 관리(RaicingGameManager)
- [x] 게임을 실행한다. // play()
  - [x] 차량 등록 => 입력 객체에게 입력을 사용자 정보를 요청하고, 자동차 객체(RacingCar)를 생성한다. // registerCarNames()
  - [x] 입력받은 사용자 정보로 게임을 진행한다. // startRace()
    - [x] 시도 횟수만큼 반복한다.
    - [x] 시도 횟수만큼 출력 객체에게 진행 결과 출력을 요청한다.
    
  - [x] 출력 객체에게 게임 결과 출력을 요청한다.