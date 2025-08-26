# Write your MySQL query statement below
(
  SELECT name AS results 
  FROM movierating 
  NATURAL JOIN users u 
  GROUP BY u.user_id 
  ORDER BY COUNT(rating) DESC, name ASC 
  LIMIT 1
)
UNION ALL
(
  SELECT title 
  FROM movierating 
  NATURAL JOIN movies 
  WHERE created_at >= '2020-02-01' 
    AND created_at < '2020-03-01' 
  GROUP BY movie_id 
  ORDER BY AVG(rating) DESC, title ASC 
  LIMIT 1
);