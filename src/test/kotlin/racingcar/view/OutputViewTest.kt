package racingcar.view

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.model.Cars

class OutputViewTest {
    private lateinit var outputView: OutputView

    @BeforeEach
    fun setUp() {
        outputView = OutputView()
    }

    @Test
    fun `showTryResult 메서드 출력 확인용 테스트`() {
        val cars = Cars(
            listOf(
                Car("pobi", 1),
                Car("woni", 2),
                Car("jun", 3),
            )
        )
        outputView.showTryResult(cars)
    }
}