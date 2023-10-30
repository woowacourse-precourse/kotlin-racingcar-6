# 레이싱 카
## 기능 구현 목록
### 1. 컴퓨터 : 게임 안내 메시지 출력
>　ㄱ. `println` 사용하여 안내메시지 출력
> 
### 2-1. 사용자 : 자동차 이름 입력받기
>　ㄱ. 빈 `list`변수 생성(사용자용)
> 
>　ㄴ. `camp.nextstep.edu.missionutils.Console`의 `readLine()` 사용
> 
>　　    **사용자가 잘못된 값을 입력할 경우**, `IllegalArgumentException` **예외 발생시킨 후 애플리케이션 종료**

>　ㄷ. `list`에 자동차 이름 추가(여러개 일경우, 쉼표를 슬라이싱)
> 
### 2-2. 사용자 : 라운드 진행횟수 입력받기
>　ㄱ. 초기값 0 `Int`변수 생성(사용자용)
> 
>　ㄴ. `camp.nextstep.edu.missionutils.Console`의 `readLine()` 사용
> 
>　　    **사용자가 잘못된 값을 입력할 경우**, `IllegalArgumentException` **예외 발생시킨 후 애플리케이션 종료**
>　ㄷ. `Int`에 추가
> 
### 3. 컴퓨터 : 게임 진행 & 결과 출력
>　ㄱ. `for문`, `println` 사용하여  라운드마다 자동차 전진상황 출력
> 
>　ㄴ. `println` 사용하여 최종 우승자 출력(여러 명일 경우, 쉼표로 구분)
```
ex) 레이싱 카 게임 
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분) // 입력받은 부분
pobi,woni,jun
시도할 횟수는 몇 회인가요?
5

실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun
```