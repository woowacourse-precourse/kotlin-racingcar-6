package racingcar

import camp.nextstep.edu.missionutils.*

data class CarStatus(
    val name: String,
    var count: Int = 0
)

class CarRacingGame {
    init {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    }

    private fun carInit(): MutableList<CarStatus> {

        val input_name = readLine()!!
        val split_name = input_name.split(",")
        val list_car =  mutableListOf<CarStatus>()

        if (nameCheck(split_name)){
            throw IllegalArgumentException("이름의 길이는 5자 이하로만 입력 가능합니다.")
            return list_car
        }

        for (it in split_name) {
            list_car.add(CarStatus(name = it))
        }

        return list_car

    }

    private fun nameCheck(name: List<String>): Boolean {

        for (it in name) {
            when(it.length <= 0 && it.length > 5) {
                true -> continue
                false -> return false
            }
        }

        return true

    }

}