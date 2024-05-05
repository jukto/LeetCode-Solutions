# Problem: https://leetcode.com/problems/delete-duplicate-emails/

DELETE FROM Person
WHERE email IN (
        SELECT email
        FROM (
            SELECT email
            FROM Person
            GROUP BY email
            HAVING COUNT(email) > '1'
        ) tmp
    ) AND id NOT IN (
        SELECT id
        FROM (
            SELECT MIN(id) as id
            FROM Person
            GROUP BY email
        ) tmp
    )
