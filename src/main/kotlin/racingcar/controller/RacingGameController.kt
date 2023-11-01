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
    private var roundCnt:Int = 0


    fun start(){
        guideView.printInputCarsName()
        racingCarsManagement = RacingCarsManagement(RacingCarsDTO(userInputView.getCarsName()).convertRacingCars())
        guideView.printInputRoundCnt()
        roundCnt = RoundDTO(userInputView.getRoundCount()).convertRoundCount()
    }





}