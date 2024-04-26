# Problem: https://leetcode.com/problems/triangle-judgement/

SELECT *, 
CASE
    WHEN
        z >= x AND z >= y AND x + y > z
        OR y >= x AND y >= z AND x + z > y
        OR x >= y AND x >= z AND y + z > x
    THEN 'Yes'
    ELSE 'No'
END AS triangle
FROM Triangle
