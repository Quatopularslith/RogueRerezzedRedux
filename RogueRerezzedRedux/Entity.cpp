/* 
 * File:   Entity.cpp
 * Author: Torri
 * 
 * Created on February 20, 2015, 4:05 PM
 */

#include "Entity.h"
#include "LTexture.h"
#include <stdio.h>

Entity::Entity(int _x, int _y) {
    x = _x;
    y = _y;
}

void Entity::render(){
    if(entityTexture != NULL){
        (*entityTexture).render(x, y);
    }else{printf("Texture is null\n");}
}