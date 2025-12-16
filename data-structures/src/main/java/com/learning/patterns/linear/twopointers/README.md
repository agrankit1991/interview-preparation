# Two Pointers — Common Interview Problems

This page collects common two-pointer interview problems, grouped by pattern and with concise notes and difficulty estimates.

## Two-ends / Opposite-direction Pointers
- **Two Sum (sorted array)** — Easy: use left/right pointers to find a pair with given sum. Implementation: [TwoSum.java](TwoSum.java)
- **Container With Most Water** — Medium: move shorter pointer inward to maximize area. Implementation: [ContainerWithMostWater.java](ContainerWithMostWater.java)
- **Pair With Target (array after sorting)** — Easy/Medium: sort then use two pointers for pairs. Implementation: [PairWithTarget.java](PairWithTarget.java)

## Fast/Slow Variant (single array / in-place)
- **Remove Duplicates from Sorted Array** — Easy: slow pointer for writing unique elements. Implementation: [RemoveDuplicatesSortedArray.java](RemoveDuplicatesSortedArray.java)
- **Move Zeroes** — Easy: maintain slow pointer for placement of non-zero elements. Implementation: [MoveZeroes.java](MoveZeroes.java)
- **Squares of a Sorted Array** — Easy: use two pointers from ends to fill result from back. Implementation: [SquaresOfSortedArray.java](SquaresOfSortedArray.java)

## In-place Merging & Partitioning
- **Merge Two Sorted Arrays (in-place)** — Easy/Medium: start from the end with two pointers. Implementation: [MergeTwoSortedArrays.java](MergeTwoSortedArrays.java)
- **Partitioning / Dutch National Flag (Sort Colors)** — Medium: three-way pointers to partition values. Implementation: [SortColors.java](SortColors.java)

## After Sorting / Reduction to Two Pointers
- **3Sum / Triplet Sum Closest** — Medium: sort array then fix one element and use two pointers for pairs. Implementation: [ThreeSum.java](ThreeSum.java), [TripletSumClosest.java](TripletSumClosest.java)
- **3Sum Smaller / 4Sum (k-sum generalization)** — Medium/Hard: reduce to two-pointer subproblems after sorting. Implementation: [ThreeSumSmaller.java](ThreeSumSmaller.java), [FourSum.java](FourSum.java)

## String & Palindrome Checks
- **Valid Palindrome** — Easy: two pointers from both ends, skip non-alphanumerics. Implementation: [ValidPalindrome.java](ValidPalindrome.java)
- **Valid Palindrome II** — Easy/Medium: check with at most one deletion using two-pointer scan. Implementation: [ValidPalindromeII.java](ValidPalindromeII.java)

## Sliding Window & Variants (when order matters)
- **Subarray with Given Sum (positive numbers)** — Medium: use two pointers as a sliding window. Implementation: [SubarrayWithGivenSumPositive.java](SubarrayWithGivenSumPositive.java)

## Notes & When to Use
- Use two-pointers when you can exploit ordering, symmetry from both ends, or maintain a read/write index.
- Sorting often enables two-pointer solutions for sum/combination problems; account for the sort cost (O(n log n)).
- Two-pointer approaches are typically O(n) time and O(1) extra space (aside from sorting), making them interview-friendly.
- Common follow-ups: handle duplicates, prove correctness, analyze time/space, adapt for immutable inputs.