package com.mac286.MidTermReview;

import com.mac286.Queue.OurQueue;
import com.mac286.stacks.OurStack;

import java.util.Random;

public class bonusTestProblem {
    public static void main(String[] args) {
        OurStack<Integer> S = new OurStack<>();

        Random rand = new Random();

        for(int i = 0; i < 20; i ++){
            int randNumber = rand.nextInt(-500,500);
            S.push(randNumber);
        }

        System.out.println("Original stack: " + S);

        int SOS = 0, SOM = 0, SOL = 0;

        OurQueue<Integer> Q = new OurQueue<>();

        while(!S.isEmpty()){
            if(S.peek() < -100) SOS ++;
            else if (S.peek() <= 100) SOM ++;
            else SOL ++;

            Q.add(S.pop());
        }

        System.out.println("initial queue: " + Q + " sos: " + SOS + " som: " + SOM + " SOL: " + SOL);

        int ms = 0, mm = 0, ml = 0;
        int tSOS = SOS, tSOM = SOM, tSOL = SOL;
        boolean lookingForS = true, lookingForM = true, lookingForL = true;

            if(lookingForS){
                for(int i = 0; i < SOS; i += ms){
                    if(Q.peek() < -100){
                        ms ++;
                        if(ms == tSOS) {
                            S.push(Q.remove());
                            ms = 0;
                            tSOS --;
                        }

                        Q.add(Q.remove());
                    }

                    else Q.add(Q.remove());

                    if(tSOS == 0) {
                        lookingForS = false;
                        break;
                    }
                }
            }


            if(lookingForM){
                for(int i = 0; i < SOM; i += mm){
                    if(Q.peek() >= -100 && Q.peek() <= 100){
                        mm ++;

                        if(mm == tSOM) {
                            S.push(Q.remove());
                            mm = 0;
                            tSOM --;
                        }

                        Q.add(Q.remove());
                    }

                    else Q.add(Q.remove());

                    if(tSOM == 0) {
                        lookingForM = false;
                        break;
                    }
                }
            }



            if(lookingForL){
                for(int i = 0; i < SOL; i += ml){
                    if(Q.peek() > 100){
                        ml ++;

                        if(ml == tSOL) {
                            S.push(Q.remove());
                            ml = 0;
                            tSOL --;
                        }

                        Q.add(Q.remove());
                    }

                    else Q.add(Q.remove());

                    if(tSOL == 0) {
                        lookingForL = false;
                        break;
                    }
                }
            }


        System.out.println(S);

    }
}
