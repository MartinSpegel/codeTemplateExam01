package Array;

import java.util.*;


public class ArrayFunctions {


    public static void main(String... args) {
        int[] array = {1, 2, 3};
        twoSum(array, 5);
    }

    public static int[] reverseArray(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int inter = array[left];
            array[left] = array[right];
            array[right] = inter;

            left++;
            right--;
        }
        return array;
    }

    public static void reverseArray2(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            // Swap elements at start and end indices
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            // Move indices towards the center
            start++;
            end--;
        }
    }

    public static int[] intoArray(int n) {
        if (n == 0) return new int[]{0};
        int length = 0;
        int copy = n;
        while (copy != 0) {
            length++;
            copy /= 10;
        }

        int[] out = new int[length];
        for (int i = 0; i < length; i++) {
            out[i] = n % 10;
            n /= 10;
        }
        return out;
    }

    public static void rotateArray(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // Handle cases where k is greater than array length

        reverseArray(arr, 0, n - 1);         // Reverse the whole array
        reverseArray(arr, 0, k - 1);         // Reverse the first part
        reverseArray(arr, k, n - 1);         // Reverse the second part
    }

    private static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static int removeDuplicates(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        int uniqueIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[uniqueIndex]) {
                uniqueIndex++;
                arr[uniqueIndex] = arr[i];
            }
        }

        return uniqueIndex + 1;
    }

    public static int maxSubArraySum(int[] arr) {
        int maxEndingHere = arr[0];
        int maxSoFar = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }
            return new int[]{};
    }

    public void rotate(int[][] matrix) {

        int n = matrix.length;

        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;

        // Check if reshape operation is possible
        if (m * n != r * c) {
            return mat; // Reshape not possible, return the original matrix
        }

        int[][] reshapedMatrix = new int[r][c];
        int row = 0, col = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                reshapedMatrix[row][col] = mat[i][j];
                col++;

                // Move to the next row if the current row is filled
                if (col == c) {
                    col = 0;
                    row++;
                }
            }
        }

        return reshapedMatrix;
    }

    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = getSmoothedValue(img, i, j, m, n);
            }
        }

        return result;
    }

    private int getSmoothedValue(int[][] img, int i, int j, int m, int n) {
        int sum = 0;
        int count = 0;

        for (int row = i - 1; row <= i + 1; row++) {
            for (int col = j - 1; col <= j + 1; col++) {
                if (row >= 0 && row < m && col >= 0 && col < n) {
                    sum += img[row][col];
                    count++;
                }
            }
        }

        return sum / count;
    }

    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int positionZero = i;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        nums[positionZero] = nums[j];
                        nums[j] = 0;
                        positionZero = j;
                    }
                }
            }
        }
    }

    public static void sortArray(int[] in) {
        for (int i = 0; i < in.length - 1; i++) {
            for (int j = i + 1; j < in.length; j++) {
                if (in[i] > in[j]) {
                    int temp = in[i];
                    in[i] = in[j];
                    in[j] = temp;
                }
            }
        }
    }

    public int[] twoSumPointers(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1}; // Indicates no solution found
    }

    public void reverseArray3(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            // Swap elements at left and right indices
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }

    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int num : nums) {
            currentSum = Math.max(num, currentSum + num);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public void moveZeros(int[] nums) {
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int product = 1;
        for (int i = 0; i < n; i++) {
            result[i] = product;
            product *= nums[i];
        }

        product = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= product;
            product *= nums[i];
        }

        return result;
    }

    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, (right - left) * h);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        reverse(nums, i + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length) ? 0 : heights[i];

            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }

    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int result = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                result += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                result += rightMax - height[right];
                right--;
            }
        }

        return result;
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[] heights = new int[n];
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heights[j] = (matrix[i][j] == '1') ? heights[j] + 1 : 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    public String minWindow(String s, String t) {
        int[] charCount = new int[128];
        for (char c : t.toCharArray()) {
            charCount[c]++;
        }

        int left = 0, right = 0, minLength = Integer.MAX_VALUE, start = 0, count = t.length();

        while (right < s.length()) {
            if (charCount[s.charAt(right)] > 0) {
                count--;
            }
            charCount[s.charAt(right)]--;
            right++;

            while (count == 0) {
                if (right - left < minLength) {
                    minLength = right - left;
                    start = left;
                }

                charCount[s.charAt(left)]++;
                if (charCount[s.charAt(left)] > 0) {
                    count++;
                }
                left++;
            }
        }

        return (minLength == Integer.MAX_VALUE) ? "" : s.substring(start, start + minLength);
    }

    public int maxSubarraySumCircular(int[] A) {
        int totalSum = 0;
        int maxSum = Integer.MIN_VALUE, minSum = Integer.MAX_VALUE;
        int currentMax = 0, currentMin = 0;

        for (int num : A) {
            totalSum += num;
            currentMax = Math.max(currentMax + num, num);
            maxSum = Math.max(maxSum, currentMax);
            currentMin = Math.min(currentMin + num, num);
            minSum = Math.min(minSum, currentMin);
        }

        return (maxSum > 0) ? Math.max(maxSum, totalSum - minSum) : maxSum;
    }













}
