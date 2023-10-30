package racingcar

class Cars {
    private var _list = mutableListOf<Car>()
    val list: List<Car>
        get() = _list

    fun addAllList(list: List<Car>) {
        list.forEach { car ->
            _list.add(car)
        }
    }

    fun getMaxDistance(): Int {
        val distanceList = _list.map { it.moveDistance }
        return distanceList.max()
    }

    fun getWinners(): List<String> {
        val maxDistance = getMaxDistance()
        val winnerList = mutableListOf<String>()
        _list.forEach { car ->
            if (car.moveDistance == maxDistance) {
                winnerList.add(car.name)
            }
        }
        return winnerList
    }
}