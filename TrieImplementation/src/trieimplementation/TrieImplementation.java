/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trieimplementation;

/**
 * Works with HackerRank Tests on Trie Problem of Address Book
 * @author gargi chakraborty
 * 
 * Input:
 * int number of queries
 * add word
 * find word
 * 
 * Sample:
 * 2
 * add hello
 * find hello
 * 
 * Output: integer for each find query
 * Example above will return 1
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class TrieImplementation {

    public static void main(String[] args) {
        TrieImplementation sol = new TrieImplementation();
        TrieImplementation.Trie contactsBook = sol.new Trie();
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if (op.equals("add")) {
                contactsBook.addWord(contact);
            } else if (op.equals("find")) {
                int numWords = contactsBook.findWord(contact);
                System.out.println(numWords);
            }
        }
    }
    
    public class TrieNode {
        char letter;
        HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();;
        Boolean isComplete = false;
        
        public TrieNode(char letterIn) {
            letter = letterIn;
        }
    }
    
    class Trie {
        TrieNode root;
        
        // constructor
        public Trie() {
            root = new TrieNode('*');
        }
        
        void addWord(String word) {
            HashMap<Character, TrieNode> children = root.children; // initially will be empty
            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);
                TrieNode letterNode;
                
                // find if letter is already in trie
                if (children.containsKey(letter)) {
                    letterNode = children.get(letter);
                } else {
                    letterNode = new TrieNode(letter);
                    children.put(letter, letterNode);
                }
                
                children = letterNode.children;
                
                if (i == word.length()-1) {
                    letterNode.isComplete = true;
                }
            }
        }
        
        int findWord(String partialWord) {
            HashMap<Character, TrieNode> children = root.children;
            TrieNode letterNode = null;
            
            for (int i = 0; i < partialWord.length(); i++) {
                char letter = partialWord.charAt(i);
                
                if (children.containsKey(letter)) {
                    letterNode = children.get(letter);
                    children = letterNode.children;
                } else {
                    return 0; // return 0 which is what numwords is at now
                }
            }
            
            //if at this point, then the partialWord has been found in Trie
            // now need to count how many words there are from this point on
            if (letterNode != null) {
                return countWords(letterNode);
            } else {
                return 0;
            }
            
        }
        
        int countWords(TrieNode letterNode) {
            int totWords = 0;
            if (letterNode.isComplete == true) totWords++;
            
            if (!letterNode.children.isEmpty()) {
                    for (Map.Entry<Character, TrieNode> entry : letterNode.children.entrySet()) {
                        TrieNode valueNode = entry.getValue();
                        totWords += countWords(valueNode);   // check if this node is it
                    }
            }
            
            return totWords;
        }
        
        
    }
    
}
