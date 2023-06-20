import java.util.*;
class Solution {
    public static int trap(int height[]){
        int n=height.length;
        //calculate left max boundary-Auxiliary Array
        int leftMax[]=new int[n];
        leftMax[0]=height[0];
        for(int i=1;i<n;i++){
            leftMax[i]=Math.max(height[i],leftMax[i-1]);
            //after loop complted, leftMax[]={4,4,4,6,6,6,6}
        }
        
        //calculate right max boundary-Auxiliary Array
        int rightMax[]=new int[n];
        rightMax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            rightMax[i]=Math.max(height[i],rightMax[i+1]);
            //after loop complted, leftMax[]={6,6,6,6,5,5,5}
        }
        
        int trappedWater=0;
        //loop 
        for(int i=0; i<n;i++){
            //waterLevel =min(left max bound, right max bound)
            int waterLevel=Math.min(leftMax[i],rightMax[i]);
            //waterLevel ={4,4,4,6,5,5,5}
            
            //trapped water= waterlevel-height[i]
            trappedWater+=waterLevel- height[i];
        }
        return trappedWater;
    }
}