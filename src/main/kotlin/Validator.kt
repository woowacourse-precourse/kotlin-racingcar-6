import InputValue.INPUT_NOT_FIRST_VALUE
import car.Car
import car.CarConfiguration.MAX_NAME_LENGTH
import car.CarConfiguration.MIN_NAME_LENGTH
import car.CarFactory.makeCar
import java.math.BigInteger

object Validator {

    fun nameCheck(input: List<String>): List<Car> {
        val carList = mutableListOf<Car>()
        input.forEach {
            nameLengthCheck(it)
            carList.add(makeCar(it))
        }
        return carList
    }

    fun roundCheck(input: String) {
        try {
            if (input.first() == INPUT_NOT_FIRST_VALUE) throw Exception()
        } catch (e: Exception) {
            throw IllegalArgumentException()
        }
        castingCheck(input)
    }

    private fun nameLengthCheck(name: String) {
        try {
            if (name.length !in MIN_NAME_LENGTH..MAX_NAME_LENGTH) throw Exception()
        } catch (e: Exception) {
            throw IllegalArgumentException()
        }
    }

    private fun castingCheck(input: String) {
        try {
            BigInteger(input)
        } catch (e: Exception) {
            throw IllegalArgumentException()
        }
    }
}
