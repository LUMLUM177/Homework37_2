package main.service;

import main.exception.WorkingArrayIntegerListException;
import main.service.IntegerList;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {

    private final Integer[] arrayList;

    private int size;

    public IntegerListImpl() {
        arrayList = new Integer[7];
    }

    public Integer[] getArrayList() {
        return arrayList;
    }

    public IntegerListImpl(int size) {
        this.arrayList = new Integer[size];
    }

    @Override
    public Integer add(Integer item) {
        validateItem(item);
        validateSizeArray();
        arrayList[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateItem(item);
        validateSizeArray();
        validateIndex(index);

        if (index == size) {
            arrayList[size++] = item;
            return item;
        }

        System.arraycopy(arrayList, index, arrayList, index + 1, size - index);
        arrayList[index] = item;
        size++;

        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateItem(item);
        validateSizeArray();
        arrayList[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validateItem(item);

        int index = indexOf(item);

        return remove(index);
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);

        Integer item = arrayList[index];

        if (index != size) {
            System.arraycopy(arrayList, index + 1, arrayList, index, size - index);
        }

        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        sortInsertion();
        validateItem(item);

        return binarySearch(item);
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (arrayList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (arrayList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return arrayList[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(arrayList, size);
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new WorkingArrayIntegerListException("Array is full! Invalid index to add.");
        }
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new WorkingArrayIntegerListException("Item is null.");
        }
    }

    private void validateSizeArray() {
        if (arrayList.length == size) {
            throw new WorkingArrayIntegerListException("Array is full!");
        }
    }

    public void sortInsertion() {
        for (int i = 1; i < size; i++) {
            int temp = arrayList[i];
            int j = i;
            while (j > 0 && arrayList[j - 1] >= temp) {
                arrayList[j] = arrayList[j - 1];
                j--;
            }
            arrayList[j] = temp;
        }
    }

    private boolean binarySearch(Integer item) {
        int min = 0;
        int max = arrayList.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == arrayList[mid]) {
                return true;
            }

            if (item < arrayList[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "IntegerListImpl{" +
                "arrayList=" + Arrays.toString(arrayList) +
                ", size=" + size +
                '}';
    }
}
