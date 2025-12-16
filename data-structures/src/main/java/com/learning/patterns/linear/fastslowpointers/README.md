
# Fast & Slow Pointers — Common Interview Problems

This page collects major fast/slow-pointer (tortoise & hare) and related two-pointer interview problems, grouped by pattern and with concise notes and difficulty estimates.

## Linked List Cycle & Cycle-Related
- **Linked List Cycle** (detect cycle) — Easy: Floyd's cycle detection (tortoise & hare). Implementation: [LinkedListCycle.java](LinkedListCycle.java)
- **Linked List Cycle II** (find cycle start) — Medium: detect + find entry point. Implementation: [LinkedListCycleII.java](LinkedListCycleII.java)
- **Find cycle length** — Medium: measure loop length once detected. Implementation: [FindCycleLength.java](FindCycleLength.java)

## Middle / Split / Half-Work
- **Middle of the Linked List** — Easy: slow/fast to find midpoint. Implementation: [MiddleOfLinkedList.java](MiddleOfLinkedList.java)
- **Remove Nth Node From End of List** — Medium: use two pointers with gap N. Implementation: [RemoveNthNodeFromEnd.java](RemoveNthNodeFromEnd.java)
- **Palindrome Linked List** — Easy/Medium: find middle, reverse second half, compare. Implementation: [PalindromeLinkedList.java](PalindromeLinkedList.java)
- **Reorder List** — Medium: split at middle, reverse second half, merge alternately. Implementation: [ReorderList.java](ReorderList.java)
- **Rotate List** — Medium: compute length, connect tail to head, break at position. Implementation: [RotateList.java](RotateList.java)

## Intersection & Relative Pointers
- **Intersection of Two Linked Lists** — Easy: two-pointer switching trick to equalize path lengths. Implementation: [IntersectionOfTwoLinkedLists.java](IntersectionOfTwoLinkedLists.java)

## Sequence / Array / Function Cycle Detection
- **Happy Number** — Easy: detect cycle in repeated function application using Floyd. Implementation: [HappyNumber.java](HappyNumber.java)
- **Find the Duplicate Number** (array with values in range) — Medium: treat values as pointers and use cycle detection. Implementation: [FindDuplicateNumber.java](FindDuplicateNumber.java)
- **Circular Array Loop** — Medium: detect cycle under direction constraints. Implementation: [CircularArrayLoop.java](CircularArrayLoop.java)

## Notes & When to Use
- Use fast/slow (Floyd) when you need to detect cycles or reason about repeating sequences.
- Use two-pointer convergence/divergence when scanning from both ends, searching for pairs, or maintaining fixed gaps (e.g., nth-from-end).
- Common follow-ups: prove correctness, analyze time/space, adapt to constraints (immutable nodes, limited passes).

---