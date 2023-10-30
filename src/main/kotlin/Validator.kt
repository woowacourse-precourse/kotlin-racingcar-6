import InputValue.CAR_DELIMITER
import InputValue.INPUT_NOT_FIRST_VALUE
import car.CarConfiguration.MAX_NAME_LENGTH
import java.math.BigInteger

object Validator {

    fun nameCheck(input: String) {
        val splitInput = input.split(CAR_DELIMITER)
        splitInput.forEach {
            nameLengthCheck(it)
        }
    }

    fun roundCheck(input: String) {
        if (input.first() == INPUT_NOT_FIRST_VALUE) throw IllegalArgumentException()
        castingCheck(input)
    }

    private fun nameLengthCheck(name: String) {
        if (name.length > MAX_NAME_LENGTH) throw IllegalArgumentException()
    }

    private fun castingCheck(input: String) {
        try {
            BigInteger(input)
        } catch (e: Exception) {
            throw IllegalArgumentException()
        }
    }
}
