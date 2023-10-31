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
    fun `DashBoard 반환값 검사`() {
        assertThat("${dashBoard.printDist()}").isEqualTo("테스트차량 : ----------\n")
    }

    @Test
    fun `DashBoard 자동차 이름 검사`() {
        val result = "테스트차량"
        assertThat(dashBoard.carName()).isEqualTo(result)
    }

    @Test
    fun `DashBoard 주행거리 반환 검사`() {
        val result = BigInteger("10")
        assertThat(dashBoard.nowDist()).isEqualTo(result)
    }
}
