package racingcar.ui

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.ui.UserInput.createNameList

class UserInterfaceTest {
    @Test
    fun `입력을 쉼표로 구분하고, 앞 뒤 공백을 제거하여 리스트를 생성한다`() {
        val input = "  choi  , gerrard  ,  mint  "
        val names = listOf("choi", "gerrard", "mint")
        val inputNames = input.createNameList()

        assertEquals(names, inputNames)
    }
}