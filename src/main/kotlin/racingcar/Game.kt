package racingcar

import camp.nextstep.edu.missionutils.Console


class Game {
    private var cars: ArrayList<Car>? = null
    init {
        cars = ArrayList()
    }
    fun gameStart() {
        input()
        winner()
    }
    private fun input(){
        val error = Error()
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val carName = Console.readLine()
        val names = carName.split(',')
        error.checkName(names)
        for (name in names) {
            cars?.add(Car(name.trim { it <= ' ' }))
        }

        println("시도할 횟수는 몇 회인가요?")
        val repeat = Console.readLine()
        error.checkNum(repeat)
        processGame(repeat.toInt())
    }

    private fun processGame(repeat: Int) {
        var rep = repeat
        println()
        println("실행 결과")
        while(rep>0){
            for (car in cars!!) {
                car.play()
            }
            println()
            rep--
        }
    }
    private fun winner(){
        val winners: MutableList<String> = ArrayList()
        val maxPosition = findMaxPos()
        for (car in cars!!) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName())
            }
        }
        println("최종 우승자 : " + winners.joinToString(", "))
    }
    private fun findMaxPos(): Int {
        var maxPos: Int = 0
        for (car in cars!!) {
            if (car.getPosition() > maxPos) {
                maxPos = car.getPosition()
            }
        }
        return maxPos
    }

}
