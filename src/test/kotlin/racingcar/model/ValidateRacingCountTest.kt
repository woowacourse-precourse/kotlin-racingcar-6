package racingcar.model

import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.main

class ValidateRacingCountTest : NsTest() {

    private val validateRacingCount = ValidateRacingCount()

    @Test
    fun `자동차 경주 횟수가 비어있을 경우 예외처리`() {
        val racingCount = ""
        assertThrows<IllegalArgumentException> { validateRacingCount.validateTryCount(racingCount) }
    }

    @Test
    fun `자동차 경주 횟수가 숫자가 아닐 경우 예외처리`() {
        val racingCount = "ss"
        assertThrows<IllegalArgumentException> { validateRacingCount.validateTryCount(racingCount) }
    }

    @Test
    fun `자동차 경주 횟수가 범위 밖일 경우 예외처리`() {
        val racingCount = "100"
        assertThrows<IllegalArgumentException> { validateRacingCount.validateTryCount(racingCount) }
    }

    override fun runMain() {
        main()
    }
}
