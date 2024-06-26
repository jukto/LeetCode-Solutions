# Problem: https://leetcode.com/problems/list-the-products-ordered-in-a-period/

SELECT p.product_name, SUM(o.unit) unit
FROM Products p
JOIN Orders o
ON p.product_id = o.product_id
WHERE o.order_date BETWEEN '2020-02-1' AND '2020-02-29'
GROUP BY product_name
HAVING unit >= '100'
