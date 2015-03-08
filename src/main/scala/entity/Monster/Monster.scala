package entity.Monster

import entity.Entity

/**
 * Created by Torri on 3/1/2015.
 */
abstract class Monster(pos: (Int, Int), maxHealth: Int, val attack: Int, val defence: Int, var level: Double) extends Entity(pos, maxHealth)
object Monster {
  def pickRand(): Monster = null
}
