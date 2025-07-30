-- 코드를 작성해주세요
select d.dept_id, d.dept_name_en, round(avg(e.sal)) AVG_SAL
from hr_department d
join hr_employees e on d.dept_id = e.dept_id
group by d.dept_id
order by avg(e.sal) desc;