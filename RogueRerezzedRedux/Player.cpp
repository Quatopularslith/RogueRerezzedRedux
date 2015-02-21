/* 
 * File:   Player.cpp
 * Author: Razim
 * 
 * Created on February 20, 2015, 3:45 PM
 */

#include "Player.h"
#include "LTexture.h"
#include <stdio.h>
#include <SDL.h>
#include <SDL_image.h>

Player::Player(int hp, int _x, int _y) : Entity (_x, _y, "player.png"){
    health = hp;
    maxHealth = hp;
}
