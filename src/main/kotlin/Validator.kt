import InputValue.CAR_DELIMITER
import car.Car
import car.CarConfiguration.MAX_NAME_LENGTH

object Validator {

    fun startCheck(input: String) {
        val splitInput = input.split(CAR_DELIMITER)
        splitInput.forEach {
            nameLengthCheck(it)
        }
    }
    private fun nameLengthCheck(name: String){
        if (name.length > MAX_NAME_LENGTH) throw IllegalArgumentException()
    }

}