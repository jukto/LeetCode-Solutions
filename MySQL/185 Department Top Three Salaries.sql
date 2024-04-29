# Problem: https://leetcode.com/problems/department-top-three-salaries/

SELECT Department, Employee, Salary
FROM (
    SELECT
        d.name Department,
        e.name Employee,
        salary Salary,
        DENSE_RANK() OVER (PARTITION BY d.id ORDER BY salary DESC) rnk
    FROM Employee e
    JOIN Department d
    ON e.departmentId = d.id
) sub
WHERE rnk <= 3
