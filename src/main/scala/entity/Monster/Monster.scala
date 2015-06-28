package entity.Monster

import entity.Entity

/**
 * Created by Torri on 3/1/2015.
 */
abstract class Monster(pos: (Double, Double), maxHealth: Int, var attack: Int, var defence: Int, var level: Double) extends Entity(pos, maxHealth)
object Monster {
  def pickRand(pos: (Double, Double)): Monster = new Goblin(pos)
}
