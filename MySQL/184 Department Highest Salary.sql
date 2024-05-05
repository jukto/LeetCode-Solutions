# Problem: https://leetcode.com/problems/department-highest-salary/

SELECT d.name AS Department, e.name AS Employee, e.salary AS Salary
FROM Employee e
JOIN Department d
ON e.departmentId = d.id
WHERE NOT EXISTS (
    SELECT *
    FROM Employee
    WHERE departmentId = e.departmentId AND salary > e.salary
)
