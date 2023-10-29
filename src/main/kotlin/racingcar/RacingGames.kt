package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingGames {
    //움직이는지 체크
    fun racing(): Boolean {
        val num = Randoms.pickNumberInRange(0, 9)
        if(num>= 4){
            return true
        }
        else{
            return false
        }

    }
    //차 움직임 체크
    fun checkCars(cars:List<String>): MutableList<String> {
        val check = MutableList(cars.size) {""}

        for(i in 0 until cars.size){
            val move = racing()
            if(move) check[i] += "-"
        }

        return check
    }
    fun moveCars(race:MutableList<String>,updates:List<String>): MutableList<String> {

        for(i in 0 until race.size){
            race[i] = race[i] + updates[i]
        }


        return race
    }
    //횟수 체크
    fun checkTime(racingCars: List<String>, times: Int){
        var race = MutableList(racingCars.size) { "" }
        for(i in 0 until times){
            val updates = checkCars(racingCars)
            race = moveCars(race, updates)
            println(race)
        }

    }
}