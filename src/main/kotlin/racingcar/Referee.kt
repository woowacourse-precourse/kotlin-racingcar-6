package racingcar

class Referee {

    fun notifyWhoWin(): List<String> {

        return arrayOf<String>().toList()

    }

    fun checkMaxForward(cars: MutableList<Car>): Int {

        var maxForward = 0

        for (car in cars) {
            if(maxForward < car.distance) {
                maxForward = car.distance
            }
        }

        return maxForward

    }

}