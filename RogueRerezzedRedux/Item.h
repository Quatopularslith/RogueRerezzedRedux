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
#include <map>

using namespace std;

class Item {
public:

    const string intname;
    const string name;
    Item();
    int ItemThing(int id);
protected:
    const int id;
    
};

#endif	/* ITEM_H */

