# 기능 명세서

- 자동차 전진기능
## Engine
- [x] 자동차의 전진 여부를 반환한다.
## DashBoard
- [x] 주행거리를 증가 시킨다.
- [x] 주행한 거리만큼 SYMBOL을 출력한다.
- [x] 주행한 거리를 반환한다.
## Car
- [x] 자신의 이름을 관리한다. 
- [x] Engine을 가지고 있다.
- [x] DashBoard를 가지고 있다.
## CarFactory
- [x] 자동차를 생산한다.
## RacingMessage
- [x] 레이싱 진행 간 사용자에 보여줄 메세지 정보를 가지고 있다.
## Validator
- [x] 자동차 이름의 길이를 검사한다.
- [x] 레이싱을 진행 할 라운드값이 유효한 값 인지 검사한다.
## Controller
- [x] 자동차의 정보를 입력 받는다.
- [x] 레이싱 진행 라운드 정보를 입력 받는다.
## Racing
- [x] 레이싱에 참가하는 자동차 목록을 가지고 있다.
- [x] 레이싱을 진행 시킨다.
- [x] 현재 1등 차량의 주행거리를 가지고 있다.
## RacingManager
- [x] 레이싱에 참가하는 자동차 목록을 전달한다.
- [x] 레이싱을 진행할 총 라운드 정보를 가지고 있다.
- [x] 레이싱을 라운드 수만큼 진행요청을 보낸다.
---
- 자동차 정보 출력 기능
- 레이싱 차수 별 결과 출력 기능
- 레이싱 결과 출력 기능
- 레이싱을 실행할 횟수 입력 기능
- 레이싱에 참가하는 자동차들의 정보 입력 기능

---
## 입출력 제한사항

---

## 🎯 프로그래밍 요구 사항

- Kotlin 1.9.0에서 실행 가능해야 한다. **Kotlin 1.9.0에서 정상적으로 동작하지 않을 경우 0점 처리한다.**
- **Java 코드가 아닌 Kotlin 코드로만 구현해야 한다.**
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle(.kts)`을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [Kotlin 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/kotlin) 가이드를 준수하며 프로그래밍한다.
- 프로그램 종료 시 System.exit()를 호출하지 않는다.
- 프로그램 구현이 완료되면 ApplicationTest의 모든 테스트가 성공해야 한다. 테스트가 실패할 경우 0점 처리한다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.

### 추가된 요구 사항

- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
    - 테스트 도구 사용법이 익숙하지 않다면 test/kotlin/study를 참고하여 학습한 후 테스트를 구현한다.

### 라이브러리

- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
