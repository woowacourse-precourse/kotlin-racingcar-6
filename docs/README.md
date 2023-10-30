# 구현할 기능 목록

## Function
### car_init
- 자동차의 이름을 문자열로 입력 받아 data class인 car_status의 List에 저장하는 함수이다.
- 입력 값은 하나의 문자열로 받아오는 형태이므로 split 매소드를 이용해 분할하여 List에 저장한 뒤 name_check 함수를 호출한다.
- name_check 호출 후 이름의 조건에 부합하면 이동한 횟수를 0으로 초기화한다.

### name_check
- 입력 받은 자동차 이름의 길이가 5자 이하인지 확인하는 함수이다.
- 이름의 size가 5자를 초과할 경우 IllegalArgumentException을 발생시킨다.

### game_start
- car_status의 List와 시도할 횟수를 정수로 전달 받아 게임을 진행하는 함수이다.
- 각 자동차에 대해 시도할 횟수만큼 moving_forward 함수를 호출하여 이동한 횟수를 카운트한다.

### moving_forward
- 해당 자동차가 전진할 것인지 결정하는 함수이다.
- Random 값 추출 매소드인 pickNumberInRange()를 이용하여 난수를 발생시킨 후 4 이상일 경우 전진하도록 반환한다.

### lap_print
- 각 차수별 실행 결과를 출력하는 함수이다.
- car_status의 List를 전달 받아 출력한다.

### result_print
- 경주 종료 후 최종 우승자의 명단을 출력하는 함수이다.
- car_status의 List를 전달 받아 출력한다.

---

## data class
### car_status
- 자동차의 이름과 이동한 횟수를 저장할 data class이다. 
- 이름을 저장할 String 변수와 이동한 횟수를 저장할 Int 변수를 포함한다.

