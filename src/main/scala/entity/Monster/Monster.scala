package entity.Monster

import entity.Entity

/**
 * Created by Torri on 3/1/2015.
 */
abstract class Monster(pos: (Int, Int), maxHealth: Int, var attack: Int, var defence: Int, var level: Double) extends Entity(pos, maxHealth)
object Monster {
  def pickRand(pos: (Int, Int)): Monster = new Goblin(pos)
}
