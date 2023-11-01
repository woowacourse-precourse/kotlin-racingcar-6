#### 기능 구현

- [x] playGame() : 게임을 시작하는 부분
- 입력 값을 받는다
- 입력 받은 값이 조건을 충족하는지 점검한다 => makeCarList(), validateCarNameLength(), validateNumberTrial()
- [x] makeCarMap(String):MutableList<String,Int> : 조건을 모두 충족한 차 이름을 key, value 의 값으로 저장해주고 각 key 값을 value 0 으로 초기화 해준다.
- [x] doSaveCarMove(List<String>,MutableMap<String,Int>): 차 마다 saveCarMove(String) 을 실행시킨다.
- [x] saveCarMove(String) : 4이상의 수가 나올 때만 map 의 value 값을 하나씩 증가시킨다.
- [x] showResult(List<String>,MutableList<String,Int>), printCarMove(String,MutableList<String,Int>): "-" 를 출력한다.
- [x] showWinner(MutableMap<String,Int>): 최종 우승자를 출력해준다