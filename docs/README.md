
### 자동차(RacingCar)
- 프로퍼티
  - [x] 이름(name)
  - [x] 이동거리(distance)
  
- 메서드
  - [x] 자동차 전진(move)

### 자동차 생성(RacingCarFactory)
- 메서드
  - [x] 자동차 생성 함수(createCars)

### 자동차 게임(RacingCarGame)
- 프로퍼티
  - [x] 참여하는 자동차(cars)
  - [x] UserInputManager 객체
  - [x] RacingCarGameMessage 객체
  - [x] RacingCarGameResultEvaluator 객체
  - [x] RacingCarFactory 객체
  - [x] RacingCarMovementRecorder 객체
  
- 메서드
  - [x] 게임 진행 함수(gamePlay)

### 자동차 게임 메시지(RacingCarGameMessage)
- 상수
  - [x] 자동차 이름 입력 메시지
  - [x] 시도할 횟수 입력 메시지
  - [x] 실행 결과 메시지
  
- 메서드 
  - [x] 자동차 이름 출력 함수(printCarNameInputMessage)
  - [x] 시도할 횟수 입력 출력 함수(printTryCountInputMessage)
  - [x] 실행 결과 메시지 출력 함수(printResultMessage)
  - [x] 최종 우승자 출력 함수(printWinnerMessage)
    
### 자동차 게임 판정(RacingCarGameResultEvaluator)
- 메서드
  - [x] 최종 우승자 판정 함수(racingCarGameJudge)

### 자동차 전진 상태 출력(RacingCarGameStatePrinter)
- 상수
  - [x] 거리 표현 문자열
  
- 메서드
  - [x] 자동차 전진 상태 출력 함수(printState)
  - [x] 모든 자동차의 1회 전진 상태 출력 함수(printAllCarsState)

### 모든 자동차 이동(RacingCarManager)
- 메서드
  - [x] 모든 자동차의 1회 전진 함수(moveAllCars)

### 자동차 전진 과정 기록(RacingCarMovementRecorder)
- 메서드
  - [x] 전진 횟수에 따른 자동차 전진 및 상태 출력 함수(racingCarMovementRecordByTryCount)

### 사용자 입력(UserInputManager)
- 프로퍼티
  - [x] UserInputValidator 객체
  
- 메서드
  - [x] 이름 입력 함수(userNameInput)
  - [x] 시도할 횟수 입력 함수(userTryCountInput)

### 사용자 입력 예외처리(UserInputValidator)
- 상수
  - [x] 이름 입력 예외처리 메시지
  - [x] 이동 횟수 입력 예외처리 메시지
  
- 메서드
  - [x] 이름 입력 예외처리 함수(userNameInputValidator)
  - [x] 이동 횟수 입력 예외처리 함수(userTryCountInputValidator)