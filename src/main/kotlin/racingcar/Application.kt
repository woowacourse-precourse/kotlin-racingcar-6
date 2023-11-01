package racingcar

import camp.nextstep.edu.missionutils.Randoms
import java.lang.IllegalArgumentException

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val cars_list = createCarsList()
    var accumulated_distance = MutableList(cars_list.size) {0}

    println("시도할 횟수는 몇 회인가요?")
    var try_number = readLine()!!.toInt()
    println()

    println("실행 결과")
    while(try_number > 0){
        printDashes(cars_list, accumulated_distance)
        try_number--
    }

    printWinner(cars_list, accumulated_distance)
}



fun createCarsList() : List<String>{
    val cars_name_input = readLine()
    val cars_list = cars_name_input!!.split(",")

    for(car_name in cars_list){
        if(car_name.length > 5){
            throw IllegalArgumentException("잘못된 입력입니다. 게임종료")
        }
    }

    return cars_list
}

fun printDashes(cars_list: List<String>, accumulated_distance: MutableList<Int>){
    for(i: Int in 0..(cars_list.size-1)){
        var random_number = Randoms.pickNumberInRange(0, 9)
        if(random_number >= 4){
            accumulated_distance[i]++
        }
        val dashes = "-".repeat(accumulated_distance[i])
        println(cars_list[i] + " : " + dashes)
    }
    println()
}

fun printWinner(cars_list: List<String>, accumulated_distance: MutableList<Int>){
    var max_distance = accumulated_distance.max()
    var winner_count = 0

    print("최종 우승자 : ")
    for(i: Int in 0..(cars_list.size-1)){
        if(winner_count >= 1 && accumulated_distance[i] == max_distance){
            print(", ")
        }

        if(accumulated_distance[i] == max_distance){
            print(cars_list[i])
            winner_count++
        }
    }
}



