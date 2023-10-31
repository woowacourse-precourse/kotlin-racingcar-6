package racingcar

class Winner(private val nameList: List<String>, private val moveNumList: MutableList<Int>) {
    fun who() {
        val max = moveNumList.max()
        val winnerIndexList = moveNumList.indices.filter { moveNumList[it] == max }
        val winnerNameList = winnerIndexList.mapNotNull { nameList.getOrNull(it) }
        println("최종 우승자 : " + winnerNameList.joinToString(", "))
    }
}