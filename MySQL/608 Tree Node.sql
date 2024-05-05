# Problem: https://leetcode.com/problems/tree-node/

SELECT id, (CASE
    WHEN p_id IS NULL THEN 'Root'
    WHEN EXISTS (
        SELECT *
        FROM Tree
        WHERE p_id = t.id
    ) THEN 'Inner'
    ELSE 'Leaf'
END) as type
FROM Tree t
