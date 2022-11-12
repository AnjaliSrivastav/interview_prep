package com.recursion;

import java.util.ArrayList;
import java.util.List;

/*If we are standing at nth stair and we need to go to 0th stair. Then return all the paths possible
from nth stair to 0th stair.
* */
public class getStairPath {
    public static void main(String[] args) {
        List<String> paths = getAllPaths(4);
        System.out.println("Paths from 4th stair to 0th stair : "+paths);
    }

    /*Expectation is that it will give all possible paths from (n) to (0)*/
    public static List<String> getAllPaths(int n){

        //base case
        if(n == 0){
            List<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }else if(n<0){
            List<String> bres = new ArrayList<>();
            return bres;
        }
        List<String> paths1 = getAllPaths(n-1); //faith that this method will return all possible paths from (n-1) to 0th stair
        List<String> paths2 = getAllPaths(n-2); //faith that this method will return all possible paths from (n-2) to 0th stair
        List<String> paths3 = getAllPaths(n-3); //faith that this method will return all possible paths from (n-3) to 0th stair

        List<String> paths = new ArrayList<>();


        for(String path : paths1){
            paths.add(1 + path); //to all paths from (n-1) to (0), if we put(1) in front of them, we get paths from n to 0
        }

        for(String path : paths2){
            paths.add(2 + path); //to all paths from (n-2) to (0), if we put(2) in front of them, we get paths from n to 0
        }

        for(String path : paths3){
            paths.add(3 + path); //to all paths from (n-3) to (0), if we put(3) in front of them, we get paths from n to 0
        }
        return paths;
    }
}
