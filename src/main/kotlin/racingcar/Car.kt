package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car {
    private var name:String
    private var distance = 0
    private var cluster:Cluster

    constructor(name:String){
        this.name = name
        cluster = Cluster()
    }

    fun getName():String{
        return name
    }

    fun getDistance():Int{
        return distance
    }

    fun getCluster():Cluster{
        return cluster
    }

    fun moveForward() {
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        if (randomNumber >= 4) {
            distance += 1
            cluster.drawDistanceLine()
        }
    }

    fun getNameAndCluster():String {
        var result = "${name} : ${cluster.getDistanceLine()}"

        return result
    }
}