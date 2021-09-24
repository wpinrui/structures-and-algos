# Structures and Algorithms :triangular_ruler:

This repository is an archive of my practice implementations of various data structures and algorithms. It can be seen as an extension / revision of what I learnt in [CS2040S]([NUSMods](https://nusmods.com/modules/CS2040S/data-structures-and-algorithms)). 



## Algorithms

### Binary Search

#### :confounded:Problem: 

Given a <ins>sorted array</ins>, search for a value $k$ in the array.

#### :bulb:Idea:

1. Find the middle element $m_0$ in the array
2. Compare $k$ to $m_0$. 
   1. If $k > m_0$, then recurse on the right half
   2. If $k < m_0$, then recurse on the left half.
   3. Else, we have found the element. Return its index.
3. If the element is not in the array, return -1. 

#### :bangbang: Precondition and Postcondition:

1. Precondition - array is sorted
2. Postcondition - if element is in array, $A[begin] == key$ 
3. Loop invariant: $A[begin] \leq key \leq A[end]$
4. Invariant: $end-begin\le n/2^k$ in iteration $k$

