import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.util.*;

/**
 * Created by Tirthmehta on 10/7/16.
 */
public class homework {
    int pos1=-1;
    int pos2=-1;

    public ArrayList<String> nextmoves(String matrix[][],int size)
    {
        ArrayList<String> spaces=new ArrayList<String>();
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(matrix[i][j].equals("."))
                {
                    int tempi=i+1;
                    String temp=String.valueOf((char)(j+65))+""+tempi;
                    spaces.add(temp);
                }
            }
        }
        return spaces;
    }

    //new way for list generation

    public ArrayList<String> nextmovesgeneral(String matrix[][],int size,String youplay)
    {
        ArrayList<String> generalstakes=new ArrayList<String>();
        ArrayList<String> raid=new ArrayList<String>();


        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(matrix[i][j].equals("."))
                {
                    int tempi=i+1;
                    String temp=String.valueOf((char)(j+65))+""+tempi+"-";
                    generalstakes.add(temp);
                }
            }
        }

        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(matrix[i][j].equals("."))
                {
                    int tempi=i+1;
                    String temp=String.valueOf((char)(j+65))+""+tempi;
                    if(checkraidmatrix(matrix,size,youplay,i,j).equals("Raid"))
                    { raid.add(temp);}

                }
            }
        }
        for(String x:raid)
        {
            generalstakes.add(x);
        }
        return generalstakes;
    }




    public String checkraidmatrix(String globalmatrix[][],int size,String youplay,int i,int j)
    {
        int checking=0;
        int raider=0;
        if(youplay.equals("O")) {


            if (j - 1 != -1) {
                if (globalmatrix[i][j - 1].equals("O"))
                {
                    raider=1;
                }
            }
            if (j + 1 != size) {
                if (globalmatrix[i][j + 1].equals("O"))
                {
                    raider=1;
                }
            }
            if (i + 1 != size) {
                if (globalmatrix[i+1][j].equals("O"))
                {
                    raider=1;
                }
            }
            if (i - 1 != -1) {
                if (globalmatrix[i-1][j].equals("O"))
                {
                    raider=1;
                }
            }



            if(raider==1) {
                if (j - 1 != -1) {
                    if (globalmatrix[i][j - 1].equals("X")) {
                        //globalmatrix[i][j - 1] = "O";
                        checking = 1;
                    }
                }
                if (j + 1 != size) {
                    if (globalmatrix[i][j + 1].equals("X")) {
                       // globalmatrix[i][j + 1] = "O";
                        checking = 1;
                    }
                }
                if (i + 1 != size) {
                    if (globalmatrix[i + 1][j].equals("X")) {
                       // globalmatrix[i + 1][j] = "O";
                        checking = 1;
                    }
                }
                if (i - 1 != -1) {
                    if (globalmatrix[i - 1][j].equals("X")) {
                       // globalmatrix[i - 1][j] = "O";
                        checking = 1;
                    }
                }
            }
        }

        if(youplay.equals("X")) {

            if (j - 1 != -1) {
                if (globalmatrix[i][j - 1].equals("X"))
                {
                    raider=1;
                }
            }
            if (j + 1 != size) {
                if (globalmatrix[i][j + 1].equals("X"))
                {
                    raider=1;
                }
            }
            if (i + 1 != size) {
                if (globalmatrix[i+1][j].equals("X"))
                {
                    raider=1;
                }
            }
            if (i - 1 != -1) {
                if (globalmatrix[i-1][j].equals("X"))
                {
                    raider=1;
                }
            }

            if(raider==1) {
                if (j - 1 != -1) {
                    if (globalmatrix[i][j - 1].equals("O")) {
                        //globalmatrix[i][j - 1] = "X";
                        checking = 1;
                    }
                }
                if (j + 1 != size) {
                    if (globalmatrix[i][j + 1].equals("O")) {
                      //  globalmatrix[i][j + 1] = "X";
                        checking = 1;
                    }
                }
                if (i + 1 != size) {
                    if (globalmatrix[i + 1][j].equals("O")) {
                      //  globalmatrix[i + 1][j] = "X";
                        checking = 1;
                    }
                }
                if (i - 1 != -1) {
                    if (globalmatrix[i - 1][j].equals("O")) {
                      //  globalmatrix[i - 1][j] = "X";
                        checking = 1;
                    }
                }
            }
        }
        if(checking==1)
        {
        String ans="Raid";
        return ans;
        }
        else
        {
        String ans="Stake";
        return ans;
        }
    }











    public ArrayList<String> nextmovesfirstlevel(String matrix[][],int size,String youplay)
    {
        ArrayList<String> stakes=new ArrayList<String>();
        ArrayList<String> raid=new ArrayList<String>();

        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(matrix[i][j].equals("."))
                {
                    int tempi=i+1;
                    String temp=String.valueOf((char)(j+65))+""+tempi;
                    if(checkraid(matrix,size,youplay,temp).equals("Stake"))
                    { stakes.add(temp);}
                    else
                    {
                        raid.add(temp);
                    }
                }
            }
        }
        for(String x:raid)
        {
            stakes.add(x);
        }
        return stakes;
    }


    public String[][] checkmatrix(String globalmatrix[][],String youplay,int size,int i,int j)
    {
        int checking=0;
        int raider=0;
        if(youplay.equals("O")) {


            if (j - 1 != -1) {
                if (globalmatrix[i][j - 1].equals("O"))
                {
                    raider=1;
                }
            }
            if (j + 1 != size) {
                if (globalmatrix[i][j + 1].equals("O"))
                {
                    raider=1;
                }
            }
            if (i + 1 != size) {
                if (globalmatrix[i+1][j].equals("O"))
                {
                    raider=1;
                }
            }
            if (i - 1 != -1) {
                if (globalmatrix[i-1][j].equals("O"))
                {
                    raider=1;
                }
            }



            if(raider==1) {
                if (j - 1 != -1) {
                    if (globalmatrix[i][j - 1].equals("X")) {
                        globalmatrix[i][j - 1] = "O";
                        checking = 1;
                    }
                }
                if (j + 1 != size) {
                    if (globalmatrix[i][j + 1].equals("X")) {
                        globalmatrix[i][j + 1] = "O";
                        checking = 1;
                    }
                }
                if (i + 1 != size) {
                    if (globalmatrix[i + 1][j].equals("X")) {
                        globalmatrix[i + 1][j] = "O";
                        checking = 1;
                    }
                }
                if (i - 1 != -1) {
                    if (globalmatrix[i - 1][j].equals("X")) {
                        globalmatrix[i - 1][j] = "O";
                        checking = 1;
                    }
                }
            }
        }

        if(youplay.equals("X")) {

            if (j - 1 != -1) {
                if (globalmatrix[i][j - 1].equals("X"))
                {
                    raider=1;
                }
            }
            if (j + 1 != size) {
                if (globalmatrix[i][j + 1].equals("X"))
                {
                    raider=1;
                }
            }
            if (i + 1 != size) {
                if (globalmatrix[i+1][j].equals("X"))
                {
                    raider=1;
                }
            }
            if (i - 1 != -1) {
                if (globalmatrix[i-1][j].equals("X"))
                {
                    raider=1;
                }
            }

            if(raider==1) {
                if (j - 1 != -1) {
                    if (globalmatrix[i][j - 1].equals("O")) {
                        globalmatrix[i][j - 1] = "X";
                        checking = 1;
                    }
                }
                if (j + 1 != size) {
                    if (globalmatrix[i][j + 1].equals("O")) {
                        globalmatrix[i][j + 1] = "X";
                        checking = 1;
                    }
                }
                if (i + 1 != size) {
                    if (globalmatrix[i + 1][j].equals("O")) {
                        globalmatrix[i + 1][j] = "X";
                        checking = 1;
                    }
                }
                if (i - 1 != -1) {
                    if (globalmatrix[i - 1][j].equals("O")) {
                        globalmatrix[i - 1][j] = "X";
                        checking = 1;
                    }
                }
            }
        }

        return globalmatrix;
    }

    public String[][] stakematrix(String globalmatrix[][],String youplay,int size,int i,int j)
    {
        if(youplay.equals("O"))
        {
            globalmatrix[i][j]="O";
        }
        if(youplay.equals("X"))
        {
            globalmatrix[i][j]="X";
        }
        return globalmatrix;
    }

    public String[][] copy(String mat1[][],int size)
    {
        String newmat[][]=new String[size][size];
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                newmat[i][j]=mat1[i][j];
            }
        }
        return newmat;
    }

    public int[][] copyvalue(int mat1[][],int size)
    {
        int newmat[][]=new int[size][size];
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                newmat[i][j]=mat1[i][j];
            }
        }
        return newmat;
    }

    public String[][] tempmatchanges(String mat[][],int size,String move,String youplay)
    {
        String tempmat[][]=copy(mat,size);
        int i,j;
        if(move.length()==2) {
            i = Integer.parseInt(String.valueOf(move.charAt(1))) - 1;
            j=move.charAt(0)-65;
            tempmat[i][j]=youplay;
            tempmat=checkmatrix(tempmat,youplay,size,i,j);
        }
        if(move.length()==3 && move.charAt(2)!='-')
        {
            String frnow=move.substring(1);
            i=Integer.parseInt(frnow)-1;
            j=move.charAt(0)-65;
            tempmat[i][j]=youplay;
            tempmat=checkmatrix(tempmat,youplay,size,i,j);
        }
        if(move.length()==3 && move.charAt(2)=='-')
        {
            i = Integer.parseInt(String.valueOf(move.charAt(1))) - 1;
            j=move.charAt(0)-65;
            //tempmat[i][j]=youplay;
            tempmat=stakematrix(tempmat,youplay,size,i,j);
        }
        if(move.length()==4 && move.charAt(3)=='-')
        {
            String frnow=move.substring(1,3);
            i=Integer.parseInt(frnow)-1;
            j=move.charAt(0)-65;
            tempmat=stakematrix(tempmat,youplay,size,i,j);
        }

      //  System.out.println(i+" "+j);

        return tempmat;

    }

    public void printmatrix(String mar[][],int size)
    {
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                System.out.print(mar[i][j]+" ");
            }
            System.out.println();
        }
    }
    public int spaces(String mat[][],int size)
    {
        int spacesleft=0;
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(mat[i][j].equals("."))
                {
                    spacesleft++;
                }
            }
        }
        return spacesleft;
    }

    public void CreateTree(int depth,int matrix1[][],String matrix2[][],String youplay,int size,String algo) throws IOException {
        String original_youplay=youplay;
        String checkraidstake="";
        String tempraidstake="";
       // System.out.println(eval(matrix2,matrix1,size,youplay));
        ArrayList<String> newmoves=nextmovesgeneral(matrix2,size,youplay);
        System.out.println(newmoves);
        int spacesinthegrid=spaces(matrix2,size);
       // System.out.println(depth);
       // System.out.println(spacesinthegrid);
        if(depth>spacesinthegrid)
        {
            depth=spacesinthegrid;
           // System.out.println(depth);
        }


        String tempmat[][]=copy(matrix2,size);
        int tempmatvalue[][]=copyvalue(matrix1,size);
        int bestscore=-Integer.MAX_VALUE;
       // System.out.println(newmoves);
        String bestmove="";
        String bestmat[][]=new String[size][size];
        for(int i=0;i<newmoves.size();i++)
        {
            String newmat[][]=tempmatchanges(tempmat,size,newmoves.get(i),youplay);
           // printmatrix(newmat,size);

            //System.out.println(newmoves.get(i));
            //printmatrix(newmat,size);
            int currentscore=minimax(newmat,tempmatvalue,size,youplay,1,depth,original_youplay);
          // System.out.println("current score "+currentscore);
         //   System.out.println("best score "+bestscore);

            if(currentscore>bestscore) {
                bestscore = currentscore;
           //     System.out.println("best score nw "+bestscore);
                bestmove=newmoves.get(i);
                bestmat=newmat;
                String matrixtocheckvalueraidstake[][]=copy(matrix2,size);
                checkraidstake=checkraid(matrixtocheckvalueraidstake,size,youplay,bestmove);
           //     System.out.println("when cs>bs "+checkraidstake);
            }
            /*else if(currentscore==bestscore)
            {
                //System.out.println("tie breaker bestscore "+bestscore);
                String matrixtocheckvalueraidstake[][]=copy(matrix2,size);
                tempraidstake=checkraid(matrixtocheckvalueraidstake,size,youplay,newmoves.get(i));
                //System.out.println(tempraidstake);
                //System.out.println(checkraidstake);
                //System.out.println(newmoves.get(i));

                if(checkraidstake.equals("Raid")&&tempraidstake.equals("Stake"))
                {
                    bestscore = currentscore;
                    bestmove=newmoves.get(i);
                    bestmat=newmat;
                    checkraidstake=tempraidstake;
                }
            }*/


        }
        writeans(matrix2,bestmat,size,youplay,bestmove);
       // System.out.println("BEST SCORE IS: "+bestscore);
    }



    public String checkraid(String matori[][],int size,String youplay,String bestmove)
    {


        String raiding="";
        int j,i;


        if(bestmove.length()==2) {
            i = Integer.parseInt(String.valueOf(bestmove.charAt(1))) - 1;
            j=bestmove.charAt(0)-65;
            //tempmat[i][j]=youplay;
           // tempmat=checkmatrix(tempmat,youplay,size,i,j);
           raiding="Raid";
        }
        if(bestmove.length()==3 && bestmove.charAt(2)!='-')
        {
            String frnow=bestmove.substring(1);
            i=Integer.parseInt(frnow)-1;
            j=bestmove.charAt(0)-65;
           // tempmat[i][j]=youplay;
         //   tempmat=checkmatrix(tempmat,youplay,size,i,j);
         raiding="Raid";
        }
        if(bestmove.length()==3 && bestmove.charAt(2)=='-')
        {
            i = Integer.parseInt(String.valueOf(bestmove.charAt(1))) - 1;
            j=bestmove.charAt(0)-65;
            //tempmat[i][j]=youplay;
           // tempmat=stakematrix(tempmat,youplay,size,i,j);
            raiding="Stake";
        }
        if(bestmove.length()==4 && bestmove.charAt(3)=='-')
        {
            String frnow=bestmove.substring(1,4);
            i=Integer.parseInt(frnow)-1;
            j=bestmove.charAt(0)-65;
            //tempmat=stakematrix(tempmat,youplay,size,i,j);
            raiding="Stake";

        }







        /*
        if(bestmove.length()==2) {
            i = Integer.parseInt(String.valueOf(bestmove.charAt(1))) - 1;
        }
        else
        {
            String frnw=bestmove.substring(1);
            i=Integer.parseInt(frnw)-1;
        }
    //  System.out.println(i+" "+j);
        if(youplay.equals("O")) {


            if (j - 1 != -1) {
                if (matori[i][j - 1].equals("O"))
                {
                    raider=1;
                }
            }
            if (j + 1 != size) {
                if (matori[i][j + 1].equals("O"))
                {
                    raider=1;
                }
            }
            if (i + 1 != size) {
                if (matori[i+1][j].equals("O"))
                {
                    raider=1;
                }
            }
            if (i - 1 != -1) {
                if (matori[i-1][j].equals("O"))
                {
                    raider=1;
                }
            }



            if(raider==1) {
                if (j - 1 != -1) {
                    if (matori[i][j - 1].equals("X")) {

                        raiding="Raid";
                    }
                }
                if (j + 1 != size) {
                    if (matori[i][j + 1].equals("X")) {

                        raiding="Raid";
                    }
                }
                if (i + 1 != size) {
                    if (matori[i + 1][j].equals("X")) {

                        raiding="Raid";
                    }
                }
                if (i - 1 != -1) {
                    if (matori[i - 1][j].equals("X")) {

                        raiding="Raid";
                    }
                }
            }
        }

        if(youplay.equals("X")) {

            if (j - 1 != -1) {
                if (matori[i][j - 1].equals("X"))
                {
                    raider=1;
                }
            }
            if (j + 1 != size) {
                if (matori[i][j + 1].equals("X"))
                {
                    raider=1;
                }
            }
            if (i + 1 != size) {
                if (matori[i+1][j].equals("X"))
                {
                    raider=1;
                }
            }
            if (i - 1 != -1) {
                if (matori[i-1][j].equals("X"))
                {
                    raider=1;
                }
            }

            if(raider==1) {
                if (j - 1 != -1) {
                    if (matori[i][j - 1].equals("O")) {

                        raiding="Raid";
                    }
                }
                if (j + 1 != size) {
                    if (matori[i][j + 1].equals("O")) {

                        raiding="Raid";
                    }
                }
                if (i + 1 != size) {
                    if (matori[i + 1][j].equals("O")) {

                        raiding="Raid";
                    }
                }
                if (i - 1 != -1) {
                    if (matori[i - 1][j].equals("O")) {

                        raiding="Raid";
                    }
                }
            }
        }
        */

        return raiding;
    }

    public void printans(String originalmat[][],String mat[][],int size,String youplay,String bestmove)
    {
        String raider=checkraid(originalmat,size,youplay,bestmove);
        System.out.println(bestmove+" "+raider);
        for(int i=0;i<size;i++)
        {
            for (int j=0;j<size;j++)
            {
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
    }

    public int eval(String mat[][],int matvalue[][],int size,String youplay)
    {
        int count1=0;
        int count2=0;
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(mat[i][j].equals("X"))
                {count1+=matvalue[i][j];
                    }

                if(mat[i][j].equals("O"))
                {
                    count2+=matvalue[i][j];

                }
            }
        }
       // System.out.println(count1);
       // System.out.println(count2);
        if(youplay.equals("O"))
        {return count2-count1;}
        else
        {
            return count1-count2;
        }
    }

    public int minimax(String matrix[][],int matvalue[][],int size, String youplay,int level,int depth,String original_youplay)
    {
        ArrayList<String> newmoves=nextmovesgeneral(matrix,size,youplay);
        String tempmat[][]=copy(matrix,size);

        String newplay="";
        int bestscore=(level%2==0)?-Integer.MAX_VALUE:Integer.MAX_VALUE;
        if(depth==level)
        {

          //  System.out.println("inside eval");
            //printmatrix(tempmat,size);
            bestscore=eval(tempmat,matvalue,size,original_youplay);
          //  System.out.println(bestscore);
            return bestscore;
        }
        else
        {
            if(youplay.equals("O"))
            {
                newplay="X";
            }
            else
            {
                newplay="O";
            }
            for(int i=0;i<newmoves.size();i++)
            {

                String newmat[][]=tempmatchanges(tempmat,size,newmoves.get(i),newplay);
                //printmatrix(newmat,size);


                int currentscore=minimax(newmat,matvalue,size,newplay,level+1,depth,original_youplay);
            //    System.out.println(currentscore);
                if(level%2==0) {
                    if (currentscore > bestscore) {
                        bestscore = currentscore;
                      //  System.out.println(bestscore);
                    }

                }
                else
                {
                    if(currentscore<bestscore) {
                        bestscore = currentscore;
                   //     System.out.println(bestscore);
                    }
                }

            }
        }
        return bestscore;
    }






    //ALPHABETA

    public int alphabeta(String mat[][], int matrix1[][], int size, String youplay, int level, int depth, String original_youplay,int bestalpha,int bestbeta)
    {
        int tempvaluealpha=-Integer.MAX_VALUE;
        int tempvaluebeta=Integer.MAX_VALUE;
       // int alpha=bestalpha;
        //int beta=bestbeta;
        String newplay="";
        int bestscore=Integer.MIN_VALUE;
        int currentscore;
        ArrayList<String> newmoves=nextmovesgeneral(mat,size,youplay);
        String tempmat[][]=copy(mat,size);
        //System.out.println(newmoves);
        if(depth==level)
        {
           // System.out.println("inside eval");
            bestscore=eval(tempmat,matrix1,size,original_youplay);
           // System.out.println(bestscore);
            return bestscore;
        }

        else
        {
            if(youplay.equals("O"))
            {
                newplay="X";
            }
            else
            {
                newplay="O";
            }
            for(int i=0;i<newmoves.size();i++)
            {

                String newmat[][]=tempmatchanges(tempmat,size,newmoves.get(i),newplay);
                //printmatrix(newmat,size);


                currentscore=alphabeta(newmat,matrix1,size,newplay,level+1,depth,original_youplay,bestalpha,bestbeta);
               // System.out.println(currentscore);
                if(level%2==0) {
                    if(currentscore>=bestbeta)
                        {
                            return currentscore;
                    }
                    bestalpha=Math.max(bestalpha,currentscore);
                    /*if(tempvaluealpha<currentscore)
                    {tempvaluealpha=currentscore;}
                    *

                   /* if (currentscore > alpha) {
                        alpha = currentscore;
                        if(bestbeta<=alpha)
                        {
                            return alpha;
                        }

                      //  System.out.println(bestscore);
                    }*/

                }
                else
                {
                    if(currentscore<=bestalpha)
                    {
                        return currentscore;
                    }
                    bestbeta=Math.min(bestbeta,currentscore);
                }

            }
        }
        if(level%2==0) {
            return bestalpha;
        }
        else
        {
            return bestbeta;
        }

    }




    public void CreateTreeAlphaBeta(int depth, int matrix1[][], String matrix2[][], String youplay, int size, String algo) throws IOException
    {
        int bestalpha=-Integer.MAX_VALUE;
        int bestbeta=Integer.MAX_VALUE;
        String original_youplay=youplay;
        String checkraidstake="";
        String tempraidstake="";
        ArrayList<String> newmoves=nextmovesgeneral(matrix2,size,youplay);

        int spacesinthegrid=spaces(matrix2,size);

        if(depth>spacesinthegrid)
        {
            depth=spacesinthegrid;
        }


        String tempmat[][]=copy(matrix2,size);
        //System.out.println(newmoves);
        String bestmove="";
        String bestmat[][]=new String[size][size];
        for(int i=0;i<newmoves.size();i++) {
            String newmat[][] = tempmatchanges(tempmat, size, newmoves.get(i), youplay);
            //printmatrix(newmat, size);
            int currentscore = alphabeta(newmat, matrix1, size, youplay, 1, depth, original_youplay,bestalpha,bestbeta);
           // System.out.println("current score " + currentscore);
            if (currentscore > bestalpha) {
                bestalpha = currentscore;
                bestmove = newmoves.get(i);
                bestmat = newmat;
              //  System.out.println("bestmove "+ bestmove);
             //   System.out.println("bestscore "+bestalpha);
                String matrixtocheckvalueraidstake1[][]=copy(matrix2,size);
                //checkraidstake = checkraid(matrix2, size, youplay, bestmove);
              //  System.out.println(checkraidstake);
            }

          /*  else if (currentscore == bestalpha) {


                String matrixtocheckvalueraidstake2[][]=copy(matrix2,size);
                //checkraidstake=checkraid(matrixtocheckvalueraidstake1,size,youplay,bestmove);
                tempraidstake=checkraid(matrixtocheckvalueraidstake2,size,youplay,newmoves.get(i));

                if (checkraidstake.equals("Raid") && tempraidstake.equals("Stake")) {
                    bestalpha = currentscore;
                    bestmove = newmoves.get(i);
                    bestmat = newmat;
                    System.out.println("tie beak bestmove "+ bestmove);
                    System.out.println("tie break bestscore "+bestalpha);

                    checkraidstake = tempraidstake;
                }
            }*/
        }
        String mainmatrix[][]=copy(matrix2,size);
        writeans(mainmatrix,bestmat,size,youplay,bestmove);
       // System.out.println(bestalpha);


    }







    public static void main(String[] args) throws IOException {
        String list[]=reader();
        int size=Integer.parseInt(list[0]);
        String algo=list[1];
        String youplay=list[2];
        int depth=Integer.parseInt(list[3]);
        int matrix1[][]=new int[size][size];
        String matrix2[][]=new String[size][size];
        int k=4;
        String arr[]=new String[size];
        for(int i=0;i<size;i++)
        {
            arr=list[k].split(" ");
            for(int j=0;j<size;j++)
            {
                matrix1[i][j]=Integer.parseInt(arr[j]);
            }
            k++;
        }
        k=size+4;
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                matrix2[i][j]= String.valueOf(list[k].charAt(j));
            }
            k++;
        }



        //PRINTING STARTS

       // System.out.println(size);
       // System.out.println(algo);
      //  System.out.println(youplay);
     //   System.out.println(depth);
        /*
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                System.out.print(matrix1[i][j]);
            }
            System.out.println();
        }
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                System.out.print(matrix2[i][j]);
            }
            System.out.println();
        }*/
        final long startTime = System.currentTimeMillis();


        //PRINTING ENDS


        // CREATE TREE
        homework h=new homework();
        if(algo.equals("MINIMAX")) {
            h.CreateTree(depth, matrix1, matrix2, youplay, size, algo);
        }
        if(algo.equals("ALPHABETA"))
        {
            h.CreateTreeAlphaBeta(depth, matrix1, matrix2, youplay, size, algo);
        }

        final long endTime = System.currentTimeMillis();

       // System.out.println("Total execution time: " + (endTime - startTime) );
        //int ansis=h.eval(matrix2,matrix1,size,youplay);
        //System.out.println(ansis);

    }




    public static String[] reader() throws IOException
    {

        FileReader fr=new FileReader("input.txt");
        BufferedReader br=new BufferedReader(fr);
        String c;
        int lines=0;
        while((c=br.readLine())!=null)
            lines++;
        String arr[]=new String[lines];
        int i=0;
        br.close();
        FileReader fr2=new FileReader("input.txt");
        BufferedReader br2=new BufferedReader(fr2);
        while((c=br2.readLine())!=null) {
            arr[i]=c;
            i++;
        }
        br.close();
        return arr;
    }
    public void writeans(String originalmat[][],String mat[][],int size,String youplay,String bestmove) throws IOException
    {
        FileWriter fw = new FileWriter("output.txt");
        PrintWriter pw = new PrintWriter(fw);

        String raider=checkraid(originalmat,size,youplay,bestmove);
        if(bestmove.charAt(bestmove.length()-1)=='-')
    {
        bestmove=bestmove.substring(0,bestmove.length()-1);
    }
        pw.println(bestmove+" "+raider);
        for(int i=0;i<size;i++)
        {
            for (int j=0;j<size;j++)
            {
               pw.print(mat[i][j]);
            }
            pw.println();
        }


        fw.close();
    }
}
