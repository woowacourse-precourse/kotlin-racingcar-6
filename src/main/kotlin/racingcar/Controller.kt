package racingcar

import racingcar.service.RacingService
import racingcar.view.Message

class Controller {
    private val racingService = RacingService()
    private val message = Message()

    //자동차 경주
    fun executeRacing(){
        setGame()
        startGame()
        gameInProgress()
        racingOver()
    }

    //경주 시작전 세팅
    private fun setGame(){
        racingService.setRacing()
    }

    //경주 시작
    private fun startGame(){
        println()
    }

    //경주가 진행중
    private fun gameInProgress(){
        message.executionResult()
        val playCount = racingService.playCount
        for(i in 1..playCount){
            racingService.doRacing()
        }
    }

    //경주가 끝남
    private fun racingOver(){
        message.winner(racingService.carList)
    }
}