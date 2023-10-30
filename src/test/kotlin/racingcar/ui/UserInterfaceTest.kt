package racingcar.ui

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.ui.UserInput.createNameList

class UserInterfaceTest {
    val input = "  choi  , gerrard  ,  mint  "
    val names = listOf("choi", "gerrard", "mint")
    val inputNames = input.createNameList()
    @Test
    fun `입력을 쉼표로 구분하고, 앞 뒤 공백을 제거하여 리스트를 생성한다`() {
        assertEquals(names, inputNames)
    }

    @Test
    fun `자동차 이름이 5자 이하인지 검사`() {
        assertThrows<IllegalArgumentException> { InputValidator.checkNamesLength(inputNames)}
    }
}