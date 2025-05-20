# Binary String Wowee

## Problem Description
Given a binary string `s` of length `n`, perform exactly `k` operations where each operation:
1. Selects an index `i` (1≤i≤n) where si=0
2. Flips all bits from position 1 to i (inclusive)

Count the number of possible ways to perform all `k` operations modulo 998244353.

## Input
- First line: number of test cases `t` (1≤t≤100)
- For each test case:
    - First line: two integers `n` and `k` (1≤k≤n≤500)
    - Second line: binary string `s` of length `n`

*Note: Sum of n across all test cases ≤ 500*

## Output
For each test case, print one integer: the number of possible operation sequences modulo 998244353.

## Example
```
Input:
5
3 1
010
3 2
000
5 4
01001
8 8
11001100
20 20
10010110101101010110

Output:
2
3
10
27286
915530405
```

## Sample Case Explanation
First test case (010):
1. i=1: 010 → 110
2. i=3: 010 → 101

Second test case (000):
1. i=1: 000 → 100 → 010 (i=2)
2. i=1: 000 → 100 → 011 (i=3)
3. i=2: 000 → 110 → 001 (i=3)
