import java.io.*;
import java.util.*;
class Practice
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        int[] sampleArr = {5,6,7,0,1,2,3,4};
        System.out.println("Target number: ");
        int target = scan.nextInt();
        // System.out.println("target numer is : "+(target));
        int left = 0;
        int right = sampleArr.length-1;
        int indexNo = findNumber(sampleArr, target, left, right);
        if(indexNo==-1)
        { System.out.println("Not found!");}
        else
        {   System.out.println("The index is: "+indexNo);   }
    }

    private static int findNumber(int[] sampleArr, int target, int left, int right)
    {
        int mid = (right-left)/2;

        if (left>right)
        {   return -1;  }
        if (sampleArr[mid]==target)
        {   return mid;  }
        if ( (sampleArr[left]==target) )
        {   return left; }
        if( (sampleArr[right]==target)  )
        { return right;  }


        // Check if right side is sorted
        if( sampleArr[mid]<sampleArr[right]  )
        {
            if(target>sampleArr[mid] && target<sampleArr[right])
            {   findNumber(sampleArr, target, mid+1, right);    }
            else
            {   findNumber(sampleArr, target, left , mid-1); }
        }
        // check if left side is UnsupportedOperationException
        if (sampleArr[left]<sampleArr[mid])
        {
            if(target>sampleArr[left] && target<sampleArr[mid])
            {
                findNumber(sampleArr, target, left, mid-1);
            }
            else
            {
                findNumber(sampleArr, target, mid+1, right );
            }
        }
        return -1;
    }
}