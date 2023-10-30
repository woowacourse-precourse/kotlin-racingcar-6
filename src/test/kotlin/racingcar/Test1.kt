package racingcar

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows

class Test1 {

    @Test
    fun `(,)로 문자열 구분을 하나`() {

    }

    @Test
    fun `5글자가 넘어가면 오류가 발생하나`() {

    }

    @Test
    fun `시도 횟수가 자연수로 입력이 안되면 오류가 발생하나`() {

    }

    @Test
    fun `0~9 무작위 값이 잘나오나`() {

    }

    @Test
    fun `무작위 값이 4 이상일때만 전진하나`() {

    }

    @Test
    fun `우승자가 여러명일때 (,)로 구분돼서 출력되나`() {

    }

    @Test
    fun `자동차 위치 반환`() {
        val CarNames = listOf("car1", "car2")
        val game = RacingCarGame(CarNames)
        val positions = game.run(1)
        assertThat(positions.keys).containsAll(CarNames)
    }

}