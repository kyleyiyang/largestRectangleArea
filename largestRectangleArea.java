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
