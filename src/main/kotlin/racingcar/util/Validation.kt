package racingcar.util

object Validation {

    fun validateName(cars : List<String>) {
        cars.forEach{
            if(it.length > 5) throw IllegalArgumentException("[Error] 이름은 5자 이하만 가능")
        }
    }
}