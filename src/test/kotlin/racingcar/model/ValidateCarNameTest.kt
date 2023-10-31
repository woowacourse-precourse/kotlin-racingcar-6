package racingcar.model

import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.main

class ValidateCarNameTest : NsTest() {

    private val validateCarName = ValidateCarName()

    @Test
    fun `자동차 이름은 5자 초과 시 예외처리(단독출전)`() {
        val carName = "123456"
        assertThrows<IllegalArgumentException> { validateCarName.validateInputSingleCarName(carName) }
    }

    @Test
    fun `자동차 이름이 비어있을 경우 예외처리(단독출전)`() {
        val carName = ""
        assertThrows<IllegalArgumentException> { validateCarName.validateInputSingleCarName(carName) }
    }

    override fun runMain() {
        main()
    }
}
