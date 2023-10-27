package racingcar

class RacingGame {
    private val userInput = UserInput()
    private lateinit var carList :List<Car>
    fun gameStart(){
        carList = userInput.inputCarNames()
        val countMove = userInput.inputCountMove()
    }
}