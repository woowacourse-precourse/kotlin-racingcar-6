package racingcar

class Champion(var champion: MutableList<String> = mutableListOf()) {
    fun getChampion(racerCrew: Racer) {
        val maxDistance = getMaxDistance(racerCrew)
    }

    private fun getMaxDistance(racerCrew: Racer): Int {
        var maxDistance = 0
        for(index in racerCrew.moveForward.indices) {
            maxDistance = compareMaxDistance(racerCrew, maxDistance, index)
        }
        return maxDistance
    }

    private fun compareMaxDistance(racerCrew: Racer, maxDistance: Int, index: Int): Int {
        return if(maxDistance < racerCrew.moveForward[index])
            racerCrew.moveForward[index]
        else maxDistance
    }
}