package racingcar.model

class GameModel {
    fun race(carList: List<CarModel>) {
        carList.forEach {
            it.move(it.numberGenerator())
        }
    }

    fun getWinners(carList: List<CarModel>): List<CarModel> {
        val maxPosition = carList.maxOf { it.position }
        return carList.filter { it.position == maxPosition }
    }
}