package racingcar
import camp.nextstep.edu.missionutils.Console
import racingcar.Message.Companion.INPUT_PROMPT_MESSAGE
class CarGameManager {
    fun play(){
        println(INPUT_PROMPT_MESSAGE)

    }
    private fun getInputUser(): String? {
        return Console.readLine()
    }
}