package racingcar.util

object Validation {

    fun validateName(cars : List<String>) {
        cars.forEach{
            if(it.length > 5) throw IllegalArgumentException("[Error] 이름은 5자 이하만 가능합니다.")
        }
    }

    fun validateNum(num : String){
        if(!num.all { it.isDigit() } || num.toInt() <= 0) {
            throw IllegalArgumentException("[Error] 1이상의 숫자만 입력해주세요.")
        }
    }
}