package com.sort;

public class QuickSort {
    /**
     * 快排
     * @param numbers
     * @param begin
     * @param end
     */
    public static void quickSortCore(int[] numbers,int begin,int end){
        if(begin<end){
            int key = split(numbers,begin,end);
            quickSortCore(numbers,begin,key-1);
            quickSortCore(numbers,key+1,end);
        }
    }
    public static int split(int[] numbers,int begin,int end){
        int stan = numbers[begin];
        int i = begin;
        int j = end;
        while(i<j){
            while(numbers[j]>=stan&&i<j){
                j--;
            }
            numbers[i] = numbers[j];
            while(numbers[i]<stan&&i<j){
                i++;
            }
            numbers[j] = numbers[i];
        }
        numbers[i] = stan;
        return i;
    }

    /**
     * 归并排序
     * @param numbers
     * @param pnumbers
     * @param begin
     * @param end
     */
    public static void mergeSort(int[] numbers,int[] pnumbers,int begin,int end){
        if(begin<end){
            int key = (begin + end) / 2;
            mergeSort(numbers,pnumbers,begin,key);
            mergeSort(numbers,pnumbers,key+1,end);
            merger(numbers,pnumbers,begin,key,end);
        }
    }
    public static void merger(int[] numbers,int[] pnumbers,int first_begin,int key,int second_end){
        int i = first_begin;
        int j = key + 1;
        int k = 0;
        while(i<=key && j<=second_end){
            if(numbers[i] < numbers[j]){
                pnumbers[k++] = numbers[i++];
            }else{
                pnumbers[k++] = numbers[j++];
            }
        }
        while(i<=key)
            pnumbers[k++] = numbers[i++];
        while(j<=second_end)
            pnumbers[k++] = numbers[j++];
        k = 0;
        for(i=first_begin;i<=second_end;i++){
            numbers[i] = pnumbers[k++];
        }
    }

    public static void heapSortCore(int[] numbers){
        //先建大顶堆
        for(int i=numbers.length/2;i>=0;i--){
            adjust(numbers,i,numbers.length);
        }
        for(int i:numbers)
            System.out.print(i+" ");
        System.out.println();
        for(int i=numbers.length-1;i>0;i--){
            swap(numbers,0,i);
            adjust(numbers,0,i);
        }
        for(int i:numbers)
            System.out.println(i);

    }
    public static void adjust(int[] numbers,int fatherIndex,int length){
        int rootValue = numbers[fatherIndex];
        int childIndex = fatherIndex * 2 + 1;
        while(childIndex < length){

            if (length > (childIndex+1) && numbers[childIndex+1] > numbers[childIndex]){
                childIndex++;
            }
            if (rootValue >= numbers[childIndex]){
                break;
            }
            numbers[fatherIndex] = numbers[childIndex];

            fatherIndex = childIndex;
            childIndex = fatherIndex * 2 + 1;
        }
        numbers[fatherIndex] = rootValue;
    }
    public static void swap(int[] numbers,int fatherIndex,int childIndex){
        int tem = numbers[fatherIndex];
        numbers[fatherIndex] = numbers[childIndex];
        numbers[childIndex] = tem;
    }
    /**
     *测试
     * @param args
     */

    public static void main(String[] args){
        int[] numbers = {1,2,3,5,4,6,7,8,0,9};
//        quickSortCore(numbers,0,numbers.length-1);
//        for(int tem : numbers)
//            System.out.println(tem);
        int[] pnumbers = new int[13];
//        mergeSort(numbers,pnumbers,0,numbers.length-1);
//        for(int tem : numbers)
//            System.out.println(tem);
        heapSortCore(numbers);
    }

}
