# 미션 - 자동차 경주

## 구현할 기능 목록
## CarRace.kt
### getCarNames(): 경주 할 자동차 이름 입력하는 함수
- 사용자 이름 한 번에 입력
- 쉼표(',')를 기준으로 나눔
- 이름은 5자 이하만 입력 가능

### getMoveCount(): 시도할 횟수 입력하는 함수
- int 정수형 입력

### handleExceptions(): 예외를 처리하는 함수
- 시도할 횟수 입력하는 함수에 대해 예외처리
- 경주 할 자동차 이름 입력하는 함수에 대해 예외처리

<hr>

## CarMovement.kt
### printCurrentPositions(): 시도하는 결과 저장하는 함수
- 0에서 9 사이에서 무작위 값을 구한 후, 무작위 값이 4 이상일 경우에 count를 한다.
<hr>


## CarResults.kt
### printCurrentPositions(): 실행 결과 출력하는 함수
- for문 사용
- 각 차수별 실행 결과 출력

### findWinners(): 최종 우승자 판단하는 함수
- 각 차수마다 제일 많은 count를 가진 사용자를 반환함

### printWinners(): 최종 우승자 출력하는 함수
- 판단한 함수로 부터 얻은 사용자 정보를 출력함