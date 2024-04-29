# Problem: https://leetcode.com/problems/queries-quality-and-percentage/

SELECT
    query_name,
    ROUND( AVG(rating / position), 2 ) quality,
    ROUND( AVG(rating < 3) * 100, 2 ) poor_query_percentage
FROM Queries
WHERE query_name IS NOT NULL
GROUP BY query_name
