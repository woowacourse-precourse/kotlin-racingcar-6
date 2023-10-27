import CarFactory.makeCar
import MessageManager.INPUT_CAR_NAME_MESSAGE
import MessageManager.INPUT_RACING_ROUND_MESSAGE
import Racing.racingSetting
import camp.nextstep.edu.missionutils.Console
import util.Validator.inputRacingRoundContentCheck

class RacingManger {
    fun racingInfoInput() {
        println(INPUT_CAR_NAME_MESSAGE)
        val racingCarList = makeCar(Console.readLine())
        println(INPUT_RACING_ROUND_MESSAGE)
        val raceRound = inputRacingRoundContentCheck(Console.readLine())
        racingSetting(racingCarList, raceRound)
    }
}
