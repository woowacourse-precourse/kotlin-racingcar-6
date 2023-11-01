package racingcar.domain.car

class Car(val name: String) {
    private var distance = 0

    fun move(num: Int) {
        if (num >= 4) {
            distance++
        }
    }

    fun getDistance(): Int {
        return distance
    }

    fun printResult(): String {
        var result = "$name : "
        for (i in 1..distance)
            result += "-"
        return result
    }
}