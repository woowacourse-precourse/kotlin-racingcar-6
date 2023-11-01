# Kotlin RacingCar 6 미션 구현목록

먼저 게임의 진행 상황을 고려해 크게 4 가지의 Class (Main, Game, Car, List<Car>) 를 생각했고, 각 객체별로 구현 사항을 나누어 보았습니다.

## 구현 사항

****

    Main
    [x] 게임 객체를 생성하고, 호출하여 게임 시작
    
    Game (start())
    [x] 게임 진행 상황을 출력 ( ~~ 를 입력하시오. 등 )
        [x] 경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
        [x] 시도할 횟수는 몇 회인가요?
        [x] 실행 결과 출력
        [x] 최종 우승자 
    [x] 이동 횟수 입력 받기
    [x] 자동차 이름을 입력받아 이름 속성을 가진 Car 객체를 생성하기
        [x] 입력받은 String을 쉼표 기준으로 구분해서 이름 list 만들기
        [x] 이름 property를 가진 Car 객체를 생성  
    
    Car (name, location, randMove())
    [x] 5글자 초과의 이름에 대해서 오류 발생 - setName후 instance init 과정에서 확인
    [x] 전진 기능 : 0 ~ 9 의 무작위 숫자 발생 후 4 이상이면 위치 + 1 - randMove()

    
    List<Car> (toStatusString(), winner(), race())
    [x] 모든 차량의 현재 위치 상황을 출력  - toStatusString()
    [x] 모든 차량의 전진 기능을 발동 - race()
    [x] 가장 앞서 나간 차량 get - winner()

### 세부 구현 사항

    [ ] indent depth <= 2
    [ ] JUnit5, AssertJ 를 이용한 테스트 코드
    [ ] camp.nextstep.edu.missionUtils 라이브러리의 다음 함수 사용
        [ ] Randoms.pickNumberInRange()
        [ ] Console.readLine() 