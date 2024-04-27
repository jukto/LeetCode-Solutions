# Problem: https://leetcode.com/problems/market-analysis-i/

SELECT u.user_id buyer_id, u.join_date, IFNULL(COUNT(o.buyer_id), 0) orders_in_2019
FROM Users u
LEFT JOIN (
    SELECT buyer_id
    FROM Orders
    WHERE YEAR(order_date) = '2019'
) o
ON u.user_id = o.buyer_id
GROUP BY u.user_id
