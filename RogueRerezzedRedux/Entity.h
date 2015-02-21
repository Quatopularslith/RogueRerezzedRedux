/* 
 * File:   Entity.h
 * Author: Torri
 *
 * Created on February 20, 2015, 4:05 PM
 */

#ifndef ENTITY_H
#define	ENTITY_H
#include "LTexture.h"
#include <stdio.h>
#include <string>
#include <map>

using namespace std;

class Entity {
public:
    Entity(int, int, string);
    ~Entity();
    void render();
    void moveTo(int, int);
    static void loadTex(string);
    int x;
    int y;
    static map<string, *LTexture> textures;
    string tpath;
private:

};

#endif	/* ENTITY_H */

