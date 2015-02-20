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
Player::Player(int hp, int _x, int _y) : Entity (_x, _y){
    playerTexture = NULL;
    health = hp;
    maxHealth = hp;
}
Player::~Player(){
    playerTexture = NULL;
}
void Player::render(){
    if(playerTexture != NULL){
        (*playerTexture).render(x, y);
    }else{printf("Texture is null\n");}
}
