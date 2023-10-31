package racingcar.ui

import camp.nextstep.edu.missionutils.Console
import racingcar.data.repository.RacingCarRepositoryImpl
import racingcar.ui.repository.RacingCarRepository
import racingcar.ui.viewmodel.RacingCarViewModel
import racingcar.utils.CommonStrings
import racingcar.utils.Exceptions

class RacingCarGame {

    private val repository: RacingCarRepository = RacingCarRepositoryImpl()
    private val viewModel = RacingCarViewModel(repository)
    fun start() {
        println(CommonStrings.MESSAGE_INPUT_CAR_NAME)
        val inputCars = Console.readLine()
        Exceptions.validateCarNamesInput(inputCars)

        println(CommonStrings.MESSAGE_INPUT_NUMBER_OF_ROUNDS)
        val inputRounds = Console.readLine()
        Exceptions.validateRoundsInput(inputRounds)

        viewModel.setData(inputCars, inputRounds.toInt())

        while (true) {
            // round가 0 이면 게임 종료
            if (viewModel.checkRounds()) break

            println(CommonStrings.MESSAGE_EXECUTION_RESULT)
            viewModel.updateRounds()
            viewModel.getRoundState().forEach { car ->
                println("${car.carName} : ${car.moveState}")
            }
        }

        val winners = viewModel.findFinalWinners()

        if (winners.size == 1) {
            println(CommonStrings.MESSAGE_FINAL_WINNER +" : "+ winners.joinToString())
        } else {
            println(CommonStrings.MESSAGE_FINAL_WINNER +" : "+ winners.joinToString(","))
        }
    }
}