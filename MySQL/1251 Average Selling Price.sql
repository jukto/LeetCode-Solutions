# Problem: https://leetcode.com/problems/average-selling-price/

SELECT
    p.product_id,
    IFNULL( ROUND( SUM(price * units) / SUM(units), 2), 0 ) average_price
FROM Prices p
LEFT JOIN UnitsSold us
ON p.product_id = us.product_id
    AND purchase_date BETWEEN start_date AND end_date
GROUP BY product_id
