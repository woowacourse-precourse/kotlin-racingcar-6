package racingcar

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

fun f_input_car_name() :List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분")
    var input_car_name = Console.readLine()
    var car_name_list = input_car_name.split(",")
    for(i in 0..car_name_list.size - 1) {
        if(car_name_list[i].length > 6) throw IllegalArgumentException()
    }
    return car_name_list
}

fun main() {
    // TODO: 프로그램 구현
    var car_name_list = f_input_car_name()
}
