package racingcar

import racingcar.service.RacingService
import racingcar.view.Message

class Controller {
    private val racingService = RacingService()
    private val message = Message()

    fun executeRacing(){
        setGame()
        startGame()
        gameInProgress()
        racingOver()
    }

    private fun setGame(){
        racingService.setRacing()
    }

    private fun startGame(){
        println()
    }

    private fun gameInProgress(){
        message.executionResult()
        val playCount = racingService.playCount
        for(i in 1..playCount){
            racingService.doRacing()
        }
    }

    private fun racingOver(){
        message.winner(racingService.carList)
    }
}