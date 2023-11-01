package racingcar

class InputMachine {

    // 자동차 이름 입력↓
    fun makeCars(): List<String> {

        return readln().split(",")

    }

    fun checkCarNameUnder5(car: String) : Boolean{
        return true
    }
    //

    // 몇 번 이동 입력↓
    fun tryMove() : Int {
        return 0
    }

    fun checkOnlyNatural(move: Int) : Boolean {
        return true
    }

}