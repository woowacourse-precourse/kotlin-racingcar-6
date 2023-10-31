package racingcar.model

class Winners(var winnerList: MutableList<RacingCar>) {
    fun getWinners(): String {
        return winnerList.joinToString(", ") { it.name }
    }
}
