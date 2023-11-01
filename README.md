# 미션 - 자동차 경주

## 작업 순서

1. 미션 내용 꼼꼼하게 확인하기!(기능 단위 커밋)
2. 기능 목록 정리
- 자동차 이름 입력받기(5자 이하, 쉽표로 구분하기)->출력할 때 마다 이름을 출력해야한다.
- 자동차 이동 가능 횟수 입력받기
- 전진 조건 설정하기(0-9까지 무작위 값 생성, 4 이상일 경우에만 전진)
- 완주 후 우승자를 알려준다. (중복 우승 인정하며 여러명일 시 쉼표로 구분)
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
3. 프로그래밍 요구 사항 확인
  indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다. 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다. 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
테스트 도구 사용법이 익숙하지 않다면 test/kotlin/study를 참고하여 학습한 후 테스트를 구현한다.
4. 라이브러리
  camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
5. 최종 점검 (내부 테스트기, 요구 조건 만족 여부 확인)
6. 제출
