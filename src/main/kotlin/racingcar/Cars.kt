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
        return _list.filter { it.isWinner(maxDistance) }.map { it.name }
    }
}