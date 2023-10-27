package util

import util.CarValue.CAR_NAME_MAX_LENGTH
import util.CarValue.CAR_NAME_MIN_LENGTH
import java.math.BigInteger

object Validator {

    fun inputRacingRoundContentCheck(input: String): BigInteger {
        if (input.length > 1 && input.first() == '0') throw IllegalArgumentException()
        input.forEach {
            if (it !in '0'..'9') throw IllegalArgumentException()
        }
        return input.toBigInteger()
    }

    fun inputCarNameCheck(input: String): List<String> {
        val carList = input.split(",")
        carNameLengthCheck(carList)
        return carList
    }

    private fun carNameLengthCheck(carList: List<String>) {
        carList.forEach {
            if (it.length !in CAR_NAME_MIN_LENGTH..CAR_NAME_MAX_LENGTH) {
                throw IllegalArgumentException()
            }
        }
    }
}
