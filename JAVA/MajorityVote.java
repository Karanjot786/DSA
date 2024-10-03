//GFG POTD Date: 03/09/24

// You are given an array of integer nums[] where each number represents a vote to a candidate. Return the candidates that have votes greater than one-third of the total votes, If there's not a majority vote, return -1. 

// Examples:
// Input: nums = [2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6]
// Output: [5, 6]
// Explanation: 5 and 6 occur more n/3 times.

// Input: nums = [1, 2, 3, 4, 5]
// Output: [-1]
// Explanation: no candidate occur more than n/3 times.

class Solution {
    public List<Integer> findMajority(List<Integer> nums) {
    int count1 = 0, count2 = 0, candidate1 = 0, candidate2 = 0;

    for (int num : nums) {
        if (num == candidate1) {
            count1++;
        } else if (num == candidate2) {
            count2++;
        } else if (count1 == 0) {
            candidate1 = num;
            count1 = 1;
        } else if (count2 == 0) {
            candidate2 = num;
            count2 = 1;
        } else {
            count1--;
            count2--;
        }
    }
    
    count1 = 0;
    count2 = 0;
    for (int num : nums) {
        if (num == candidate1) count1++;
        else if (num == candidate2) count2++;
    }
    
    List<Integer> result = new ArrayList<>();
    int n = nums.size();
    
    if (count1 > n / 3) result.add(candidate1);
    if (count2 > n / 3) result.add(candidate2);
    
    if (result.isEmpty()) {
        result.add(-1);
    }
    
    return result;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the list:");
        int size = sc.nextInt();
        
        List<Integer> nums = new ArrayList<>();
        System.out.println("Enter the elements of the list:");
        for (int i = 0; i < size; i++) {
            nums.add(sc.nextInt());
        }

        List<Integer> result = findMajority(nums);

        System.out.println("Majority elements: " + result);
    }
}