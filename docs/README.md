# 구현해야 할 기능 목록

1. 경주할 자동차 이름 입력 받기
2. 시도할 횟수 입력 받기
3. 0 ~ 9 사이의 무작위 값 가져오기
4. 전진 여부 출력 ( 각 차수별 실행 결과 출력 )
5. 최종 결과 출력 ( 단독 우승자 / 공동 우승자 출력 )

# 만들 함수 목록

## startRace: 최종 실행 함수
- `carList`: 차 이름 저장 배열 ( makeCar 실행 )
- `attempt` : 시도할 횟수 ( attemptInput 실행 )
- `carResult` : 각 차에 해당하는 전진 결과값 저장 배열 ( carList 크기만큼 생성 )
- 포맷에 맞추어 printStart 실행
- 시도 횟수만큼 race 진행
- printResult 실행, 최종 결과 출력.

## 세부 함수 목록
## INPUT 관련

### carInput
- 경주할 자동차 이름 입력 받기.
- `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 사용한다.
- 입력 받은 값 return.

### attemptInput
- 시도할 횟수 입력 받기
- `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 사용한다.
- attemptValidation() 실행 : 입력 값이 1 이상의 숫자인지 확인.
- 시도 횟수를 return.

## Racing 관련

### makeCar
- inputCar를 쉼표를 통해 split.
- split한 결과 값을 carNameValidation()을 통해 5자 이하인지 확인 후, carList 배열에 append.
- carList를 return.

### makeRandomNumber
- 0 ~ 9 사이의 random number 생성.
- `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`을 사용한다.
- randomNumber을 return.

### raceCar
- car 개수만큼 반복문 진행.
- randomNumber가 4 이상인 경우 전진, 미만인 경우 멈춤
- 전진했을 경우 carResult 값 1 추가.

### findWinner
- carResult에서 max value 도출.
- carResult에서 max value와 같은 index의 cars[index]를 모두 찾아 return.

## 출력 관련

### printRace
- 1번의 시도가 종료될 때마다 실행. 
- `차 이름 : 진행 횟수`의 형식으로 출력.

### printResult
- 최종 우승자 출력.
- findWinner()로 결과값 받아오기.
- 우승자가 없을 경우, `우승자가 없습니다` 출력
- 우승자가 2명 이상일 경우, 마지막 우승자까지 쉼표와 함께 출력.

### printStart
- 포맷에 맞추어 `실행 결과` 출력.

## 예외 처리 관련

### carNameValidation
- Car name이 5자 이하인지 여부 확인
- 5글자를 초과했을 경우, `IllegalArgumentException` 실행

### attemptValidation
- 입력 받은 값이 1 이상의 int 값인지 확인
- 0 이하의 수 혹은 int가 아닌 경우 `IllegalArgumentException` 실행