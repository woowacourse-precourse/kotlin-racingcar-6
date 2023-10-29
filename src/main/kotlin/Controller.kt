import Validator.startCheck
import camp.nextstep.edu.missionutils.Console
import raceoption.RacingMessage.CAR_INPUT_MESSAGE

object Controller {
    fun inputCarInformation() {
        println(CAR_INPUT_MESSAGE)
        val inputValue = Console.readLine()
    }

}