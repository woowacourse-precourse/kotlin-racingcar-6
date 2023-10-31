package lst1995kotlintest

import car.CarConfiguration.START_FLAG
import caroption.DashBoard
import caroption.Engine
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.math.BigInteger

class CarTest {

    private val dashBoard = DashBoard("테스트차량")
    private val engine = Engine()

    @BeforeEach
    fun setUp() {
        repeat(10) {
            dashBoard.distPlus()
        }
    }

    @ParameterizedTest
    @CsvSource("$START_FLAG,true", "${START_FLAG + 1},true", "${START_FLAG - 1},false")
    fun `Engine 입력값에 따른 반환값 검사`(input: Int, result: Boolean) {
        assertThat(result).isEqualTo(engine.start(input))
    }

    @Test
    fun `Engine START_FLAG 보다 큰 경계값 검사`() {
        val input = START_FLAG + 1
        val result = true
        assertThat(result).isEqualTo(Engine().start(input))
    }

    @Test
    fun `DashBoard 반환값 검사`() {
        val testDashBoard = DashBoard("테스트차량")
        val result = "테스트차량 : ----------\n"
        repeat(10) {
            testDashBoard.distPlus()
        }
        assertThat("${testDashBoard.printDist()}").isEqualTo(result)
    }
}
