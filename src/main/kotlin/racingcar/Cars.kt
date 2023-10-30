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
}