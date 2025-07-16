# Write your MySQL query statement below
-- select Department.name as Department, e.name as Employee, e.salary as Salary from Employee e where e.salary = (select MAX(d.salary) from Employee d where e.departmentId=d.departmentId);

select d.name as Department , e.name as Employee , e.salary as Salary from Employee e left join Department d on e.departmentId = d.id where e.salary = (select MAX(salary) from Employee where departmentId = e.departmentId);