# Problem: https://leetcode.com/problems/monthly-transactions-i/

SELECT
    DATE_FORMAT(trans_date, "%Y-%m") month,
    country,
    COUNT(state) trans_count,
    SUM(state = 'approved') approved_count,
    SUM(amount) trans_total_amount,
    SUM(amount * (state = 'approved')) approved_total_amount
FROM Transactions
GROUP BY EXTRACT(YEAR_MONTH FROM trans_date), country
