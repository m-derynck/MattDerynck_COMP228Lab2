package Ex_2;

import java.util.Random;

public class Lotto {

    private int[] lottoNums = new int[3];
    private Random lottoRand = new Random();

    public Lotto() {
        Roll();
    }

    public int[] getLottoNums() {
        return lottoNums;
    }

    //Returns the sum of the lottery numbers.
    public int getSum() {
        int sum = 0;
        for (int number : lottoNums) {
         sum += number;
        }
        return sum;
    }

    //Rolls the random numbers from 1-9 for the lottery.
    public void Roll(){
        for (int i = 0; i < lottoNums.length; i++) {
            lottoNums[i] = lottoRand.nextInt(9) + 1;
        }
    }

}
