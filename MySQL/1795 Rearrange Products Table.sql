# Problem: https://leetcode.com/problems/rearrange-products-table/

SELECT 
    product_id,
    'store1' store,
    store1 price
FROM Products p
WHERE store1 IS NOT NULL

UNION

SELECT 
    product_id,
    'store2' store,
    store2 price
FROM Products p
WHERE store2 IS NOT NULL

UNION

SELECT 
    product_id,
    'store3' store,
    store3 price
FROM Products p
WHERE store3 IS NOT NULL
