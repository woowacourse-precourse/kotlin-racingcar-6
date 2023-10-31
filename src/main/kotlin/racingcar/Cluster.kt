package racingcar

class Cluster {
    private var distanceLine = ""

    fun getDistanceLine():String{
        return distanceLine
    }

    fun drawDistanceLine(){
        distanceLine += "-"
    }
}