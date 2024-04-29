# Problem: https://leetcode.com/problems/the-number-of-employees-which-report-to-each-employee/

SELECT
    m.employee_id,
    m.name,
    COUNT(*) reports_count,
    ROUND( AVG(e.age) ) average_age
FROM Employees m
JOIN Employees e
ON m.employee_id = e.reports_to
GROUP BY m.employee_id
ORDER BY m.employee_id
