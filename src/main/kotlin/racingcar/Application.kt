package racingcar

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun f_input_car_name() :List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분")
    var input_car_name = Console.readLine()
    var car_name_list = input_car_name.split(",")
    for(i in 0..car_name_list.size - 1) {
        if(car_name_list[i].length >= 6) throw IllegalArgumentException()
    }
    return car_name_list
}

fun f_try_number() : Int {
    println("시도할 횟수는 몇 회인가요?")
    try {
        var try_number = Console.readLine().toInt()
        return try_number
    }catch (e : IllegalArgumentException) {
        return throw e
    }
}

fun racing_garme(car_name_list : List<String>, try_number : Int) {
    println("실행 결과")
    var forward_list : ArrayList<Int> = arrayListOf<Int>()
    for(i in 0..car_name_list.size - 1) {
        forward_list.add(0)
    }
    for (k in 0 .. try_number) {
        for (i in 0..car_name_list.size - 1) {
            var random_number = Randoms.pickNumberInRange(0, 9)
            if(random_number >= 4 ) forward_list[i]++
            print(car_name_list[i] + " : ")
            for(j in 0 .. forward_list[i] - 1) {
                print("-")
            }
            println()
        }
        println()
    }
    var max_forward = 0
    for(i in 0 .. car_name_list.size - 1) {
        if(max_forward < forward_list[i]) {
            max_forward = forward_list[i]
        }
    }
    var winner : ArrayList<String> = ArrayList<String>()
    for (i in 0 .. car_name_list.size - 1) {
        if(max_forward == forward_list[i]) {
            winner.add(car_name_list[i])
        }
    }
    print("최종 우승자 : ")
    print(winner.joinToString(", "))
}

fun main() {
    // TODO: 프로그램 구현
    var car_name_list = f_input_car_name()

    var try_number = f_try_number()

    racing_garme(car_name_list, try_number)
}