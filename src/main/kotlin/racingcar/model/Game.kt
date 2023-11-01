package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class Game(private val user: List<String>, private val tryNumber: Int) {
    private val scoreMap = mutableMapOf<String, Int>()
    init {
        for(car in user){
            scoreMap[car] = 0
        }
    }

    fun getScoreMap(): MutableMap<String,Int> = scoreMap

    fun tryEachUser(){
        for(car in user){
            if(moveEachCar()) scoreMap[car] = scoreMap[car]!!+1
        }
    }

    fun getWinner(): List<String>{
        val winnerList = mutableListOf<String>()
        for(cars in user){
            if(scoreMap[cars] == scoreMap.maxBy { it.value }.value) winnerList.add(cars)
        }
        return winnerList
    }

    private fun moveEachCar():Boolean{
        return Randoms.pickNumberInRange(0, 9)>=4
    }
}