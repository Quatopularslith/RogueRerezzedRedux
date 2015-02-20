/* 
 * File:   Player.h
 * Author: Razim
 *
 * Created on February 20, 2015, 3:45 PM
 */

#ifndef PLAYER_H
#define	PLAYER_H
#include "LTexture.h"
class Player {
public:
    Player(int hp);
    ~Player();
    void render(int x, int y);
    int health;
    int maxHealth;
    
    LTexture* playerTexture;
private:

};

#endif	/* PLAYER_H */

