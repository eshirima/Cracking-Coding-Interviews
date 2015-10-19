//
//  main.cpp
//  Linked List
//
//  Created by Emil Shirima on 9/30/15.
//  Copyright (c) 2015 Emil Shirima. All rights reserved.
//

#include "LinkedList.h"

int main(int argc, const char * argv[]) {
    
    LinkedList testList = *new LinkedList();
    
    testList.insertBack(30);
    testList.insertBack(20);
    testList.insertInfront(10);
    testList.insertInfront(30);
    
    testList.printContents();
    
//    std::cout << "Detecting Duplicates Without Buffer Test \n";
//    testList.findDuplicatesWithoutBuffer();
//    testList.printContents();
    
    std::cout << "Detecting Duplicates With Buffer Test \n";
    testList.findDuplicatesWithBuffer();
    testList.printContents();
    
    
    return 0;
}