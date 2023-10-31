package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
class CarDemo {
    @Test
    fun `계기판에 자동차의 이동거리가 똑같이 나타나는지 확인`() {
        val car = Car("a")
        val cluster = car.getCluster()
        for (i in 1..4) {
            car.moveForward()
        }
        val distance = car.getDistance()
        val distanceLine = cluster.getDistanceLine()

        assertEquals(distanceLine.length, distance)
    }

}