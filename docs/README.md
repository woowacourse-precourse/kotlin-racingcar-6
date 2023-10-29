# 구현할 기능
1. 유저에게 경주할 자동차 이름을 입력해 달라고 출력 후 쉼표로 구분된 유저의 자동자 이름 입력을 받기 ✅
   - `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용
2. 입력 받은 이름들이 5자 이하인지 확인 ✅
   - 5자 초과 일 경우, `IllegalArgumentException`
   - 각 자동차에 이름을 **부여할 수 있다**고 했으므로 이름이 비어있어도 **예외 처리는 하지 않음**
3. 시도할 횟수를 입력해 달라고 출력 후 유저에게 시도할 횟수를 입력 받기 ✅
   - `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용
4. 유저가 올바르게 시도할 횟수를 입력했는지 확인 ✅
   - 숫자 변환 불가시, `IllegalArgumentException`
   - 0 미만의 값이 들어올 경우도 `IllegalArgumentException`
5. 팩토리로 입력받은 이름에 대한 자동차를 생성 ✅
6. 모든 자동차에 대해 전진을 할지 멈출지 정함 ✅
   - 무작위 값을 구하여서 전진 여부 결정
     - 값이 4 이상일 경우, 전진
     - 그렇지 않으면 멈춤
   - `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용
7. 해당 턴의 실행 결과를 출력 ✅
8. 사용자가 입력한 시도할 횟수 만큼 7~8번을 반복
9. 최종 우승자 출력
   - 만약 최중 우승자가 여러명일 경우 쉼표로 구분

# 추가된 요구사항
- intent depth 3 초과 금지
- 함수가 한가지 일만 하도록
- 구현한 기능에 대한 테스트 코드