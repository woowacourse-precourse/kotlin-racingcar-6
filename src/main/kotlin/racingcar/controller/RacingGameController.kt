package racingcar.controller

import racingcar.model.RacingCarModel
import racingcar.view.GuideView
import racingcar.view.RaceResultView
import racingcar.view.UserInputView

class RacingGameController {
    private val guideView = GuideView
    private val raceResultView = RaceResultView
    private val userInputView = UserInputView
    private lateinit var racingCars:MutableList<RacingCarModel>
    private val racingCarsManagement = racingCars
    private var roundCnt:Int = 0


    fun start(){
        guideView.printInputCarsName()
        userInputView.getCarsName()
        guideView.printInputRoundCnt()
    }


}