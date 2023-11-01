# 미션 - 자동차 경주

## 기능 목록

- [ ] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
  - [ ] 몇 번의 이동을 할지 사용자로부터 입력받는다.
  - [ ] 입력받은 횟수만큼 각 자동차는 전진하거나 멈춘다.
- [x] 자동차에 부여할 이름을 사용자로부터 입력받는다.
  - [x] 자동차 이름은 쉼표를 기준으로 구분한다.
  - [ ] 자동차 이름은 5자 이하만 가능하다.
- [ ] 전진하는 자동차 출력할때 이름 함께 출력한다.
- [ ] 0~9 사이에서 구한 무작위 값이 4이상일 경우 전진한다.
- [ ] 자동차 게임 완료
- [ ] 최종 우승자를 알려준다.
  - [ ] 우승자 한 명 이상일 수 있다.
  - [ ] 우승자 여럿일 경우 쉼표로 구분한다.
- [ ] 사용자 입력값이 잘못되었을 경우 IllegalArgumentException을 발생시킨다.
  - [ ] IllegalArgumentException 발생하면 애플리케이션 종료된다.
  - [ ] 이름을 잘못 입력한 경우
    - [ ] 5자 이상을 입력한 경우
    - [ ] 쉼표 이외의 기호를 입력한 경우
  - [ ] 횟수를 잘못 입력한 경우
    - [ ] 숫자가 아닌 값을 입력한 경우

## 프로그래밍 요구 사항

- [ ] Kotlin 1.9.0에서 실행 가능해야 한다.
- [ ] Java 코드가 아닌 Kotlin 코드로만 구현해야 한다.
- [ ] 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- [ ] `build.gradle(.kts)`을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [ ] [Kotlin 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/kotlin) 가이드를 준수하며 프로그래밍한다.
- [ ] 프로그램 종료 시 System.exit()를 호출하지 않는다.
- [ ] 프로그램 구현이 완료되면 ApplicationTest의 모든 테스트가 성공해야 한다.
- [ ] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.
- [ ] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- [ ] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [ ] JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
- [ ] `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
  - [ ] Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
  - [ ] 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

## 과제 진행 요구 사항

- [ ] 미션은 [kotlin-racingcar-6](https://github.com/woowacourse-precourse/kotlin-racingcar-6) 저장소를 Fork & Clone해 시작한다.
- [ ] 기능을 구현하기 전 `docs/README.md`에 구현할 기능 목록을 정리해 추가한다.
- [ ] Git의 커밋 단위는 앞 단계에서 `docs/README.md`에 정리한 기능 목록 단위로 추가한다.
  - [ ] [커밋 메시지 컨벤션](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 가이드를 참고해 커밋 메시지를 작성한다.
- 과제 진행 및 제출 방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고한다.
- [ ] 요구 사항에 명시된 출력값 형식을 지키도록 한다.
- [ ] 기능 구현을 완료한 뒤 테스트 성공하는지 확인한다.