package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RacingGameTest {
    @Test
    fun `자동차 이름 입력 값 체크`(){
        val validator = RacingCarValidator.instance
        //빈 값 테스트
        assertThrows<IllegalArgumentException> {
            validator.validateCarName("")
        }
        //한 개 값 길이 초과
        assertThrows<IllegalArgumentException> {
            validator.validateCarName("onew,jonghyun,key")
        }
        //정상 값
        validator.validateCarName("onew")
    }
    @Test
    fun `이동 횟수 입력 값 체크`(){
        val validator = RacingCarValidator.instance
        //빈 값 테스트
        assertThrows<IllegalArgumentException> {
            validator.validateCarName("")
        }
        //숫자가 아닌 값
        assertThrows<IllegalArgumentException> {
            validator.validateCarName("s")
        }
        //정상 테스트
        validator.checkTrying("6")

    }
}