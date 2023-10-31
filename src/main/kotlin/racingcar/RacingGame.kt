package racingcar

import camp.nextstep.edu.missionutils.Randoms
import java.util.LinkedList
import java.util.Stack
import kotlin.math.max

class RacingGame(carList : List<String>) {
    private var gameRound : Int = 0
    private val cars = mutableSetOf<Car>()

    init {
        carList.forEach {
            cars.add(Car(it))
        }
    }

    fun initRound(){
        gameRound++
        cars.forEach { car ->
            if (canCarMove()){
                car.move()
            }
        }
        displayRoundResult()
    }

    fun getCurrentGameRound() = gameRound

    fun getWinnerName() : List<String>{
        val winnerMap = HashMap<String,Int>()
        cars.forEach {
            winnerMap.put(it.getName(),it.getLocation())
        }
        val maxLocation = winnerMap.values.maxOrNull()

        return winnerMap.filterValues { it == maxLocation }.keys.toList()
    }

    private fun canCarMove() : Boolean = Randoms.pickNumberInRange(1, 9) >= 4

    private fun displayRoundResult(){
         cars.forEach{ car ->
             car.displayLocation()
         }
        println()
    }




}