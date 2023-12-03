package day6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedList;

import adventofcode2021.AdventDay;

public class LanternFish implements AdventDay {
  final static private String path = "inputs/6.txt";
  private LinkedList<Fish> input = new LinkedList<Fish>();

  public LanternFish() {
    try {
      BufferedReader inputStream = new BufferedReader(
          new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));

      Arrays.stream(inputStream.readLine().split(","))
        .forEach(value -> input.add(new Fish(Integer.parseInt(value))));

      inputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @SuppressWarnings("unchecked")
  public void runA() {
    LinkedList<Fish> copy = (LinkedList<Fish>) input.clone();
    
    for(int i = 0; i < 80; i++) {
      int fishToSpawn = 0;
      
      for(Fish f: copy) {
        if(f.decreaseTimer()) {
          fishToSpawn++;
        }
      }
      
      for(int j = 0; j < fishToSpawn; j++) {
        copy.add(new Fish(8));
      }
    }
    
    System.out.println("Day6 A: " + copy.size());
  }

  public void runB() {
    long[] fish = new long[9];
    Arrays.fill(fish, 0L);
    
    for(Fish f: input) {
      fish[f.timer]++;
    }
    
    for(int i = 0; i < 256; i++) {
      long newGeneration = fish[0];

      for(int j = 1; j < 9; j++) {
        fish[j-1] = fish[j];           
      }
      
      fish[6] += newGeneration;
      
      fish[8] = newGeneration;
    }
    
    long sum = Arrays.stream(fish).sum();
    
    System.out.println("Day6 B: " + sum);    
  }

}
