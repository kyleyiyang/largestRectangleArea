class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans=0;
        Stack<Integer> stack=new Stack<>();
        for (int i=0;i<=heights.length;i++) {
            int h=(i==heights.length?0:heights[i]);
            if (stack.isEmpty() || h>=heights[stack.peek()]) {
                stack.push(i);
            } else {
                ans=Math.max(ans,heights[stack.pop()]*(stack.isEmpty()?i:(i-stack.peek()-1)));
                i--;
            }
        }
        return ans;
    }
}

****************************

class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans=0;
        int[] left=new int[heights.length]; //the far left index where heights[left[i]]>=heights[i]
        int[] right=new int[heights.length]; //the far right index where heights[right[i]]>=heights[i]
        left[0]=-1;
        right[heights.length-1] = heights.length;
        for (int i=1;i<heights.length;i++) {
            int j=i-1;
            while (j>=0 && heights[j]>=heights[i]) {
                j=left[j];
            }  
            left[i]=j;
        }
        for (int i=heights.length-2;i>=0;i--) {
            int j=i+1;
            while (j<heights.length && heights[j]>=heights[i]) {
                j=right[j];
            } 
            right[i]=j;
        }
        for (int i=0;i<heights.length;i++) {
            ans=Math.max(ans, heights[i]*(right[i]-left[i]-1));
        }
        return ans;
    }
}
