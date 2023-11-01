package racingcar.controller

import racingcar.model.RacingCarModel
import racingcar.view.GuideView
import racingcar.view.RaceResultView
import racingcar.view.UserInputView

class RacingGameController {
    private val guideView = GuideView
    private val raceResultView = RaceResultView
    private val userInputView = UserInputView
    private lateinit var racingCarsManagement: RacingCarsManagement
    private lateinit var roundManagement: RoundManagement

    fun play(){
        start()
        progress()
        end()
    }


    private fun start(){
        guideView.printInputCarsName()
        racingCarsManagement = RacingCarsManagement(RacingCarsDTO(userInputView.getCarsName()).convertRacingCars())
        guideView.printInputRoundCnt()
        roundManagement = RoundManagement(RoundDTO(userInputView.getRoundCount()).convertRoundCount(),racingCarsManagement)
    }

    private fun progress(){
        guideView.printExecutionResult()
        repeat (roundManagement.count){
            roundManagement.playRound()
            raceResultView.printRoundResult(roundManagement.getRacingResult())
        }
    }

    private fun end(){
        raceResultView.printWinners(racingCarsManagement.getWinners())
    }





}