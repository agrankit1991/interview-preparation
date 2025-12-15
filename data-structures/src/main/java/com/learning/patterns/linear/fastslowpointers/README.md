
# Fast & Slow Pointers — Common Interview Problems

This page collects major fast/slow-pointer (tortoise & hare) and related two-pointer interview problems, grouped by pattern and with concise notes and difficulty estimates.

## Linked List Cycle & Cycle-Related
- **Linked List Cycle** (detect cycle) — Easy: Floyd's cycle detection (tortoise & hare).
- **Linked List Cycle II** (find cycle start) — Medium: detect + find entry point.
- **Find cycle length** — Medium: measure loop length once detected.

## Middle / Split / Half-Work
- **Middle of the Linked List** — Easy: slow/fast to find midpoint. Implementation: `MiddleOfLinkedList` — [MiddleOfLinkedList.java](MiddleOfLinkedList.java)
- **Remove Nth Node From End of List** — Medium: use two pointers with gap N.
- **Palindrome Linked List** — Easy/Medium: find middle, reverse second half, compare.
- **Reorder List** — Medium: split at middle, reverse second half, merge alternately.
- **Rotate List** — Medium: compute length, connect tail to head, break at position.

## Intersection & Relative Pointers
- **Intersection of Two Linked Lists** — Easy: two-pointer switching trick to equalize path lengths.

## Sequence / Array / Function Cycle Detection
- **Happy Number** — Easy: detect cycle in repeated function application using Floyd.
- **Find the Duplicate Number** (array with values in range) — Medium: treat values as pointers and use cycle detection.
- **Circular Array Loop** — Medium: detect cycle under direction constraints.

## Two-Pointer Variants (Related Techniques)
- **Two Sum II - Input array is sorted** — Easy: classic two-pointer convergence.
- **Container With Most Water** — Medium: shrink pointers to maximize area.
- **Trapping Rain Water (two-pointer solution)** — Hard: optimize height scanning with two pointers.

## Notes & When to Use
- Use fast/slow (Floyd) when you need to detect cycles or reason about repeating sequences.
- Use two-pointer convergence/divergence when scanning from both ends, searching for pairs, or maintaining fixed gaps (e.g., nth-from-end).
- Common follow-ups: prove correctness, analyze time/space, adapt to constraints (immutable nodes, limited passes).

---

If you'd like, I can add links to canonical problems (e.g., LeetCode numbers), sample solutions in `java`, or brief diagrams for each pattern.
