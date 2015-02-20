/* 
 * File:   Entity.h
 * Author: Torri
 *
 * Created on February 20, 2015, 4:05 PM
 */

#ifndef ENTITY_H
#define	ENTITY_H
#include "LTexture.h"
class Entity {
public:
    Entity(int, int);
    void render();
    int x;
    int y;
    LTexture* entityTexture;
private:

};

#endif	/* ENTITY_H */

