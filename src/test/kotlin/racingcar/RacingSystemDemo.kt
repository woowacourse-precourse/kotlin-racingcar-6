package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RacingSystemDemo {
    @Test
    fun `콤마를 기준으로_CarName이 나뉘었는지 테스트`() {
        val input = "a,b,c"
        RacingSystem.setCarNames(input)
        val result = RacingSystem.getCarNames()

        assertEquals(listOf("a","b","c"),result)
    }
    @Test
    fun `공백이 있을 경우_CarName에 포함되는지 테스트`() {
        val input = "팀 노홍철, 팀  버튼, 팀   쿡"
        RacingSystem.setCarNames(input)
        val result = RacingSystem.getCarNames()

        assertEquals(listOf("팀 노홍철","팀  버튼","팀   쿡"),result)
    }

    @Test
    fun `CarName에 5글자 초과인 이름이 포함될 경우_IlleGalArgumentException발생 테스트`() {
        val input = "스쿠테리아 람보르기니, 레드불 레이싱"

        assertThrows<IllegalArgumentException>{
            RacingSystem.setCarNames(input)
        }
    }

    @Test
    fun `문자열 타입의 숫자를 입력한 경우_정수 타입의 시도횟수로 변환되는지 테스트`() {
        val input = "4"
        RacingSystem.setAttemptNumber(input)
        val result = RacingSystem.getAttemptNumber()

        assertEquals(4,result)
    }
    @Test
    fun `문자열 타입의 문자열을 입력한 경우_IlleGalArgumentException발생 테스트`() {
        val input = "세번"

        assertThrows<IllegalArgumentException>{
            RacingSystem.setAttemptNumber(input)
        }
    }
}