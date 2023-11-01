package racingcar.model

import racingcar.MAX_NAME_LENGTH
import racingcar.MIN_NAME_LENGTH
import racingcar.exceptions.BlankNameException
import racingcar.exceptions.UnvalidNameLengthException

class Name(val name: String) {

    fun checkValidateName(): Boolean {
        if (checkValidNameBlank())
            throw BlankNameException()
        if (checkValidNameLength())
            throw UnvalidNameLengthException()
        return true
    }

    private fun checkValidNameBlank(): Boolean {
        val nameLength = name.length

        return nameLength == 0
    }

    private fun checkValidNameLength(): Boolean {
        val nameLength = name.length

        return nameLength !in MIN_NAME_LENGTH..MAX_NAME_LENGTH
    }

    fun getNameString(): String {
        return name
    }
}