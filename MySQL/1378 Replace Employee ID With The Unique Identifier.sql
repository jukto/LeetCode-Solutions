# Problem: https://leetcode.com/problems/replace-employee-id-with-the-unique-identifier/

SELECT
    unique_id,
    name
FROM Employees e
LEFT JOIN EmployeeUNI u
ON e.id = u.id
