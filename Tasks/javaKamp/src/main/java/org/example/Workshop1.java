package org.example;

public class Workshop1 {
    public static void main(String[] args) {

        int[] numbers = new int[]{1,2,5,7,9};
        int checkNumber = 9;
        boolean hasNumber = findNumber(numbers,9);

        showMessage(hasNumber,checkNumber);
    }


    public static void showMessage(boolean hasNumber, int checkNumber){

        String message = " ";

        if (hasNumber == true){
            message = "List has a number " + checkNumber;
            System.out.println(message);
        }else{
            message = "List has not a number " + checkNumber;
            System.out.println(message);
        }
    }

    public static boolean findNumber(int[] numbers,int checkNumber){

        boolean hasNumber = false;

        for (int number : numbers) {

            if (number == checkNumber){
                hasNumber = true;
                break;
            }
        }

        return hasNumber;
    }
}
