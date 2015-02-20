/* 
 * File:   Player.h
 * Author: Razim
 *
 * Created on February 20, 2015, 3:45 PM
 */

#ifndef PLAYER_H
#define	PLAYER_H
#include "LTexture.h"
class Player : public Entity{
public:
    Player(int hp, int x, int y);
    ~Player();
    void render();
    int health;
    int maxHealth;
    
    LTexture* playerTexture;
private:

};

#endif	/* PLAYER_H */

