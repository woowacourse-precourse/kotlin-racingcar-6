package racingcar

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun car_name_checker(): List<String>{
    var car_names = readLine()!!.split(",")
    for (i in car_names){
        if (i.length > 5){
            throw IllegalArgumentException()
        }
    }
    return (car_names)
}

fun race_start(car_name: List<String>): MutableList<String>{
    var try_time = readLine()!!.toIntOrNull()
    if (try_time == null){
        throw IllegalArgumentException()
    }

    var race_result: MutableList<String> = MutableList(car_name.size) {""}

    for (i in 1..try_time){
        race_result = race_report(car_name, race_result)
    }

    var winner_score: Int = 0
    for (i in race_result){
        if (i.length >= winner_score){
            winner_score = i.length
        }
    }

    var winner_list = mutableListOf<String>()
    for (i in 0 until race_result.count()){
        if (race_result[i].length == winner_score){
            winner_list.add(car_name[i])
        }
    }
    return (winner_list)
}

fun race_report(car_name: List<String>, race_result: MutableList<String>): MutableList<String>{
    for (i in 0 until race_result.count()){
        if (Randoms.pickNumberInRange(0, 9) >= 4){
            race_result[i] += "-"
        }
        println(car_name[i] + " : " + race_result[i])
    }
    println("")
    return (race_result)
}

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    var car_names = car_name_checker()
    println("시도할 횟수는 몇 회인가요?")
    var winner = race_start(car_names)
    println("최종 우승자 : " + winner.joinToString(","))
}
