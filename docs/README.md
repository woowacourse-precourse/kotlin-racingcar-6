
## 🥲 이전 미션 개선점 찾기
- 커밋 메시지 작성의 필요성 : 커밋 메시지를 기능별로 적절하게 관리하기
- 축약 : 이름이 길어지더라도 의도 들어내기
- 의미 없는 주석 : 의도를 들어내기 힘든 경우만 주석 작성하기
- kotlin API 적극 활용 : 메소드를 구현하기 전에 코틀린에서 제공하는지 확인하기
- Kotlin Collection 적극 활용 : contains, index 등 다양한 API 활용

---
## 🛠 추가 요구사항 점검하기
- indent(들여쓰기) depth를 3이 넘지 않도록 구현
  - ex> while 문 안에 if 문이 들어간 경우 들여쓰기 2
- 함수를 적극 활용하고, 하나의 함수는 한 가지 일만 하도록 최대한 작게 작성
- JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인
  - test/kotlin/study를 참고하여 직접 테스트 구현

---
## 🗂 기능 구성하기
- n대의 자동차 생성
    - 정확한 이름 입력 -> 게임 진행
    - 사용자가 잘못된 값을 입력할 경우 -> 게임 종료 (`IllegalArgumentException`)
- 총 시도 횟수 생성
    - 정확한 숫자 입력 -> 자동차 경주 시작
    - 사용자가 잘못된 값을 입력할 경우 -> 게임 종료 (`IllegalArgumentException`)
- 총 시도 횟수만큼 반복
    - 각 자동차의 무작위 값 생성
        - 무작위 값이 4 이상인 경우 : 전진("-")
        - 무작위 값이 4 미만인 경우 : 정지("")
    - 결과 출력 (자동차 이름 : 전진 상태)
- 최종 우승자 출력

---
## 🧑‍💻 기능 구현하기

---
## GameConsole

---
### [GameConsole.kt](..%2Fsrc%2Fmain%2Fkotlin%2Fracingcar%2Fconsole%2FGameConsole.kt)
- 게임 진행과 데이터를 관리하는 오브젝트 입니다.
#### Variable
#### Method
- `getCarList()` : 자동차 리스트를 반환합니다.
- `getRacingCount()` : 레이싱 시도 횟수를 반환합니다.
- `separateCarList()` : 자동차 리스트를 생성합니다.
- `selectWinner()` : 우승자를 선별합니다.
- `setRacingCount()` : 레이싱 시도 횟수를 사용자로부터 받습니다.
- `registerCar()` :  새로운 자동차를 등록합니다.
- `getUserInput()` : 사용자의 입력을 받습니다.

## Manager

---
### [RacingManager.kt](..%2Fsrc%2Fmain%2Fkotlin%2Fracingcar%2Fmanager%2FRacingManager.kt)
- 레이싱을 진행하기 위한 클래스 입니다.
#### Method
- `racingCycle` : 모든 자동차의 한 번의 레이싱 레이싱 결과를 적용합니다.
- `remoteCarProgress` : 하나의 자동차에 레이싱 결과를 적용합니다. 
- `makeRandomNumber` :  랜덤값을 생성합니다.

### [MessageManager.kt](..%2Fsrc%2Fmain%2Fkotlin%2Fracingcar%2Fmanager%2FMessageManager.kt)
- 메시지 출력을 위한 클래스입니다.
#### Method
- `printGameStart` : 게임 시작 메시지를 출력합니다.
- `printGameCount` : 레이싱 시도 횟수를 받는 메시지를 출력합니다.
- `printGameResult` : 게임 결과를 출력합니다.
- `printOneRacingResult` : 한 번의 레이싱 결과를 출력합니다.
- `printCarProgress` : 하나의 자동차의 진행 상태를 출력합니다. 
- `printWinningCars` : 구분자를 삽입하여 우승자를 출력합니다.

## Model

--- 
### [Car.kt](..%2Fsrc%2Fmain%2Fkotlin%2Fracingcar%2Fmodel%2FCar.kt)
- 자동차 데이터를 보관하기 위한 클래스입니다.
#### Property
- `name` : 자동차의 이름입니다.
- `progress` : 자동차의 진행 상태로, 0을 기본값으로 가집니다.

## Validation

---
### [CheckValidation.kt](..%2Fsrc%2Fmain%2Fkotlin%2Fracingcar%2Fvalidation%2FCheckValidation.kt)
- 올바른 값이 입력되었는지 검증하기 위한 클래스입니다.
#### Method
#### Public
- `checkCarLength` : 자동차 이름의 길이를 검사합니다.
- `checkCarNameValidation` : 올바른 자동차 이름인지 검사합니다. 
- `checkInputRacingCount` : 레이싱 시도 횟수가 올바른 정수인지 검사합니다.
- `checkDuplicateCarName` : 자동차 이름의 중복값이 있는지 검사합니다.
#### Private
- `checkIsnumber` : 숫자인지 확인하는 함수입니다.
- `checkIsPositive` : 양의 정수인지 확인하는 함수입니다.
- `checkNameLength` : 문자열 길이가 5 이하인지 확인하는 함수입니다.
- `checkNameIsBlank` : 문자열 길이가 0인지 확인하는 함수입니다.
- `checkEnglishAndNumRegex` : 문자열이 영어나 숫자 정규식을 준수하는지 확인하는 함수입니다.
- `checkKoreanRegex` : 문자열이 한국어 정규식을 준수하는지 확인하는 함수입니다.
- `checkDuplication` : 자동차 이름 리스트에 중복값이 있는지 확인하는 함수입니다.

## Test

---
### [CarValidationTest.kt](..%2Fsrc%2Ftest%2Fkotlin%2FvalidationTest%2FCarValidationTest.kt)
- 사용자로부터 입력받은 자동차 리스트의 유효성을 테스트합니다.
### [RacingCountValidationTest.kt](..%2Fsrc%2Ftest%2Fkotlin%2FvalidationTest%2FRacingCountValidationTest.kt)
- 사용자로부터 입력받은 레이싱 시도 횟수의 유효성을 테스트합니다.