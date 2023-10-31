package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class ClusterDemo {
    @Test
    fun `이동거리를 그린만큼 그림이 형성되는지 확인`() {
        val cluster = Cluster()
        for (i in 1..5) {
            cluster.drawDistanceLine()
        }
        val input = cluster.getDistanceLine()

        assertEquals("-----",input)
    }
}