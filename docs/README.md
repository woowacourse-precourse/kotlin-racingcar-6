# 미션 - 자동차 경주

### class RacingGameView

입력과 출력을 담당한다.  
View는 입력을 받아 ViewModel에게 일을 시키고, 결과를 받아 출력한다.

### class RacingGameViewModel

비즈니스 로직을 담당한다.  
ViewModel은 View의 입력을 받아 검증∙작업을 진행한다.

### class Player

인메모리 데이터베이스 역할을 해줄 객체  
Repository 객체 대신 List로 간소화한다.

### interface NumberGenerator

랜덤 값을 생성하기 위한 인터페이스

#### class RandomNumberGenerator: NumberGenerator

0 ~ 9 랜덤한 수를 생성하기위한 클래스

#### class MoveNumberGenerator: NumberGenerator

무조건 전진(5) 수를 생성하기 위한 클래스

#### class StopNumberGenerator: NumberGenerator

무조건 멈춤(0) 수를 생성하기 위한 클래스

### Todo

#### NumberGenerator

- [x] NumberGenerator 인터페이스 구현
- [x] 0 ~ 9 랜덤값 생성 클래스 구현
- [x] 직진값(5) 생성 클래스 구현
- [x] 멈춤값(0) 생성 클래스 구현

#### Player

- [x] Player 클래스 기본 구성
- [x] 출력을 위한 toString 오버라이딩

#### Constants

- [x] 사용할 텍스트들을 상수로 정의

#### RacingGameViewModel

- [x] savePlayer(): 사용자 입력 받아서 플레이어 저장
- [ ] saveRound(): 사용자 입력 받아서 라운드 저장
- [ ] playRound(): 각 라운드 플레이해줄 함수
- [ ] getRoundResult(): 현재 라운드 결과 리턴
- [ ] getWinners(): 우승자 담아서 리턴
- [ ] canMoveForward(): 이동할 수 있는지 여부

#### RacingGameView

- [ ] startGame(): 사용자의 입력을 받아서 viewModel에게 일 시키고, 결과들을 받아서 출력

#### RacingGameViewModelTest

비즈니스 로직을 처리하는 ViewModel 클래스에 대한 테스트만 진행하면 된다.

- [ ] savePlayer() 테스트
- [ ] saveRound() 테스트
- [ ] playRound() 테스트
- [ ] getWinners() 테스트