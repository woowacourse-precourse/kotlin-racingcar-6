package racingcar.data

import java.util.concurrent.atomic.AtomicInteger

data class Car(
    val name: String,
) {
    private val id: Int = numForId.getAndIncrement()
    private var _location: Int = 0
    val location: Int
        get() = _location

    fun move() {
        _location++
    }

    override fun toString(): String = "$name : ${"-".repeat(_location)}"

    companion object {
        private var numForId = AtomicInteger(0)
    }
}
