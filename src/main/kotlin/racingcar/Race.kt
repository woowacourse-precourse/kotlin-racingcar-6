package racingcar

class Race(var cars:MutableList<Car>) {

    fun getWinners():MutableList<Car>{
        return cars.filter { it.position == getTopPosition() }.toMutableList()
    }

    fun getTopPosition():Int{
        var topPosition = 0
        for (car in cars) {
            if (car.position >= topPosition) {
                topPosition = car.position
            }
        }
        return topPosition
    }

    fun getOutput() ="최종 우승자 : ${getWinners().joinToString(", ")}"

}