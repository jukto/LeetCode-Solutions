# Problem: https://leetcode.com/problems/product-price-at-a-given-date/

WITH DatedProducts AS (
    SELECT *
    FROM Products
    WHERE change_date <= '2019-08-16'
)

SELECT p1.product_id, IFNULL(p2.new_price, 10) price
FROM (
    SELECT DISTINCT product_id
    FROM Products
) p1
LEFT JOIN (
    SELECT *
    FROM DatedProducts
    WHERE (product_id, change_date) IN (
        SELECT product_id, MAX(change_date)
        FROM DatedProducts
        GROUP BY product_id
    )
) p2
ON p1.product_id = p2.product_id
