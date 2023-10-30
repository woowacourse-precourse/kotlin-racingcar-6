## 기능 목록

1. 경주 할 자동차 이름을 입력받는다
    1. 자동차 이름은 쉼표로 구분한다
    2. 구분한 것을 리스트에 저장한다
    3. 입력된 자동차 이름이 5자 초과이면 `IllegalArgumentException` 발생
    4. 입력된 자동차 개수가 1개 이하면 `IllegalArgumentException` 발생 (경주는 둘 이상부터 가능)

2. 몇 번의 이동을 할 것인지 입력받는다
    1. 입력된 숫자의 수가 0 이하라면 `IllegalArgumentException` 발생
    2. 숫자가 아니라면 `IllegalArgumentException` 발생 (`NumberFormatException`)

3. 입력받은 숫자만큼 반복하여 경주를 진행한다
    1. Data class에 자동차 이름과 전진 수를 저장한다
    2. 무작위 값이 4 이상일 경우 전진 수를 ++ 해준다

4. 우승자를 프린트한다
    1. 우승자가 여러 명일 경우 쉼표를 이용하여 나타내준다