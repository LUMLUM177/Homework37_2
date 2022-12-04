import main.service.IntegerList;
import main.service.IntegerListImpl;

import java.util.Arrays;

public class Main {

    public static Integer[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        Integer[] arr = new Integer[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }

    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    public static void sortBubble(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    public static void sortSelection(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    public static void sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {

        Integer[] arr = generateRandomArray();

        Integer[] arr2 = Arrays.copyOf(arr, arr.length);

        Integer[] arr3 = Arrays.copyOf(arr, arr.length);

//        long start = System.currentTimeMillis();
//        sortBubble(arr);
//        System.out.println(System.currentTimeMillis() - start);
        // время выполнения - 67105

//        long start2 = System.currentTimeMillis();
//        sortSelection(arr2);
//        System.out.println(System.currentTimeMillis() - start2);
        // время выполнения - 30821

//        long start3 = System.currentTimeMillis();
//        sortInsertion(arr3);
//        System.out.println(System.currentTimeMillis() - start3);
        // время выполнения - 28666, значит сортировка методом вставки является самым быстрым, и этот метод
        // добавим в реализацию нашего класса

        IntegerListImpl arrayList = new IntegerListImpl();

        System.out.println(arrayList.isEmpty());

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        System.out.println(arrayList.contains(1));

        arrayList.add(1, 10);
        System.out.println(arrayList);

        Integer num = 3;
        arrayList.remove(num);
        System.out.println(arrayList);

        arrayList.remove(2);
        System.out.println(arrayList);

        System.out.println(arrayList.indexOf(num));
        System.out.println(arrayList.indexOf(2));

        System.out.println(arrayList.lastIndexOf(4));
        System.out.println(arrayList.lastIndexOf(10));

        System.out.println(arrayList.get(0));
        IntegerList otherList = new IntegerListImpl(5);

        arrayList.equals(otherList);

        System.out.println(arrayList.size());

        System.out.println(arrayList.isEmpty());

        arrayList.clear();
        System.out.println(arrayList);

    }
}