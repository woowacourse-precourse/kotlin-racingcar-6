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

    fun gameStart() {

        val list_car = carInit()

        if (list_car.size == 0) { // 입력된 자동차가 없는 경우 예외처리 후 종료
            throw IllegalArgumentException("입력된 자동차가 없습니다.")
            return
        }

        println("시도할 횟수는 몇 회인가요?")
        val cnt_play = readLine()!!.toInt()
        println(cnt_play)
        println("\n실행 결과")

        for (i in 1 .. cnt_play) {
            gamePlay(list_car)
            lapPrint(list_car)
            println()
        }

    }

    private fun gamePlay(list_car: MutableList<CarStatus>) {
        for (i in list_car) {
            if (movingForward()) i.count++
        }
    }

    private fun carInit(): MutableList<CarStatus> {

        val input_name = readLine()!!

        println(input_name)

        val split_name = input_name.split(",")
        val list_car =  mutableListOf<CarStatus>()

        if (!nameCheck(split_name)){ // 이름 조건 체크 후 부합하지 않은 경우 예외처리 후 빈 리스트 반환
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
            when(it.length <= 0 || it.length > 5) { // 조건에 부합하지 않는 이름이 있으면 false 반환
                true -> return false
                false -> continue
            }
        }

        return true
    }

    private fun movingForward(): Boolean {
        val randomInt = Randoms.pickNumberInRange(0, 9)

        if (randomInt >= 4) return true
        else return false
    }

    private fun lapPrint(list_car: MutableList<CarStatus>) {
        for (i in list_car) {
            print(i.name + " : ")

            for (num in 1..i.count){
                print("-")
            }
            
            println()
        }
    }


}