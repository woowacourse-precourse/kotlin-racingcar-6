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
        gameRound++
        cars.forEach { index, car ->
            if (canCarMove()){
                car.move()
            }
        }
        displayRoundResult()
    }

    private fun canCarMove() : Boolean = Randoms.pickNumberInRange(1, 9) >= 4

    private fun displayRoundResult(){
         cars.forEach{ index, car ->
             car.displayLocation()
         }
    }




}