# 초간단 자동차 경주 게임
## 기능 목록
- [x] 이름을 붙인 n개의 자동차 생성. - Car#createCar
  - [x] 이름이 5자 이하인지 확인 - Car#validateCarNameLength
  - [x] 이름이 중복되지 않는지 확인 - Car#validateDuplicateName
  - [x] 이름이 공백이 아닌지 확인 - Car#validateBlnakName
- [x] 이동 횟수 입력 - Racing#enterMoveCount
  - [ ] 이동 횟수가 0 이하의 수가 입력되었는지 확인 - Racing#validateIsCountZero
  - [ ] 이동 횟수가 숫자가 맞는지 확인 - Racing#validateIsNumeric
- [ ] 전진 또는 멈춤을 결정 할 랜덤 값 생성 - Racing#CreateRandomNumber 
    - [ ] 전진 조건 만족하는지 확인 - Racing#ValidateMoveCondition
- [ ] 우승자 목록 확인 - Result#checkWinner
- [ ] 우승자 출력 - Result#printWinner
