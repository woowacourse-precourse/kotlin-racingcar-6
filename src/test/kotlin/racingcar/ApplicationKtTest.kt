package racingcar

import camp.nextstep.edu.missionutils.Randoms
import org.junit.jupiter.api.Test
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows


import org.junit.jupiter.api.Assertions.*

class ApplicationKtTest {

    @Test
    fun inputNum() : Int {
        println("시도할 횟수는 몇 회인가요?")
        val repeitNum = readLine()?.toInt()?: 0
        return repeitNum
    }

    @Test
    fun setRandomNum() :Int {
        val randomNum = Randoms.pickNumberInRange(0, 9)
        return randomNum
    }

    @Test
    fun checkUserInput(names: List<String>) {
        names.forEach { name ->
            if (name.length > 5) {
                throw IllegalArgumentException("자동차 이름은 5자 이하로 입력해야 합니다.")
            }
        }
    }

    @Test
    fun printDash(res: String, count: Int) {
        val dashLine = "-".repeat(count)
        println("${res} : ${dashLine}")
    }

    @Test
    fun determineWinner(cntList: MutableMap<String, Int>): List<String> {
        val maxCount = cntList.values.maxOrNull()
        val winners = cntList.filterValues { it == maxCount }.keys.toList()
        return winners
    }
}