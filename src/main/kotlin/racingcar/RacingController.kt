package racingcar

import InputUser

class RacingController {
    val inputUser = InputUser()
    val gamePlaying=Racing()
    val carNames = inputUser.inputCarName()
    var gameInfo = emptyMap<String, Int>()
    fun run(){
        if(inputUser.validName(carNames)){
            val gameCount=inputGameCount()
            gamePlaying.outputStartMent()
           for(round in 1 ..gameCount){
               inputControl()
               gamePlaying.printPerExecutionResult(gameInfo)
           }
            val scoreList = gamePlaying.calculateScore(gameInfo)
            val topScore = gamePlaying.findTopScoreList(scoreList)
            gamePlaying.printlnTopScore(topScore)
        }
    }
    private fun inputControl(){
       if(inputUser.validName(carNames)) {
           gameInfo = gamePlaying.generateNumber(carNames)
       }
   }
    private fun inputGameCount():Int{
        inputUser.printlnGameCountMent()
        return inputUser.tryGameCount()
    }
}