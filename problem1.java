import java.util.ArrayList;
import java.util.List;


class problem1 
{
    public int[] resultArray(int[] nums) 
    {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        arr1.add(nums[0]);
        arr2.add(nums[1]);

        for(int i = 2; i < nums.length; i++)
        {
            if(arr1.get(arr1.size() - 1) > arr2.get(arr2.size() - 1))
            {
                arr1.add(nums[i]);
            }
            else
            {
                arr2.add(nums[i]);
            }
        }

        int[] result = new int[nums.length];
        int index = 0;

        for(int num : arr1)
        {
            result[index++] = num;
        }

        for(int num : arr2)
        {
            result[index++] = num;
        }

        return result;
    }

    public static void main(String[] args) 
    {
        problem1 obj = new problem1();

        int[] nums = {5,4,3,8};

        int[] result = obj.resultArray(nums);

        for (int num : result) 
        {
            System.out.print(num + " ");
        }

        System.out.println();
    }
}