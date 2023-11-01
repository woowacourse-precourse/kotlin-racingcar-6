## 기능구현

### 입력

* [x] 경주할 자동차 수
* [x] 시도 횟수
* [x] 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하
* [x] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상

### 출력

* [x] 시작 안내문구
* [x] 각 차수별 실행결과
* [x] 단독 우승자 안내문구
* [x] 공동 우승자 안내문구
* [x] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분
* [x] 실행결과 예시

### 예외처리 사항

* [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료

### 추가

* [x] 클래스 분리
* [x] 상수 분리

### 요구 사항

* [x] commit message convention
- feat (feature)
- fix (bug fix)
- docs (documentation)
- style (formatting, missing semi colons, …)
- refactor
- test (when adding missing tests)
- chore (maintain)

* [ ] indent depth
* [ ] 함수는 최소 역할만 하게 작성
* [ ] Junit, AssertJ를 이용해 테스트 코드 작성
* [ ] 테스트 케이스 통과