package racingcar

import InputUser

class RacingController {
    val inputUser = InputUser()
    val gamePlaying=Racing()
    val carNames = inputUser.inputCarName()
    val gameInfo = gamePlaying.generateNumber(carNames)
    fun inputControl(){
       inputUser.printlnMent()
       if(inputUser.validName(carNames)) {
           gameControl()
       }
   }
    fun gameControl(){
        inputUser.printlnGameCountMent()
        val gameCount = inputUser.tryGameCount()
        gamePlaying.outputStartMent()
        for (round in 1..gameCount) {
            gamePlaying.printPerExecutionResult(gameInfo)
            gamePlaying.calculateScore(gameInfo)
            val scoreList=gamePlaying.calculateScore(gameInfo)
            gamePlaying.findTopScoreList(scoreList)
            val topScore=gamePlaying.findTopScoreList(scoreList)
            gamePlaying.printlnTopScore(topScore)
        }
    }
}