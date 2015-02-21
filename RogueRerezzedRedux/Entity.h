/* 
 * File:   Entity.h
 * Author: Torri
 *
 * Created on February 20, 2015, 4:05 PM
 */

#ifndef ENTITY_H
#define	ENTITY_H
#include "LTexture.h"
#include <string>
class Entity {
public:
    Entity(int, int, LTexture*);
    ~Entity();
    void render();
    int x;
    int y;
    LTexture* texture;
private:

};

#endif	/* ENTITY_H */

