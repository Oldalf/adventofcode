package day4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedList;

import adventofcode2021.AdventDay;

public class GiantSquidBingo implements AdventDay {
  final static private String path = "inputs/test.txt";
 
  private LinkedList<Integer> draws = new LinkedList<Integer>();
  private LinkedList<Integer[][]> boards = new LinkedList<Integer[][]>();
  
  public GiantSquidBingo() {
    try {
      BufferedReader inputStream = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
      
      Arrays.stream(inputStream.readLine().split(","))
        .forEach(value -> draws.add(Integer.parseInt(value)));
      
      int rowCount = 0;
      Integer[][] board = new Integer[5][5];

      String line;
      while((line = inputStream.readLine()) != null) {
        if(!(line.trim().length() == 0)) {          
          board[rowCount] = (Integer[]) Arrays.stream(line.trim().split(" "))
              .filter(value -> value.length() > 0)
              .mapToInt(value -> Integer.parseInt(value))
              .boxed()
              .toArray(Integer[]::new);

          rowCount++;
        } else {
          boards.add(board);
          rowCount = 0;
        }
      }
      
      /* boards.stream().forEach(value -> {
        Arrays.stream(value).forEach(val -> {
          Arrays.stream(val).forEach(v -> System.out.print(v + " "));
          System.out.println("");
        });
        System.out.println("****");
      }); */
      
      inputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
  }

  public void runA() {
    LinkedList<Integer> drawn = new LinkedList<Integer>();
    
    int counter = 0;
    while(drawn.size() < draws.size()) {
      drawn.add(draws.get(counter++));
      
      if(drawn.size() > 5) {
        for(Integer[][] board: boards) {
          
        }
        
      }
    }
    
  }

  public void runB() {
    
  }

}
