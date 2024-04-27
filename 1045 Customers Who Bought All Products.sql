# Problem: https://leetcode.com/problems/customers-who-bought-all-products/

SELECT customer_id
FROM Customer c
GROUP BY customer_id
HAVING COUNT(DISTINCT product_key) = (SELECT COUNT(*) FROM Product)
