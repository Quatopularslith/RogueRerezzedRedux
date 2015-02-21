/* 
 * File:   Entity.cpp
 * Author: Torri
 * 
 * Created on February 20, 2015, 4:05 PM
 */

#include "Entity.h"
#include "LTexture.h"
#include <stdio.h>
#include <string>

using namespace std;
map<string, LTexture*> Entity::textures;

Entity::Entity(int _x, int _y, string path) {
    x = _x;
    y = _y;
    tpath = path;
    loadTex(path);
}

Entity::Entity(int _x, int _y){
    x = _x;
    y = _y;
}

Entity::~Entity(){
}

void Entity::loadTex(string path){
    if(!textures[path] && path != ""){
        textures.insert(std::make_pair(path, new LTexture(path)));
    }
}

void Entity::render(){
    if(!textures[tpath]){
        textures[tpath]->render(x, y);
    }else{
        printf("Texture is null\n");
    }
}

void Entity::moveTo(int newX, int newY){
    x = newX;
    y = newY;
}