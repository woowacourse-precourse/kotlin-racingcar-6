package racingcar

class Referee {

    fun notifyWhoWin(cars: MutableList<Car>): List<String> {

        val maxForward = checkMaxForward(cars)
        val winCarsList = mutableListOf<String>()

        for (car in cars) {
            if (maxForward == car.distance) {
                winCarsList.add(car.name)
            }
        }

        return winCarsList

    }

    private fun checkMaxForward(cars: MutableList<Car>): Int {
        var maxForward = 0

        for (car in cars) {
            if (maxForward < car.distance) {
                maxForward = car.distance
            }
        }

        return maxForward
    }


}