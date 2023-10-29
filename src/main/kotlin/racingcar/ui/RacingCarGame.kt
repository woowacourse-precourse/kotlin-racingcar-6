package racingcar.ui

import racingcar.data.RacingCarRepositoryImpl
import racingcar.ui.repository.RacingCarRepository
import racingcar.ui.viewmodel.RacingCarViewModel
import racingcar.util.CommonStrings

class RacingCarGame {

    val repository : RacingCarRepository = RacingCarRepositoryImpl()
    private val viewModel = RacingCarViewModel(repository)
    fun start() {
        println(CommonStrings.MESSAGE_INPUT_CAR_NAME)
        viewModel





    }
}