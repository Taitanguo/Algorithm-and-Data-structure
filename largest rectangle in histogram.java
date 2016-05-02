//强行破解法
public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] min = new int[height.length];
        int maxArea = 0;
        for(int i = 0; i < height.length; i++){
            if(height[i] != 0 && maxArea/height[i] >= (height.length - i)) {
                continue;
            }
            for(int j = i; j < height.length; j++){
                if(i == j) min[j] = height[j];
                else {
                    if(height[j] < min[j - 1]) {
                        min[j] = height[j];
                    }else min[j] = min[j-1];
                }
                int tentativeArea = min[j] * (j - i + 1);
                if(tentativeArea > maxArea) {
                    maxArea = tentativeArea;
                }
            }
        }
        return maxArea;
    }


public class Solution {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= height.length; i++) {
            int curt = (i == height.length) ? -1 : height[i];
            while (!stack.isEmpty() && curt <= height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }

        return max;
    }
}