package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class GameLogicTest {

    @Test
    fun `입력에서 자동차를 정확히 만드는지 테스트`() {
        val input = "abc,def,ghi,jkl"

        val expected = listOf(Car("abc"), Car("def"), Car("ghi"), Car("jkl"))
        val actual = generateCarsFromInput(input)
        assertThat(actual).containsExactlyElementsOf(expected)
    }

    @Test
    fun `길이가 5 이상인 이름이 주어졌을 때 예외 발생`() {
        val token = "abcdefg"
        assertThrows<IllegalArgumentException>("잘못된 입력입니다") {
            generateCarFromToken(token)
        }
    }

    @Test
    fun `우승자가 한 명일때 우승자를 제대로 계산하는지 테스트`() {
        val cars = listOf(Car("abc"), Car("def"), Car("ghi"), Car("jkl"))
        repeat(3) {
            cars[1].moveForward()
        }

        assertThat(findWinners(cars)).containsExactly(cars[1])
    }

    @Test
    fun `우승자가 여러 명일 때 우승자를 제대로 계산하는지 테스트`() {
        val cars = listOf(Car("abc"), Car("def"), Car("ghi"), Car("jkl"))
        repeat(3) {
            cars[1].moveForward()
            cars[2].moveForward()
        }

        assertThat(findWinners(cars)).containsExactlyInAnyOrder(cars[1], cars[2])
    }

    @Test
    fun `여러 명의 우승자의 이름을 제대로 이어붙이는지 테스트`() {
        val cars = listOf(Car("abc"), Car("def"), Car("ghi"), Car("jkl"))
        repeat(3) {
            cars[1].moveForward()
            cars[2].moveForward()
        }

        val winners = findWinners(cars)
        assertThat(createWinnersName(winners)).isEqualTo("def, ghi")
    }
}