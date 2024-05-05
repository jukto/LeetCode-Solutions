# Problem: https://leetcode.com/problems/consecutive-numbers/

SELECT distinct(l1.num) as ConsecutiveNums 
FROM logs l1, logs l2 , logs l3
WHERE l2.id = l1.id + 1
    AND l3.id = l2.id + 1
    AND l1.num = l2.num
    AND l1.num = l3.num
