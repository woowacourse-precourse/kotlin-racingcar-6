## 📝 기능 목록
### Application
- [x] 게임 로직 시작

### InputView
- [x] `Console.ReadLine()`을 이용해 값을 입력 받는 함수 구현
- [x] 입력받은 값에 따라 유효한 값인지 확인

### OutputView
- [x] 게임을 진행하면서 출력과 관련된 함수를 모아놓은 클래스

### GameController
- [x] 생성자 : inputView와 outputView를 받아 클래스의 속성으로 저장하고 nameList, car, count를 초기화한다.
- [x] runGame : 게임을 설정하고 진행하는 메서드로, setGame, Racing, gameResult 메서드를 호출한다.
- [x] setCount : 사용자에게 라운드 수를 입력받아 반환하는 메서드로, inputView.inputCount를 호출한다.
- [x] setCar : nameList의 이름을 사용해 Car 객체를 생성하고 car 리스트에 추가하는 메서드다.
- [x] setGame : 게임을 설정하는 메서드로, 사용자에게 이름과 라운드 수를 입력받고 car 리스트를 초기화한다.
- [x] setWinner : 승자를 결정하는 메서드로, car 리스트에서 가장 높은 점수를 가진 차량의 이름을 반환한다.
- [x] gameResult : 게임의 결과를 출력하는 메서드로, setWinner 메서드를 호출해 승자를 결정하고 outputView.winnerOutput를 호출해 결과를 출력한다.

### Car
- [x] 생성자 : 매개변수로 받은 name을 클래스의 속성으로 저장하고 score를 0으로 초기화한다.
- [x] move : score를 1 증가시킨다.

### Racing
- [x] 생성자 : 매개변수로 받은 count만큼 startRacing 메서드를 반복 호출한다.
- [x] generateRandomNumber : 0에서 9까지의 랜덤한 숫자를 생성하여 반환한다.
- [x] resultOutput : 매개변수로 받은 자동차의 이름과 점수를 OutputView의 resultOutput 메서드에 전달하여 출력한다.
- [x] isMove : 랜덤으로 생성된 숫자가 4 이상이면 true를 반환하고, 그렇지 않으면 false를 반환한다.
- [x] startRacing : cars 리스트의 모든 자동차에 대해 isMove 메서드의 결과가 true일 경우 해당 자동차의 move 메서드를 호출하고, resultOutput 메서드를 호출하여 자동차의 이름과 점수를 출력한다.