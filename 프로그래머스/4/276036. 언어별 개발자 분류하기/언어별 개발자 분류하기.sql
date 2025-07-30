-- 코드를 작성해주세요
select 
    case 
        when sum(s.name = 'Python') > 0 and sum(s.category = 'Front End') > 0 then 'A'
        when sum(s.name = 'C#') > 0                                then 'B'
        when sum(s.category = 'Front End') > 0                    then 'C'
        else null
    end as grade,
    d.id, 
    d.email
from developers d
join skillcodes s on (d.skill_code & s.code) = s.code
group by d.id, d.email
having grade is not null
order by grade, d.id;