package racingcar

class UserInput {
    private val restPointRegex = Regex("[^,]+")
    val underFiveCharRegex = Regex("^.{1,5}\$")
    fun inputCarNames(): List<Car> {
        val input = readln().trim()
        checkRestPoint(input)

    }



    fun checkRestPoint(input: String){
        if(!restPointRegex.matches(input)){
            throw IllegalArgumentException("잘못된 입력")
        }
    }



}