//
//  main.cpp
//  Question35
//
//  Created by Emil Shirima on 11/1/15.
//  Copyright © 2015 Emil Shirima. All rights reserved.
//

#include <iostream>
#include <time.h>
#include <vector>

bool isEmpty(std::vector<int> elements)
{
    if (elements.size() == 0)
    {
        return true;
    }
    else
    {
        return false;
    }
}

std::vector<int> FisherYatesShuffle(std::vector<int> elements)

{
    if (isEmpty(elements))
    {
        std::cout << "Cannot shuffle an empty array :( \n";
    }
    else
    {
        for (int i = 0; i < elements.size(); ++i)
        {
            int randomNumber = std::rand() % elements.size();
	    // swapping elements
            int temp = elements[randomNumber];
            elements[randomNumber] = elements[i];
            elements[i] = temp;
        }
    }
    
    return elements;
}

void print(std::vector<int> elements)
{
    if (isEmpty(elements))
    {
        std::cout << "Cannot print an empty array :( \n";
        
    }
    else
    {
        for (int i = 0; i < elements.size(); ++i)
        {
            std::cout << elements[i] << "\n";
        }
        std::cout << "\n";
    }
}

int main(int argc, const char * argv[])
{
    std::vector<int> contents;
    
    contents.push_back(4727);
    contents.push_back(7104);
    contents.push_back(4531);
    contents.push_back(1915);
    contents.push_back(7189);
    contents.push_back(9363);
    contents.push_back(9336);
    contents.push_back(7629);
    contents.push_back(412);
    contents.push_back(2070);
    contents.push_back(5362);
    contents.push_back(8901);
    contents.push_back(3753);
    contents.push_back(1737);
    contents.push_back(2127);
    contents.push_back(8140);
    contents.push_back(960);
    
    std::cout << "Before Shuffling \n";
    print(contents);
    
    std::cout << "After Shuffling \n";
    print(FisherYatesShuffle(contents));
    
    return 0;
}
