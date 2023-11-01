package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChangeTest {
    @Test
    fun `List to Map으로 변환`() {
        val nameList = listOf("test1", "test2", "test3", "test4")
        val distanceList = listOf("-", "--", "-----", "--")
        val resultMap = mutableMapOf<String, String>()
        val exMap = mutableMapOf<String, String>()
        exMap["test1"] = "-"
        exMap["test2"] = "--"
        exMap["test3"] = "-----"
        exMap["test4"] = "--"
        repeat(nameList.size) {
            resultMap[nameList[it]] = distanceList[it]
        }
        assertThat(resultMap).isEqualTo(exMap)
    }
}