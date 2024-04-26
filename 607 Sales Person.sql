# Problem: https://leetcode.com/problems/sales-person/

SELECT name
FROM SalesPerson
WHERE name NOT IN (
    SELECT s.name
    FROM SalesPerson s
    JOIN Orders o
    ON s.sales_id = o.sales_id
    JOIN Company c
    ON o.com_id = c.com_id
    WHERE c.name = 'RED'
)
