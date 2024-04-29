# Problem: https://leetcode.com/problems/employees-with-missing-information/

SELECT employee_id
FROM Employees
WHERE employee_id NOT IN (
    SELECT employee_id from Salaries
)

UNION

SELECT employee_id
FROM Salaries
WHERE employee_id NOT IN (
    SELECT employee_id from Employees
)

ORDER BY employee_id
