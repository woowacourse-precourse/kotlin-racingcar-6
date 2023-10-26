package util

import util.CarValue.CAR_NAME_MAX_LENGTH
import java.math.BigInteger

object Validator {

    fun inputRacingRoundContentCheck(input: String): BigInteger {
        input.forEach {
            if (it !in '0'..'9') throw IllegalArgumentException()
        }
        return input.toBigInteger()
    }

    fun inputCarContentCheck(input: String): List<String> {
        val carList = input.split(",")
        carNameLengthCheck(carList)
        return carList
    }

    private fun carNameLengthCheck(carList: List<String>) {
        carList.forEach {
            if (it.length > CAR_NAME_MAX_LENGTH) {
                throw IllegalArgumentException()
            }
        }
    }
}
