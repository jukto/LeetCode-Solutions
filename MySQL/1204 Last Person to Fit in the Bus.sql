# Problem: https://leetcode.com/problems/last-person-to-fit-in-the-bus/

SELECT person_name
FROM (
    SELECT person_name, turn, SUM(weight) OVER (ORDER BY turn) total_weight
    FROM Queue
) sub
WHERE total_weight <= 1000
ORDER BY turn DESC
LIMIT 1
