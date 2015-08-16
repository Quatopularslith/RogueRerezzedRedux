package entity.Monster

import entity.Entity
import generators.Dungeon

/**
 * Created by Torri on 3/1/2015.
 */
abstract class Monster(pos: (Double, Double), maxHealth: Int, var attack: Int, var defence: Int, var level: Double, dungeon: Dungeon) extends Entity(pos, maxHealth, dungeon)

object Monster {
  def pickRand(pos: (Double, Double), dungeon: Dungeon): Monster = new Goblin(pos, dungeon)
}
