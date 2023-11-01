package racingcar

class InputMachine {

    // 자동차 이름 입력↓
    fun makeCars(): List<String> {

        val cars = readln().split(",")


        return cars

    }

    fun checkCarNameUnder5(cars: List<String>){

        for (car in cars) {
            if (car.length > 5) {
                throw IllegalArgumentException("자동차 이름이 5자를 초과합니다.")
            }
        }

    }

    // 몇 번 이동 입력↓
    fun tryMove() : Int {
        return 0
    }

    fun checkOnlyNatural(move: Int) : Boolean {
        return true
    }


}