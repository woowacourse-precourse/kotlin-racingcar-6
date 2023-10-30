package racingcar

class Champion(var championName: MutableList<String> = mutableListOf()) {
    fun getChampion(racerCrew: Racer) {
        val maxDistance = getMaxDistance(racerCrew)
        getMaxDistanceRacer(racerCrew, maxDistance)
    }

    private fun getMaxDistance(racerCrew: Racer): Int {
        var maxDistance = INITIALIZATION
        for (index in racerCrew.moveDistance.indices) {
            maxDistance = compareMaxDistance(racerCrew, maxDistance, index)
        }
        return maxDistance
    }

    private fun getMaxDistanceRacer(racerCrew: Racer, maxDistance: Int) {
        for (index in racerCrew.moveDistance.indices) {
            compareMaxDistanceRacer(racerCrew, maxDistance, index)
        }
    }

    private fun compareMaxDistance(racerCrew: Racer, maxDistance: Int, index: Int): Int {
        return if (maxDistance < racerCrew.moveDistance[index])
            racerCrew.moveDistance[index]
        else maxDistance
    }

    private fun compareMaxDistanceRacer(racerCrew: Racer, maxDistance: Int, index: Int) {
        if (racerCrew.moveDistance[index]==maxDistance)
            this.championName.add(racerCrew.racerName[index])
    }
}