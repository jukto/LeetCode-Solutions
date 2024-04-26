# Problem: https://leetcode.com/problems/managers-with-at-least-5-direct-reports/

SELECT m.name
FROM Employee m
JOIN Employee e
ON m.id = e.managerId
GROUP BY m.id
HAVING COUNT(m.id) >= 5
