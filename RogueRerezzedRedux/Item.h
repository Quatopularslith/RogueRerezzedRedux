/* 
 * File:   Item.h
 * Author: Torri
 *
 * Created on February 19, 2015, 7:47 PM
 */

#ifndef ITEM_H
#define	ITEM_H

#include <string>
#include <stdio.h>
#include "Entity.h"

using namespace std;

class Item : public Entity {
public:
    Item(int);
    string getName();
    int getID();
protected:
    string name;
    int id;
private:
    string otherNamer(int);
};

#endif

