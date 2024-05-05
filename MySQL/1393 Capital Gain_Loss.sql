# Problem: https://leetcode.com/problems/capital-gainloss/

SELECT
    stock_name, 
    SUM( IF(operation = 'Buy', -price, price) ) capital_gain_loss
FROM Stocks s
GROUP BY stock_name
