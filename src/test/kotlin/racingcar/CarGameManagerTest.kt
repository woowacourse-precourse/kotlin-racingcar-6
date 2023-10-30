package racingcar

import camp.nextstep.edu.missionutils.Randoms
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import racingcar.Constants.Companion.MAX_NUMBER
import racingcar.Constants.Companion.MIN_NUMBER

class CarGameManagerTest {

    @Test
    fun `랜덤값이 0 - 9 사이가 맞는지 확인`() {
        val randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)
        assertTrue(randomNumber in MIN_NUMBER..MAX_NUMBER)
    }
    @Test
    fun `진행결과 출력`() {
        val carNameListTest: List<String> = listOf("yang", "won", "sik")
        val carListCountTest = carNameListTest.size
        val carResultListTest = MutableList(carListCountTest) { "" }
        val randomValueList: List<Int> = listOf(4, 2, 8)
        val outputTestList: List<String> = listOf("yang : -","won : ","sik : -")
        for (countList in 0 until carListCountTest) { // MIN_NUMBER 제거
            if (randomValueList[countList] >= Constants.FORWARD_CONDITION) {
                carResultListTest[countList] += "-"
            }
            val output = "${carNameListTest[countList]} : ${carResultListTest[countList]}"
            Assertions.assertEquals(output, outputTestList[countList])
        }
    }

}