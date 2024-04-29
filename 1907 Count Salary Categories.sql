# Problem: leetcode.com/problems/count-salary-categories/

SELECT
    'Low Salary' category,
    COUNT(*) accounts_count
FROM Accounts
WHERE income < 20000

UNION

SELECT
    'High Salary' category,
    COUNT(*) accounts_count
FROM Accounts
WHERE income > 50000

UNION

SELECT
    'Average Salary' category,
    COUNT(*) accounts_count
FROM Accounts
WHERE income BETWEEN 20000 AND 50000
