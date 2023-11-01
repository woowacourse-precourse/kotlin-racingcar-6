package racingcar

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationKtTest {

    @Test
    fun `게임시작 메시지 출력되는지`() {
        val expectedOutput = """
            레이싱 카 게임
            =====================================
            경주할 자동차 이름을 입력하세요.(이름은 영문으로 쉼표(,) 기준으로 구분)            
        """.trimIndent()

        val realOutput = 뉴게임시작()
        assertEquals(expectedOutput, realOutput.toString())
    }

    private fun `뉴게임시작`(): String {
        val gameStartMessag = """
            레이싱 카 게임
            =====================================
            경주할 자동차 이름을 입력하세요.(이름은 영문으로 쉼표(,) 기준으로 구분)            
        """.trimIndent()

        return gameStartMessag
    }

    @Test
    fun `인풋 카네임이 정상적인 이름인지`() {
        val carName1 = "한글, 123"
        val exception1 = assertThrows<IllegalArgumentException> {
            뉴인풋카네임(carName1)
        }

        val carName2 = "★car☆, sub"
        val exception2 = assertThrows<IllegalArgumentException> {
            뉴인풋카네임(carName2)
        }
        //Not(alphabet + 숫자) || Not(alphabet)

        val carName3 = ", "
        val exception3 = assertThrows<IllegalArgumentException> {
            뉴인풋카네임(carName3)
        }
        //only Comma

        val carName4 = "wendy,tom"
        var resultList = 뉴인풋카네임(carName4)
        assertEquals(2, resultList.size)
        // nomal

    }

    private fun `뉴인풋카네임`(carName: String): MutableList<String> {
        var inputText = ""
        var afterText = ""
        var carNameList = mutableListOf<String>()

        val stringPattern = Regex("[^A-Za-z0-9,]")
        val commaPattern = Regex(",{1,}")
        val numberPattern = Regex("[0-9,]{1,}")

        inputText = carName.replace(" ", "")
        afterText = stringPattern.replace(inputText, "")

        if (inputText != afterText || commaPattern.matches(afterText)) {
            /* 입력받은 값과 카네임 기준으로 보정한 값이 다르거나
            카네임 기준으로 보정한 값이 쉼표만 확인되는 경우 처리*/
            throw IllegalArgumentException()
            try {
            } catch (e: IllegalArgumentException) {
                println("잘못된 문자 또는 쉼표만 입력되어 게임종료")
                System.out
            }
        } else if (numberPattern.matches(afterText)) {
            throw IllegalArgumentException()
            try {
            } catch (e: IllegalArgumentException) {
                println("숫자만 입력되어 게임종료")
                System.out
            }
        }

        carNameList = afterText.split(",").toMutableList()
        return carNameList
    }

    @Test
    fun `카네임 공백값이 있는지`() {
        val carName1 = ""
        val carNameList1 = mutableListOf<String>("car1", "", "car3")
        val exception1 = assertThrows<IllegalArgumentException> {
            getCarNameEmptyCheck(carName1, carNameList1)
        }
    }

    @Test
    fun `카네임 리스트 이상 있는지`() {
        val carNameList1 = mutableListOf<String>()
        val resultCarNameMap1 = getCarNameListCheck(carNameList1)
        assertEquals(0, resultCarNameMap1.size)
        // carNameList isEmpty

        val carNameList2 = mutableListOf("car1")
        val exception1 = assertThrows<IllegalArgumentException> {
            getCarNameListCheck(carNameList2)
        }
        // carNameListSize == 1

        val carNameList3 = mutableListOf("car1", "car1")
        val exception2 = assertThrows<IllegalArgumentException> {
            getCarNameListCheck(carNameList3)
        }
        // carNameList isNotEmpty && carNameNotUnique

        val carNameList4 = mutableListOf("car1", "car2")
        val resultCarNameMap4 = getCarNameListCheck(carNameList4)
        assertEquals(2, resultCarNameMap4.size)
        assertEquals(4, resultCarNameMap4["car1"]!!)
        assertEquals(4, resultCarNameMap4["car2"]!!)
        // all nomal

    }

    @Test
    fun `카네임이 5자 인지`() {
        val longCarName = "TooLongCarName"
        val exception = assertThrows<IllegalArgumentException> {
            getCarNameLengthCheck(longCarName)
        }
        // long carName

        val shortCarName = "Car1"
        val result2 = getCarNameLengthCheck(shortCarName)
        assertEquals(false, result2)
        // Short carName
    }

    @Test
    fun `라운드숫자가 이상있는지`() {
        val carNameMap1 = mutableMapOf<String, Int>()
        val InputCount1 = inputRoundCount(carNameMap1)
        assertEquals(0, InputCount1)
        // Map isEmpty

        val exception1 = assertThrows<IllegalArgumentException> {
            뉴인풋라운드카운트1(15)
        }
        // Map isNotEmpty && count > 10
        val exception2 = assertThrows<IllegalArgumentException> {
            뉴인풋라운드카운트1(0)
        }
        // Map isNotEmpty && count < 1

        val exception3 = assertThrows<IllegalArgumentException> {
            val intString = "s1"
            뉴인풋라운드카운트2(intString.toInt())
        }
        // count not Int
    }

    private fun `뉴인풋라운드카운트1`(count: Int) {
        print("진행할 라운드 횟수 입력(최대 10) : ")

        if (count < 1 || count > 10) {
            throw IllegalArgumentException()
            try {
            } catch (e: IllegalArgumentException) {
                println("해당 범위가 아닌 숫자가 입력되어 게임종료")
                System.out
            }
        }
    }

    private fun `뉴인풋라운드카운트2`(count: Int) {
        try {
            count.toInt()
        } catch (e: IllegalArgumentException) {
            println("해당 범위가 아닌 숫자가 입력되어 게임종료")
            System.out
        }
    }


    @Test
    fun `최종우승자가 잘 출력되는지`() {
        val playerListMap1 = mutableMapOf("Car1" to 5, "Car2" to 3)
        var realWinner1 = 뉴레이싱플레이(playerListMap1, "Car1", "Car2")
        val expectedWinner1 = "Car1"
        assertEquals(expectedWinner1, realWinner1)
        // winner == 1

        val playerListMap2 = mutableMapOf("Car1" to 7, "Car2" to 7)
        var realWinner2 = 뉴레이싱플레이(playerListMap2, "Car1", "Car2")
        val expectedWinner2 = "Car1,Car2"
        assertEquals(expectedWinner2, realWinner2)
        // winner > 1
    }

    private fun `뉴레이싱플레이`(playerMap: MutableMap<String, Int>, carName1: String, carName2: String)
            : String {
        var num1 = playerMap[carName1].toString().toInt()
        var num2 = playerMap[carName2].toString().toInt()
        var maxnumber = maxOf(num1, num2)
        if (num1 < num2) {
            return carName2
        } else if (num1 > num2) {
            return carName1
        } else{
            return carName1+","+carName2
        }
    }

    @Test
    fun `진행상황이 잘 출력되는지`() {
        val ResultMap = mutableMapOf("Car1" to "5", "Car2" to "3")
        val realOutput = 뉴겟레이싱플레이로그("Car1", "Car2", ResultMap)

        val expectedOutput = """
            Car1 :ㅡ
            Car2 :-
        """.trimIndent()
        assertEquals(
            expectedOutput,
            "Car1 :" + ResultMap["Car1"] + "\nCar2 :" + ResultMap["Car2"]
        )

    }


    fun `뉴겟레이싱플레이로그`(
        key1: String,
        key2: String,
        ResultMap: MutableMap<String, String>
    ): MutableMap<String, String> {
        if (ResultMap[key1].toString().toInt() > 4) {
            ResultMap[key1] = "ㅡ"
        }
        if (ResultMap[key2].toString().toInt() < 4) {
            ResultMap[key2] = "-"
        }
        return ResultMap
    }

    @Test
    fun `랜덤숫자에 따라 전진 멈춤이 되는지`() {
        val randomNumber1 = 3
        val stepProgress = 뉴겟넘버(3)
        assertEquals("", stepProgress)
        // randomNumber < 4

        val randomNumber2 = 5
        val stopProgress = 뉴겟넘버(5)
        assertEquals("-", stopProgress)
        // randomNumber > 4
    }

    private fun `뉴겟넘버`(randomNumber: Int): String {
        var racingProgress = ""
        if (randomNumber >= 4) {
            racingProgress += "-"
        }
        return racingProgress
    }

    @Test
    fun `최종우승자가 1명인지 2명이상 인지`() {
        val result1 = getUserCountCheck(2)
        assertEquals(",", result1)
        // userCount > 1

        val result2 = getUserCountCheck(0)
        assertEquals("", result2)
        // userCount < 1

        val result3 = getUserCountCheck(1)
        assertEquals("", result3)
        // userCount == 1
    }
}


