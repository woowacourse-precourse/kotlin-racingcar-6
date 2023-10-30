package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingGame(carList : List<String>, amount : Int) {
    private var gameRound : Int = amount
    private val cars = HashMap<Int, Car>(carList.size)

    init {
        for ((index, carName) in carList.withIndex()){
            cars[index] = Car(carName)
        }
    }

    fun initRound(){
        cars.forEach { index, car ->
            if (canCarMove()){
                car.move()
            }
        }
    }

    fun canCarMove() : Boolean = Randoms.pickNumberInRange(1, 9) >= 4




}