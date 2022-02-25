package com.bonpopkon.app;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {
    
    public static void main( String[] args ) {
        
        System.out.println( "Hello World!" );
        GetRandomWord getRandomWord = new GetRandomWord();
        try {
            getRandomWord.callRandomWordApi(10);
        } catch (IOException e) {
            System.out.println("failure! " + e.toString());
        }
    }
}
