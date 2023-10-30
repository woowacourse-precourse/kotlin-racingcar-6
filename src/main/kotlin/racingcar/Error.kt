package racingcar

class Error {
    fun checkNum(repeat: String) {
        when(repeat.toIntOrNull()){
            null -> throw IllegalArgumentException("숫자가 아니거나 null값입니다.")
            else -> true
        }
    }
    fun checkName(cars: List<String>) {
        for(i in cars.indices){
            checkError(cars[i])
        }
    }
    fun checkError(input: String) {
        if(input.length>5 || input.length<0){
            throw IllegalArgumentException("이름이 5자가 넘어가거나 값이 없습니다.")
        }
        if(input.contains(" ")){
            throw IllegalArgumentException(",뒤에 공백이 있습니다.")
        }
    }
}