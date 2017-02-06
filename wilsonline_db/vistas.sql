create view v_generic_flight as
select concat(city1.name, ', ', city1.country) origin,
  concat(city2.name, ', ', city2.country) destiny,
  gf2.generic_flight_id,
	cast(substring(gf2.arrive_time,1,2) as unsigned) arrive_hour,
    cast(substring(gf2.arrive_time,4,2) as unsigned) arrive_minutes,
	cast(substring(gf2.departure_time,1,2) as unsigned) departure_hour,
    cast(substring(gf2.departure_time,4,2) as unsigned) departure_minutes,
    gf2.price,
    a2.name airline
from genericFlight gf2
inner join airline a2 
  on a2.airline_code = gf2.airline_code
inner join airport airport1
  on airport1.airport_id=gf2.origin
inner join city city1
  on city1.city_id=airport1.city_city_id
inner join airport airport2
  on airport2.airport_id=gf2.destiny
inner join city city2
  on city2.city_id=airport2.city_city_id;
    
create view v_airline as
select name from airline;

create view v_flight as
select f.flight_number, f.date, f.free_seatings, f.genericFlight_generic_flight_id
from flight f;

create view v_reservations as
select f.flight_number, f.date, gf.price
from flight f
inner join genericFlight gf
  on f.genericFlight_generic_flight_id=gf.generic_flight_id;
    
create view v_confirmation as
select r.reservation_number, a.name airline, f.flight_number,
  f.date, (select concat(c.name, ', ', c.country, ', ', a.name) destiny
  from genericFlight gf
  inner join airport a
    on a.airport_id = gf.destiny
  inner join city c
    on c.city_id = a.city_city_id) destiny
from reservations r
inner join flight f
  on r.flight_flight_number=f.flight_number
inner join airline a
  on a.airline_code = f.airline_airline_code
inner join genericFlight gf
  on f.genericFlight_generic_flight_id= gf.generic_flight_id
