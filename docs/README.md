### 구현할 기능 목록 리스트
1. 경주 할 자동차 이름들 입력
- 이름은 쉼표(,) 기준으로 구분한다.
- 이름은 5자 이하만 가능하다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
2. 시도할 횟수 입력
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
3. 전진 단계
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
4. 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다.
- 우승자는 한 명 이상일 수 있다.

### 라이브러리
- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.