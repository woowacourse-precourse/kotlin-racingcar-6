package racingcar

import camp.nextstep.edu.missionutils.Randoms
import java.lang.IllegalArgumentException

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val cars_list = createCarsList()
    var accumulated_distance = MutableList(cars_list.size) {0}

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

