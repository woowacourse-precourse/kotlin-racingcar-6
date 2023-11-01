package racingcar.model

class GameReferee {

    fun validatePossibleForward(number: Int): Boolean{
        if (number >= MINIMUM_FORWARDABLE_NUMBER){
            return true
        }
            return false
    }

    fun calculateHighestScore(carList: List<Car>): Int {
        var highestScore = 0
        for (car in carList) {
            val carScore = car.getPosition()
            if (carScore > highestScore){
                highestScore = carScore
            }
        }
        return highestScore
    }
    fun determineGameWinner(carList: List<Car>, highestScore: Int): List<Car> {

        val gameWinnerList = mutableListOf<Car>()

        for (car in carList) {
            if (car.getPosition() == highestScore){
                gameWinnerList.add(car)
            }
        }
        return gameWinnerList.toList()
    }

    companion object{
        const val MINIMUM_FORWARDABLE_NUMBER = 4
    }
}