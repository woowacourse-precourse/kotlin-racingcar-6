package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import racingcar.model.CarModel
import racingcar.model.GameModel

class GameTest {
    @Test
    fun `4 이상인 경우 전진`() {
        val car = CarModel("test", 0)
        car.move(4)
        assertTrue(car.position == 1)
    }

    @Test
    fun `우승자 출력`() {
        val cars = listOf(CarModel("test1",1), CarModel("test2",2), CarModel("test3",3))
        val gameModel = GameModel()

        val winners = gameModel.getWinners(cars)
        assertEquals("test3", winners[0].name)
    }

    @Test
    fun `공동 우승자 출력`() {
        val cars = listOf(CarModel("test1",3), CarModel("test2",2), CarModel("test3",3))
        val gameModel = GameModel()

        val winners = gameModel.getWinners(cars)
        assertEquals("test1", winners[0].name)
        assertEquals("test3", winners[1].name)
    }
}