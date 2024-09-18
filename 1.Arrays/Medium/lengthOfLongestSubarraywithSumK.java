import java.util.HashMap;

public class lengthOfLongestSubarraywithSumK 
{
    public static int lenOfLongSubarr(int A[], int N, int K) {
        
        int sum=0;
        int maxlen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++)
        {
            sum+=A[i];
            if(sum==K)
            {
                maxlen = i+1;
            }
            if(map.containsKey(sum-K))
            {
                maxlen = Math.max(maxlen, i-map.get(sum-K));
            }
            if(!map.containsKey(sum))
            {
                map.put(sum, i);
            }
        }
        return maxlen;
    }
}
