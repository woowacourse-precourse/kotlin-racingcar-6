# Kotlin RacingCar 6 미션 구현목록

먼저 게임의 진행 상황을 고려해 크게 4 가지의 Class (Main, Game, Car, Cars) 를 생각했고, 각 객체별로 구현 사항을 나누어 보았습니다.

## 구현 사항
****

    Main
    [x] 게임 객체를 생성하고, 호출하여 게임 시작
    
    Game
    [ ] 게임 진행 상황을 출력 ( ~~ 를 입력하시오. 등 )
    [ ] Car 객체를 생성
    [ ] 이동 횟수 입력 받기
    
    Car
    [ ] 5글자 이상의 이름에 대해서 오류 발생 
    [ ] 전진 기능 : 0 ~ 9 의 무작위 숫자 발생 후 4 이상이면 위치 + 1 
    
    Cars
    [ ] 모든 차량의 현재 위치 상황을 출력 
    [ ] 모든 차량의 전진 기능을 발동 
    [ ] 가장 앞서 나간 차량 get


### 세부 구현 사항

    [ ] indent depth <= 2
    [ ] JUnit5, AssertJ 를 이용한 테스트 코드
    [ ] camp.nextstep.edu.missionUtils 라이브러리의 다음 함수 사용
        [ ] Randoms.pickNumberInRange()
        [ ] Console.readLine() 