package 剑指offer;

public class duplicate {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers==null || length<=0){
            return false;
        }
        int pos = 0;
        while(pos<length){
            int num = numbers[pos];
            if(num == pos){
                pos++;
            }else{
                if(num == numbers[num]){
                    duplication[0] = num;
                    return true;

                }else{
                    numbers[pos] = numbers[num];
                    numbers[num] = num;
                }
            }
        }
        return false;
    }
}
