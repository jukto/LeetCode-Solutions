# Problem: https://leetcode.com/problems/restaurant-growth/

SELECT
    visited_on,
    SUM(amount) OVER (ROWS BETWEEN 6 PRECEDING AND CURRENT ROW) amount,
    ROUND(AVG(amount) OVER (ROWS BETWEEN 6 PRECEDING AND CURRENT ROW), 2) average_amount
FROM (
    SELECT visited_on, SUM(amount) amount
    FROM Customer
    GROUP BY visited_on
) sub
GROUP BY visited_on
LIMIT 99 OFFSET 6
