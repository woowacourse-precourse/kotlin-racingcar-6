import InputValue.CAR_DELIMITER
import Validator.nameCheck
import camp.nextstep.edu.missionutils.Console
import raceoption.RacingMessage.CAR_INPUT_MESSAGE

object Controller {
    fun inputCarInformation(): List<String> {
        println(CAR_INPUT_MESSAGE)
        val inputValue = Console.readLine()
        nameCheck(inputValue)
        return inputValue.split(CAR_DELIMITER)
    }

}