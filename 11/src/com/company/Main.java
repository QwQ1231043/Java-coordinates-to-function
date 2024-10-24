package com.company;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        // write your code here
        Coordinates_To_function();
    }

    public static double [][] Matrix_multiplication(double[][] x, double[][] y){
        double[][] k= new double[x.length][y[0].length];
        ArrayList<Double> hh=new ArrayList<Double>();
        int p=0;
        if(x[0].length==y.length){

            for(int i=0;i<x.length;i++) {
                for(int j=0;j<y[0].length;j++){
                    int n=0;
                    double value=0;
                    while(n<x[0].length){
                        value+=x[i][n]*y[n][j];
                        n++;
                    }
                    k[i][j]=value;
                }
            }
            return k;}

        else {System.out.println("These two multrix cannot multiply to each other"); return k;}
    }//make two matrix times together.

    public static void Matrix_method_solving_regular_equation_unknownVariable(){

        Scanner kk=new Scanner(System.in);
        int number_coordinates= kk.nextInt();
        int jj=0;

        ArrayList<Double> sumy= new ArrayList<Double>();



        System.out.println("Please insert the left part of the equation");
        double[][] x=Return_matrix();
        number_coordinates=x[0].length;
        System.out.println("Please insert the right part (only constant) of the equation");
        while(jj<number_coordinates){
            double temp=0;
            System.out.println("Please enter coordinate y of "+jj);
            temp=kk.nextDouble();
            sumy.add(temp);
            jj++;
        }
        double[][] y_matrix=new double[number_coordinates][1];
        for(int i=0;i<number_coordinates;i++){
            y_matrix[i][0]=sumy.get(i);
        }

        System.out.println();
        System.out.println();
        printMatrix(Reduced_Row_Echolo_Form(y_matrix,x,number_coordinates),number_coordinates);
        printMatrix(Reduced_Row_Echolo_Form_Solutions(y_matrix,x,number_coordinates),number_coordinates);
    }



    public static double[][] Return_matrix(){
        int number_of_rows=0;
        int number_of_columns=0;
        ArrayList<Double> sumx= new ArrayList<Double>();
        Scanner kk=new Scanner(System.in);
        System.out.println("Please enter the number of row");
        number_of_rows= kk.nextInt();
        System.out.println("Please enter the number of column");
        number_of_columns= kk.nextInt();
        int jj=0;
        int o=1;
        while(jj<number_of_rows){
            System.out.println("Please enter the "+o+" row");
            int gg=0;
            while(gg<number_of_columns){
                double temp=kk.nextDouble();
                sumx.add(temp);
                gg++;}
            o++;
            jj++;}
        double [][] k= new double[ number_of_rows][number_of_columns];
        int p=0;
        for(int i=0;i<number_of_rows;i++){
            for(int j=0;j<number_of_columns;j++){
                k[i][j]=sumx.get(p);p++;
            }
        }
        printMatrix(k);
        return k;
    }//Record the matrix entered by the user



    public static void printMatrix(double [][] x){
        for(int i=0;i<x.length;i++){
            for(int j=0;j<x[0].length;j++){
                System.out.print(x[i][j]+" ");
            }
            System.out.println();
        }
    }


    public static void Coordinates_To_function(){  Scanner kk=new Scanner(System.in);
        System.out.println("Please enter the number of coordinates");
        int number_coordinates= kk.nextInt();
        int jj=0;
        ArrayList<Double> sumx= new ArrayList<Double>();
        ArrayList<Double> sumy= new ArrayList<Double>();

        while(jj<number_coordinates){
            System.out.
                    println("Please enter coordinate x of "+jj);
            double temp=kk.nextDouble();
            sumx.add(temp);
            System.out.println("Please enter coordinate y of "+jj);
            temp=kk.nextDouble();
            sumy.add(temp);
            jj++;
        }



        double[][] x=new double[number_coordinates][number_coordinates];
        for(int j=0;j<number_coordinates;j++) {
            for (int i =0; i<number_coordinates; i++) {
                x[j][i] =Math.pow(sumx.get(j),number_coordinates-i-1);
                System.out.print(x[j][i]+" ");
            }
            System.out.println();
        }
        double[][] y_matrix=new double[number_coordinates][1];
        for(int i=0;i<number_coordinates;i++){
            y_matrix[i][0]=sumy.get(i);
        }
        System.out.println();
        System.out.println();
        printMatrix(Guass_Backward_Subsituation(y_matrix,x,number_coordinates),number_coordinates);
        printMatrix(Guass_Backward_Subsituation_Temporary_Solution(y_matrix,x,number_coordinates),number_coordinates);
        System.out.println();
        System.out.println();
        printMatrix(Reduced_Row_Echolo_Form(y_matrix,x,number_coordinates),number_coordinates);
        printMatrix(Reduced_Row_Echolo_Form_Solutions(y_matrix,x,number_coordinates),number_coordinates);}// a method helps us to find the expression of the provided coordinates



    public static void printMatrix (double[][] o,int number_coordinates){
        if(o[0].length==number_coordinates){
            for(int i=0;i<number_coordinates;i++){
                for(int j=0;j<number_coordinates;j++){
                    System.out.print(o[i][j]);
                    System.out.print(" ");
                }
                System.out.println();

            }}
        else{          for (int p = 0; p < number_coordinates; p++) {
            System.out.println(o[p][0]);
        }for(int i=0;i<number_coordinates;i++){if(i==number_coordinates-1){System.out.print(o[i][0]+"x^"+(number_coordinates-1-i)+"=y");}else System.out.print(o[i][0]+"x^"+(number_coordinates-i-1)+"+ ");}
        }

    }//help print out the matrix


    public static double[][] Guass_Backward_Subsituation(double[][] y_matrix, double[][] x, int number_coordinates){
        for(int i=0;i<number_coordinates;i++) {
            for (int j = 0; j < number_coordinates; j++) {
                if (j >= i) {
                    if (i == j) {
                        if (x[j][i] != 1) {
                            double temp2 = x[j][i];
                            for (int k =0; k < number_coordinates; k++) {
                                x[i][k] = x[i][k] / temp2;

                            }
                            y_matrix[j][0]/=temp2;
                        }
                    } else if(i!=j){
                        double temp3 = x[j][i];
                        int t=0;
                        for (int k = 0; k < number_coordinates; k++) {
                            int u=1;
                            int g=1;
                            for(int h=0;h<100;h+=0){
                                if((j-g)!=i){u+=1;g++;}
                                else{h=100;}}
                            x[j][k] = x[j][k] - temp3*x[j-u][k];
                            if(t==0){
                                y_matrix[j][0] = y_matrix[j][0] - temp3*y_matrix[j-u][0];t++;}
                        }

                    }
                }

            }
        }return x;}


    public static double[][] Guass_Backward_Subsituation_Temporary_Solution(double[][] y_matrix, double[][] x, int number_coordinates){
        for(int i=0;i<number_coordinates;i++) {
            for (int j = 0; j < number_coordinates; j++) {
                if (j >= i) {
                    if (i == j) {
                        if (x[j][i] != 1) {
                            double temp2 = x[j][i];
                            for (int k =0; k < number_coordinates; k++) {
                                x[i][k] = x[i][k] / temp2;

                            }
                            y_matrix[j][0]/=temp2;
                        }
                    } else if(i!=j){
                        double temp3 = x[j][i];
                        int t=0;
                        for (int k = 0; k < number_coordinates; k++) {
                            int u=1;
                            int g=1;
                            for(int h=0;h<100;h+=0){
                                if((j-g)!=i){u+=1;g++;}
                                else{h=100;}}
                            x[j][k] = x[j][k] - temp3*x[j-u][k];
                            if(t==0){
                                y_matrix[j][0] = y_matrix[j][0] - temp3*y_matrix[j-u][0];t++;}
                        }

                    }
                }

            }
        }return y_matrix;}






    public static double[][] Reduced_Row_Echolo_Form(double[][] y_matrix, double[][] x, int number_coordinates){
        for(int i=0;i<number_coordinates;i++) {
            for (int j = 0; j < number_coordinates; j++) {
                if (j >= i) {
                    if (i == j) {
                        if (x[j][i] != 1) {
                            double temp2 = x[j][i];
                            for (int k =0; k < number_coordinates; k++) {
                                x[i][k] = x[i][k] / temp2;

                            }
                            y_matrix[j][0]/=temp2;
                        }
                    } else if(i!=j){
                        double temp3 = x[j][i];
                        int t=0;
                        for (int k = 0; k < number_coordinates; k++) {
                            int u=1;
                            int g=1;
                            for(int h=0;h<100;h+=0){
                                if((j-g)!=i){u+=1;g++;}
                                else{h=100;}}
                            x[j][k] = x[j][k] - temp3*x[j-u][k];
                            if(t==0){
                                y_matrix[j][0] = y_matrix[j][0] - temp3*y_matrix[j-u][0];t++;}
                        }

                    }
                }

            }
        }
        for(int j=0;j<number_coordinates;j++){
            for(int i=0;i<number_coordinates;i++){
                if(i>=j){
                    if(i!=j){
                        int u=1;
                        int t=0;
                        while(t==0){if((j+u)!=i){u++;}else{t+=1;}}
                        if(x[j][i]!=0){
                            double temp3=x[j][i];
                            for(int k=i;k<number_coordinates;k++){x[j][k]=x[j][k]-temp3*x[j+u][k];
                            }  y_matrix[j][0]=y_matrix[j][0]-temp3*y_matrix[j+u][0]; }
                    }
                }
            }
        }
        return x;
    }
    public static double[][] Reduced_Row_Echolo_Form_Solutions(double[][] y_matrix, double[][] x, int number_coordinates){
        for(int i=0;i<number_coordinates;i++) {
            for (int j = 0; j < number_coordinates; j++) {
                if (j >= i) {
                    if (i == j) {
                        if (x[j][i] != 1) {
                            double temp2 = x[j][i];
                            for (int k =0; k < number_coordinates; k++) {
                                x[i][k] = x[i][k] / temp2;

                            }
                            y_matrix[j][0]/=temp2;
                        }
                    } else if(i!=j){
                        double temp3 = x[j][i];
                        int t=0;
                        for (int k = 0; k < number_coordinates; k++) {
                            int u=1;
                            int g=1;
                            for(int h=0;h<100;h+=0){
                                if((j-g)!=i){u+=1;g++;}
                                else{h=100;}}
                            x[j][k] = x[j][k] - temp3*x[j-u][k];
                            if(t==0){
                                y_matrix[j][0] = y_matrix[j][0] - temp3*y_matrix[j-u][0];t++;}
                        }

                    }
                }

            }
        }
        for(int j=0;j<number_coordinates;j++){
            for(int i=0;i<number_coordinates;i++){
                if(i>=j){
                    if(i!=j){
                        int u=1;
                        int t=0;
                        while(t==0){if((j+u)!=i){u++;}else{t+=1;}}
                        if(x[j][i]!=0){
                            double temp3=x[j][i];
                            for(int k=i;k<number_coordinates;k++){x[j][k]=x[j][k]-temp3*x[j+u][k];
                            }  y_matrix[j][0]=y_matrix[j][0]-temp3*y_matrix[j+u][0]; }
                    }
                }
            }
        }
        return y_matrix;
    }

}
