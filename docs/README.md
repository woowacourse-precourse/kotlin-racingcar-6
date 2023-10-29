
### 자동차(RacingCar)
- 프로퍼티
  - [x] 이름(name)
  - [x] 이동거리(distance)
  
- 메서드
  - [x] 자동차 전진(move)

### 자동차 생성(RacingCarFactory)
- 메서드
  - [x] 자동차 생성(createCars)

### 자동차 게임(RacingCarGame)
- 프로퍼티
  - [x] 참여하는 자동차(cars)
  - [x] UserInputManager 객체
  - [x] RacingCarGameMessage 객체
  - [x] RacingCarGameResultEvaluator 객체
  - [x] RacingCarFactory 객체
  - [x] RacingCarMovementRecorder 객체
  
- 메서드
  - [x] 게임 진행(gamePlay)

### 자동차 게임 메시지(RacingCarGameMessage)
- 상수
  - [x] 자동차 이름 입력 메시지(CAR_NAME_INPUT_MESSAGE)
  - [x] 시도할 횟수 입력 메시지(TRY_COUNT_MESSAGE)
  - [x] 실행 결과 메시지(RESULT_MESSAGE)
  
- 메서드 
  - [x] 자동차 이름 출력(printCarNameInputMessage)
  - [x] 시도할 횟수 입력 출력(printTryCountInputMessage)
  - [x] 실행 결과 메시지 출력(printResultMessage)
  - [x] 최종 우승자 출력(printWinnerMessage)
    
### 자동차 게임 판정(RacingCarGameResultEvaluator)
- 메서드
  - [x] 최종 우승자 판정(racingCarGameJudge)

### 자동차 전진 상태 출력(RacingCarGameStatePrinter)
- 상수
  - [x] 거리 표현 문자열(DISTANCE_EXPRESSION)
  
- 메서드
  - [x] 자동차 전진 거리 출력(printCarDistance)
  - [x] 모든 자동차의 1회 전진 거리 출력(printAllCarsDistance)

### 모든 자동차 이동(RacingCarManager)
- 메서드
  - [x] 모든 자동차의 1회 전진(moveAllCars)

### 자동차 전진 과정 기록(RacingCarMovementRecorder)
- 메서드
  - [x] 전진 횟수에 따른 자동차 전진 및 이동 거리 출력(racingCarMovementRecordByTryCount)

### 사용자 입력(UserInputManager)
- 프로퍼티
  - [x] UserInputValidator 객체
  
- 메서드
  - [x] 이름 입력(userNameInput)
  - [x] 시도할 횟수 입력(userTryCountInput)

### 사용자 입력 예외처리(UserInputValidator)
- 상수
  - [x] 이름 입력 길이 5 이상 예외처리 메시지(USER_NAME_INPUT_LENGTH_EXCEPTION_MESSAGE)
  - [x] 이름 중복 입력 예외처리 메시지(USER_NAME_INPUT_NAME_DUPLICATE_EXCEPTION_MESSAGE)
  - [x] 이동 횟수 입력 예외처리 메시지(USER_TRY_COUNT_INPUT_IS_NOT_NUMBER_EXCEPTION_MESSAGE)
  - [x] 이동 횟수 음수 입력 예외처리 메시지(USER_TRY_COUNT_INPUT_IS_MINUS_NUMBER_EXCEPTION_MESSAGE)
  - [x] 이름 최대 글자 수(NAME_MAX_LENGTH)
  
- 메서드
  - [x] 이름 입력 예외처리(userNameInputValidator)
  - [x] 이동 횟수 입력 예외처리(userTryCountInputValidator)
  - [x] 이름 최대 글자 수에 부적합 여부(isNotCorrectLength)
  - [x] 입력한 문자열이 숫자에 부적합 여부(isNotCorrectLength)
  - [x] 이름 중복 여부(hasDuplicateName)
  - [x] IllegalArgumentException 발생(invokeIllegalArgumentException)