# ✅ 구현할 기능 목록

### 1️⃣ 사용자로부터 자동차 이름을 입력받는 기능

- [x] 자동차 이름 입력 요청 문구를 출력한다.
- [x] Console.readLine()을 활용하여 문자열을 입력받는다.
- [x] 입력받은 문자열을 "," 로 분리하고, 리스트로 저장한 후 검증한다.
- [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨다.
    - [x] ❗️ [예외사항] 이름이 공백일 경우
    - [x] ❗️ [예외사항] 이름이 다섯 자 이하가 아닌 경우
    - [x] ❗ [예외사항] 이름이 중복되는 경우

### 2️⃣ 자동차를 생성하는 기능

- [x] 이름을 가진 n대의 자동차를 생성한다.
- [x] 0부터 9 사이의 무작위 값을 구해 4 이상이 나오면 전진하고, 아니면 정지하는 기능을 가지고 있다.
    - [x] Randoms.pickNumberInRange()를 활용하여 무작위 값을 추출한다.

### 3️⃣ 사용자로부터 자동차의 이동 횟수를 입력받는 기능

- [x] 이동 횟수 입력 요청 문구를 출력한다.
- [x] Console.readLine()을 활용하여 문자열을 입력받는다.
- [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨다.
    - [x] ❗️ [예외사항] 1 이상의 숫자가 아닌 경우

### 4️⃣ 이동 횟수만큼 모든 자동차를 경주시키는 기능

- [x] 이동 횟수만큼 모든 자동차를 전진 혹은 정지 시킨다.
- [x] 한 번의 경주가 끝날 때마다 각 차수별 실행 결과를 출력한다.
    - [x] 모든 자동차의 이름과 현재 위치를 출력한다.

### 5️⃣ 우승자 출력 기능

- [x] 현재 위치가 가장 높은 자동차(들)의 이름을 출력한다.
    - [x] 우승자는 복수일 수 있다.

<br/>

## 📚 2주차 구현 목표

    1. 커밋 메세지를 작업한 내용을 명확하게 전달할 수 있도록 작성한다.
    2. 변수와 메소드, 클래스 등의 의도를 쉽게 파악할 수 있도록 좋은 이름을 짓기 위해 노력한다.
    3. kotiln의 API, 문법을 최대한 적용할 수 있도록 노력한다.
    4. indent(인덴트, 들여쓰기) depth를 3이 넘지 않고, 함수 또는 메서드가 한 가지 일만 하도록
       최대한 작게 만들기 위해 노력한다.
    5. 객체의 역할과 책임에 따라 클래스를 분리할 수 있도록 노력한다.

<br/>

## 📚 기능별 테스트 목록

    1번 기능 : CarNameValidatorTest, ConverterTest, ApplicationTest
    2번 기능 : CarTest, CircuitTest, RandomNumberTest, ApplicationTest
    3번 기능 : RaceRoundValidatorTets, ConverterTest, ApplicationTest
    4번 기능 : CircuitTest, ApplicationTest
    5번 기능 : RefereeTest, ApplicationTest