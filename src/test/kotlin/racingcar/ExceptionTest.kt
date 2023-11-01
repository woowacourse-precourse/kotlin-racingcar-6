package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.io.checker.CarNameExceptionChecker
import racingcar.io.checker.LoopCountExceptionChecker
import racingcar.util.Const

class ExceptionTest {
    @Test
    fun `이름 숫자, 알파벳 제외한 문자`() {
        val checker = CarNameExceptionChecker()

        assertThrows<IllegalArgumentException>(Const.CAR_NAME_ERR_TYPE) {
            checker.check("base,100,2?0")
        }
    }

    @Test
    fun `이름 길이 5 초과`() {
        val checker = CarNameExceptionChecker()

        assertThrows<IllegalArgumentException>(Const.CAR_NAME_ERR_LEN) {
            checker.check("base,100abc,210")
        }
    }

    @Test
    fun `이름 길이 0 `(){
        val checker = CarNameExceptionChecker()

        assertThrows<IllegalArgumentException>(Const.CAR_NAME_ERR_LEN) {
            checker.check(",100,210")
        }
    }

    @Test
    fun `중복된 이름`() {
        val checker = CarNameExceptionChecker()

        assertThrows<IllegalArgumentException>(Const.CAR_NAME_ERR_DUP) {
            checker.check("base,base,210")
        }
    }

    @Test
    fun `반복 횟수 숫자 아닌 문자`() {

        val checker = LoopCountExceptionChecker()
        assertThrows<IllegalArgumentException>(Const.LOOP_COUNT_ERR_TYPE) {
            checker.check("24!")
        }
    }

    @Test
    fun `반복 횟수 0`() {

        val checker = LoopCountExceptionChecker()
        assertThrows<IllegalArgumentException>(Const.LOOP_COUNT_ERR_ZERO) {
            checker.check("0")
        }
    }
}