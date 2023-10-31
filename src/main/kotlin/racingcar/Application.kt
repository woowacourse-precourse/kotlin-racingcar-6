package racingcar

import InputUser

fun main() {
   val inputUser = InputUser()
   val gamePlaying = Racing()
   val carNames = inputUser.inputCarName()
   var gameInfo = emptyMap<String, Int>()

   if (inputUser.validName(carNames)) {
      val gameCount = inputUser.tryGameCount()
      gamePlaying.outputStartMent()
      if(!inputUser.validName(carNames)){
         throw IllegalArgumentException("5글자를 초과하는 이름은 입력불가합니다.")
      }
      for (round in 1..gameCount) {
         if (inputUser.validName(carNames)) {
            gameInfo = gamePlaying.generateNumber(carNames)
            gamePlaying.printPerExecutionResult(gameInfo)
         }
      }

      val scoreList = gamePlaying.calculateScore(gameInfo)
      val topScore = gamePlaying.findTopScoreList(scoreList)
      gamePlaying.printlnTopScore(topScore)
   }}
