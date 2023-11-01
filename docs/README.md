# 초간단 자동차 경주 게임
## 기능 목록
- [x] 이름을 붙인 n개의 자동차 생성. - Car#createCar
  - [x] 이름이 5자 이하인지 확인 - Car#validateCarNameLength
  - [x] 이름이 중복되지 않는지 확인 - Car#validateDuplicateName
  - [x] 이름이 공백이 아닌지 확인 - Car#validateBlnakName
- [x] 자동차들의 전진 현황이 담긴 리스트 생성 - Car#createcarProgressList 
- [x] 정수의 이동 횟수 입력 - Racing#enterMoveCount
  - [ ] 이동 횟수가 0 이하의 수가 입력되었는지 확인 - Racing#validatePositiveInteger
- [ ] 전진 결과 전달 Racing#determineProgress
  - [ ] 전진 또는 멈춤을 결정 할 랜덤 값 생성 - Racing#createRandomNumber 
  - [ ] 전진 조건 만족하는지 확인 - Racing#validateMoveCondition
- [ ] 우승자 목록 확인 - Result#checkWinner
- [ ] 우승자 출력 - Result#printWinner
