/* 
 * File:   Item.cpp
 * Author: Torri
 * 
 * Created on February 19, 2015, 7:47 PM
 */

#include "Item.h"
#include <string>

using namespace std; 

Item::Item(int id) {
    this->id = id;
    string name = "";
    int mod = id % item["modifier"].size();
    int mat = id % item["material"].size();
    int type = id % (item["weapon"].size() + item["armor"].size() + item["other"].size());
    name << item["modifier"][mod];
    name << " " << item["material"][mat];
    
}