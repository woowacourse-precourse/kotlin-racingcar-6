package racingcar.datahandling

class Save {
    fun saveDistance(move: Int, distance: MutableList<String>, index: Int) {
        when (move) {
            GO -> distance[index] += GO_STRING
            STOP -> distance[index] += STOP_STRING
        }
    }

    companion object {
        private const val GO = 1
        private const val STOP = 0
        private const val GO_STRING = "-"
        private const val STOP_STRING = ""
    }
}