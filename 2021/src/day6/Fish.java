package day6;

public class Fish {
  public int timer;

  public Fish(int timer) {
    this.timer = timer;
  }
  
  public Boolean decreaseTimer() {
   if(timer == 0) {
     timer = 6;
     return true;
   }
   
   timer--;
   return false;
  }
}
