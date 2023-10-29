import car.CarConfiguration.MAX_NAME_LENGTH

object Validator {
    fun nameLengthCheck(name: String) {
        if (name.length > MAX_NAME_LENGTH) throw IllegalArgumentException()
    }

}