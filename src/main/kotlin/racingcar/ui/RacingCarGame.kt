package racingcar.ui

import camp.nextstep.edu.missionutils.Console
import racingcar.data.RacingCarRepositoryImpl
import racingcar.ui.repository.RacingCarRepository
import racingcar.ui.viewmodel.RacingCarViewModel
import racingcar.util.CommonStrings

class RacingCarGame {

    val repository: RacingCarRepository = RacingCarRepositoryImpl()
    private val viewModel = RacingCarViewModel(repository)
    fun start() {

        while (true) {

            println(CommonStrings.MESSAGE_INPUT_CAR_NAME)
            val inputCars = Console.readLine()
            // 예외처리 추가예정
            println(CommonStrings.MESSAGE_INPUT_NUMBER_OF_ROUNDS)
            val inputRounds = Console.readLine()
            // 예외처리 추가예정
            viewModel.setData(inputCars, inputRounds.toInt())

            while (true){
                if(viewModel.roundCheck()){ // round가 0 이면 게임 종료
                    break
                }
                println(CommonStrings.MESSAGE_EXECUTION_RESULT)

                
            }



        }
    }
}