# Problem: https://leetcode.com/problems/sales-analysis-iii/

SELECT product_id, product_name
FROM Product p
WHERE
    EXISTS (
        SELECT product_id
        FROM Sales
        WHERE product_id = p.product_id AND sale_date BETWEEN '2019-01-01' AND '2019-03-31'
    ) AND NOT EXISTS (
        SELECT product_id
        FROM Sales
        WHERE product_id = p.product_id AND (sale_date < '2019-01-01' OR sale_date > '2019-03-31')
    )
