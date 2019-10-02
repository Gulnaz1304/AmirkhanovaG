package com.example.homework2.StarVsTheForcesOfEvil

class StarEnemie(val dimension: Dimension, val name:String,val age:Int, var lifePoints: Int = 100){
    private var hp: Int = lifePoints

    public fun getDamage(damage: Int){
        hp -= damage
    }
    fun attack(friend : StarEnemie){
        friend.getDamage(1)

    }
}