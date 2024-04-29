# Problem: https://leetcode.com/problems/bank-account-summary-ii/

SELECT
    name,
    SUM(amount) balance
FROM Users u
JOIN Transactions t
ON u.account = t.account
GROUP BY u.account
HAVING balance > 10000
