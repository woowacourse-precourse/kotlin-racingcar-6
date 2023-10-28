package racingcar.view

import racingcar.util.GameMessage
import java.lang.IllegalArgumentException

object InputValidator {

    private val inputNameRegex = Regex("^[a-z0-9A-Z]{1,5}${'$'}")

    fun validateName(name : String){
        if(!inputNameRegex.matches(name)){
            throw IllegalArgumentException(GameMessage.GAME_INPUT_NAME_ERROR_MESSAGE)
        }
    }

}