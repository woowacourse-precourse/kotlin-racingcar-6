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

    @Test
    fun `자동차 이름이 중복될 경우 예외처리`() {
        val carName = listOf("son", "son", "mm")
        assertThrows<IllegalArgumentException> { validateCarName.validateInputMultiCarName(carName) }
    }

    @Test
    fun `자동차 이름이 한 자동차라도 비어있을 경우 예외처리`() {
        val carName = listOf("", "son", "MM")
        assertThrows<IllegalArgumentException> { validateCarName.validateInputMultiCarName(carName) }
    }

    @Test
    fun `출전 자동차 수가 7대 초과될 경우 예외처리`() {
        val carName = listOf("1", "2", "3", "4", "5", "6", "7", "8")
        assertThrows<IllegalArgumentException> { validateCarName.validateInputMultiCarName(carName) }
    }

    override fun runMain() {
        main()
    }
}
