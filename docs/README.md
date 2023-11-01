# 우아한테크코스 프리코스 2주차 구현 기능 목록
## 자동차 경주

#### 게임 진행 과정
* 자동차 이름 입력 받기
* 시도할 횟수 입력 받기
* 전진 시도 및 각 시도의 실행 결과 출력
* 최종 우승자 출력

#### 자동차 이름 입력 받기
* "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" 출력
* 이름은 5자 이하만 가능
* 자동차 이름은 쉼표(,)를 기준으로 구분 
* 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용
* 잘못된 입력 발생 시 IllegalArgumentException 발생 시킨 후 샐행 종료

#### 시도할 횟수 입력 받기
* "시도할 횟수는 몇 회인가요?" 출력
* 숫자만 가능
* 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용
* 잘못된 입력 발생 시 IllegalArgumentException 발생 시킨 후 샐행 종료

#### 전진 시도
* 0-9의 무작위 값을 구한 후 4 이상일 경우, 전진 가능
* Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용

#### 각 시도 결과 출력
* "실행 결과" 출력
* 전진 성공 횟수는 '-'를 이용해 출력
  * "자동차 이름 : 전진 성공 횟수"
  * 각 자동차 별로 줄바꿈 필요

#### 최종 우승자 출력
* "최종 우승자 : " 출력
* 우승자는 한명 이상 가능
* 여러명인 경우 쉼표(,)로 구분해서 출력