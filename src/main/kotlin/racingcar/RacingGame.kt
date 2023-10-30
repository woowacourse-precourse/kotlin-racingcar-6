package racingcar

class RacingGame(carList : List<String>, amount : Int) {
    private var gameRound : Int = amount
    private val cars = HashMap<Int, Car>(carList.size)

    init {
        for ((index, carName) in carList.withIndex()){
            cars[index] = Car(carName)
        }
    }

}