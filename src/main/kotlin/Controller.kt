import InputValue.CAR_DELIMITER
import Validator.nameCheck
import Validator.roundCheck
import camp.nextstep.edu.missionutils.Console
import race.RacingMessage.CAR_INPUT_MESSAGE
import race.RacingMessage.TRIES_REQUEST_MESSAGE

object Controller {
    fun inputCarInformation(): List<String> {
        println(CAR_INPUT_MESSAGE)
        val input = Console.readLine()
        nameCheck(input)
        return input.split(CAR_DELIMITER)
    }

    fun inputRacingRoundInformation(): Int {
        println(TRIES_REQUEST_MESSAGE)
        val input = Console.readLine()
        roundCheck(input)
        return input.toInt()
    }

}