##기능 목록

* 전진하는 조건은 0~9사이의 숫자를 구한 후 4 이상일 경우 전진, 4미만일 경우 정지 
  * camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
*   자동차 이름 입력 후 횟수 입력
    * camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
    * 자동차 이름은 5자 이하만 사용가능
    * 쉼표로 구분(글자와 쉼표를 붙여서 사용)
    * 횟수 입력(숫자만 사용 가능)

  * 전진 횟수가 가장 많은 차량이 우승 - 출력 이름
    * 여러 대 일수도 있음
    * 출력도 쉼표로 구분(쉼표 이후 공백 한칸)
  * indent depth는 최대 2까지 허용
  * 함수 축소화 할껏