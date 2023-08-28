package practice;

public class CodingPractice {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 7, 10, 14, 15, 21, 35, 70};
        printHelloWorld(numbers);
        System.out.println(findSecondBiggest(numbers));
    }

    public static void printHelloWorld(int[] numbers) {
        for (int num : numbers) {
            if (num % 5 == 0 && num % 7 == 0) {
                System.out.println("HelloWorld");
            } else if (num % 5 == 0) {
                System.out.println("Hello");
            } else if (num % 7 == 0) {
                System.out.println("World");
            }
        }
    }

    public static int findSecondBiggest(int[] numbers) {
        if (numbers.length < 2) {
            throw new IllegalArgumentException("The array should have at least two numbers.");
        }

        int biggest, secondBiggest;

        if (numbers[0] > numbers[1]) {
            biggest = numbers[0];
            secondBiggest = numbers[1];
        } else {
            biggest = numbers[1];
            secondBiggest = numbers[0];
        }

        for (int i = 2; i < numbers.length; i++) {
            if (numbers[i] > biggest) {
                secondBiggest = biggest;
                biggest = numbers[i];
            } else if (numbers[i] > secondBiggest) {
                secondBiggest = numbers[i];
            }
        }

        return secondBiggest;
    }

}
