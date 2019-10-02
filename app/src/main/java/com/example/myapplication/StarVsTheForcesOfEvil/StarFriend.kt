package com.example.homework2.StarVsTheForcesOfEvil

class StarFriend( val lifePoints: Int = 100, val dimension: Dimension, val name: String, val age:Int){
    private var hp:Int = lifePoints
    fun attackTheEnemie(enemie: StarEnemie){
        enemie.getDamage(1)
    }
    public fun getDamage(damage: Int){
        hp -= damage
    }
}